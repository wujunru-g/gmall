package com.wujunru.gmall.manage.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.wujunru.gmall.bean.PmsSkuAttrValue;
import com.wujunru.gmall.bean.PmsSkuImage;
import com.wujunru.gmall.bean.PmsSkuInfo;
import com.wujunru.gmall.bean.PmsSkuSaleAttrValue;
import com.wujunru.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuImageMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuInfoMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.wujunru.gmall.service.PmsSkuService;
import com.wujunru.gmall.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PmsSkuServiceImpl implements PmsSkuService {
    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuImageMapper  pmsSkuImageMapper;
    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public String saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        String SUCCESS=null;
        try {
            //判断是否图片设置默认,如果空则选择第一张图片位默认
            if (StringUtils.isBlank(pmsSkuInfo.getSkuDefaultImg())||pmsSkuInfo.getSkuDefaultImg()==null){//为空
                pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
            }
            //插入Skuinfo
            pmsSkuInfoMapper.insertSelectiveSkuInfo(pmsSkuInfo);
            String SkuId=pmsSkuInfo.getId();
            //插入平台属性关联
            List<PmsSkuAttrValue> pmsSkuAttrValueList=pmsSkuInfo.getSkuAttrValueList();
            for (PmsSkuAttrValue psav:pmsSkuAttrValueList) {
                psav.setSkuId(SkuId);
                pmsSkuAttrValueMapper.insertSelectiveSkuAttrValue(psav);
            }
            //插入销售属性关系
            List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList =pmsSkuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pssav:pmsSkuSaleAttrValueList) {
                pssav.setSkuId(SkuId);
                pmsSkuSaleAttrValueMapper.insertSelectiveSkuSaleAttrValue(pssav);
            }
            //插入图片信息
            List<PmsSkuImage> pmsSkuImageList =pmsSkuInfo.getSkuImageList();
            for (PmsSkuImage psi:pmsSkuImageList) {
                psi.setSkuId(SkuId);
                pmsSkuImageMapper.insertSelectiveSkuImage(psi);
            }
            SUCCESS="添加成功";
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            SUCCESS="添加失败";
            return SUCCESS;
        }
    }

    /**
     * 查询SKU对象与关联的图片
     * @param pmsSkuInfo
     * @return
     */
    public PmsSkuInfo selectByIdFromDB(PmsSkuInfo pmsSkuInfo) {
        PmsSkuInfo pmsSkuInfos= pmsSkuInfoMapper.selectById(pmsSkuInfo);
        //根据skuID 查出 图片集合放入PmsSkuInfo中
        PmsSkuImage pmsSkuImage= new PmsSkuImage();
        pmsSkuImage.setSkuId(pmsSkuInfo.getId());
        List<PmsSkuImage> pmsSkuImageList= pmsSkuImageMapper.selectImgBySkuId(pmsSkuImage);
        pmsSkuInfos.setSkuImageList(pmsSkuImageList);
        return pmsSkuInfos;
    }

    @Override
    public PmsSkuInfo selectById(PmsSkuInfo pmsSkuInfo) {
        System.err.println(Thread.currentThread().getName()+"进入商品详情页面");
        String skuId=pmsSkuInfo.getId();
        String skuKey="sku:"+skuId+":info";
        String skuKeyLock="sku:"+skuId+":lock";
        String token= UUID.randomUUID().toString();
        //链接缓存
        Jedis jedis= redisUtil.getJedis();
        try {
            //查询缓存
            String skuJson=  jedis.get(skuKey);
            if (StringUtils.isNotEmpty(skuJson)){ //不为空的标准是str!=null或str.length()!=0
                System.err.println(Thread.currentThread().getName()+"从缓存拿商品详情");
                pmsSkuInfo=JSON.parseObject(skuJson,PmsSkuInfo.class);
            }else {
                //设置分布式锁  获得分布式锁
              String lock= jedis.set(skuKeyLock,token,"nx","px",5*1000);//5秒过期时间
                System.err.println(Thread.currentThread().getName()+"缓存没有商品详情,获取锁");
                if (StringUtils.isNotEmpty(lock)&&lock.equals("OK")){
                    //如果缓存里没有就查询mysql
                    System.err.println(Thread.currentThread().getName()+"从Mysql拿商品详情(10S内)");
                    pmsSkuInfo=selectByIdFromDB(pmsSkuInfo);
                    //将mysql查出来的数据放入redis里
                    if (pmsSkuInfo!=null){
                        jedis.set(skuKey,JSON.toJSONString(pmsSkuInfo));
                    }else {
                        //数据库不存在该SKU 为了防止缓存穿透，将一个null或者空字符串设置给redis.
                        jedis.setex(skuKey,60*3,JSON.toJSONString(""));
                    }
                }else {
                    //未获得分布式锁 开始自旋
                    System.err.println(Thread.currentThread().getName()+"没抢到锁，自旋");
                    Thread.sleep(1000);
                    return selectById(pmsSkuInfo);  //selectById(pmsSkuInfo);
                }
            }
            return pmsSkuInfo;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭链接
            jedis.close();
            //防止误删锁
            String lockToken=jedis.get(skuKeyLock);
            if (StringUtils.isNotEmpty(lockToken)&&lockToken.equals(token)){
                jedis.del(skuKeyLock);
                //释放锁
                System.err.println(Thread.currentThread().getName()+"释放锁");
            }
        }
        return pmsSkuInfo;
    }

    @Override
    public String selectSpuHash(String spuId) {
        HashMap<String,Object> Skumap=new HashMap();
        List<PmsSkuInfo> pmsSkuInfoList= pmsSkuInfoMapper.selectSpuHash(spuId);
        for (PmsSkuInfo psi :pmsSkuInfoList) {
            String k="";  //K值
            String v=psi.getId(); //v值
            List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList=psi.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pssav:pmsSkuSaleAttrValueList) {
                k +=pssav.getSaleAttrValueId()+"|";
            }
            Skumap.put(k,v);
        }
        //将sku属性值hash表放到页面  转成json字符串
        return JSON.toJSONString(Skumap);
    }

}

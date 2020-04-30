package com.wujunru.gmall.manage.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.wujunru.gmall.bean.PmsSkuAttrValue;
import com.wujunru.gmall.bean.PmsSkuImage;
import com.wujunru.gmall.bean.PmsSkuInfo;
import com.wujunru.gmall.bean.PmsSkuSaleAttrValue;
import com.wujunru.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuImageMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuInfoMapper;
import com.wujunru.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.wujunru.gmall.service.PmsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

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

    @Override
    public PmsSkuInfo selectById(PmsSkuInfo pmsSkuInfo) {
        PmsSkuInfo pmsSkuInfos= pmsSkuInfoMapper.selectById(pmsSkuInfo);
        //根据skuID 查出 图片集合放入PmsSkuInfo中
        PmsSkuImage pmsSkuImage= new PmsSkuImage();
        pmsSkuImage.setSkuId(pmsSkuInfo.getId());
        List<PmsSkuImage> pmsSkuImageList= pmsSkuImageMapper.selectImgBySkuId(pmsSkuImage);
        pmsSkuInfos.setSkuImageList(pmsSkuImageList);
        return pmsSkuInfos;
    }

}

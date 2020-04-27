package com.wujunru.gmall.manage.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.wujunru.gmall.bean.PmsBaseAttrInfo;
import com.wujunru.gmall.bean.PmsBaseAttrValue;
import com.wujunru.gmall.bean.PmsBaseSaleAttr;
import com.wujunru.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.wujunru.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.wujunru.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.wujunru.gmall.service.PmsBaseAttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmsBaseAttrServiceImpl implements PmsBaseAttrService {
    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Override
    public List<PmsBaseAttrInfo> selectBycatalog3Id(String catalog3Id) {
      List<PmsBaseAttrInfo> pmsBaseAttrInfos= pmsBaseAttrInfoMapper.selectBycatalog3Id(catalog3Id);
      //查询出相关的属性值
        PmsBaseAttrValue pmsBaseAttrValue=null;
        for (PmsBaseAttrInfo pmsBaseAttrInfo:pmsBaseAttrInfos) {
              pmsBaseAttrValue= new PmsBaseAttrValue();
              pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
              List<PmsBaseAttrValue> pmsBaseAttrValueList= pmsBaseAttrValueMapper.selectByattrId(pmsBaseAttrValue);
              pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValueList);
        }
        return pmsBaseAttrInfos;
    }

    @Override
    public String insertSelectiveinfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
         String id=  pmsBaseAttrInfo.getId();
        try {
                if (StringUtils.isBlank(id)){   //id为空  添加
                    //保存属性
                    pmsBaseAttrInfoMapper.insertSelectiveinfo(pmsBaseAttrInfo);
                    //保存属性值
                    List<PmsBaseAttrValue> pmsBaseAttrValues=pmsBaseAttrInfo.getAttrValueList();
                    for (PmsBaseAttrValue pmsBaseAttrValue:pmsBaseAttrValues) {
                        pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                        pmsBaseAttrValueMapper.insertSelectiveValue(pmsBaseAttrValue);
                    }
                    return  "添加成功";
                }else {         //id不为空 修改
                    //修改属性
                    pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
                    //修改属性值
                    PmsBaseAttrValue pv=new PmsBaseAttrValue();
                    pv.setAttrId(id);
                    //删除已有的属性值
                    pmsBaseAttrValueMapper.deleteByPrimaryKey(pv);
                    //保存属性值
                    List<PmsBaseAttrValue> pmsBaseAttrValues=pmsBaseAttrInfo.getAttrValueList();
                    for (PmsBaseAttrValue pmsBaseAttrValue:pmsBaseAttrValues) {
                        pmsBaseAttrValue.setAttrId(id);
                        pmsBaseAttrValueMapper.insertSelectiveValue(pmsBaseAttrValue);
                    }
                    return  "修改成功";
                }
        }catch (Exception e){
            e.printStackTrace();
            return  "添加失败";
        }
    }

    @Override
    public List<PmsBaseAttrValue> selectByattrId(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
         pmsBaseAttrValue.setAttrId(attrId);
       List<PmsBaseAttrValue> pmsBaseAttrValues= pmsBaseAttrValueMapper.selectByattrId(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

    @Override
    public List<PmsBaseSaleAttr> selectAll() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs= pmsBaseSaleAttrMapper.selectAll();
        return pmsBaseSaleAttrs;
    }

    /*@Override
    public String insertSelectiveValue(PmsBaseAttrValue pmsBaseAttrValue) {
        String SUCCESSVALUE=pmsBaseAttrValueMapper.insertSelectiveValue(pmsBaseAttrValue)+"";
        return SUCCESSVALUE;
    }*/
}

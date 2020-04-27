package com.wujunru.gmall.manage.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.wujunru.gmall.bean.PmsProductImage;
import com.wujunru.gmall.bean.PmsProductInfo;
import com.wujunru.gmall.bean.PmsProductSaleAttr;
import com.wujunru.gmall.bean.PmsProductSaleAttrValue;
import com.wujunru.gmall.manage.mapper.PmsProductImageMapper;
import com.wujunru.gmall.manage.mapper.PmsProductInfoMapper;
import com.wujunru.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.wujunru.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.wujunru.gmall.service.spuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.FocusEvent;
import java.util.List;

@Service
public class spuServiceImpl  implements spuService {
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Override
    public List<PmsProductInfo> selectBycatalog3Id(String catalog3Id) {
         PmsProductInfo pmsProductInfos=new PmsProductInfo();
         pmsProductInfos.setCatalog3Id(catalog3Id);
       List<PmsProductInfo> pmsProductInfoList= pmsProductInfoMapper.selectBycatalog3Id(pmsProductInfos);
        return pmsProductInfoList;
    }

    @Override
    public String insertSelectiveSpuinfo(PmsProductInfo pmsProductInfo) {
       try {
           //保存商品属性
           Integer i=  pmsProductInfoMapper.insertSelectiveSpuinfo(pmsProductInfo);
           String id=pmsProductInfo.getId();//主键ID
           //保存图片路径
           List<PmsProductImage> pmsProductImageslist=  pmsProductInfo.getSpuImageList();
           for (PmsProductImage ppi:pmsProductImageslist)
           {
               ppi.setProductId(id);
               pmsProductImageMapper.insertSelectiveSpuImg(ppi);
           }
           //保存商品属性
           List<PmsProductSaleAttr>pmsProductSaleAttrList= pmsProductInfo.getSpuSaleAttrList();
           for (PmsProductSaleAttr ppsa:pmsProductSaleAttrList)
           {
               ppsa.setProductId(id);
               pmsProductSaleAttrMapper.insertSelectiveSpuSale(ppsa);
               //保存商品属性值
            List<PmsProductSaleAttrValue>pmsProductSaleAttrValueList=  ppsa.getSpuSaleAttrValueList();
               for (PmsProductSaleAttrValue ppsav:pmsProductSaleAttrValueList) {
                   ppsav.setProductId(id);
                   ppsav.setSaleAttrId(ppsa.getSaleAttrId());
                   pmsProductSaleAttrValueMapper.insertSelectiveSpuSaleValue(ppsav);
               }
           }
           return "保存成功";
       }catch (Exception e){
           e.printStackTrace();
           return "保存失败";
       }
    }

    @Override
    public List<PmsProductSaleAttr> selectSaleAttrList(String  spuId) {
        //查询属性
            PmsProductSaleAttr pmsProductSaleAttr=new PmsProductSaleAttr();
            pmsProductSaleAttr.setProductId(spuId);
            List<PmsProductSaleAttr> pmsProductSaleAttrs= pmsProductSaleAttrMapper.selectSaleAttrByProductId(pmsProductSaleAttr);
            //查出属性值
        PmsProductSaleAttrValue pmsProductSaleAttrValue=null;
        for (PmsProductSaleAttr productSaleAttr:pmsProductSaleAttrs) {
             pmsProductSaleAttrValue= new PmsProductSaleAttrValue();
             pmsProductSaleAttrValue.setProductId(spuId);
             pmsProductSaleAttrValue.setSaleAttrId(productSaleAttr.getSaleAttrId());
             List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList=pmsProductSaleAttrValueMapper.selectSaleAttrValueByProductId(pmsProductSaleAttrValue);
             productSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        }
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> selectImgByProductId(String spuId) {
        PmsProductImage pmsProductImage=new PmsProductImage();
        pmsProductImage.setProductId(spuId);
        List<PmsProductImage> pmsProductImages= pmsProductImageMapper.selectImgByProductId(pmsProductImage);
        return pmsProductImages;
    }
}

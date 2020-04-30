package com.wujunru.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wujunru.gmall.bean.PmsProductSaleAttr;
import com.wujunru.gmall.bean.PmsSkuInfo;
import com.wujunru.gmall.service.PmsSkuService;
import com.wujunru.gmall.service.spuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class itemController {
    @Reference
    PmsSkuService pmsSkuService;
    @Reference
    spuService spuService;
    @RequestMapping("{skuId}.html")
    public  String index(ModelMap modelMap, @PathVariable String  skuId){
        PmsSkuInfo pmsSkuInfo=new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo pmsSkuInfos= pmsSkuService.selectById(pmsSkuInfo);
        //sku对象
        modelMap.put("skuInfo",pmsSkuInfos);
        //销售属性列表
       List<PmsProductSaleAttr> pmsProductSaleAttrList= spuService.selectSpuCheckBysku(pmsSkuInfos.getSpuId(),pmsSkuInfos.getId());
       System.err.println(pmsProductSaleAttrList.get(0));
        modelMap.put("spuSaleAttrListCheckBySku",pmsProductSaleAttrList);
        return "item";
    }
}

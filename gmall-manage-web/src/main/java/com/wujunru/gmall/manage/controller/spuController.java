package com.wujunru.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wujunru.gmall.bean.PmsProductImage;
import com.wujunru.gmall.bean.PmsProductInfo;
import com.wujunru.gmall.bean.PmsProductSaleAttr;
import com.wujunru.gmall.manage.utils.FastDFSClientWrapper;
import com.wujunru.gmall.service.spuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
public class spuController {
    @Reference
    spuService spuService;
    @Autowired
    FastDFSClientWrapper fastDFSClientWrapper;
    @RequestMapping("/spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
          List<PmsProductInfo> pmsProductInfoList=  spuService.selectBycatalog3Id(catalog3Id);
        return pmsProductInfoList ;
    }
    @RequestMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        //把图片或者音视频上传到分布式的文件储存系统
        String imgUrl=fastDFSClientWrapper.uploadFile(multipartFile);
        return imgUrl ;
    }

    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        String SUCCESS = spuService.insertSelectiveSpuinfo(pmsProductInfo);
        return SUCCESS;
    }
    @RequestMapping("/spuSaleAttrList")
    @ResponseBody
    public  List<PmsProductSaleAttr> spuSaleAttrList(String  spuId){
       List<PmsProductSaleAttr> pmsProductSaleAttrList= spuService.selectSaleAttrList(spuId);
        return pmsProductSaleAttrList;
    }
    @RequestMapping("/spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){
        List<PmsProductImage> pmsProductImages= spuService.selectImgByProductId(spuId);
        return pmsProductImages;
    }
}

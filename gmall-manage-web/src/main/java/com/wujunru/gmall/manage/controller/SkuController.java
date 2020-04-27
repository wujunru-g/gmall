package com.wujunru.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wujunru.gmall.bean.PmsSkuInfo;
import com.wujunru.gmall.service.PmsSkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@CrossOrigin
public class SkuController {
    @Reference
    PmsSkuService pmsSkuService;

    @RequestMapping("/saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
       String SUCCESS= pmsSkuService.saveSkuInfo(pmsSkuInfo);
        return SUCCESS ;
    }

}

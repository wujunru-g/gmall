package com.wujunru.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wujunru.gmall.bean.PmsBasecatalog1;
import com.wujunru.gmall.service.PmsBasecatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsBasecatalogController {
    @Reference
    PmsBasecatalogService pmsBasecatalogService;

    @RequestMapping("/getCatalog1")
    @ResponseBody
    public List<PmsBasecatalog1> getCatalog1(){
       List<PmsBasecatalog1> pmsBasecatalog1s= pmsBasecatalogService.selectGetAll();
        return pmsBasecatalog1s;
    }
}

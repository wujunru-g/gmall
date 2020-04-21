package com.wujunru.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wujunru.gmall.bean.PmsBaseAttrInfo;
import com.wujunru.gmall.bean.PmsBaseAttrValue;
import com.wujunru.gmall.service.PmsBaseAttrService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsBaseAttrController {
    @Reference
    PmsBaseAttrService pmsBaseAttrService;

    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
          String SUCCESS=  pmsBaseAttrService.insertSelectiveinfo(pmsBaseAttrInfo);
          return SUCCESS;
    }

    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=  pmsBaseAttrService.selectBycatalog3Id(catalog3Id);
        return  pmsBaseAttrInfos;
    }

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
     List<PmsBaseAttrValue> pmsBaseAttrValues= pmsBaseAttrService.selectByattrId(attrId);
        return  pmsBaseAttrValues;
    }
}

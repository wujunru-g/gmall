package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.PmsBaseAttrInfo;
import com.wujunru.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrService {
    /**
     * 根据第三分类查出具体数据
     */
    public List<PmsBaseAttrInfo> selectBycatalog3Id(String catalog3Id);
    /**
     * 添加商品属性 info
     */
    public String insertSelectiveinfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    /**
     * 查询出属性值
     */
    public List<PmsBaseAttrValue> selectByattrId(String attrId);

}

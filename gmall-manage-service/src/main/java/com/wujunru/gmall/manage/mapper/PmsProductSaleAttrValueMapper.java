package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsProductSaleAttrValue;

import java.util.List;

public interface PmsProductSaleAttrValueMapper {
    public Integer insertSelectiveSpuSaleValue(PmsProductSaleAttrValue pmsProductSaleAttrValue);

    public List<PmsProductSaleAttrValue> selectSaleAttrValueByProductId (PmsProductSaleAttrValue pmsProductSaleAttrValue);
}

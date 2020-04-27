package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface PmsProductSaleAttrMapper {
    public Integer  insertSelectiveSpuSale(PmsProductSaleAttr pmsProductSaleAttr);

    public List<PmsProductSaleAttr> selectSaleAttrByProductId(PmsProductSaleAttr pmsProductSaleAttr);
}

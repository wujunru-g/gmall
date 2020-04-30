package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductSaleAttrMapper {
    public Integer  insertSelectiveSpuSale(PmsProductSaleAttr pmsProductSaleAttr);

    public List<PmsProductSaleAttr> selectSaleAttrByProductId(PmsProductSaleAttr pmsProductSaleAttr);

    public List<PmsProductSaleAttr> selectSpuCheckBysku(@Param("productId") String productId ,@Param("skuId")String skuId);
}

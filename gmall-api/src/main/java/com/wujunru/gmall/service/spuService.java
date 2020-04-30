package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.PmsProductImage;
import com.wujunru.gmall.bean.PmsProductInfo;
import com.wujunru.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface spuService {
    /**
     * 根据三级分类查询
     * @param catalog3Id
     * @return
     */
    public List<PmsProductInfo> selectBycatalog3Id(String catalog3Id);
    /**
     * 保存商品属性
     */
    public  String insertSelectiveSpuinfo(PmsProductInfo pmsProductInfo);

    /**
     * 查询销售属性
     * @param spuId
     * @return
     */
    public  List<PmsProductSaleAttr> selectSaleAttrList(String  spuId);
    /**
     * 查询图片
     */
    public  List<PmsProductImage> selectImgByProductId(String spuId);
    /**
     * 查询商品销售属性与销售属性值
     */
    public List<PmsProductSaleAttr> selectSpuCheckBysku(String productId ,String skuId);
}

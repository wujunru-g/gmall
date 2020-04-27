package com.wujunru.gmall.bean;

import java.io.Serializable;
import java.util.List;

public class PmsProductInfo implements Serializable {
    private String id;
    private String productName;
    private String description;
    private  String catalog3Id;
    private List<PmsProductSaleAttr> spuSaleAttrList;
    private List<PmsProductImage> spuImageList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public List<PmsProductSaleAttr> getSpuSaleAttrList() {
        return spuSaleAttrList;
    }

    public void setSpuSaleAttrList(List<PmsProductSaleAttr> spuSaleAttrList) {
        this.spuSaleAttrList = spuSaleAttrList;
    }

    public List<PmsProductImage> getSpuImageList() {
        return spuImageList;
    }

    public void setSpuImageList(List<PmsProductImage> spuImageList) {
        this.spuImageList = spuImageList;
    }

    @Override
    public String toString() {
        return "PmsProductInfo{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", catalog3Id='" + catalog3Id + '\'' +
                ", spuSaleAttrList=" + spuSaleAttrList +
                ", spuImageList=" + spuImageList +
                '}';
    }
}

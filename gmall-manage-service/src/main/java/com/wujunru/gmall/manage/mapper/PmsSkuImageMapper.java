package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsSkuImage;

import java.util.List;

public interface PmsSkuImageMapper {
    public Integer insertSelectiveSkuImage(PmsSkuImage pmsSkuImage);

    public List<PmsSkuImage> selectImgBySkuId(PmsSkuImage pmsSkuImage);
}

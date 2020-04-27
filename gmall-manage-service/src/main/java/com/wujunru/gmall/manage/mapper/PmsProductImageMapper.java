package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsProductImage;

import java.util.List;

public interface PmsProductImageMapper {
    public Integer insertSelectiveSpuImg(PmsProductImage pmsProductImage);
    public List<PmsProductImage> selectImgByProductId(PmsProductImage pmsProductImage);
}

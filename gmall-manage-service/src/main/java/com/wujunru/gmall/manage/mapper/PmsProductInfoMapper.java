package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsProductInfo;

import java.util.List;

public interface PmsProductInfoMapper {
    public List<PmsProductInfo> selectBycatalog3Id(PmsProductInfo pmsProductInfo);

    public  Integer insertSelectiveSpuinfo(PmsProductInfo pmsProductInfo);
}

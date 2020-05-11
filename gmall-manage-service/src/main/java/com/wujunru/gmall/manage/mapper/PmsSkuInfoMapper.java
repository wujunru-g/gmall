package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsSkuInfo;

import java.util.List;

public interface PmsSkuInfoMapper {
    public Integer insertSelectiveSkuInfo(PmsSkuInfo pmsSkuInfo);
    public PmsSkuInfo selectById(PmsSkuInfo pmsSkuInfo);
    public List<PmsSkuInfo> selectSpuHash(String spuId);
}

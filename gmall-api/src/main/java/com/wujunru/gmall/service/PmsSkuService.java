package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.PmsSkuImage;
import com.wujunru.gmall.bean.PmsSkuInfo;

import java.util.List;

public interface PmsSkuService {
    /**
     * 添加SKU
     * @param pmsSkuInfo
     * @return
     */
    public String saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 查询SKU
     * @param pmsSkuInfo
     * @return
     */
    public PmsSkuInfo selectById(PmsSkuInfo pmsSkuInfo);
    /**
     * 得到销售属性切换的hash表
     */
    public String  selectSpuHash(String spuId);
}

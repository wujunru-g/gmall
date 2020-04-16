package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.PmsBasecatalog1;

import java.util.List;

public interface PmsBasecatalogService {
    /**
     * 查询一级列表所有项
     */
    public List<PmsBasecatalog1> selectGetAll();
}

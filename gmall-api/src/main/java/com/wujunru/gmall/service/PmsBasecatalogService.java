package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.PmsBasecatalog1;
import com.wujunru.gmall.bean.PmsBasecatalog2;
import com.wujunru.gmall.bean.PmsBasecatalog3;

import java.util.List;

public interface PmsBasecatalogService {
    /**
     * 查询一级列表所有项
     */
    public List<PmsBasecatalog1> selectGetAll();
    /**
     * 根据一级列表查询二级列表
     */
    public List<PmsBasecatalog2> selectBycatalog1Id(String catalog1Id);
    /**
     * 根据二级列表查询三级列表
     */
    public List<PmsBasecatalog3> selectBycatalog2Id(String catalog2Id);
}

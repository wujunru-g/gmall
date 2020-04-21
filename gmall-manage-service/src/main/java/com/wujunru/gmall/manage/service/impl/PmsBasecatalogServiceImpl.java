package com.wujunru.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wujunru.gmall.bean.PmsBasecatalog1;
import com.wujunru.gmall.bean.PmsBasecatalog2;
import com.wujunru.gmall.bean.PmsBasecatalog3;
import com.wujunru.gmall.manage.mapper.PmsBasecatalog1Mapper;
import com.wujunru.gmall.manage.mapper.PmsBasecatalog2Mapper;
import com.wujunru.gmall.manage.mapper.PmsBasecatalog3Mapper;
import com.wujunru.gmall.service.PmsBasecatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBasecatalogServiceImpl implements PmsBasecatalogService {
    @Autowired
    PmsBasecatalog1Mapper pmsBasecatalog1Mapper;
    @Autowired
    PmsBasecatalog2Mapper pmsBasecatalog2Mapper;
    @Autowired
    PmsBasecatalog3Mapper pmsBasecatalog3Mapper;

    @Override
    public List<PmsBasecatalog1> selectGetAll() {
       List<PmsBasecatalog1> pmsBasecatalog1s= pmsBasecatalog1Mapper.selectGetAll();
        return pmsBasecatalog1s;
    }

    @Override
    public List<PmsBasecatalog2> selectBycatalog1Id(String catalog1Id) {
      List<PmsBasecatalog2> pmsBasecatalog2s= pmsBasecatalog2Mapper.selectBycatalog1Id(catalog1Id);
        return pmsBasecatalog2s;
    }

    @Override
    public List<PmsBasecatalog3> selectBycatalog2Id(String catalog2Id) {
        List<PmsBasecatalog3> pmsBasecatalog3s=  pmsBasecatalog3Mapper.selectBycatalog2Id(catalog2Id);
        return pmsBasecatalog3s;
    }
}

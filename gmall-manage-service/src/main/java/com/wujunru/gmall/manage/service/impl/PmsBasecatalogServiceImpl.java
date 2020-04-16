package com.wujunru.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wujunru.gmall.bean.PmsBasecatalog1;
import com.wujunru.gmall.manage.mapper.PmsBasecatalog1Mapper;
import com.wujunru.gmall.service.PmsBasecatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBasecatalogServiceImpl implements PmsBasecatalogService {
    @Autowired
    PmsBasecatalog1Mapper pmsBasecatalog1Mapper;

    @Override
    public List<PmsBasecatalog1> selectGetAll() {
       List<PmsBasecatalog1> pmsBasecatalog1s= pmsBasecatalog1Mapper.selectGetAll();
        return pmsBasecatalog1s;
    }
}

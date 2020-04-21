package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsBaseAttrInfo;
import com.wujunru.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrInfoMapper {

    public List<PmsBaseAttrInfo> selectBycatalog3Id(String catalog3Id);

     public int insertSelectiveinfo(PmsBaseAttrInfo pmsBaseAttrInfo);

     public  int updateByPrimaryKeySelective(PmsBaseAttrInfo pmsBaseAttrInfo);

}

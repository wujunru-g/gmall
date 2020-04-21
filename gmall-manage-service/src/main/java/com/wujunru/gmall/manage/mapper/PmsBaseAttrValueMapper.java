package com.wujunru.gmall.manage.mapper;

import com.wujunru.gmall.bean.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrValueMapper {
    public int insertSelectiveValue(PmsBaseAttrValue pmsBaseAttrValue);

    public List<PmsBaseAttrValue> selectByattrId(PmsBaseAttrValue pmsBaseAttrValue);

    public  int deleteByPrimaryKey(PmsBaseAttrValue pmsBaseAttrValue);
}

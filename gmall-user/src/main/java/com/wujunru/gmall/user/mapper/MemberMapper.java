package com.wujunru.gmall.user.mapper;

import com.wujunru.gmall.bean.Member;
import com.wujunru.gmall.bean.MemberAddress;

import java.util.List;

public interface MemberMapper {

    public List<Member> selectGetAll();
    public List<MemberAddress> selectById(Long memberID);
}

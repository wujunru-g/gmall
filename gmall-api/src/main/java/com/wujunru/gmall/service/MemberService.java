package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.Member;

import java.util.List;

public interface MemberService {
    /**
     * 查询所有用户
     * @return
     */
    public List<Member> selectGetAll();
}

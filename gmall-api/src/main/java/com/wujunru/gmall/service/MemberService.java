package com.wujunru.gmall.service;

import com.wujunru.gmall.bean.Member;
import com.wujunru.gmall.bean.MemberAddress;

import java.util.List;

public interface MemberService {
    /**
     * 查询所有用户
     * @return
     */
    public List<Member> selectGetAll();

    /**
     * 根据用户ID查询地址信息
     * @return
     */
    public List<MemberAddress> selectById(Long memberID);
}

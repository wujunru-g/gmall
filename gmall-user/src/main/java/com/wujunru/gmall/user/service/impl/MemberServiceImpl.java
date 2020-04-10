package com.wujunru.gmall.user.service.impl;

import com.wujunru.gmall.bean.Member;
import com.wujunru.gmall.bean.MemberAddress;
import com.wujunru.gmall.service.MemberService;
import com.wujunru.gmall.user.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public List<Member> selectGetAll() {
        List<Member> members = memberMapper.selectGetAll();
        return members;
    }

    @Override
    public List<MemberAddress> selectById(Long memberID) {
        List<MemberAddress> memberAddresses = memberMapper.selectById(memberID);
        return memberAddresses;
    }
}

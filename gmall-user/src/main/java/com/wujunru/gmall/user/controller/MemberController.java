package com.wujunru.gmall.user.controller;

import com.wujunru.gmall.bean.Member;
import com.wujunru.gmall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/gmall/getUserAll")
    @ResponseBody
    public List<Member> getUser(){
        return memberService.selectGetAll();
    }
}

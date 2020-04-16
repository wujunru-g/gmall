package com.wujunru.gmall.bean;

import java.io.Serializable;

public class MemberAddress implements Serializable {
    private Long id;
    private Long member_id;
    private String name;
    private String  phone_number;
    private Integer default_status;
    private String post_code;
    private String province;
    private String city;
    private String region;
    private String detail_address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getDefault_status() {
        return default_status;
    }

    public void setDefault_status(Integer default_status) {
        this.default_status = default_status;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    @Override
    public String toString() {
        return "MemberAddress{" +
                "id=" + id +
                ", member_id=" + member_id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", default_status=" + default_status +
                ", post_code='" + post_code + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", detail_address='" + detail_address + '\'' +
                '}';
    }
}

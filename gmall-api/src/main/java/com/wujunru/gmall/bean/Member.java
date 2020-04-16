package com.wujunru.gmall.bean;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private Long id;
    private Long member_level_id;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private Integer status;
    private Date create_time;
    private String icon;
    private Integer gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalized_signature;
    private Integer source_type;
    private Integer integration;
    private Integer growth;
    private Integer luckey_count;
    private Integer history_integration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMember_level_id() {
        return member_level_id;
    }

    public void setMember_level_id(long member_level_id) {
        this.member_level_id = member_level_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalized_signature() {
        return personalized_signature;
    }

    public void setPersonalized_signature(String personalized_signature) {
        this.personalized_signature = personalized_signature;
    }

    public Integer getSource_type() {
        return source_type;
    }

    public void setSource_type(Integer source_type) {
        this.source_type = source_type;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getLuckey_count() {
        return luckey_count;
    }

    public void setLuckey_count(Integer luckey_count) {
        this.luckey_count = luckey_count;
    }

    public Integer getHistory_integration() {
        return history_integration;
    }

    public void setHistory_integration(Integer history_integration) {
        this.history_integration = history_integration;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", member_level_id=" + member_level_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", create_time=" + create_time +
                ", icon='" + icon + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", job='" + job + '\'' +
                ", personalized_signature='" + personalized_signature + '\'' +
                ", source_type=" + source_type +
                ", integration=" + integration +
                ", growth=" + growth +
                ", luckey_count=" + luckey_count +
                ", history_integration=" + history_integration +
                '}';
    }
}

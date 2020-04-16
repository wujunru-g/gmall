package com.wujunru.gmall.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.wujunru.gmall.user.mapper")
public class GmallUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallUserServiceApplication.class, args);
    }

}

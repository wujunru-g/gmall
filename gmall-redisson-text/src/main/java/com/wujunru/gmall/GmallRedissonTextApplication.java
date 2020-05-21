package com.wujunru.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class GmallRedissonTextApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallRedissonTextApplication.class, args);
    }

}

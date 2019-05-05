package com.yxp423.ssmempl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.yxp423.ssmempl.mapper")
public class SsmemplApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmemplApplication.class, args);
    }

}

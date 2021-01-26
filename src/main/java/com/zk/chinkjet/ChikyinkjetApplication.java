package com.zk.chinkjet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zk.chinkjet.dao")
public class ChikyinkjetApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChikyinkjetApplication.class, args);
    }

}

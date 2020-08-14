package com.baosteel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.baosteel.item.mapper")
public class BsItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BsItemApplication.class);
    }
}

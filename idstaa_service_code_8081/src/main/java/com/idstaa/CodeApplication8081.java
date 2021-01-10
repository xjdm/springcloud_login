package com.idstaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenjie
 * @date 2021/1/4 13:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.idstaa.pojo")
@EnableFeignClients
public class CodeApplication8081 {
    public static void main(String[] args) {
        SpringApplication.run(CodeApplication8081.class,args);
    }
}
package com.idstaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenjie
 * @date 2021/1/4 13:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmailApplication9190 {
    public static void main(String[] args) {
        SpringApplication.run(EmailApplication9190.class,args);
    }
}

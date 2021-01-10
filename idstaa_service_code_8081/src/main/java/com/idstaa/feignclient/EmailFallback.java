package com.idstaa.feignclient;

import org.springframework.stereotype.Component;

/**
 * @author chenjie
 * @date 2021/1/4 14:21
 */
@Component
public class EmailFallback implements EmailServiceFeignClient {
    @Override
    public boolean sendEmail(String email, String code) {
        return false;
    }
}

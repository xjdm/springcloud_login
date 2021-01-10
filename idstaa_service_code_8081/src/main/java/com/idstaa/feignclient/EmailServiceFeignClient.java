package com.idstaa.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenjie
 * @date 2021/1/4 14:21
 */
@FeignClient(value="idstaa-service-email",fallback = EmailFallback.class,path = "/email")
public interface EmailServiceFeignClient {
    @GetMapping(value = "/{email}/{code}")
   boolean sendEmail(@PathVariable("email") String email, @PathVariable("code") String code);
}

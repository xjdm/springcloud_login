package com.idstaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjie
 * @date 2021/1/4 13:29
 */

@RestController
@RequestMapping("/")
public class EmailController {
    @Autowired(required = true)
    private JavaMailSender mailSender;
    @Value("${spring.mail.from}")
    private String from;

    /**
     * 发送验证码到邮箱，true成功，false失败
     * @param email
     * @param code
     * @return
     */
    @GetMapping("/email/{email}/{code}")
    public boolean sendEmail(@PathVariable String email, @PathVariable String code){
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(email.split(";"));
        //邮件主题
        message.setSubject("【idstaa】springCloud登录注册短信验证码");
        //邮件内容
        message.setText("idstaa验证码："+code);
        //发送邮件
        mailSender.send(message);
        return true;
    }
}

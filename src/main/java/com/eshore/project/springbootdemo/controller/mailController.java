package com.eshore.project.springbootdemo.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Api(value="/mail",tags={"邮件控制层"})
public class mailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.addr}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;
    /**
     * 测试springboot
     * @return
     */
    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/sendSimpleMail")
    public void sendSimpleMail() {
        String to = "1733571444@qq.com";
        //不能发送垃圾邮件
        String subject = "公司的介绍";
        String content = "你好，我们是......";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }

    }
}

package com.example.EmailServiceExam;


import com.example.EmailServiceExam.dto.EmailRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
@Slf4j
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public void sendMail(@RequestBody EmailRequestDto emailRequestDto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        log.info("Email request received for: "+emailRequestDto.getTo());
        simpleMailMessage.setFrom("0708802077nar@gmail.com");
        simpleMailMessage.setTo(emailRequestDto.getTo());
        simpleMailMessage.setSubject(emailRequestDto.getSubject());
        simpleMailMessage.setText(emailRequestDto.getBody());

        javaMailSender.send(simpleMailMessage);
        log.info("Mail sent successfully!");


    }

}

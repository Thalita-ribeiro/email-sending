package com.devsuperior.integrations.controller;

import com.devsuperior.integrations.dto.EmailDto;
import com.devsuperior.integrations.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody EmailDto emailDto) {
        emailService.sendEmail(emailDto);
        return ResponseEntity.noContent().build();
    }
}

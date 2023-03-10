package com.devsuperior.integrations.service;

import com.devsuperior.integrations.dto.EmailDto;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private static Logger LOG = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private SendGrid sendGrid;

    public void sendEmail(EmailDto emailDto) {
        Email from = new Email(emailDto.getFromEmail(), emailDto.getFromName());
        Email to = new Email(emailDto.getTo());
        Content content = new Content(emailDto.getContentType(), emailDto.getBody());
        Mail mail = new Mail(from, emailDto.getSubject(), to, content);

        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            LOG.info("Sending email to: " + emailDto.getTo());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400 & response.getStatusCode() <= 500) {
                LOG.error("Error sending email" + response.getBody());
            } else {
                LOG.info("Email sent! Status = " + response.getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

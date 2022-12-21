package com.devsuperior.integrations.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class EmailDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fromEmail;
    private String fromName;
    private String replyTo;
    private String to;
    private String body;
    private String contentType;

    public EmailDto() {
    }

    public EmailDto(String fromEmail, String fromName, String replyTo, String to, String body, String contentType) {
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.replyTo = replyTo;
        this.to = to;
        this.body = body;
        this.contentType = contentType;
    }
}

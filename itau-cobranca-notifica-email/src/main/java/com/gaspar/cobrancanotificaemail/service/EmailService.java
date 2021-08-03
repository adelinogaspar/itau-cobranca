package com.gaspar.cobrancanotificaemail.service;

import com.gaspar.cobrancanotificaemail.config.properties.EmailServerProperties;
import com.gaspar.cobrancanotificaemail.entity.Cobranca;
import com.gaspar.cobrancanotificaemail.entity.Email;
import com.gaspar.cobrancanotificaemail.entity.TemplateEmail;
import com.gaspar.cobrancanotificaemail.repository.EmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmailServerProperties emailServerProperties;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    TemplateEmailService templateEmailService;

    @Autowired
    UUIDService uuidService;


    public void sendSimpleMessage(
            String to,
            String subject,
            String text
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailServerProperties.getFrom());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public Email save(Email email) {
        email.setDataEnvio(new Date());
        email.setId(uuidService.generateId());
        return emailRepository.save(email);
    }

    public void sendMail(Email email) {
        sendSimpleMessage(email.getEmailPara(), email.getAssunto(), email.getCorpo());
        LOGGER.info(email.toString());
    }

    public void sendMailCobranca(Cobranca cobranca) {
        Email email = templateEmailService.aplicaTemplateCobranca(cobranca);
        sendMail(email);
        save(email);
    }
}

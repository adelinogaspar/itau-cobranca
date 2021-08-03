package com.gaspar.cobrancanotificaemail.config;

import com.gaspar.cobrancanotificaemail.config.properties.EmailServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailSenderConfig {
    @Autowired
    EmailServerProperties emailServerProperties;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailServerProperties.getHost());
        mailSender.setPort(emailServerProperties.getPort());

        mailSender.setUsername(emailServerProperties.getUsername());
        mailSender.setPassword(emailServerProperties.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailServerProperties.getTransportProtocol());
        props.put("mail.smtp.auth", emailServerProperties.isSmtpAuthEnable());
        props.put("mail.smtp.starttls.enable", emailServerProperties.isSmtpStartTlsEnable());
        props.put("mail.debug", emailServerProperties.isDebug());

        return mailSender;
    }
}

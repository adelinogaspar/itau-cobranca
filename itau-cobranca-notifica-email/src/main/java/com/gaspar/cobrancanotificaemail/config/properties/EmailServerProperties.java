package com.gaspar.cobrancanotificaemail.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
@Getter
@Setter
public class EmailServerProperties {
    String from;
    String host;
    int port;
    String username;
    String password;
    String transportProtocol;
    boolean smtpAuthEnable;
    boolean smtpStartTlsEnable;
    boolean debug;

}

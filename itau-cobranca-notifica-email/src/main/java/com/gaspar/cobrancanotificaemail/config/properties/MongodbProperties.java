package com.gaspar.cobrancanotificaemail.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Getter
@Setter
public class MongodbProperties {
    String username;
    String password;
    String host;
    int port;
    String database;
    boolean autoIndexCreation;
}

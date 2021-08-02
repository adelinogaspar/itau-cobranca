package com.gaspar.cobranca.config;

import com.gaspar.cobranca.config.properties.MongodbProperties;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collections;

@Configuration
public class MongodbConfig extends AbstractMongoClientConfiguration {

    @Autowired
    MongodbProperties mongodbProperties;

    @Override
    protected String getDatabaseName() {
        return mongodbProperties.getDatabase();
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder.credential(MongoCredential.createCredential(
                        mongodbProperties.getUsername(),
                        mongodbProperties.getDatabase(),
                        mongodbProperties.getPassword().toCharArray())
                )
                .applyToClusterSettings(settings -> {

                    settings.hosts(Collections.singletonList(new ServerAddress(mongodbProperties.getHost(), mongodbProperties.getPort())));
                });
    }

}

package com.gaspar.cobrancanotificaemail.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String QUEUE_NOTIFICA_COBRANCA_EMAIL = "queue.notifica.cobranca.email";

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonConverter());
        return template;
    }

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("cobranca.direct");
    }

    @Bean
    Queue queueNotificaCobrancaEmail() {
        return new Queue(QUEUE_NOTIFICA_COBRANCA_EMAIL, true);
    }

    @Bean
    public Binding bindingEmail(DirectExchange direct,
                                Queue queueNotificaCobrancaEmail) {
        return BindingBuilder.bind(queueNotificaCobrancaEmail)
                .to(direct)
                .with("email");
    }
}

package com.gaspar.cobranca.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_NOTIFICA_COBRANCA_SMS = "queue.notifica.cobranca.sms";
    public static final String QUEUE_NOTIFICA_COBRANCA_EMAIL = "queue.notifica.cobranca.email";
    public static final String QUEUE_NOTIFICA_COBRANCA_TELEGRAM = "queue.notifica.cobranca.telegram";

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("cobranca.direct");
    }

    @Bean
    Queue queueNotificaCobrancaSms() {
        return new Queue(QUEUE_NOTIFICA_COBRANCA_SMS, true);
    }

    @Bean
    public Binding bindingSms(DirectExchange direct,
                             Queue queueNotificaCobrancaSms) {
        return BindingBuilder.bind(queueNotificaCobrancaSms)
                .to(direct)
                .with("sms");
    }

    @Bean
    Queue queueNotificaCobrancaTelegram() {
        return new Queue(QUEUE_NOTIFICA_COBRANCA_TELEGRAM, true);
    }

    @Bean
    public Binding bindingTelegram(DirectExchange direct,
                              Queue queueNotificaCobrancaTelegram) {
        return BindingBuilder.bind(queueNotificaCobrancaTelegram)
                .to(direct)
                .with("telegram");
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
}

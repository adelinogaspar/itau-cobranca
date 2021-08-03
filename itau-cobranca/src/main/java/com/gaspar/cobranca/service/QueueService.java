package com.gaspar.cobranca.service;

import com.gaspar.cobranca.config.RabbitmqConfig;
import com.gaspar.cobranca.dto.CobrancaDto;
import com.gaspar.cobranca.entity.Cobranca;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    @Autowired
    private ConvertService convert;

    public void enqueue(Cobranca cobranca) {
        CobrancaDto cobrancaDto = convert.toDto(cobranca);
        template.convertAndSend(RabbitmqConfig.QUEUE_NOTIFICA_COBRANCA_SMS, cobrancaDto);
        template.convertAndSend(RabbitmqConfig.QUEUE_NOTIFICA_COBRANCA_EMAIL, cobrancaDto);
        template.convertAndSend(RabbitmqConfig.QUEUE_NOTIFICA_COBRANCA_TELEGRAM, cobrancaDto);
    }
}

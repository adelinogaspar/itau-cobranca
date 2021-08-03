package com.gaspar.cobrancanotificaemail.controller.queue;

import com.gaspar.cobrancanotificaemail.config.RabbitmqConfig;
import com.gaspar.cobrancanotificaemail.dto.CobrancaDto;
import com.gaspar.cobrancanotificaemail.service.ConvertService;
import com.gaspar.cobrancanotificaemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoEmailQueueListener {

    @Autowired
    EmailService emailService;

    @Autowired
    ConvertService convert;

    @RabbitListener(queues = RabbitmqConfig.QUEUE_NOTIFICA_COBRANCA_EMAIL)
    public void notificacaoEmail(CobrancaDto cobrancaDto) {
        emailService.sendMailCobranca(convert.toEntity(cobrancaDto));
    }
}

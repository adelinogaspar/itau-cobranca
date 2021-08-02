package com.gaspar.cobranca.service;

import com.gaspar.cobranca.entity.Cobranca;
import com.gaspar.cobranca.exception.DuplicatedRecordException;
import com.gaspar.cobranca.repository.CobrancaRepository;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CobrancaService {

    @Autowired
    CobrancaRepository cobrancaRepository;

    @Autowired
    QueueService queueService;

    Cobranca save(Cobranca cobranca) {
        try {
            return cobrancaRepository.save(cobranca);
        } catch (Exception e) {
            throw new DuplicatedRecordException("[CobrancaService.save] Registro de cobrança duplicado.");
        }
    }

    public Cobranca criaCobranca(Cobranca cobranca) {
        cobranca.setDataCriacao(new Date());
        save(cobranca);
        queueService.enqueue(cobranca);
        return cobranca;
    }
}

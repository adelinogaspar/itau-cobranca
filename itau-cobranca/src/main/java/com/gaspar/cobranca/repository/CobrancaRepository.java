package com.gaspar.cobranca.repository;

import com.gaspar.cobranca.entity.Cobranca;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobrancaRepository extends MongoRepository<Cobranca, String> {
}

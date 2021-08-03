package com.gaspar.cobrancanotificaemail.repository;

import com.gaspar.cobrancanotificaemail.entity.TemplateEmail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateEmailRepository extends MongoRepository<TemplateEmail, String> {
    Optional<TemplateEmail> findByCategoria(String categoria);
}

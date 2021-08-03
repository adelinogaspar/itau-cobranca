package com.gaspar.cobrancanotificaemail.repository;

import com.gaspar.cobrancanotificaemail.entity.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {
}

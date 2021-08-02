package com.gaspar.cobranca.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDService {
    String generateId() {
        return UUID.randomUUID().toString();
    }
}

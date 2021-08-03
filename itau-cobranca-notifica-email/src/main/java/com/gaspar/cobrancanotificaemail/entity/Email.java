package com.gaspar.cobrancanotificaemail.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder(toBuilder=true)
@Document(collection = "email")
public class Email {
    String id;
    String emailPara;
    String assunto;
    String corpo;
    Date dataEnvio;
}

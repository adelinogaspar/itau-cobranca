package com.gaspar.cobrancanotificaemail.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder(toBuilder=true)
@Document(collection = "template_email")
public class TemplateEmail {
    @Indexed(unique=true, direction = IndexDirection.ASCENDING)
    String categoria;
    String assunto;
    String from;
    String corpo;
}

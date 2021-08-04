package com.gaspar.cobranca.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
@Builder(toBuilder=true)
@Document(collection = "cobranca")
public class Cobranca {
    @Indexed(unique=true, direction = IndexDirection.ASCENDING)
    String idCliente;
    String nome;
    String email;
    String telefone;
    Date dataCriacao;
}

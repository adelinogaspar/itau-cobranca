package com.gaspar.cobrancanotificaemail.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CobrancaDto {
    String idCliente;
    String nome;
    String email;
    String telefone;
    Date dataCriacao;
}

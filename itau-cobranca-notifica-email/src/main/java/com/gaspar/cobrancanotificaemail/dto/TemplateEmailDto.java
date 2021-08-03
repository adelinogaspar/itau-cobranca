package com.gaspar.cobrancanotificaemail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateEmailDto {
    String categoria;
    String assunto;
    String from;
    String corpo;
}

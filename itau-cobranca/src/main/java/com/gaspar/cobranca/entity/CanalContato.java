package com.gaspar.cobranca.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CanalContato {
    String canal;
    Date dataUltimoContato;
}

package com.gaspar.cobranca.service;

import com.gaspar.cobranca.dto.CobrancaDto;
import com.gaspar.cobranca.dto.CobrancaPostDto;
import com.gaspar.cobranca.entity.Cobranca;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService {

    @Autowired
    ModelMapper modelMapper;

    public Cobranca toEntity(CobrancaPostDto cobrancaPostDto) {
        return modelMapper.map(cobrancaPostDto, Cobranca.class);
    }

    public CobrancaPostDto toCobrancaPostDto(Cobranca cobranca) {
        return modelMapper.map(cobranca, CobrancaPostDto.class);
    }

    public CobrancaDto toDto(Cobranca cobranca) {
        return modelMapper.map(cobranca, CobrancaDto.class);
    }
}

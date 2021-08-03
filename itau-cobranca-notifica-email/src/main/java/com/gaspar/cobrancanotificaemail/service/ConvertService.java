package com.gaspar.cobrancanotificaemail.service;

import com.gaspar.cobrancanotificaemail.dto.CobrancaDto;
import com.gaspar.cobrancanotificaemail.dto.CobrancaPostDto;
import com.gaspar.cobrancanotificaemail.dto.TemplateEmailDto;
import com.gaspar.cobrancanotificaemail.entity.Cobranca;
import com.gaspar.cobrancanotificaemail.entity.TemplateEmail;
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

    public Cobranca toEntity(CobrancaDto cobrancaDto) {
        return modelMapper.map(cobrancaDto, Cobranca.class);
    }

    public CobrancaPostDto toCobrancaPostDto(Cobranca cobranca) {
        return modelMapper.map(cobranca, CobrancaPostDto.class);
    }

    public CobrancaDto toDto(Cobranca cobranca) {
        return modelMapper.map(cobranca, CobrancaDto.class);
    }

    public TemplateEmail toEntity(TemplateEmailDto templateEmailDto) {
        return modelMapper.map(templateEmailDto, TemplateEmail.class);
    }

    public TemplateEmailDto toDto(TemplateEmail templateEmail) {
        return modelMapper.map(templateEmail, TemplateEmailDto.class);
    }

}

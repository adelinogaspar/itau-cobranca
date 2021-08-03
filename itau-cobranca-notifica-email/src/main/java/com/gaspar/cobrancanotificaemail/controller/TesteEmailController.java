package com.gaspar.cobrancanotificaemail.controller;

import com.gaspar.cobrancanotificaemail.dto.CobrancaDto;
import com.gaspar.cobrancanotificaemail.dto.CobrancaPostDto;
import com.gaspar.cobrancanotificaemail.service.ConvertService;
import com.gaspar.cobrancanotificaemail.service.EmailService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(
        value = "/teste",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteEmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    ConvertService convert;

    @PostMapping
    public ResponseEntity<CobrancaDto> criaCobranca (
            @Parameter(description="CobrancaDto: dados de cobrança, não pode ser nulo ou vazio",
                    required=true,
                    content = @Content(schema=@Schema(implementation = CobrancaPostDto.class)))
            @Valid @RequestBody CobrancaPostDto cobrancaPostDto
    ) {
        emailService.sendMailCobranca(convert.toEntity(cobrancaPostDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

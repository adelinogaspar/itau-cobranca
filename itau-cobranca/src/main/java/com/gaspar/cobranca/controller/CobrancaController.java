package com.gaspar.cobranca.controller;


import com.gaspar.cobranca.dto.CobrancaDto;
import com.gaspar.cobranca.dto.CobrancaPostDto;
import com.gaspar.cobranca.entity.Cobranca;
import com.gaspar.cobranca.service.CobrancaService;
import com.gaspar.cobranca.service.ConvertService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
        value = "/cobranca",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CobrancaController {

    @Autowired
    CobrancaService cobrancaService;

    @Autowired
    ConvertService convert;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "Cobrança criada",
                    content = @Content(schema = @Schema(implementation = CobrancaDto.class))),
            @ApiResponse(
                    responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = Void.class)))
    })
    @PostMapping(path = "/ask")
    public ResponseEntity<CobrancaDto> criaCobranca (
            @Parameter(description="Order to place. Cannot be null or empty.",
                    required=true,
                    content = @Content(schema=@Schema(implementation = CobrancaPostDto.class)))
            @Valid @RequestBody CobrancaPostDto cobrancaPostDto
    ) {
        Cobranca cobranca = cobrancaService.criaCobranca(convert.toEntity(cobrancaPostDto));
        return new ResponseEntity(convert.toDto(cobranca), HttpStatus.CREATED);
    }
}

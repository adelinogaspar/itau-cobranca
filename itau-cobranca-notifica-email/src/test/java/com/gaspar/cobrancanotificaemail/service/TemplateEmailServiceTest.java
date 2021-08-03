package com.gaspar.cobrancanotificaemail.service;

import com.gaspar.cobrancanotificaemail.entity.Cobranca;
import com.gaspar.cobrancanotificaemail.entity.Email;
import com.gaspar.cobrancanotificaemail.entity.TemplateEmail;
import com.gaspar.cobrancanotificaemail.repository.TemplateEmailRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class TemplateEmailServiceTest {
    @Mock
    TemplateEmailRepository templateEmailRepository;

    @InjectMocks
    TemplateEmailService templateEmailService;

    public static final String CATEGORIA_OK = "cobranca";
    public static final String CATEGORIA_NOK = "********";

    @BeforeEach
    public void prepareTemplateCobranca() {
        TemplateEmail templateEmail = new TemplateEmail();
        templateEmail.setAssunto("assunto teste #nome#");
        templateEmail.setCategoria("cobranca");
        templateEmail.setFrom("nao-responda@teste.com");
        templateEmail.setCorpo("corpo teste #nome#");

        Optional<TemplateEmail> optionalTemplateEmail = Optional.of(templateEmail);

        Mockito.when(templateEmailRepository.findByCategoria(CATEGORIA_OK))
                .thenReturn(optionalTemplateEmail);
    }

    public Cobranca prepareCobrancaOK() {
        Cobranca cobranca = new Cobranca();
        cobranca.setEmail("teste@dominioteste.com");
        cobranca.setIdCliente("abc123");
        cobranca.setNome("Fulano123 da Silva");
        return cobranca;
    }

    @Test
    public void whenFindByCategoriaNotFound() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> templateEmailService.find(CATEGORIA_NOK));
    }

    @Test
    public void whenFindByCategoriaFound() {
        TemplateEmail templateEmail = templateEmailService.find(CATEGORIA_OK);

        Assertions.assertThat(templateEmail)
                .isNotEqualTo(Optional.empty());
    }

    @Test
    public void substituiVarsTemplate() {
        Cobranca cobranca = prepareCobrancaOK();
        String textoComSubstituicaoComNome = templateEmailService.substituiVarsTemplate("#nome# blablabla", cobranca);

        Assertions.assertThat(textoComSubstituicaoComNome.equals("Fulano123 da Silva blablabla"));
    }

    @Test
    public void aplicaTemplateCobranca() {
        Cobranca cobranca = prepareCobrancaOK();
        Email email = templateEmailService.aplicaTemplateCobranca(cobranca);

        Assertions.assertThat(email.getAssunto().equals("assunto teste Fulano123 da Silva"));
        Assertions.assertThat(email.getAssunto().equals("corpo teste Fulano123 da Silva"));
    }
}

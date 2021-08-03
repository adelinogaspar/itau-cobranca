package com.gaspar.cobrancanotificaemail.service;

import com.gaspar.cobrancanotificaemail.entity.Cobranca;
import com.gaspar.cobrancanotificaemail.entity.Email;
import com.gaspar.cobrancanotificaemail.entity.TemplateEmail;
import com.gaspar.cobrancanotificaemail.repository.TemplateEmailRepository;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateEmailService {
    @Autowired
    TemplateEmailRepository templateEmailRepository;

    public TemplateEmail find(String categoria) {
        Optional<TemplateEmail> template = templateEmailRepository.findByCategoria(categoria);
        Assert.isTrue(template.isPresent(), String.format("Não foi encontrado nenhum template de email com a categoria %s", categoria));
        return template.get();
    }

    public TemplateEmail save(TemplateEmail templateEmail) {
        return templateEmailRepository.save(templateEmail);
    }

    public String substituiVarsTemplate(String texto, Cobranca cobranca) {
        String textoFinal = texto;
        textoFinal = textoFinal.replaceAll("#nome#", cobranca.getNome());
        return textoFinal;
    }

    public Email aplicaTemplateCobranca(Cobranca cobranca) {
        TemplateEmail templateEmail = find("cobranca");

        Email email = new Email();
        email.setCorpo(substituiVarsTemplate(templateEmail.getCorpo(), cobranca));
        email.setAssunto(substituiVarsTemplate(templateEmail.getAssunto(), cobranca));
        email.setEmailPara(cobranca.getEmail());

        return email;
    }
}

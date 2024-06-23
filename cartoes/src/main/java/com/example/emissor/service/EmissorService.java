package com.example.emissor.service;

import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;
import com.example.emissor.template.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmissorService {
    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmail(Cliente cliente, Cartao cartao) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@teste.com");
        message.setTo(cliente.getEmail());
        message.setSubject("Cartão de Crédito Emitido");
        message.setText(EmailTemplate.getTemplate(cliente, cartao));

        emailSender.send(message);
    }
}

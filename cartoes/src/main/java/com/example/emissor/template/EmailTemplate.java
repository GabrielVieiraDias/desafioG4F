package com.example.emissor.template;

import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;

public class EmailTemplate {
    public static String getTemplate(Cliente cliente, Cartao cartao) {
        return "Olá " + cliente.getNome() + ",\n\n" +
                "Seu cartão foi emitido com sucesso!\n" +
                "Número do Cartão: " + cartao.getNumeroCartao() + "\n" +
                "Limite: " + cartao.getLimite() + "\n\n";
    }
}
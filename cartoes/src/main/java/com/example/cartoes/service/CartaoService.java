package com.example.cartoes.service;

import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    public Cartao criarCartao(Cliente cliente) {
        Cartao cartao = new Cartao();
        cartao.setClienteId(cliente.getId());
        cartao.setLimite(calcularLimite(cliente.getScore().getId()));
        cartao.setNumeroCartao(gerarNumeroCartao());

        return cartaoRepository.save(cartao);
    }

    private double calcularLimite(Integer score) {
        return 1000.0 * score;
    }

    private String gerarNumeroCartao() {
        Random random = new Random();

        int parte1 = random.nextInt(9999);
        int parte2 = random.nextInt(9999);
        int parte3 = random.nextInt(9999);
        int parte4 = random.nextInt(9999);

        String random16DigitNumber = String.format("%04d-%04d-%04d-%04d", parte1, parte2, parte3, parte4);

        return random16DigitNumber;
    }
}

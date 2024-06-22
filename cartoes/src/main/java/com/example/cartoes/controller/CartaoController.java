package com.example.cartoes.controller;

import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/emitir")
    public Cartao emitirCartao(@RequestBody Cliente cliente) {
        return cartaoService.criarCartao(cliente);
    }

}

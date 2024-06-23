package com.example.emissor.controller;

import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.service.CartaoService;
import com.example.cartoes.service.ClienteService;
import com.example.emissor.service.EmissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/emissor")
public class EmissorController {

    @Autowired
    private EmissorService emissorService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/emitir/{idCliente}")
    public void emitirCartao(@PathVariable Long idCliente) throws Exception {
        Optional<Cliente> cliente = clienteService.buscarCliente(idCliente);
        if (cliente.isPresent()){
            Cartao cartao = cartaoService.criarCartao(cliente.get());
            emissorService.enviarEmail(cliente.get(), cartao);
        } else
            throw new Exception("Cliente não encontrado.");
    }
}

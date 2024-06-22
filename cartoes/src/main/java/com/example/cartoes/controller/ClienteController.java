package com.example.cartoes.controller;

import com.example.cartoes.model.Cliente;
import com.example.cartoes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @PostMapping("/criar")
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return clienteService.criarCliente(cliente);
    }
    @GetMapping("/buscarCliente/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id);
    }
}

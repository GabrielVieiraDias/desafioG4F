package com.example.cartoes.service;

import com.example.cartoes.enumerator.EnumScoreClient;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long Id){
        return clienteRepository.findById(Id);
    }
}

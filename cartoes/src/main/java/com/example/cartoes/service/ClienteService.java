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

    public Cliente criaProposta (Long id) throws Exception {
        Optional<Cliente> cliente = buscarCliente(id);

        if(cliente.isPresent()){
            Cliente cliente1 = new Cliente();
            cliente1.setConta("123");
            cliente1.setEmail(cliente.get().getEmail());
            cliente1.setId(cliente.get().getId());
            cliente1.setNomeProposta("Proposta 1");
            cliente1.setScore(cliente.get().getScore());
            return cliente1;
        }else
            throw new Exception("Cliente não encontrado");
    }
}

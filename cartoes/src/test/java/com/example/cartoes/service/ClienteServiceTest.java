package com.example.cartoes.service;

import com.example.cartoes.enumerator.EnumScoreClient;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setEmail("test@teste.com");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteService.criarCliente(cliente);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("test@teste.com", resultado.getEmail());

        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void testBuscarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setEmail("test@teste.com");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.buscarCliente(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        assertEquals("test@teste.com", resultado.get().getEmail());

        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testCriaProposta_ClienteEncontrado() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setEmail("test@teste.com");
        cliente.setScore(EnumScoreClient.SCORE_ALTO);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.criaProposta(1L);

        assertNotNull(resultado);
        assertEquals("123", resultado.getConta());
        assertEquals("test@teste.com", resultado.getEmail());
        assertEquals(1L, resultado.getId());
        assertEquals("Proposta 1", resultado.getNomeProposta());
        assertEquals(EnumScoreClient.SCORE_ALTO, resultado.getScore());

        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void testCriaProposta_ClienteNaoEncontrado() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(Exception.class, () -> {
            clienteService.criaProposta(1L);
        });

        assertEquals("Cliente não encontrado", exception.getMessage());

        verify(clienteRepository, times(1)).findById(1L);
    }
}
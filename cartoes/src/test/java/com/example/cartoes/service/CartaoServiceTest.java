package com.example.cartoes.service;

import com.example.cartoes.enumerator.EnumScoreClient;
import com.example.cartoes.model.Cartao;
import com.example.cartoes.model.Cliente;
import com.example.cartoes.repository.CartaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CartaoServiceTest {

    @Mock
    private CartaoRepository cartaoRepository;

    @InjectMocks
    private CartaoService cartaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarCartao() {
        // Dados de teste
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setScore(EnumScoreClient.SCORE_REGULAR);
        cliente.setNome("Gabriel");
        cliente.setNomeProposta("aaaaa");
        cliente.setEmail("teste@teste.com");

        Cartao cartaoSalvo = new Cartao();
        cartaoSalvo.setClienteId(1L);
        cartaoSalvo.setClienteId(cliente.getId());
        cartaoSalvo.setLimite(2000.0);
        cartaoSalvo.setNumeroCartao("1234-5678-9876-5432");

        when(cartaoRepository.save(any(Cartao.class))).thenReturn(cartaoSalvo);

        Cartao resultado = cartaoService.criarCartao(cliente);

        assertNotNull(resultado);
        assertEquals(cliente.getId(), resultado.getClienteId());
        assertEquals(2000.0, resultado.getLimite());
        assertNotNull(resultado.getNumeroCartao());

        ArgumentCaptor<Cartao> cartaoCaptor = ArgumentCaptor.forClass(Cartao.class);
        verify(cartaoRepository, times(1)).save(cartaoCaptor.capture());
        Cartao cartaoParaSalvar = cartaoCaptor.getValue();

        assertEquals(cliente.getId(), cartaoParaSalvar.getClienteId());
        assertEquals(2000.0, cartaoParaSalvar.getLimite());
        assertNotNull(cartaoParaSalvar.getNumeroCartao());
    }
}

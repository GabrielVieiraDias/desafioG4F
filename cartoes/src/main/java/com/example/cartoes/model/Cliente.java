package com.example.cartoes.model;

import com.example.cartoes.enumerator.EnumScoreClient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String email;
    private EnumScoreClient score;

    private String conta;
    private String nomeProposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public EnumScoreClient getScore() {
        return score;
    }

    public void setScore(EnumScoreClient score) {
        this.score = score;
    }
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNomeProposta() {
        return nomeProposta;
    }

    public void setNomeProposta(String nomeProposta) {
        this.nomeProposta = nomeProposta;
    }

}

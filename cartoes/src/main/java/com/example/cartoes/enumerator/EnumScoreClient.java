package com.example.cartoes.enumerator;

public enum EnumScoreClient {

    SCORE_BAIXO(1, "BAIXO SCORE"),
    SCORE_REGULAR(2, "SCORE REGULAR"),
    SCORE_ALTO(3, "SCORE ALTO"),
    SCORE_EXCELENTE(4, "SCORE EXCELENTE");

    private Integer id;
    private String descricao;

    EnumScoreClient(Integer id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    public Integer getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }

}

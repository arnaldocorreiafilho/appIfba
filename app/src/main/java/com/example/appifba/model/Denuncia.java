package com.example.appifba.model;

public class Denuncia {

    private Long id;
    private  String descricao;

    public Denuncia(Long id, String descricao) {
        this.setId(id);
        this.setDescricao(descricao);
    }

    public Denuncia() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

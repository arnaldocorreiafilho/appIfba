package com.example.appifba.model;

public class Denuncia {


    private  String descricao;

    public Denuncia(String descricao) {

        this.setDescricao(descricao);
    }

    public Denuncia() {

    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

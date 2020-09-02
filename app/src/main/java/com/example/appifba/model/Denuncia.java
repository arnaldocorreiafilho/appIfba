package com.example.appifba.model;

public class Denuncia {

    private String uid;
    private  String descricao;
    public void setUid(String uid) {
        this.uid = uid;
    }



    public String getUid() {
        return uid;
    }


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

    @Override
    public String toString() {
        return "Denuncia{" +
                "uid='" + uid + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

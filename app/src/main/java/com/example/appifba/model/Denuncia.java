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


    public Denuncia(String uid,String descricao) {

        this.setDescricao(descricao);
        this.setUid(uid);
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

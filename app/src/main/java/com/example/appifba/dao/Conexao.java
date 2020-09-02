package com.example.appifba.dao;

import com.google.firebase.database.FirebaseDatabase;

public class Conexao  implements  IConexao{

    @Override
    public Object getConexao() {
        return FirebaseDatabase.getInstance();
    }
}

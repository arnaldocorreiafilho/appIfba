package com.example.appifba.dao;

import com.google.firebase.firestore.FirebaseFirestore;

public class Conexao  implements  IConexao{

    @Override
    public Object getConexao() {
        return FirebaseFirestore.getInstance();
    }
}

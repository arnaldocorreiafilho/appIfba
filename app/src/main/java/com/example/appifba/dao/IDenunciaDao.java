package com.example.appifba.dao;

import com.example.appifba.model.Denuncia;

import java.util.Map;

public interface IDenunciaDao {
   void salvar(Denuncia denuncia);
   void atualizar(Denuncia denuncia);
   Map<String,Denuncia> localizaPorId(String id);
   Map<String,Denuncia> listaTodos();
   void apagarporId(String id);
}

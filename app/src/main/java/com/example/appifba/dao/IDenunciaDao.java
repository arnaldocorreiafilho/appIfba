package com.example.appifba.dao;

import com.example.appifba.model.Denuncia;

import java.util.List;

public interface IDenunciaDao {
   void salvar(Denuncia denuncia);
   void atualizar(Denuncia denuncia);
   Denuncia localizaPorId(Long id);
   List<Denuncia> listaTodos();

}

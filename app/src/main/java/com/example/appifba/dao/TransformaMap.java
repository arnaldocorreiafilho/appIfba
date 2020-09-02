package com.example.appifba.dao;

import com.example.appifba.model.Denuncia;

import java.util.HashMap;
import java.util.Map;

public class TransformaMap {

    public static Map<String,Object> Transforma(Denuncia denuncia)
    {
        Map<String, Object> denuncias = new HashMap<>();

        denuncias.put("descricao",denuncia.getDescricao());
        return  denuncias;
    }
}

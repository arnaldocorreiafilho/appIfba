package com.example.appifba.dao;

import androidx.annotation.NonNull;

import com.example.appifba.model.Denuncia;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DenunciaDao implements IDenunciaDao {
    List<Denuncia> denuncias;
    private  static String TAG = "atividade";
    private  IConexao c;
    private FirebaseDatabase db;
    private  DatabaseReference ref;
    public DenunciaDao() {
        c = new Conexao();
        db  = (FirebaseDatabase) c.getConexao();
        ref = db.getReference().child("denuncias");
    }

    @Override
    public void salvar(Denuncia denuncia) {

        ref.push().setValue(denuncia);
    }

    @Override
    public void atualizar(Denuncia denuncia) {

    }

    @Override
    public Denuncia localizaPorId(Long id) {
        return  null;
    }
    private void Teste(List<Denuncia> denuncias)
    {
        this.denuncias = denuncias;
    }

    @Override
    public Map<String,Denuncia> listaTodos() {
        final Map<String,Denuncia> messages = new HashMap<>();
       Query query =  db.getReference("denuncias").limitToLast(50);
       query.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               GenericTypeIndicator<Map<String,Denuncia>> t = new GenericTypeIndicator<Map<String, Denuncia>>() {
               };
               messages.putAll(snapshot.getValue(t));
               System.out.println(messages.size()+"teste");
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
       return messages;
    }


}

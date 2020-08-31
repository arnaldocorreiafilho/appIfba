package com.example.appifba.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.appifba.model.Denuncia;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class DenunciaDao implements IDenunciaDao {
    private  IConexao c;
    private FirebaseFirestore db;

    public DenunciaDao() {
        c = new Conexao();
        db  = (FirebaseFirestore) c.getConexao();
    }

    @Override
    public void salvar(Denuncia denuncia) {
        Map<String,Object> denuncias = TransformaMap.Transforma(denuncia);
        db.collection("denuncias")
                .add(denuncias)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Sucesso", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Falhou", "Error adding document", e);
                    }
                });
    }

    @Override
    public void atualizar(Denuncia denuncia) {

    }

    @Override
    public Denuncia localizaPorId(Long id) {
        return null;
    }


    @Override
    public List<Denuncia> listaTodos() {

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Sucesso", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("Erro", "Error getting documents.", task.getException());
                        }
                    }
                });
        return null;
    }
}

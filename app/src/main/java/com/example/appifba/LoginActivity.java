package com.example.appifba;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appifba.adapter.Adapter;
import com.example.appifba.model.Denuncia;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LoginActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        recyclerView = findViewById(R.id.recyclerView);

       Query query1 = FirebaseDatabase.getInstance().getReference().child("denuncias");
        FirebaseRecyclerOptions<Denuncia> options = new  FirebaseRecyclerOptions.Builder<Denuncia>()
                        .setQuery(query1, Denuncia.class)
                        .build();
        Adapter adapter = new Adapter(options);
        adapter.startListening();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }
}
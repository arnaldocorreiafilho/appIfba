package com.example.appifba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appifba.adapter.Adapter;
import com.example.appifba.adapter.DenunciaViewHolder;
import com.example.appifba.model.Denuncia;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LoginActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null) {
            recyclerView = findViewById(R.id.recyclerView);

            Toolbar toolbar = (Toolbar) findViewById(R.id.id_toobar);
            toolbar.setTitle("Fazer Denúncia");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Listar Denúncias");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), LoginAuth.class));
                    finish();
                }
            });

            Query query1 = FirebaseDatabase.getInstance().getReference().child("denuncias");
            FirebaseRecyclerOptions<Denuncia> options = new FirebaseRecyclerOptions.Builder<Denuncia>()
                    .setQuery(query1, Denuncia.class)
                    .build();
            Adapter adapter = new Adapter(options);
            adapter.startListening();
            adapter.setIclick(new DenunciaViewHolder.Iclick() {
                @Override
                public void click(Denuncia denuncia) {
                    Intent intent = DetailsActivity.getStartIntent(getApplicationContext(), denuncia.getUid(), denuncia.getDescricao());
                    startActivity(intent);
                    finish();
                }
            });
            RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(lm);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }


    }
}
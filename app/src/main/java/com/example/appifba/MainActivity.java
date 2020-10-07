package com.example.appifba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appifba.dao.DenunciaDao;
import com.example.appifba.dao.IDenunciaDao;
import com.example.appifba.model.Denuncia;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private Button clickButton;
    private Button clickSingOut;
    private EditText text;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


            if(user != null) {
                final IDenunciaDao dao = new DenunciaDao();
                // Write a message to the database
                Toolbar toolbar = (Toolbar) findViewById(R.id.id_toobar);
                //toolbar.setTitle("Fazer Denúncia");
                setSupportActionBar(toolbar);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
                getSupportActionBar().setTitle("Fazer Denúncia");

                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(), LoginAuth.class));
                        finish();
                    }
                });

                clickButton = (Button) findViewById(R.id.button_send);
                text = (EditText) findViewById(R.id.edit_message);

                clickSingOut = (Button) findViewById(R.id.button_singout);


                clickButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (!text.getText().toString().equals("")) {
                            Denuncia d = new Denuncia();
                            //d.setUid("-MGExaSMJA6ZBZm3CU0x");
                            d.setDescricao(text.getText().toString());
                            dao.salvar(d);
                            //dao.listaTodos();
                        } else {

                            Toast.makeText(v.getContext(), "Valor da Caixa de Texto Vazio", Toast.LENGTH_LONG).show();

                        }


                    }
                });


                clickSingOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AuthUI.getInstance().signOut(MainActivity.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                signOut();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

                    }


                });
            }


    }

    private void signOut() {
        startActivity(new Intent(this, LoginAuth.class));
        finish();
    }
}
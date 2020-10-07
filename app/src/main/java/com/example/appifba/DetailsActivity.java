package com.example.appifba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DetailsActivity extends AppCompatActivity {

    private  static  String EXTRA_UID  = "UID";
    private  static String EXTRA_DESCRICAO = "DESCRICAO";
    TextView textViewUid;
    TextView textViewDesc;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.id_toobar);
            toolbar.setTitle("Fazer Denúncia");
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Visualizar Denúncias");
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            });

            Intent intent = getIntent();
            textViewUid = findViewById(R.id.txtuiddenucia);
            textViewDesc = findViewById(R.id.txt_descdenucia);
            textViewDesc.setText(intent.getStringExtra(EXTRA_DESCRICAO));
            textViewUid.setText(intent.getStringExtra(EXTRA_UID));
        }
    }

    public  static Intent getStartIntent(Context context,String uid,String descricao)
    {
        Intent intent = new Intent(context,DetailsActivity.class);
        intent.putExtra(EXTRA_UID,uid);
        intent.putExtra(EXTRA_DESCRICAO,descricao);
        return intent;
    }
}
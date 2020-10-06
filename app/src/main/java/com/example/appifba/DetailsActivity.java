package com.example.appifba;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private  static  String EXTRA_UID  = "UID";
    private  static String EXTRA_DESCRICAO = "DESCRICAO";
    TextView textViewUid;
    TextView textViewDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        textViewUid = findViewById(R.id.txtuiddenucia);
        textViewDesc = findViewById(R.id.txt_descdenucia);
        textViewDesc.setText(intent.getStringExtra(EXTRA_DESCRICAO));
        textViewUid.setText(intent.getStringExtra(EXTRA_UID));
    }

    public  static Intent getStartIntent(Context context,String uid,String descricao)
    {
        Intent intent = new Intent(context,DetailsActivity.class);
        intent.putExtra(EXTRA_UID,uid);
        intent.putExtra(EXTRA_DESCRICAO,descricao);
        return intent;
    }
}
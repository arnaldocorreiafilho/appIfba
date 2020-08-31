package com.example.appifba;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appifba.dao.DenunciaDao;
import com.example.appifba.dao.IDenunciaDao;
import com.example.appifba.model.Denuncia;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IDenunciaDao dao = new DenunciaDao();
        Denuncia d = new Denuncia(Long.valueOf(1),"Teste descricao");






    }
}
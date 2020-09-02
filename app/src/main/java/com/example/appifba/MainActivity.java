package com.example.appifba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appifba.dao.DenunciaDao;
import com.example.appifba.dao.IDenunciaDao;
import com.example.appifba.model.Denuncia;

public class MainActivity extends AppCompatActivity {


    private Button clickButton;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final IDenunciaDao dao = new DenunciaDao();
        // Write a message to the database

        clickButton = (Button) findViewById(R.id.button_send);
        text = (EditText) findViewById(R.id.edit_message);

        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Denuncia d = new Denuncia();
                d.setUid("-MGExaSMJA6ZBZm3CU0x");
                d.setDescricao(text.getText().toString());
               // dao.salvar(d);
                dao.atualizar(d);

            }
        });







    }
}
package com.example.aula_01.recyclefatima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class ActivityDescricao extends AppCompatActivity {

    TextView nome;
    TextView conteudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        nome = findViewById(R.id.descricaoMinas);
        conteudo = findViewById(R.id.descricao);
        nome.setText(getIntent().getStringExtra("nome"));
        conteudo.setText(getIntent().getStringExtra("conteudo"));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackground(getResources().getDrawable(getResources().getIdentifier(getIntent().getStringExtra("imagem"),"drawable", getPackageName())));
    }
}

package com.example.aula_01.recyclefatima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Click_Listener {

    FatimaAdapter fatimaAdapter;
    RecyclerView recyclerView;
    List<MinasProgramacao> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        String ada = getResources().getString(R.string.ada);
        String carol = getResources().getString(R.string.carol);
        String france = getResources().getString(R.string.france);
        String garotas = getResources().getString(R.string.garotas);
        String grace = getResources().getString(R.string.grace);
        String irma = getResources().getString(R.string.irma);
        String jean = getResources().getString(R.string.jean);
        String karen = getResources().getString(R.string.karen);
        String radia = getResources().getString(R.string.radia);
        String roberta = getResources().getString(R.string.roberta);

        MinasProgramacao adaa = new MinasProgramacao("Ada Lovelace",  "@drawable/adalovelace", ada);
        MinasProgramacao caroll = new MinasProgramacao("Carol Shaw",  "@drawable/carolshaw", carol);
        MinasProgramacao francee = new MinasProgramacao("France Sallen",  "@drawable/francesallen", france);
        MinasProgramacao garotass = new MinasProgramacao("Garotas do Eniac", "@drawable/garotasdoeniac", garotas);
        MinasProgramacao gracee = new MinasProgramacao("Grace Hopper", "@drawable/gracehopper", grace);
        MinasProgramacao irmaa = new MinasProgramacao("Irma Mary", "@drawable/irmamary", irma);
        MinasProgramacao jeann = new MinasProgramacao("Jean Sammet", "@drawable/jeansammet", jean);
        MinasProgramacao karenn = new MinasProgramacao("Karen Spark", "@drawable/karenspark", karen);
        MinasProgramacao radiaa = new MinasProgramacao("Radia Perlman", "@drawable/radiaperlman", radia);
        MinasProgramacao robertaa = new MinasProgramacao("Roberta Willians", "@drawable/robertawillians", roberta);

         lista = new ArrayList<>();
        lista.add(adaa);
        lista.add(caroll);
        lista.add(francee);
        lista.add(garotass);
        lista.add(gracee);
        lista.add(irmaa);
        lista.add(jeann);
        lista.add(karenn);
        lista.add(radiaa);
        lista.add(robertaa);
        fatimaAdapter = new FatimaAdapter(lista, this);
        fatimaAdapter.setClickListener(MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(fatimaAdapter);

    }

    @Override
    public void onClick(View view, int position) {
        MinasProgramacao minasProgramacao = lista.get(position);
        Intent intent = new Intent(view.getContext(), ActivityDescricao.class);
        intent.putExtra("nome", minasProgramacao.getNome());
        intent.putExtra("conteudo", minasProgramacao.getConteudo());
        intent.putExtra("imagem", minasProgramacao.getImagem());
        startActivity(intent);
    }
}

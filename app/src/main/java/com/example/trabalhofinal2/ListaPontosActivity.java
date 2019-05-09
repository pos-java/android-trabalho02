package com.example.trabalhofinal2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.trabalhofinal2.custom.AdapterCustom;
import com.example.trabalhofinal2.dao.Dao;
import com.example.trabalhofinal2.model.Ponto;

import java.util.List;

public class ListaPontosActivity extends AppCompatActivity {
    private ListView listaDePontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pontos);

        listaDePontos = (ListView) findViewById(R.id.lista);

        Dao dao = new Dao(this);

        List<Ponto> pontos = dao.listarPontos();
        AdapterCustom adapter = new AdapterCustom(pontos, this);

        listaDePontos.setAdapter(adapter);
    }
}

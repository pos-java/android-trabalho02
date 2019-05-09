package com.example.trabalhofinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAbrirMapa(View view) {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    public void onClickListar(View view) {
        startActivity(new Intent(MainActivity.this, ListaPontosActivity.class));
    }

    public void onClickCadastrar(View view) {
        startActivity(new Intent(MainActivity.this, CadastroActivity.class));
    }
}

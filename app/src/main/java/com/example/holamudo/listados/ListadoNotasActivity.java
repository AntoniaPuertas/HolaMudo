package com.example.holamudo.listados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.holamudo.R;
import com.example.holamudo.dates.Nota;

import java.util.ArrayList;

public class ListadoNotasActivity extends AppCompatActivity {

    ListView listViewNotas;
    ArrayList<Nota> listaNotas;
    ListadoNotasAdapter listadoNotasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_notas);

        listViewNotas = findViewById(R.id.lstNotas);

        listaNotas = new ArrayList<>();

        listaNotas.add(new Nota("Dar un paseo", "Importante"));
        listaNotas.add(new Nota("Comprar pan", "Normal"));
        listaNotas.add(new Nota("Cortarme el pelo", "urgente"));
        listaNotas.add(new Nota("Dar un paseo", "Importante"));
        listaNotas.add(new Nota("Comprar pan", "Normal"));
        listaNotas.add(new Nota("Cortarme el pelo", "urgente"));
        listaNotas.add(new Nota("Dar un paseo", "Importante"));
        listaNotas.add(new Nota("Comprar pan", "Normal"));
        listaNotas.add(new Nota("Cortarme el pelo", "urgente"));
        listaNotas.add(new Nota("Dar un paseo", "Importante"));
        listaNotas.add(new Nota("Comprar pan", "Normal"));
        listaNotas.add(new Nota("Cortarme el pelo", "urgente"));

        listadoNotasAdapter = new ListadoNotasAdapter(this, listaNotas);
        listViewNotas.setAdapter(listadoNotasAdapter);
    }
}

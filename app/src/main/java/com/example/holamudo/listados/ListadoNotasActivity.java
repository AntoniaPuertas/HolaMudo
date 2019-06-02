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

    //crea un objeto de la clase que hemos creado para mostrar cada nota
    ListadoNotasAdapter listadoNotasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_notas);

        listViewNotas = findViewById(R.id.lstNotas);

        //Creamos una lista de notas
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

        //llamamos al constructor del adapter pasándole el contexto y los datos
        listadoNotasAdapter = new ListadoNotasAdapter(this, listaNotas);

        //Vinculamos el adapter al listview
        listViewNotas.setAdapter(listadoNotasAdapter);
    }
}

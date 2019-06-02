package com.example.holamudo.listados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.holamudo.R;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listaPrueba;
    ArrayList<String> listaRobots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listaPrueba = findViewById(R.id.listado);
        //creo un arraylist con los datos que se van a mostrar en la lista
        listaRobots = new ArrayList<>();
        listaRobots.add("Mazinger Z");
        listaRobots.add("Afrodita");
        listaRobots.add("R2 D2");
        listaRobots.add("Sofarium");
        listaRobots.add("Conan");
        listaRobots.add("Bumblebee");
        listaRobots.add("Magdaleno");
        listaRobots.add("Afrodita");
        listaRobots.add("R2 D2");
        listaRobots.add("Mazinger Z");
        listaRobots.add("Afrodita");
        listaRobots.add("R2 D2");
        listaRobots.add("R2 D2");
        listaRobots.add("Sofarium");
        listaRobots.add("Conan");
        listaRobots.add("Bumblebee");
        listaRobots.add("Magdaleno");
        listaRobots.add("Afrodita");
        listaRobots.add("R2 D2");
        listaRobots.add("Mazinger Z");
        listaRobots.add("Afrodita");
        listaRobots.add("R2 D2");

        /*
        hay que definir un adaptador que se encarga de transformar
        todos los elementos del array y los va pintando como
        elementos del listview
        vamos a utilizar un adaptador por defecto que viene ya diseñado en android
         */
        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                listaRobots);

        //vinculamos el listview y el adaptador
        listaPrueba.setAdapter(adaptador);

        //definición de eventos sobre los elementos de la lista
        listaPrueba.setOnItemClickListener(this);

    }

    //evento que se ejecuta cuando se pulsa sobre un item de la lista
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Crea una variable con el string que contiene el arraylist en la posición que se ha pulsado
        String robotSeleccionado = listaRobots.get(position);

        //Muestra el valos del string en un Toast
        Toast.makeText(this,
                "Has elegido el robot: " + robotSeleccionado,
                Toast.LENGTH_LONG).show();
    }
}

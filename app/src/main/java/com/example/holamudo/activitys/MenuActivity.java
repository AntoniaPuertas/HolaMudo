package com.example.holamudo.activitys;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.holamudo.R;
import com.example.holamudo.listados.ListadoActivity;
import com.example.holamudo.listados.ListadoNotasActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    //declaro variables para los views de la vista asociada a esta activity
    TextView txtSaludo;
    Button btnNotificaciones;
    Button btnListado;
    Button btnListadoNotas;
    Button btnCalculadora;
    Button btnWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //creo las referencias de las views
        txtSaludo = findViewById(R.id.txtSaludo);
        btnNotificaciones = findViewById(R.id.btnNotificaciones);
        btnListado = findViewById(R.id.btnListado);
        btnListadoNotas = findViewById(R.id.btnListadoNotas);
        btnCalculadora = findViewById(R.id.btnCalculadora);
        btnWeb = findViewById(R.id.btnWeb);

        //asocio los listeners para los eventos onclick a cada botón
        btnNotificaciones.setOnClickListener(this);
        btnListado.setOnClickListener(this);
        btnListadoNotas.setOnClickListener(this);
        btnCalculadora.setOnClickListener(this);
        btnWeb.setOnClickListener(this);

        //recoje los datos que la ha mandado la activity anterior
        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email", "sin nombre");

        //muestra los datos en el textview
        txtSaludo.setText("Hola " + email);


    }

    //Método onClick que se encarga de esperar a que se pulse un botón para ejecutarse
    @Override
    public void onClick(View v) {
        //según el botón que se haya pulsado se inicia una actividad u otra
        switch (v.getId())
        {
            case R.id.btnNotificaciones:
                Intent intent = new Intent(MenuActivity.this, NotificacionesActivity.class);
                startActivity(intent);
                break;
            case R.id.btnListado:
                Intent intent2 = new Intent(MenuActivity.this, ListadoActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnListadoNotas:
                Intent intent3 = new Intent(MenuActivity.this, ListadoNotasActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnCalculadora:
                Intent intent4 = new Intent(MenuActivity.this, CalculadoraActivity.class);
                startActivity(intent4);
                break;
            case R.id.btnWeb:
                Intent intent5 = new Intent(MenuActivity.this, WebviewActivity.class);
                startActivity(intent5);
                break;
            default: 
                break;
        }

    }
}

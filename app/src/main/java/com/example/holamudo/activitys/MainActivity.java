package com.example.holamudo.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.holamudo.R;

public class MainActivity extends AppCompatActivity {

    //declaro variables para los views de la vista asociada a esta activity
    EditText edtEmail;
    EditText edtPassword;
    Button btnEntrar;
    CheckBox chkRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo las referencias de las views
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnEntrar = findViewById(R.id.btnEntrar);
        chkRecordar = findViewById(R.id.chkRecordar);

        //accedo a los datos guardados en preferencias
        SharedPreferences prefs =
                getSharedPreferences(
                        "misPreferencias",
                        Context.MODE_PRIVATE);

        //muestro los datos guardados en preferencias en las views
        edtEmail.setText(prefs.getString("email", ""));
        edtPassword.setText(prefs.getString("password", ""));

        //crea el listener para el botón entrar
        //este método se ejecuta cuando se pulsa el botón
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recoje los textos de los edittext
                String textoEmail = edtEmail.getText().toString();
                String textoPass = edtPassword.getText().toString();
                boolean correcto = true;

                //comprueba que haya texto introducido
                if(textoEmail.isEmpty()){
                    edtEmail.setError("Tienes que introducir un correo");
                    correcto = false;
                }
                //comprueba que se haya introducido una contraseña
                if(textoPass.isEmpty()){
                    edtPassword.setError("Tienes que introducir un password");
                    correcto = false;
                }


                if(correcto){
                    //llama a otra actividad y le pasa un valor
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.putExtra("email", textoEmail);
                    startActivity(intent);
                }
            }
        });
    }


    //métodos que se ejecutan a lo largo de la vida de una actividad
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.i("COMPROBANDO", "Ejecuta onStart");


    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        Log.i("COMPROBANDO", "Ejecuta onResume");
    }

    //método que se ejecuta cuando la actividad pierde el primer plano
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.i("COMPROBANDO", "Ejecuta onPause");

        //comprueba si el check está activado
        if(chkRecordar.isChecked()){
            //guarda datos en mis preferencias para que se mantengan guardados
            //de forma permanente aunque se cierrre la aplicación
            SharedPreferences pref = getSharedPreferences(
                    "misPreferencias",
                    Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = pref.edit();
            editor.putString("email", edtEmail.getText().toString());
            editor.putString("password", edtPassword.getText().toString());
            editor.commit();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        Log.i("COMPROBANDO", "Ejecuta onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        Log.i("COMPROBANDO", "Ejecuta onDestroy");
    }
}

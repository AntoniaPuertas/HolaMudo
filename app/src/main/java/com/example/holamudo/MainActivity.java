package com.example.holamudo;

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
import android.widget.TextView;

import com.example.holamudo.listados.ListadoNotasActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPassword;
    Button btnEntrar;
    CheckBox chkRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnEntrar = findViewById(R.id.btnEntrar);
        chkRecordar = findViewById(R.id.chkRecordar);

        SharedPreferences prefs =
                getSharedPreferences(
                        "misPreferencias",
                        Context.MODE_PRIVATE);
        edtEmail.setText(prefs.getString("email", ""));
        edtPassword.setText(prefs.getString("password", ""));

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoEmail = edtEmail.getText().toString();
                String textoPass = edtPassword.getText().toString();
                boolean correcto = true;
                if(textoEmail.isEmpty()){
                    edtEmail.setError("Tienes que introducir un correo");
                    correcto = false;
                }
                if(textoPass.isEmpty()){
                    edtPassword.setError("Tienes que introducir un password");
                    correcto = false;
                }
                if(correcto){

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("email", textoEmail);
                    startActivity(intent);
                }
            }
        });
    }

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
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        Log.i("COMPROBANDO", "Ejecuta onPause");
        if(chkRecordar.isChecked()){
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

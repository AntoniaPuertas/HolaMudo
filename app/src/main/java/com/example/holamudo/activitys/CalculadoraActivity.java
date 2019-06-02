package com.example.holamudo.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.holamudo.R;

public class CalculadoraActivity extends AppCompatActivity {

    EditText etNum1;
    EditText etNum2;
    RadioGroup rgOperaciones;
    RadioButton rgSuma;
    RadioButton rgResta;
    RadioButton rgMultiplicacion;
    RadioButton rgDivision;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        rgOperaciones = findViewById(R.id.rgOperaciones);
        rgSuma = findViewById(R.id.rgSuma);
        rgResta = findViewById(R.id.rgResta);
        rgMultiplicacion = findViewById(R.id.rgMultiplicacion);
        rgDivision = findViewById(R.id.rgDivision);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(comprobarDatos()){
                    txtResultado.setText(calcular());
                }
            }
        });

    }

    private boolean comprobarDatos(){
        boolean correcto = true;
        if(etNum1.getText().toString().isEmpty()){
            etNum1.setError("Debes introducir un número");
            correcto = false;
        }
        if(etNum2.getText().toString().isEmpty()){
            etNum2.setError("Debes introducir un número");
            correcto = false;
        }
        if(etNum2.getText().toString().equals("0") && rgDivision.isChecked()){
            etNum2.setError("No se puede dividir por cero");
            correcto = false;
        }
        return correcto;
    }

    private String calcular(){
        String resultado = "";

        double operador1 = Double.parseDouble(etNum1.getText().toString());
        double operador2 = Double.parseDouble(etNum2.getText().toString());

        int operacionSeleccionada = rgOperaciones.getCheckedRadioButtonId();

        // hacemos un case con lo que ocurre cada vez que pulsemos un botón

        switch(operacionSeleccionada) {
            case R.id.rgSuma:
                resultado = String.valueOf(operador1 + operador2);
                    break;
            case R.id.rgResta:
                resultado = String.valueOf(operador1 - operador2);
                    break;
            case R.id.rgMultiplicacion:
                resultado = String.valueOf(operador1 * operador2);
                    break;
            case R.id.rgDivision:
                resultado = String.valueOf(operador1 / operador2);
                    break;
            default:
                Toast.makeText(CalculadoraActivity.this, "No has seleccionado la operación a realizar", Toast.LENGTH_LONG).show();
                    break;
        }
        return resultado;
    }
}

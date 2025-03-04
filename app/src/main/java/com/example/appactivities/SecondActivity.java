package com.example.appactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    RadioButton suma, resta, mult, div;
    TextView res2;
    double num1, num2;
    String s = "";
    ImageButton btnEnviar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        btnEnviar2 = findViewById(R.id.btn_enviar2);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        mult = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        res2 = findViewById(R.id.resultado2);

        Intent i = getIntent();
        num1 = i.getDoubleExtra("numero1", 0.0);
        num2 = i.getDoubleExtra("numero2", 0.0);

        btnEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v); // Se llama antes de enviar el resultado

                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultado2", s);
                setResult(RESULT_OK, resultIntent); // Se envía el resultado a MainActivity
                finish(); // Se cierra esta actividad
            }
        });
    }

    public void calcular(View v) {
        if (suma.isChecked())
            s = "Suma de " + num1 + " + " + num2 + " = " + (num1 + num2);
        else if (resta.isChecked())
            s = "Resta de " + num1 + " - " + num2 + " = " + (num1 - num2);
        else if (mult.isChecked())
            s = "Multiplicación de " + num1 + " * " + num2 + " = " + (num1 * num2);
        else if (div.isChecked()) {
            if (num2 != 0)
                s = "División de " + num1 + " / " + num2 + " = " + (num1 / num2);
            else
                s = "Error: División por 0";
        }
    }
}

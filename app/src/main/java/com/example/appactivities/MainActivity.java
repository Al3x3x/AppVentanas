package com.example.appactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    ImageButton btnEnviar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);
        btnEnviar = (ImageButton) findViewById(R.id.btn_enviar);
        resultado = (TextView) findViewById(R.id.resultado);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double n1 = Double.parseDouble(numero1.getText().toString());
                Double n2 = Double.parseDouble(numero2.getText().toString());

                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                i.putExtra("numero1", n1);
                i.putExtra("numero2", n2);
                startActivity(i);
            }
        });
    }



}
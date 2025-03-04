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

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    ImageButton btnEnviar;
    TextView resultado;
    Button verres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        btnEnviar = findViewById(R.id.btn_enviar);
        resultado = findViewById(R.id.resultado);
        verres = findViewById(R.id.button);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double n1 = Double.parseDouble(numero1.getText().toString());
                Double n2 = Double.parseDouble(numero2.getText().toString());

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("numero1", n1);
                i.putExtra("numero2", n2);
                startActivityForResult(i, 1);
            }
        });

        verres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("No hay resultado aún.");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String resultadoCalculado = data.getStringExtra("resultado2");
            resultado.setText(resultadoCalculado);
        }
    }
}

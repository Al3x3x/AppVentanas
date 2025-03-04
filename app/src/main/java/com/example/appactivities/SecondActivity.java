package com.example.appactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
RadioButton suma,resta,mult,div;
TextView res2;
double num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        suma= (RadioButton) findViewById(R.id.suma);
        resta= (RadioButton) findViewById(R.id.resta);
        mult= (RadioButton) findViewById(R.id.multi);
        div= (RadioButton) findViewById(R.id.div);

      res2 = (TextView) findViewById(R.id.resultado2);

      Intent i= getIntent();
     num1=i.getDoubleExtra("numero1",0.0);
        num2=i.getDoubleExtra("numero2",0.0);



    }

    public void calcular(View v){
        String s="";
        if(suma.isChecked())
            s= "Suma de "+num1+"+"+num2+"="+(num1+num2);
       else if(resta.isChecked())
            s=  "Resta de "+num1+"-"+num2+"="+(num1-num2);
       else if(mult.isChecked())
            s=  "Multiplicacion de "+num1+"*"+num2+"="+(num1*num2);
        else if(div.isChecked())
            s=  "Division de "+num1+"/"+num2+"="+(num1/num2);

        res2.setText(s);

    }


}
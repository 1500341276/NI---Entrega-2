package com.example.questao1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbCoca;
    TextView textResultado;
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbCoca = findViewById(R.id.cbCoca);
        textResultado = findViewById(R.id.textResultado);
        btnSet = findViewById(R.id.btnSet);


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0;

                if (cbArroz.isChecked()) total += 2.69;
                if (cbLeite.isChecked()) total += 2.70;
                if (cbCarne.isChecked()) total += 16.70;
                if (cbFeijao.isChecked()) total += 3.38;
                if (cbCoca.isChecked()) total += 3.00;


                String resultado = String.format("Valor total: R$ %.2f", total);
                textResultado.setText(resultado);
            }
        });
    }
}
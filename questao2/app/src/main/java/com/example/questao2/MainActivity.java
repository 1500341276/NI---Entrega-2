package com.example.questao2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtSalario;
    RadioGroup radioGroup;
    RadioButton radio40, radio45, radio50;
    Button btnCalcular;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSalario = findViewById(R.id.edtSalario);
        radioGroup = findViewById(R.id.radioGroup);
        radio40 = findViewById(R.id.radio40);
        radio45 = findViewById(R.id.radio45);
        radio50 = findViewById(R.id.radio50);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String salarioStr = edtSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    textResultado.setText("Por favor, insira o salário!");
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double novoSalario = salario;

                if (radio40.isChecked()) {
                    novoSalario = salario * 1.40;
                } else if (radio45.isChecked()) {
                    novoSalario = salario * 1.45;
                } else if (radio50.isChecked()) {
                    novoSalario = salario * 1.50;
                } else {
                    textResultado.setText("Selecione um percentual!");
                    return;
                }

                String resultado = String.format("Novo salário: R$ %.2f", novoSalario);
                textResultado.setText(resultado);
            }
        });
    }
}

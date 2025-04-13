package com.example.questao4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;


public class ResumoActivity extends AppCompatActivity {

    TextView textDados;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo);

        textDados = findViewById(R.id.textDados);
        btnVoltar = findViewById(R.id.btnVoltar);


        String nome = getIntent().getStringExtra("nomeCliente");
        String lanche = getIntent().getStringExtra("lancheEscolhido");


        String textoFinal = "Cliente: " + nome + "\nLanche: " + lanche;
        textDados.setText(textoFinal);

        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainResumo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
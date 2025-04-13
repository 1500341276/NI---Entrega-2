package com.example.questao4;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;


public class PedidoActivity extends AppCompatActivity {

    EditText edtNome;
    RadioGroup groupLanches;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);

        edtNome = findViewById(R.id.edtNome);
        groupLanches = findViewById(R.id.groupLanches);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(view -> {
            String nome = edtNome.getText().toString().trim();
            if (nome.isEmpty()) {
                edtNome.setError("Digite seu nome");
                return;
            }

            int checkedId = groupLanches.getCheckedRadioButtonId();
            if (checkedId == -1) {
                return;
            }

            RadioButton rbSelecionado = findViewById(checkedId);
            String lancheEscolhido = rbSelecionado.getText().toString();

            Intent intent = new Intent(this, ResumoActivity.class);
            intent.putExtra("nomeCliente", nome);
            intent.putExtra("lancheEscolhido", lancheEscolhido);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainPedido), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
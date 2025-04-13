package com.example.questao5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    CheckBox cbCalabresa, cbMarguerita, cbPortuguesa;
    RadioGroup groupTamanho, groupPagamento;
    RadioButton rbPequena, rbMedia, rbGrande;
    RadioButton rbDinheiro, rbCartao;
    Button btnFinalizar;
    TextView textResumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        groupTamanho = findViewById(R.id.groupTamanho);
        groupPagamento = findViewById(R.id.groupPagamento);
        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);
        rbDinheiro = findViewById(R.id.rbDinheiro);
        rbCartao = findViewById(R.id.rbCartao);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        textResumo = findViewById(R.id.textResumo);

        btnFinalizar.setOnClickListener(view -> {
            StringBuilder sabores = new StringBuilder("Sabores: ");
            if (cbCalabresa.isChecked()) sabores.append("Calabresa ");
            if (cbMarguerita.isChecked()) sabores.append("Marguerita ");
            if (cbPortuguesa.isChecked()) sabores.append("Portuguesa ");

            String tamanho = "";
            double preco = 0;
            if (rbPequena.isChecked()) {
                tamanho = "Pequena";
                preco = 20;
            } else if (rbMedia.isChecked()) {
                tamanho = "Média";
                preco = 30;
            } else if (rbGrande.isChecked()) {
                tamanho = "Grande";
                preco = 40;
            }

            String pagamento = rbDinheiro.isChecked() ? "Dinheiro" :
                    rbCartao.isChecked() ? "Cartão" : "Não selecionado";

            String resumo = sabores + "\nTamanho: " + tamanho +
                    "\nPagamento: " + pagamento +
                    "\nTotal: R$ " + preco;

            textResumo.setText(resumo);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
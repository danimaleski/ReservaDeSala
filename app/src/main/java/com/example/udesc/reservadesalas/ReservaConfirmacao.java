package com.example.udesc.reservadesalas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.udesc.reservadesalas.ReservaDataActivity.DATA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.HORARIO_SELECIONADO;
import static com.example.udesc.reservadesalas.ReservaDataActivity.SALA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.NOME_RESPONSAVEL;

public class ReservaConfirmacao extends AppCompatActivity {

    TextView txtNome;
    TextView txtSala;
    TextView txtData;
    TextView txtHorario;

    String dataSelecionada;
    String horarioSelecionado;
    String salaSelecionada;
    String nomeResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_confirmacao);

        txtNome = findViewById(R.id.txtNome);
        txtSala = findViewById(R.id.txtSala);
        txtData  = findViewById(R.id.txtData);
        txtHorario = findViewById(R.id.txtHorario);

        nomeResp = getIntent().getStringExtra(NOME_RESPONSAVEL);
        salaSelecionada = getIntent().getStringExtra(SALA_SELECIONADA);
        dataSelecionada = getIntent().getStringExtra(DATA_SELECIONADA);
        horarioSelecionado = getIntent().getStringExtra(HORARIO_SELECIONADO);

        txtNome.setText("Nome: " + nomeResp);
        txtSala.setText("Sala: " + salaSelecionada);
        txtData.setText("Data: " + dataSelecionada);
        txtHorario.setText("Horários: " + horarioSelecionado);
    }
}

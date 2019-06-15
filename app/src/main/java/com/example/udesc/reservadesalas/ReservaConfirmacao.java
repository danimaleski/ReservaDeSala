package com.example.udesc.reservadesalas;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.udesc.reservadesalas.Services.ReservaService;

import static com.example.udesc.reservadesalas.ReservaDataActivity.DATA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.HORARIO_SELECIONADO;
import static com.example.udesc.reservadesalas.ReservaDataActivity.SALA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.NOME_RESPONSAVEL;

public class ReservaConfirmacao extends AppCompatActivity {

    TextView txtMsgConfirmacao;

    String dataSelecionada;
    String horarioSelecionado;
    String salaSelecionada;
    String nomeResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_confirmacao);

        txtMsgConfirmacao = findViewById(R.id.txtMsgConfirmacao);

        new PopulateTask().execute();

        nomeResp = getIntent().getStringExtra(NOME_RESPONSAVEL);
        salaSelecionada = getIntent().getStringExtra(SALA_SELECIONADA);
        dataSelecionada = getIntent().getStringExtra(DATA_SELECIONADA);
        horarioSelecionado = getIntent().getStringExtra(HORARIO_SELECIONADO);

    }

    class PopulateTask extends AsyncTask<Void, Void, Boolean> {
        //1º: DoInbackground recebe
        //2º: Não usamos progress
        //3º: retorno do doInnbackground e onPostExecute recebe

        @Override
        protected Boolean doInBackground(Void... voids) {
            ReservaService conecta = new ReservaService();
            boolean resultado = conecta.addReserva(
                    "1",
                    nomeResp,
                    dataSelecionada,
                    horarioSelecionado,
                    salaSelecionada
            );

            return resultado;
        }

        @Override
        protected void onPostExecute(Boolean sucesso) {
            if (sucesso) {
                txtMsgConfirmacao.setText("Reserva realizada com sucesso! Seu ID é 1");

            } else {
                txtMsgConfirmacao.setText("Erro ao realizar a reserva!");
            }

        }
    }
}

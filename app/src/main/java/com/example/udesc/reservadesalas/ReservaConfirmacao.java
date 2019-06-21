package com.example.udesc.reservadesalas;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.udesc.reservadesalas.Services.ReservaService;

import java.util.List;

import static com.example.udesc.reservadesalas.ReservaDataActivity.DATA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.HORARIO_SELECIONADO;
import static com.example.udesc.reservadesalas.ReservaDataActivity.SALA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.NOME_RESPONSAVEL;

public class ReservaConfirmacao extends AppCompatActivity {

    TextView txtMsgConfirmacao;
    Button btnNovaReserva;

    String maxId;
    String dataSelecionada;
    List<String> horarioSelecionado;
    String salaSelecionada;
    String nomeResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_confirmacao);

        txtMsgConfirmacao = findViewById(R.id.txtMsgConfirmacao);
        btnNovaReserva = findViewById(R.id.btnNovaReserva);

        new ConsultaIdTask().execute();
        new PopulateTask().execute();

        btnNovaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservaConfirmacao.this, ReservaDeSalasActivity.class);
                startActivity(intent);
            }
        });

    }

    class ConsultaIdTask extends AsyncTask<Void, Void, String> {
        //1º: DoInbackground recebe
        //2º: Não usamos progress
        //3º: retorno do doInnbackground e onPostExecute recebe

        @Override
        protected String doInBackground(Void... voids) {
            ReservaService conecta = new ReservaService();
            maxId = conecta.getMaxId();
            maxId = String.valueOf(Integer.parseInt(maxId) + 1);
            return maxId;
        }

        @Override
        protected void onPostExecute(String maxId) {

        }
    }

    class PopulateTask extends AsyncTask<Void, Void, Boolean> {
        //1º: DoInbackground recebe
        //2º: Não usamos progress
        //3º: retorno do doInnbackground e onPostExecute recebe

        @Override
        protected Boolean doInBackground(Void... voids) {
            ReservaService conecta = new ReservaService();

            String idAux;
            idAux = maxId;

            boolean resultado = false;

            nomeResp = getIntent().getStringExtra(NOME_RESPONSAVEL);
            salaSelecionada = getIntent().getStringExtra(SALA_SELECIONADA);
            dataSelecionada = getIntent().getStringExtra(DATA_SELECIONADA);
            horarioSelecionado = getIntent().getStringArrayListExtra(HORARIO_SELECIONADO);

            String codcancela = maxId + "-" + horarioSelecionado.get(0).toString();

            for (int i = 0; i < horarioSelecionado.size(); i++) {

                resultado = conecta.addReserva(
                        idAux,
                        nomeResp,
                        dataSelecionada,
                        horarioSelecionado.get(i).toString(),
                        salaSelecionada,
                        codcancela
                );

                idAux = String.valueOf(Integer.parseInt(idAux) + 1);

            }

            resultado = true;

            return resultado;
        }

        @Override
        protected void onPostExecute(Boolean sucesso) {
            if (sucesso) {

                txtMsgConfirmacao.setText("Reserva realizada com sucesso!\n\nCódigo da Reserva: " + maxId + "-" + horarioSelecionado.get(0));

            } else {
                txtMsgConfirmacao.setText("Erro ao realizar a reserva!");
            }

        }
    }
}

package com.example.udesc.reservadesalas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.udesc.reservadesalas.ReservaDataActivity.SALA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.DATA_SELECIONADA;
import static com.example.udesc.reservadesalas.ReservaDataActivity.HORARIO_SELECIONADO;
import static com.example.udesc.reservadesalas.ReservaDataActivity.NOME_RESPONSAVEL;

public class ReservaHorarioActivity extends AppCompatActivity {

    TextView txtDataSelecionada;
    TextView txtExibeIdHora;
    EditText NomeResp;
    Button btnConfirmar;
    String dataSelecionada;
    String salaSelecionada;
    String horariosSelecionados = "";
    String nomeResponsavel;
    CheckBox horario1;
    CheckBox horario2;
    CheckBox horario3;
    CheckBox horario4;
    CheckBox horario5;
    CheckBox horario6;
    CheckBox horario7;
    CheckBox horario8;
    CheckBox horario9;
    CheckBox horario10;
    CheckBox horario11;
    CheckBox horario12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_horario);

        txtDataSelecionada = findViewById(R.id.txtDataSelecionada);
        NomeResp = findViewById(R.id.NomeResp);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        horario1  = findViewById(R.id.horario1);
        horario2  = findViewById(R.id.horario2);
        horario3  = findViewById(R.id.horario3);
        horario4  = findViewById(R.id.horario4);
        horario5  = findViewById(R.id.horario5);
        horario6  = findViewById(R.id.horario6);
        horario7  = findViewById(R.id.horario7);
        horario8  = findViewById(R.id.horario8);
        horario9  = findViewById(R.id.horario9);
        horario10 = findViewById(R.id.horario10);
        horario11 = findViewById(R.id.horario11);
        horario12 = findViewById(R.id.horario12);

        dataSelecionada = getIntent().getStringExtra(DATA_SELECIONADA);
        txtDataSelecionada.setText(dataSelecionada);

        salaSelecionada = getIntent().getStringExtra(SALA_SELECIONADA);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horario1.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "1, ";
                }

                if (horario2.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "2, ";
                }
                if (horario3.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "3, ";
                }
                if (horario4.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "4, ";
                }
                if (horario5.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "5, ";
                }
                if (horario6.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "6, ";
                }
                if (horario7.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "7, ";
                }
                if (horario8.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "8, ";
                }
                if (horario9.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "9, ";
                }
                if (horario10.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "10, ";
                }
                if (horario11.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "11, ";
                }
                if (horario12.isChecked())
                {
                    horariosSelecionados = horariosSelecionados + "12";
                }

                horariosSelecionados = horariosSelecionados.replace(", \n", "");

                nomeResponsavel = NomeResp.getText().toString();

                Intent intent = new Intent(ReservaHorarioActivity.this, ReservaConfirmacao.class);

                intent.putExtra(DATA_SELECIONADA, dataSelecionada);
                intent.putExtra(SALA_SELECIONADA, salaSelecionada);
                intent.putExtra(HORARIO_SELECIONADO, horariosSelecionados);
                intent.putExtra(NOME_RESPONSAVEL, nomeResponsavel);

                startActivity(intent);
            }
        });

    }
}

package com.example.udesc.reservadesalas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;

import java.util.Date;

public class ReservaDataActivity extends AppCompatActivity {

    static String DATA_SELECIONADA = "DATA_SELECIONADA";
    static String SALA_SELECIONADA = "SALA_SELECIONADA";
    static String HORARIO_SELECIONADO = "HORARIO_SELECIONADO";
    static String NOME_RESPONSAVEL = "NOME_RESPONSAVEL";

    Button btnDataProximo;
    CalendarView calendarioData;
    RadioButton sala1;
    RadioButton sala2;
    RadioButton sala3;
    int teste;

    String dataSelecionada;
    String salaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_data);

        btnDataProximo = findViewById(R.id.btnDataProximo);
        calendarioData = findViewById(R.id.calendarioData);

        sala1 = findViewById(R.id.sala1);
        sala2 = findViewById(R.id.sala2);
        sala3 = findViewById(R.id.sala3);

        calendarioData.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                dataSelecionada = (dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        });

        btnDataProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sala1.isSelected())
                    salaSelecionada = "1";
                else if (sala2.isSelected())
                    salaSelecionada = "2";
                else
                    salaSelecionada = "3";

                Intent intent = new Intent(ReservaDataActivity.this, ReservaHorarioActivity.class);
                intent.putExtra(DATA_SELECIONADA, dataSelecionada);
                intent.putExtra(SALA_SELECIONADA, salaSelecionada);
                startActivity(intent);
            }
        });

    }
}

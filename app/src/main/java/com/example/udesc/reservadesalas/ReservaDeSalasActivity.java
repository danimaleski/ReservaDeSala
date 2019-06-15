package com.example.udesc.reservadesalas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReservaDeSalasActivity extends AppCompatActivity {

    Button btnReserva;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_de_salas);

        btnReserva = findViewById(R.id.btnReservar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservaDeSalasActivity.this, ReservaDataActivity.class);
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservaDeSalasActivity.this, ReservaCancelar.class);
                startActivity(intent);
            }
        });

    }
}

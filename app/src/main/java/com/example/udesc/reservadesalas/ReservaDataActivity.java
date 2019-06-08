package com.example.udesc.reservadesalas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReservaDataActivity extends AppCompatActivity {

    Button btnDataProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_data);

        btnDataProximo = findViewById(R.id.btnDataProximo);

        btnDataProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservaDataActivity.this, ReservaHorarioActivity.class);
                startActivity(intent);
            }
        });

    }
}

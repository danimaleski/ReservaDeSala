package com.example.udesc.reservadesalas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReservaCancelar extends AppCompatActivity {

    Button btncancelar;
    EditText txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_cancelar);

        btncancelar = findViewById(R.id.btncancelar);
        txtID = findViewById(R.id.txtID);

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog(txtID.getText().toString());
            }
        });

    }

    private void openDialog (final String id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Você tem certeza?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                new DeleteTask().execute(id);
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    class DeleteTask extends AsyncTask<String, Void, Boolean> {
        //1º: DoInbackground recebe
        //2º: Não usamos progress
        //3º: retorno do doInnbackground e onPostExecute recebe

        @Override
        protected Boolean doInBackground(String... strings) {

            return true;

        }

        @Override
        protected void onPostExecute(Boolean sucesso) {
            if (sucesso) {
                Toast.makeText(ReservaCancelar.this, "Excluído com sucesso!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(ReservaCancelar.this, "ERROOOOO!", Toast.LENGTH_LONG).show();
            }

            finish();
        }
    }

}

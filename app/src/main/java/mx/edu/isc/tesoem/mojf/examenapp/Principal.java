package mx.edu.isc.tesoem.mojf.examenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {

    Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        comenzar = findViewById(R.id.btnprincipal);

        comenzar.setOnClickListener(view -> {
            Intent lanza = new Intent(Principal.this, Examen.class);
            finish();
            startActivity(lanza);
        });
    }
}
package mx.edu.isc.tesoem.mojf.examenapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import DatosExamen.EstructuraDatos;

public class Pregunta1 extends AppCompatActivity {

    TextView txtpregunta;
    Button regresa, siguiente, calificar;
    RadioButton r1, r2, r3;
    ArrayList <EstructuraDatos> listadatos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);

        txtpregunta = findViewById(R.id.txtpregunta);
        regresa = findViewById(R.id.btnanterior);
        siguiente = findViewById(R.id.btnsiguiente);
        calificar = findViewById(R.id.btncalificar);

        regresa.setEnabled(false);
        calificar.setEnabled(false);

        r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        r3 = findViewById(R.id.rb3);

        EstructuraDatos ed;
        ed = new EstructuraDatos();

        ed.setPregunta("Pregunta 1.\n\n¿Cuantos meses tiene el año?");
        ed.setR1("A) 19");
        ed.setR2("B) 15");
        ed.setR3("C) 12");
        ed.setRc("C");
        listadatos.add(ed);
        EstructuraDatos edm = listadatos.get(0);
        Log.i("informacion", "valor: " + edm.getPregunta());

        txtpregunta.setText(edm.getPregunta());
        r1.setText(edm.getR1());
        r2.setText(edm.getR2());
        r3.setText(edm.getR3());

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lanza = new Intent(Pregunta1.this, Pregunta2.class);
                startActivity(lanza);
            }
        });

    }
}
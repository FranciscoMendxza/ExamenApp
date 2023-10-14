package mx.edu.isc.tesoem.mojf.examenapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    Button salir;
    TextView aciertos, errores, resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        salir = findViewById(R.id.btnsalir);
        aciertos = findViewById(R.id.lblaciertos);
        errores = findViewById(R.id.lblfallos);
        resultado = findViewById(R.id.lblcalificacion);

        // Obtén los datos del intent
        int aciertosValor = getIntent().getIntExtra("aciertos", 0);
        int erroresValor = getIntent().getIntExtra("errores", 0);
        int puntosValor = getIntent().getIntExtra("puntos", 0);

        // Establece los valores en los TextView
        aciertos.setText(+ aciertosValor);
        errores.setText(erroresValor);
        resultado.setText(puntosValor);

        salir.setOnClickListener(view -> {
            finish();
            Toast.makeText(Resultado.this, "Se cerro con éxito", Toast.LENGTH_SHORT).show();
        });
    }
}
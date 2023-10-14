package mx.edu.isc.tesoem.mojf.examenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import DatosExamen.EstructuraDatos;

public class Examen extends AppCompatActivity {

    TextView preguntas;
    Button regresa, siguiente, califica;
    RadioButton RB1, RB2, RB3;
    RadioGroup grupo;
    int contador = 0, aciertos = 0, puntos = 0, errores = 10;
    ArrayList<EstructuraDatos> listadatos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        preguntas = findViewById(R.id.txtpreguntas);
        regresa = findViewById(R.id.btnregresar);
        siguiente = findViewById(R.id.btnnext);
        califica = findViewById(R.id.btncalifica);
        RB1 = findViewById(R.id.rb1);
        RB2 = findViewById(R.id.rb2);
        RB3 = findViewById(R.id.rb3);
        grupo = findViewById(R.id.grupo);

        preguntas();
        siguiente.setEnabled(false);
        califica.setEnabled(false);
        regresa.setEnabled(false);

        siguiente.setOnClickListener(view -> {
            String seleccion = seleccionr();
            if(seleccion != null){
                listadatos.get(contador).setSeleccion(seleccion);
            }
            contador++;
            if (contador < listadatos.size()){
                EstructuraDatos siguientep = listadatos.get(contador);
                preguntas.setText(siguientep.getPregunta());
                RB1.setText(siguientep.getR1());
                RB2.setText(siguientep.getR2());
                RB3. setText(siguientep.getR3());

                grupo.clearCheck();
            }

        });
        regresa.setOnClickListener(view -> {
            contador--;

            if(contador >= 0 && contador < listadatos.size()){
                EstructuraDatos prev = listadatos.get(contador);
                preguntas.setText(prev.getPregunta());
                RB1.setText(prev.getR1());
                RB2.setText(prev.getR2());
                RB3.setText(prev.getR3());

                grupo.clearCheck();
            }
        });
        //Es para que identifique si se selecciono alguna opcion de los RadioButtons del grupo RadioGroup
        grupo.setOnCheckedChangeListener((radioGroup, i) -> {
            if (RB1.isChecked() || RB2.isChecked() || RB3.isChecked()){ //Si se selecciona alguno, se activa el boton siguiente
                if (contador==9){
                    siguiente.setEnabled(false);
                    califica.setEnabled(true);
                }else{
                    siguiente.setEnabled(true);
                }

                regresa.setEnabled(contador != 0);
            }else{
                siguiente.setEnabled(false);
            }
        });
        //<>
        califica.setOnClickListener(view -> {
            if(contador >= 0 && contador < listadatos.size()){
                EstructuraDatos actual = listadatos.get(contador);
                String seleccion = seleccionr();

                if (seleccion != null){
                    actual.setSeleccion(seleccion);
                }
            }
            puntos = 0; //se reinicia cada que se califica
            aciertos = 0;
            errores = 10;

            for (EstructuraDatos pregunta : listadatos){
                String respSeleccionada = pregunta.getSeleccion();

                if (respSeleccionada != null){
                    if (respSeleccionada.equals(pregunta.getRc())){
                        puntos++;
                        aciertos++;
                        errores--;
                    }
                }
            }

            Intent lanza = new Intent(Examen.this, Resultado.class);
            lanza.putExtra("aciertos", aciertos);
            lanza.putExtra("errores", errores);
            lanza.putExtra("puntos", puntos);
            finish();
            startActivity(lanza);

            /*preguntas.setText("Puntaje total: " + puntos +
                    "\nCorrectas: " + aciertos +
                    "\nErrores: " + errores);

            siguiente.setVisibility(View.INVISIBLE);
            regresa.setVisibility(View.INVISIBLE);
            califica.setVisibility(View.INVISIBLE);
            grupo.setVisibility(View.INVISIBLE);*/


        });

    }
    public void preguntas() {
        EstructuraDatos ed;

        ed = new EstructuraDatos();//Pregunta 1
        ed.setPregunta("Pregunta 1.\n\n ¿Cuántos planetas tiene el sistema solar?");
        ed.setR1("a) 6 planetas");
        ed.setR2("b) 8 planetas");
        ed.setR3("c) 9 planetas");
        ed.setRc("c");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 2
        ed.setPregunta("Pregunta 2.\n\n ¿Cuántos colores tiene el arcoiris?");
        ed.setR1("a) 4 colores");
        ed.setR2("b) 6 colores");
        ed.setR3("c) 7 colores");
        ed.setRc("c");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 3
        ed.setPregunta("Pregunta 3.\n\n ¿Pesa más 1kg de algodón que 1 kg de metal?");
        ed.setR1("a) Pesa más el metal");
        ed.setR2("b) Pesa más el algodón");
        ed.setR3("c) Pesan lo mismo");
        ed.setRc("c");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 4
        ed.setPregunta("Pregunta 4.\n\n ¿Cuál es la estrella más cercana a la tierra?");
        ed.setR1("a) Betelgueuse");
        ed.setR2("b) Sol");
        ed.setR3("c) Las de los reyes magos");
        ed.setRc("b");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 5
        ed.setPregunta("Pregunta 5.\n\n ¿A que velocidad va la luz?");
        ed.setR1("a) 344km/h");
        ed.setR2("b) 250km/h");
        ed.setR3("c) 410km/h");
        ed.setRc("a");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 6
        ed.setPregunta("Pregunta 6.\n\n ¿Cuál es el elemento químico del Oro?");
        ed.setR1("a) Au");
        ed.setR2("b) Ae");
        ed.setR3("c) Ug");
        ed.setRc("a");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 7
        ed.setPregunta("Pregunta 7.\n\n ¿Cuál es la vida promedio de un humano?");
        ed.setR1("a) 50 años");
        ed.setR2("b) 75 años");
        ed.setR3("c) 93 años");
        ed.setRc("b");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 8
        ed.setPregunta("Pregunta 8.\n\n ¿Que comen los animales herbívoros?");
        ed.setR1("a) Carne y plantas");
        ed.setR2("b)Plantas e instector");
        ed.setR3("c) Plantas");
        ed.setRc("c");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 9
        ed.setPregunta("Pregunta 9.\n\n ¿Cómo se les llama a los gases que rodean la tierra?");
        ed.setR1("a) Troposfera");
        ed.setR2("b) Placas Tectónicas");
        ed.setR3("c) Atmósfera");
        ed.setRc("c");
        listadatos.add(ed);

        ed = new EstructuraDatos();//Pregunta 10
        ed.setPregunta("Pregunta 10.\n\n ¿Cuantas champions ha ganado el Cruz Azul?");
        ed.setR1("a) 8");
        ed.setR2("b) 9");
        ed.setR3("c) ninguna");
        ed.setRc("c");
        listadatos.add(ed);

        EstructuraDatos edm = listadatos.get(0);
        preguntas.setText(edm.getPregunta());
        RB1.setText(edm.getR1());
        RB2.setText(edm.getR2());
        RB3.setText(edm.getR3());
        seleccionr();
    }

    private String seleccionr(){
        if (RB1.isChecked()){
            return "a";
        } else if (RB2.isChecked()) {
            return "b";
        } else if (RB3.isChecked()) {
            return "c";
        }else{
            return null;
        }
    }
}
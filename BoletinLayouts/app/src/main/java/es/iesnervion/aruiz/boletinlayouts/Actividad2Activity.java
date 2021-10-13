package es.iesnervion.aruiz.boletinlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Actividad2Activity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private final String PIEDRA = "Piedra";
    private final String PAPEL = "Papel";
    private final String TIJERA = "Tijera";


    private String jugadaUsuario = "";
    private RadioGroup radioGroup;
    private Button buttonVolverJugar;
    private TextView textGanador;
    private ImageView imageJugador;
    private ImageView imageCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_1);

        imageJugador = findViewById(R.id.imagenPiedraPapelTijera);
        imageCPU = findViewById(R.id.imagenPiedraPapelTijeraCPU);

        textGanador = findViewById(R.id.textGanador);

        radioGroup = findViewById(R.id.radioGroupPiedraPapelTijera);
        radioGroup.setOnCheckedChangeListener(this);

        Button buttonConfirmar = findViewById(R.id.buttonConfirmarJugada);
        buttonConfirmar.setOnClickListener(this);

        buttonVolverJugar = findViewById(R.id.buttonVolverAJugar);
        buttonVolverJugar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.buttonConfirmarJugada:
                if (!jugadaUsuario.equals("")) {
                    confirmarJugar();
                }
            break;

            case R.id.buttonVolverAJugar:
                resetearValores();
            break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton;

        switch(i){

            case R.id.radioButtonPiedra:
                radioButton = findViewById(R.id.radioButtonPiedra);
                if (radioButton.isChecked()){
                    imageJugador.setImageResource(R.drawable.imagenpiedra);
                    jugadaUsuario = PIEDRA;
                }
                break;

            case R.id.radioButtonPapel:
                radioButton = findViewById(R.id.radioButtonPapel);
                if (radioButton.isChecked()){
                    imageJugador.setImageResource(R.drawable.imagenpapel);
                    jugadaUsuario = PAPEL;
                }
                break;

            case R.id.radioButtonTijera:
                radioButton = findViewById(R.id.radioButtonTijera);
                if (radioButton.isChecked()){
                    imageJugador.setImageResource(R.drawable.imagentijera);
                    jugadaUsuario = TIJERA;
                }
                break;
        }
    }

    private void confirmarJugar(){
        String[] opciones = {PIEDRA,PAPEL,TIJERA};
        String jugadaCPU = opciones[(int) (Math.random()*3)];
        int ganador = 0;

        if (jugadaCPU.equals(PIEDRA)){
            imageCPU.setImageResource(R.drawable.imagenpiedra);
            if (jugadaUsuario.equals(TIJERA)){
                ganador = 1;
            }else if (jugadaUsuario.equals(PAPEL)){
                ganador = 2;
            }
        }else if(jugadaCPU.equals(PAPEL)){
            imageCPU.setImageResource(R.drawable.imagenpapel);
            if (jugadaUsuario.equals(PIEDRA)){
                ganador = 1;
            }else if (jugadaUsuario.equals(TIJERA)){
                ganador = 2;
            }
        }else if(jugadaCPU.equals(TIJERA)){
            imageCPU.setImageResource(R.drawable.imagentijera);
            if (jugadaUsuario.equals(PAPEL)){
                ganador = 1;
            }else if (jugadaUsuario.equals(PIEDRA)){
                ganador = 2;
            }
        }

        switch(ganador){
            case 1:
                textGanador.setText(getString(R.string.ganador)+" CPU");
                break;

            case 2:
                textGanador.setText(getString(R.string.ganador)+" Usuario");
                break;

            case 0:
                textGanador.setText(getString(R.string.ganador)+" Empate");
                break;
        }
        textGanador.setVisibility(View.VISIBLE);
        imageCPU.setVisibility(View.VISIBLE);
        buttonVolverJugar.setVisibility(View.VISIBLE);
    }

    private void resetearValores(){
        jugadaUsuario = "";
        radioGroup.clearCheck();
        imageJugador.setImageResource(R.drawable.imagentijera);
        textGanador.setVisibility(View.INVISIBLE);
        imageCPU.setVisibility(View.INVISIBLE);
        buttonVolverJugar.setVisibility(View.INVISIBLE);
    }
}
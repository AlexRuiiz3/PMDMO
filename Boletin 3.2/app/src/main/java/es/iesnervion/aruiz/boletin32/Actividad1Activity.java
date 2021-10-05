package es.iesnervion.aruiz.boletin32;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Actividad1Activity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox checkBoxNegrita;
    private CheckBox checkBoxAumentoFuente;
    private CheckBox checkBoxDisminucionFuente;
    private CheckBox checkBoxColorRojo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        checkBoxNegrita = findViewById(R.id.checkBoxTextBlack);
        checkBoxAumentoFuente = findViewById(R.id.checkBoxMoreFont);
        checkBoxDisminucionFuente = findViewById(R.id.checkBoxLessFont);
        checkBoxColorRojo = findViewById(R.id.checkBoxColorRed);

        checkBoxNegrita.setOnClickListener(this);
        checkBoxAumentoFuente.setOnClickListener(this);
        checkBoxDisminucionFuente.setOnClickListener(this);
        checkBoxColorRojo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TextView textView = findViewById(R.id.textViewAct1);
        switch (view.getId()){

            case R.id.checkBoxTextBlack:
                if (checkBoxNegrita.isChecked()){
                    textView.setTypeface(null, Typeface.BOLD);
                }else{
                    textView.setTypeface(Typeface.DEFAULT);
                }
            break;

            case R.id.checkBoxMoreFont:
                if (checkBoxAumentoFuente.isChecked()){
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
                }else{
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,28);
                }
            break;
            case R.id.checkBoxLessFont:
                if (checkBoxDisminucionFuente.isChecked()){
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,5);
                }else{
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,28);
                }
            break;

            case R.id.checkBoxColorRed:
                if (checkBoxColorRojo.isChecked()){
                    textView.setTextColor(getResources().getColor(R.color.red));
                }else{
                    textView.setTextColor(getResources().getColor(R.color.colorTexViewDefault));
                }
            break;
        }
    }
}
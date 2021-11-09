package com.example.pruebas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CicloVidaActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "CicloVidaActivity";
    private final String  KEY_BLUNDE_CONT = "Cont";
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            cont = savedInstanceState.getInt(KEY_BLUNDE_CONT,0);
        }
        Log.e(TAG,"Estas en el metodo onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_vida);

        Button button = findViewById(R.id.buttonCicloVida);
        button.setOnClickListener(this);


    }
    @Override
    protected void onPause() {
        Log.e(TAG,"Estas en el metodo onPause");
        super.onPause();
    }
    @Override
    protected void onStart() {
        Log.e(TAG,"Estas en el metodo onStart");
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.e(TAG,"Estas en el metodo onStop");
        super.onStop();
    }
    @Override
    protected void onRestart() {
        Log.e(TAG,"Estas en el metodo onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,"Estas en el metodo onResume");
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BLUNDE_CONT,cont);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.e(TAG,"Estas en el metodo onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,"Estas en el metodo onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        cont++;
        Log.e(TAG,""+cont);
    }
}
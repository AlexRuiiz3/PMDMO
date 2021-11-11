package com.example.pruebas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class EjemploViewModelLiveData extends AppCompatActivity {

    private ViewModelEjemploViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_view_model_live_data);

        viewModel = new ViewModelProvider(this).get(ViewModelEjemploViewModel.class);

        final Observer<Integer> nameObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        };

        viewModel.getmContador().observe(this,nameObserver);
    }
}
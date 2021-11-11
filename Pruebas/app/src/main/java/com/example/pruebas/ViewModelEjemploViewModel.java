package com.example.pruebas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelEjemploViewModel extends ViewModel {

    private MutableLiveData<Integer> mContador = new MutableLiveData<>();
    private int contador;

    public int getContador(){return contador;}
    public void setContador(int contador){this.contador = contador;}

    public MutableLiveData<Integer> getmContador(){return mContador;}

}

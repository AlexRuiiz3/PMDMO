package com.example.pruebaprimeraevaluacion.ViewModels;

import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pruebaprimeraevaluacion.clasesBasicas.Persona;

import java.util.ArrayList;

public class EmpresaTecnologicaActivityVM extends ViewModel {

    private MutableLiveData<String> mldNombre;
    private MutableLiveData<String> mldWeb;
    private MutableLiveData<String> mdlLocalizacion;
    private MutableLiveData<String> mldDireccion;
    private MutableLiveData<String> mldTelefono;
    private MutableLiveData<String> mldEmail;
    private MutableLiveData<ArrayList<Persona>> mldPersonasContacto;

    public MutableLiveData<String> getNombre(){
        if(mldNombre == null){
            mldNombre = new MutableLiveData<String>();
        }
        return mldNombre;
    }

    public MutableLiveData<String> getWeb(){
        if(mldWeb == null){
            mldWeb = new MutableLiveData<String>();
        }
        return mldWeb;
    }

    public MutableLiveData<String> getLocalizacion(){
        if(mdlLocalizacion == null){
            mdlLocalizacion = new MutableLiveData<String>();
        }
        return mdlLocalizacion;
    }

    public MutableLiveData<String> getDireccion(){
        if(mldDireccion == null){
            mldDireccion = new MutableLiveData<String>();
        }
        return mldDireccion;
    }

    public MutableLiveData<String> getTelefono(){
        if(mldTelefono == null){
            mldTelefono = new MutableLiveData<String>();
        }
        return mldTelefono;
    }

    public MutableLiveData<String> getEmail(){
        if(mldEmail == null){
            mldEmail = new MutableLiveData<String>();
        }
        return mldEmail;
    }

    public MutableLiveData<ArrayList<Persona>> getPersonasContacto(){
        if(mldPersonasContacto == null){
            mldPersonasContacto = new MutableLiveData<ArrayList<Persona>>();
        }
        return mldPersonasContacto;
    }
}

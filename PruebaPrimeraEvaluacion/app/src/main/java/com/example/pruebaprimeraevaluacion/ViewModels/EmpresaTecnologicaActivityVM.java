package com.example.pruebaprimeraevaluacion.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pruebaprimeraevaluacion.clasesBasicas.Empresa;
import com.example.pruebaprimeraevaluacion.clasesBasicas.EmpresaTecnologica;
import com.example.pruebaprimeraevaluacion.clasesBasicas.Persona;

import java.util.ArrayList;

public class EmpresaTecnologicaActivityVM extends ViewModel {

    private MutableLiveData<EmpresaTecnologica> mldEmpresa;


    public MutableLiveData<EmpresaTecnologica> getEmpresa(){
        if(mldEmpresa == null){
            mldEmpresa = new MutableLiveData<EmpresaTecnologica>();
        }
        return mldEmpresa;
    }

}

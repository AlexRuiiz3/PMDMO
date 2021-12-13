package com.example.pruebaprimeraevaluacion.clasesBasicas;

import java.io.Serializable;

public class Empresa implements Serializable {

    private int logo;
    private String nombre;

    public Empresa(int logo, String nombre) {
        this.logo = logo;
        this.nombre = nombre;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package com.example.pruebas;

public class Persona {

    private String nombre;
    private int codigoImagen;

    public Persona(String nombre, int codigoImagen){
        this.nombre = nombre;
        this.codigoImagen = codigoImagen;
    }

    public int getCodigoImagen() {
        return codigoImagen;
    }

    public String getNombre(){return nombre;}

    @Override
    public String toString() {
        return nombre;
    }
}

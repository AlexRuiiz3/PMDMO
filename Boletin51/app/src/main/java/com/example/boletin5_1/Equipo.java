package com.example.boletin5_1;

public class Equipo {

    private String nombre;
    private int imagen;

    public Equipo(String nombre, int imagen){
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre(){
        return nombre;
    }

    public int getImagen(){
        return imagen;
    }
}

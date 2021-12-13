package com.example.pruebaprimeraevaluacion.clasesBasicas;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpresaTecnologica extends Empresa implements Serializable {

    private String web;
    private String localizacion;
    private String email;
    private String direccion;
    private String telefono;
    private ArrayList<Persona> personasContacto;

    public EmpresaTecnologica(int logo, String nombre, String web, String localizacion, String email, String direccion, String telefono, ArrayList<Persona> personasContacto) {
        super(logo, nombre);
        this.web = web;
        this.localizacion = localizacion;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personasContacto = personasContacto;
    }
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Persona> getPersonasContacto() {
        return personasContacto;
    }

    public void setPersonasContacto(ArrayList<Persona> personasContacto) {
        this.personasContacto = personasContacto;
    }

    @Override
    public String toString() {
        return  getNombre();
    }
}

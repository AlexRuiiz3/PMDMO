/*
 * Nombre: EmpresaTecnologica
 *
 * Comentario: Esta clase representa a una empresa tecnologica y que al hereda de la clase Empresa
 *             tendra todas las caracteristidas de dicha clase.
 *
 * Atributos:
 *              - Basicos:
 *                          -Web: Cadena, Consultable, Modificable
 *                          -Localizacion: Cadena, Consultable, Modificable
 *                          -Telefono: Cadena, Consultable, Modificable
 *                          -Email: Cadena, Consultable, Modificable
 *                          -Direccion: Cadena, Consultable, Modificable
 *                          -PersonasConacto: Lista, Consultable, Modificable
 *              - Derivados: Ninguno
 *              - Compartidos: Ninguno
 *
 * Metodos fundamentales(Propiedades):
 *              -Web
 *                      -public String getWeb()
 *                      -public void setWeb(String web)
 *              -Localizacion
 *                      -public String getLocalizacion()
 *                      -public void setLocalizacion(String localizacion)
 *
 *             -Telefono
 *                      -public String getTelefono()
 *                      -public void setTelefono(String telefono)
 *
 *             -Email
 *                      -public String getEmail()
 *                      -public void setEmail(String email)
 *
 *             -Direccion
 *                      -public String getDireccion()
 *                      -public void setDireccion(String direccion)
 *
 *            -PersonasContacto
 *                      -public String getPersonasContacto()
 *                      -public void setPersonasContacto(ArrayList<Persona> personasContacto)
 *
 * Metodos añadidos: Ninguno
 *
 * Metodos hereados: Ninguno
 *
 */


package com.example.pruebaprimeraevaluacion.clasesBasicas;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpresaTecnologica extends Empresa implements Serializable {

    //Atributos
    private String web;
    private String localizacion;
    private String email;
    private String direccion;
    private String telefono;
    private ArrayList<Persona> personasContacto;

    //Constructor sin parametros
    public EmpresaTecnologica() {
        super();
        this.web = "";
        this.localizacion = "";
        this.email = "";
        this.direccion = "";
        this.telefono = "";
        this.personasContacto = new ArrayList<>();
    }
    //Constructor con parametros
    public EmpresaTecnologica(int logo, String nombre, String web, String localizacion, String email, String direccion, String telefono, ArrayList<Persona> personasContacto) {
        super(logo, nombre);
        this.web = web;
        this.localizacion = localizacion;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personasContacto = personasContacto;
    }

    //Metodos fundamentales(Propiedades)
    //Web
    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    //Localizacion
    public String getLocalizacion() {
        return localizacion;
    }
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Direccion
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Telefono
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //PersonasContacto
    public ArrayList<Persona> getPersonasContacto() {
        return personasContacto;
    }
    public void setPersonasContacto(ArrayList<Persona> personasContacto) {
        this.personasContacto = personasContacto;
    }
}

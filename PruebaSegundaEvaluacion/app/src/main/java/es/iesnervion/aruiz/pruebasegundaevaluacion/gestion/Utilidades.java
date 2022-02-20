package es.iesnervion.aruiz.pruebasegundaevaluacion.gestion;

import android.content.Context;
import android.widget.Toast;

public class Utilidades {
    private static final int LONGITUD_CONTRASENHA = 8;

    public static boolean validarCadena(String cadena){
        return !cadena.trim().equals("");
    }


    public static boolean comprarValidezDNI(String DNI, Context context){//Se le pasa el context para que se pueda mostrar el mensaje de error correspondiente
        char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int numeroDNI = 0;
        boolean valido = false;

        if(!DNI.trim().equals("")){// Si el DNI no esta vacio
            if(DNI.length() == 9) {
                try {
                    numeroDNI = Integer.parseInt(DNI.substring(0,8));
                    if(DNI.charAt(8) == letras[numeroDNI % 23]) {
                        valido = true;
                    }else {
                        Toast.makeText(context,"Letra del DNI no valida",Toast.LENGTH_SHORT).show();
                    }
                }catch(NumberFormatException e) {
                    Toast.makeText(context,"Numeros del DNI no valido",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(context,"Longitud DNI no valida(Debe ser de 9)",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(context,"DNI no puede estar vacio",Toast.LENGTH_SHORT).show();
        }
        return valido;
    }

    public static boolean validarContrasenha(String contrasenha,Context context){
        boolean contrasenhaValida = false;
        if(!contrasenha.trim().equals("") && contrasenha.length() >= LONGITUD_CONTRASENHA) {
            contrasenhaValida = true;
        }else{
            Toast.makeText(context,"La contraseña tiene que tener una longitud minima de 8 digitos",Toast.LENGTH_SHORT).show();
        }
        return contrasenhaValida;
    }
}

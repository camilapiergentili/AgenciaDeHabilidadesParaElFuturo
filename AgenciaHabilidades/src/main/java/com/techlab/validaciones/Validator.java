package com.techlab.validaciones;

public final class Validator {

    public static boolean validarTextoNoVacio(String cadena){
        return !cadena.trim().isEmpty();
    }

    public static boolean validarNoNegativo(int numero){
        return numero >= 0;
    }

    public static boolean validarNoNegativo(double numero){
        return numero >= 0;
    }
}

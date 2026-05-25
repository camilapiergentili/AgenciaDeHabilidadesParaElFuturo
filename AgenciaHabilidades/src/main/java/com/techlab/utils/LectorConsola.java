package com.techlab.utils;

import com.techlab.validaciones.Validator;

import java.util.Scanner;

public final class LectorConsola {

    private static final Scanner sc = new Scanner(System.in);

    public static String leerTexto(String mensaje){
        System.out.println(mensaje);
        String respuesta = sc.nextLine().trim();
        while(!Validator.validarTextoNoVacio(respuesta)){
            System.out.println("El campo no puede estar vacio");
            respuesta = sc.nextLine().trim();
        }
        return respuesta;
    }
    private static int leerIntValido() {
        while (!sc.hasNextInt()) {
            System.out.println("Ingrese un número válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public static int leerIntegrer(String mensaje) {
        System.out.println(mensaje);
        int valor = leerIntValido();
        while (!Validator.validarNoNegativo(valor)) {
            System.out.println("El número no puede ser negativo, reingrese: ");
            valor = leerIntValido();
        }
        return valor;
    }

    private static double leerDoubleValido() {
        while (!sc.hasNextDouble()) {
            System.out.println("Ingresá un número válido: ");
            sc.next();
        }
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    public static double leerDouble(String mensaje) {
        System.out.println(mensaje);
        double valor = leerDoubleValido();
        while (!Validator.validarNoNegativo(valor)) {
            System.out.println("El número no puede ser negativo, reingrese: ");
            valor = leerDoubleValido();
        }
        return valor;
    }
}

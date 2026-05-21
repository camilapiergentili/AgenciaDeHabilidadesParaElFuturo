package com.techlab.utils;

import java.util.Scanner;

public final class LectorConsola {

    private static final Scanner sc = new Scanner(System.in);

    public static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return sc.nextLine().trim();
    }

    public static int leerIntegrer(String mensaje){
        System.out.println(mensaje);
        while(!sc.hasNextInt()){
            System.out.println("Ingrese un número válido: ");
            sc.next();
        }

        return sc.nextInt();
    }

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.print("Ingresá un número válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}

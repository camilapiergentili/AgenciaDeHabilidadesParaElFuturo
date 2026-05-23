package com.techlab;

import com.techlab.utils.LectorConsola;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {



        int option;

        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver menú ARTICULOS");
            System.out.println("2. ver menú CATEGORIAS");
            System.out.println("0. Salir");

            option = LectorConsola.leerIntegrer("Ingrese una opción: ");

            switch (option) {
                case 1:

                    break;
                case 2:
                    //listarPedido();
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }

        } while (option == 3);


    }
}
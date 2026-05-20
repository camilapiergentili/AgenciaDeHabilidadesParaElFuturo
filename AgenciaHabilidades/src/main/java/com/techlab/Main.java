package com.techlab;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;

        do{

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar/Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedido");
            System.out.println("0. Salir");

            System.out.print("Elegí una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    //agregarPedido();
                    break;

                case 2:
                    //listarPedido();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }

        } while (option == 0);


    }
}
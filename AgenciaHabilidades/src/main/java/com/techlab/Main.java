package com.techlab;

import com.techlab.menu.ArticuloMenu;
import com.techlab.menu.CategoriaMenu;
import com.techlab.model.Articulo;
import com.techlab.model.Categoria;
import com.techlab.repository.Repositorio;
import com.techlab.utils.LectorConsola;



public class Main {
    public static void main(String[] args) {

        Repositorio<Categoria> dbCategoria = new Repositorio<>();
        Repositorio<Articulo> dbArticulo = new Repositorio<>();

        CategoriaMenu categoriaMenu = new CategoriaMenu(dbCategoria, dbArticulo);
        ArticuloMenu articuloMenu  = new ArticuloMenu(dbCategoria, dbArticulo);

        int option;

        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver menú ARTICULOS");
            System.out.println("2. ver menú CATEGORIAS");
            System.out.println("0. Salir");

            option = LectorConsola.leerIntegrer("Ingrese una opción: ");

            switch (option) {
                case 1:
                    if(dbCategoria.estaVacia()){
                        System.out.println("Debe ingresar una Categoria antes de ingresar un Articulo");
                        break;
                    }
                    articuloMenu.ejecutarMenu();
                    break;
                case 2:
                    categoriaMenu.ejecutarMenu();
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }

        } while (option != 0);


    }
}
package com.techlab.menu;

import com.techlab.interfaces.Menu;
import com.techlab.model.Articulo;
import com.techlab.model.ArticuloAlimenticio;
import com.techlab.model.ArticuloElectronico;
import com.techlab.model.Categoria;
import com.techlab.repository.Repositorio;
import com.techlab.utils.LectorConsola;


public class ArticuloMenu implements Menu {
    private final Repositorio<Categoria> dbCategoria;
    private final Repositorio<Articulo> dbArticulo;

    public ArticuloMenu(Repositorio<Categoria> dbCategoria, Repositorio<Articulo> dbArticulo) {
        this.dbCategoria = dbCategoria;
        this.dbArticulo = dbArticulo;
    }


    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ ARTICULOS ---");
        System.out.println("1. Ingresar Articulo");
        System.out.println("2. Listar Articulos");
        System.out.println("3. Consulta Articulo por ID");
        System.out.println("4. Modificar Articulo");
        System.out.println("5. Eliminar Articulo");
        System.out.println("0. Salir");
    }

    @Override
    public void ejecutarMenu() {


        int option;
        mostrarMenu();
        do{
            option = LectorConsola.leerIntegrer("Ingrese una opción: ");

            switch (option) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    listarArticulos();
                    break;
                case 3:
                    //buscarArticuloPorId();
                    break;
                case 4:
                    //modificarArticulo();
                    break;
                case 5:
                    //eliminarArticulo();
                case 0:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }

        } while (option != 0);

    }

    public void agregarArticulo(){

        System.out.println("## AGREGAR ARTICULO ##");
        int code = LectorConsola.leerIntegrer("Ingrese el código: ");

        for(Articulo a : dbArticulo.listar()){
            if(a.getCodigo() == code){
                System.out.println("El código ya esta registrado");
                return;
            }
        }

        String name = LectorConsola.leerTexto("Ingrese el nombre: ");
        double precio = LectorConsola.leerDouble("Ingrese el precio: ");
        int stock = LectorConsola.leerIntegrer("Ingrese stock: ");

        String nombreCategoria = LectorConsola.leerTexto("Ingrese nombre de la categoria");

        Categoria categoria = null;

        for(Categoria c : dbCategoria.listar()){
            if(c.getNombre().equalsIgnoreCase(nombreCategoria)){
                categoria = c;
            }
        }

        int op;
        do{

            System.out.println("1- ARTICULO ALIMENTICIO");
            System.out.println("2- ARTICULO ELECTRONICO");
            System.out.println("3- SALIR");
            op = LectorConsola.leerIntegrer("Elija una opción: ");

        } while (op != 1 && op != 2 && op != 3);

        if(op == 3) return;

        if(op == 1){
            int vencimiento = LectorConsola.leerIntegrer("Ingresar los días para el vencimiento: ");
            ArticuloAlimenticio articuloAlimenticio = new ArticuloAlimenticio(code, name, precio, stock, categoria, vencimiento);
            dbArticulo.create(articuloAlimenticio);
            System.out.println("Articulo alimenticio agregado con exito");
        }

        if(op == 2){
            int garantiaEnMeses = LectorConsola.leerIntegrer("Ingresar el tiempo de garantia en meses: ");
            ArticuloElectronico articuloElectronico = new ArticuloElectronico(code, name, precio, stock, categoria, garantiaEnMeses);
            dbArticulo.create(articuloElectronico);
            System.out.println("Articulo electronico agregado con exito");
        }

    }

    public void listarArticulos(){
        if(dbArticulo.estaVacia()){
            System.out.println("No hay articulos para mostrar");
        }
        for (Articulo a : dbArticulo.listar()){
            System.out.println(a);
        }
    }

}

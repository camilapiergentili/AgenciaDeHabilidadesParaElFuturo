package com.techlab.menu;

import com.techlab.interfaces.Menu;
import com.techlab.model.Articulo;
import com.techlab.model.Categoria;
import com.techlab.repository.Repositorio;
import com.techlab.utils.LectorConsola;

public class CategoriaMenu implements Menu {

    private final Repositorio<Categoria> dbCategoria;
    private final Repositorio<Articulo> dbArticulo;

    public CategoriaMenu(Repositorio<Categoria> dbCategoria, Repositorio<Articulo> dbArticulo) {
        this.dbCategoria = dbCategoria;
        this.dbArticulo = dbArticulo;
    }


    @Override
    public void mostrarMenu() {
        System.out.println("\n--- MENÚ CATEGORIA ---");
        System.out.println("1. Ingresar Categoria");
        System.out.println("2. Listar Categorias");
        System.out.println("3. Consulta Categoria por ID");
        System.out.println("4. Modificar Categoria");
        System.out.println("5. Eliminar Categoria");
        System.out.println("0. Salir");
    }

    @Override
    public void ejecutarMenu() {


        int option;


        do{
            mostrarMenu();
            option = LectorConsola.leerIntegrer("Ingrese una opción: ");
            switch (option) {
                case 1:
                    ingresarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    int code = LectorConsola.leerIntegrer("Ingrese el código de la categoria");
                    consultarPorCodigo(code);
                    break;
                case 4:
                    modificarCategoria();
                    break;
                case 5:
                    eliminarCategoria();
                case 0:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("La opción ingresada es incorrecta");
            }

        } while (option != 0);

    }

    public void ingresarCategoria() {

        String name = LectorConsola.leerTexto("Ingrese nombre de la categoria");

        if(buscarPorNombre(name) != null){
            System.out.println("El nombre ingresado ya se encuentra cargado");
        }

        String description = LectorConsola.leerTexto("Ingrese descripción de la categoria");

        Categoria categoria = new Categoria(name, description);

        dbCategoria.create(categoria);
    }

    public void listarCategorias(){
        if(dbCategoria.listar().isEmpty()){
            System.out.println("No hay categorias para mostrar");
        }

        for (Categoria c : dbCategoria.listar()){
            System.out.println(c);
        }
    }

    public void consultarPorCodigo(int codigo) {
        Categoria categoria = dbCategoria.findByCodigo(codigo);
        if (categoria == null) {
            System.out.println("No existe categoría con el código: " + codigo);
            return;
        }
        System.out.println(categoria);
    }

    public Categoria buscarPorNombre(String nombre){
        for(Categoria c : dbCategoria.listar()){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }

    // para buscar y devolver el objeto, usado internamente
    private Categoria buscarPorCodigo(int codigo) {
        return dbCategoria.findByCodigo(codigo);
    }

    public void modificarCategoria() {
        int code = LectorConsola.leerIntegrer("Ingrese el código de la Categoria que desea modificar: ");

        if(buscarPorCodigo(code) == null){
            System.out.println("No existe categoria con el código ingresado " + code);
            return;
        }

        String nombreNuevo = LectorConsola.leerTexto("Ingrese el nuevo nombre: ");

        Categoria categoriaExistete = buscarPorNombre(nombreNuevo);

        if(categoriaExistete != null && categoriaExistete.getCodigo() != code){
            System.out.println("Ya existe una categoria con el nombre ingresado");
            return;
        }

        String descripcionNueva = LectorConsola.leerTexto("Ingrese la nueva descripción: ");

        Categoria categoria = dbCategoria.findByCodigo(code);
        categoria.setNombre(nombreNuevo);
        categoria.setDescripcion(descripcionNueva);

        System.out.println("Categoria modificada con exito");
    }

    public void eliminarCategoria(){
        int code = LectorConsola.leerIntegrer("Ingrese el código de la Categoria a eliminar: ");

        if(dbCategoria.findByCodigo(code) == null){
            System.out.println("No se encontro categoria con el código ingresado");
            return;
        }

        if(categoriaTieneArticulos(code)){
            System.out.println("La categoria que desea eliminar tiene Articulos asociados");
        }

        Categoria categoriaEliminar = dbCategoria.findByCodigo(code);

        dbCategoria.eliminar(categoriaEliminar);

        System.out.println("Categoria eliminada con exito");

    }

    private boolean categoriaTieneArticulos(int codigo){
        for(Articulo a : dbArticulo.listar()){
            if(a.getCategoria().getCodigo() == codigo){
                return true;
            }
        }

        return false;
    }

}

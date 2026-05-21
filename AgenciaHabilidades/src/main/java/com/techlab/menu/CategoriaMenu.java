package com.techlab.menu;

import com.techlab.model.Articulo;
import com.techlab.model.Categoria;
import com.techlab.repository.Repositorio;
import com.techlab.utils.LectorConsola;
import com.techlab.validaciones.Validator;

import java.util.Scanner;

public class CategoriaMenu {

    private final Repositorio<Categoria> dbCategoria;
    private final Repositorio<Articulo> dbArticulo;

    public CategoriaMenu(Repositorio<Categoria> dbCategoria, Repositorio<Articulo> dbArticulo) {
        this.dbCategoria = dbCategoria;
        this.dbArticulo = dbArticulo;
    }

    public void ingresarCategoria() {

        String name = LectorConsola.leerTexto("Ingrese nombre de la categoria");

        if(!Validator.validarTextoNoVacio(name)){
            System.out.println("El campo Nombre no puede estar vacio");
        }

        if(buscarPorNombre(name) != null){
            System.out.println("El nombre ingresado ya se encuentra cargado");
        }

        String description = LectorConsola.leerTexto("Ingrese descripción de la categoria");

        if(!Validator.validarTextoNoVacio(description)){
            System.out.println("El campo Descripcion no puede estar vacio");
        }

        Categoria categoria = new Categoria(name, description);

        dbCategoria.create(categoria);
    }

    public void listarCategoria(){
        if(dbCategoria.listar().isEmpty()){
            System.out.println("No hay categorias para mostrar");
        }

        for (Categoria c : dbCategoria.listar()){
            System.out.println(c);
        }
    }

    public Categoria consultarPorCodigo(int codigo){
        return dbCategoria.findByCodigo(codigo);
    }

    public Categoria buscarPorNombre(String nombre){
        for(Categoria c : dbCategoria.listar()){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }

    public void modificar() {
        int code = LectorConsola.leerIntegrer("Ingrese el código de la Categoria que desea modificar: ");

        if(consultarPorCodigo(code) == null){
            System.out.println("No existe categoria con el código ingresado " + code);
            return;
        }

        String nombreNuevo = LectorConsola.leerTexto("Ingrese el nuevo nombre: ");

        Categoria categoriaExistete = buscarPorNombre(nombreNuevo);

        if(categoriaExistete != null && categoriaExistete.getCodigo() != code){
            System.out.println("Ya existe una categoria con el nombre ingresado");
            return;
        }

        if(!Validator.validarTextoNoVacio(nombreNuevo)){
            System.out.println("El campo Nombre no puede estar vacio");
            return;
        }

        String descripcionNueva = LectorConsola.leerTexto("Ingrese la nueva descripción: ");

        if(!Validator.validarTextoNoVacio(descripcionNueva)){
            System.out.println("La descripción no puede estar vacio");
            return;
        }

        Categoria categoria = dbCategoria.findByCodigo(code);
        categoria.setNombre(nombreNuevo);
        categoria.setDescripcion(descripcionNueva);

        System.out.println("Categoria modificada con exito");
    }

    public void eliminar(){
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

package com.techlab.service;

import com.techlab.model.Categoria;

public class CategoriaService {

    public Categoria create(Categoria categoria){
        Categoria c = new Categoria(
                categoria.getCodigo(),
                categoria.getNombre(),
                categoria.getDescripcion());
        return c;
    }
}

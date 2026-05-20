package com.techlab.model;

import java.util.List;

public class Pedido {
    private long id;
    private List<Articulo> producto;

    private static int contador = 1;

    public Pedido(List<Articulo> producto) {
        this.id = contador++;
        this.producto = producto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Articulo> getProducto() {
        return producto;
    }

    public void setProducto(List<Articulo> producto) {
        this.producto = producto;
    }
}
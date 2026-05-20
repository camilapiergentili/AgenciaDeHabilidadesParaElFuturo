package com.techlab.model;

import com.techlab.interfaces.Calculable;

public abstract class Articulo implements Calculable {
    private long id;
    private String name;
    private double price;
    private int stock;
    private Categoria categoria;

    private static int contador = 1;

    public Articulo(String name, double price, int stock, Categoria categoria) {
        this.id = contador++;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Métodos abstractos — cada subclase los implementa a su manera
    public abstract String getTipoArticulo();
    protected abstract String getDetalleEspecifico();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Articulo { id=" + id +
                ", tipo=" + getTipoArticulo() +
                ", nombre='" + name + "'" +
                ", precio=" + price +
                ", stock=" + stock +
                ", categoria=" + categoria.getNombre() +
                ", " + getDetalleEspecifico() + " }";
    }
}
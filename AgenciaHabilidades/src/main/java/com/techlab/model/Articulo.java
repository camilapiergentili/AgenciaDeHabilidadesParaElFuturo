package com.techlab.model;

import com.techlab.interfaces.Calculable;
import com.techlab.interfaces.Identificable;

public abstract class Articulo implements Calculable, Identificable {
    private int codigo;
    private String name;
    private double price;
    private int stock;
    private Categoria categoria;

    public Articulo(int codigo, String name, double price, int stock, Categoria categoria) {
        this.codigo = codigo;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Métodos abstractos — cada subclase los implementa a su manera
    public abstract String getTipoArticulo();
    protected abstract String getDetalleEspecifico();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return "Articulo { id=" + codigo +
                ", tipo=" + getTipoArticulo() +
                ", nombre='" + name + "'" +
                ", precio=" + price +
                ", stock=" + stock +
                ", categoria=" + categoria.getNombre() +
                ", " + getDetalleEspecifico() + " }";
    }
}
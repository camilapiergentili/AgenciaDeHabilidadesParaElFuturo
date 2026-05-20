package com.techlab.model;

public class ArticuloAlimenticio extends Articulo {
    private int diasVencimiento;

    public ArticuloAlimenticio(String name, double price, int stock, Categoria categoria, int diasVencimiento) {
        super(name, price, stock, categoria);
        this.diasVencimiento = diasVencimiento;
    }

    @Override
    public double calcularPrecioFinal() {
        if(diasVencimiento < 3){
            return getPrice() * 0.80;
        }

        if(diasVencimiento < 7){
            return  getPrice() * 0.90;
        }

        return getPrice();
    }

    @Override
    public String getTipoArticulo() {
        return "Alimenticio";
    }

    @Override
    protected String getDetalleEspecifico() {
        return "Días para vencimiento: " + diasVencimiento;
    }
}

package com.techlab.model;

public class ArticuloElectronico extends Articulo {

    private int garantiaEnMeses;

    public ArticuloElectronico(String name, double price, int stock, Categoria categoria, int garantiaEnMeses) {
        super(name, price, stock, categoria);
        this.garantiaEnMeses = garantiaEnMeses;
    }

    public int getGarantiaEnMeses() {
        return garantiaEnMeses;
    }

    public void setGarantiaEnMeses(int garantiaEnMeses) {
        this.garantiaEnMeses = garantiaEnMeses;
    }

    @Override
    public double calcularPrecioFinal() {
        if (garantiaEnMeses > 12){
            return getPrice() * 1.10;
        }
        return getPrice();
    }


    @Override
    public String getTipoArticulo() {
        return "Electronico";
    }

    @Override
    protected String getDetalleEspecifico() {
        return "Garantia en meses: " + this.garantiaEnMeses;
    }
}

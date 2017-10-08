package me.willhernandezg.celularapp;

/**
 * Created by willhernandezg on 27/10/2017.
 */

public class Celular {
    private int marca;
    private int color;
    private int sistema;
    private int ram;
    private double precio;

    public Celular(int marca, int color, int sistema, int ram, double precio) {
        this.marca = marca;
        this.color = color;
        this.sistema = sistema;
        this.ram = ram;
        this.precio = precio;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSistema() {
        return sistema;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardarCelulares(this);
    }
}

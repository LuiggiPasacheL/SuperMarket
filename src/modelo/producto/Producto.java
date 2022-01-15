/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.producto;

/**
 *
 * @author luigg
 */
public class Producto implements IProducto{

    private String id_producto;
    private String nombre_producto;
    private float precio;
    private int cantidad;
    private String tipo;

    public Producto(String id_producto, String nombre_producto, float precio, int cantidad, String tipo) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    @Override
    public String getId_producto() {
        return id_producto;
    }

    @Override
    public String getNombre_producto() {
        return nombre_producto;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    @Override
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad =  cantidad;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void ventaProducto(int cantidad) {
        this.cantidad -= cantidad;
    }

    @Override
    public void compra(int cantidad) {
        this.cantidad += cantidad;
    }

    @Override
    public String getDescuento() {
        return null;
    }

    @Override
    public String getPromocion() {
        return null;
    }

    @Override
    public IProducto quitarDecorador() {
        return null;
    }
    
}

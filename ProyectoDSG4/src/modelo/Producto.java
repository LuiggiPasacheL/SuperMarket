/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OSCAR
 */
public class Producto {
    private String id_producto;
    private String nombre_producto;
    private float precio;
    private int cantidad;
    private String tipo; //Categoria

    public Producto(String id_producto, String nombre_producto, float precio, int cantidad, String tipo) { //guardarProducto()
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    //Metodos GET
    public String getId_producto() {
        return id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
    
}

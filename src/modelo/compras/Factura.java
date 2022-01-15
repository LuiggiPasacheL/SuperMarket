/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.compras;

import modelo.producto.IProducto;

/**
 *
 * @author luigg
 */
class Factura {
    private String nombrePropietario;
    private String[] productos;
    private int cantidad;
    private float precioTotal;

    public Factura(String nombrePropietario, String[] productos, int cantidad, float precioTotal) {
        this.nombrePropietario = nombrePropietario;
        this.productos = productos;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }
    
    public String crearFactura(){
        String resultado = "";
        
        resultado += "nombre del cliente: " + nombrePropietario;
        
        for (int i = 0; i < productos.length; i++){
            resultado += "producto " + (i + 1) + ": " + productos[i] + "\n";
            resultado += "cantidad: " + cantidad + "\n";
            resultado += "precio: " + precioTotal + "\n";
        }
        
        return resultado;
    }
    
}

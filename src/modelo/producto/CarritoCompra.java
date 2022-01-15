/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.producto;

import java.util.ArrayList;

/**
 *
 * @author luigg
 */
public class CarritoCompra {
    private final ArrayList<IProducto> productosEnCarrito;
    private final String[] cabecera = {"ID", "NOMBRE", "STOCK", "TIPO", "PRECIO"};

    public CarritoCompra() {
        productosEnCarrito = new ArrayList<>();
    }
    
    public void setProducto(int indice, IProducto producto){
        productosEnCarrito.set(indice, producto);
    }
    
    public void añadirProducto(IProducto producto){
        productosEnCarrito.add(producto);
    }
    
    public void eliminarProducto(IProducto producto){
        productosEnCarrito.remove(producto);
    }
    
    public int cantidadDeProductos(){
        return productosEnCarrito.size();
    }
    
    public IProducto getProducto(int indice){
        return productosEnCarrito.get(indice);
    }
    
    public String[][] getDatos() {
        String[][] result = new String[cantidadDeProductos()][cabecera.length];
        for (int i = 0; i < cantidadDeProductos(); i++) {
            result[i][0] = getProducto(i).getId_producto();
            result[i][1] = getProducto(i).getNombre_producto();
            result[i][2] = String.valueOf(getProducto(i).getCantidad());
            result[i][3] = getProducto(i).getTipo();
            result[i][4] = Float.toString(getProducto(i).getPrecio());
        }
        return result;
    }
    
    public String[] getCabecera() {
        return this.cabecera;
    }
}

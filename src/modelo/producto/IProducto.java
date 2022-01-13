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
public interface IProducto {
    public String getId_producto();
    public String getNombre_producto();
    public float getPrecio();
    public int getCantidad();
    public String getTipo();
    public void setId_producto(String id_producto);
    public void setNombre_producto(String nombre_producto);
    public void setPrecio(float precio);
    public void setCantidad(int cantidad);
    public void setTipo(String tipo);
    
    public void venta(int cantidad);
    public void compra(int cantidad);
}

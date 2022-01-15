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
public abstract class DecoratorProducto implements IProducto {

    protected IProducto producto;

    public DecoratorProducto(IProducto producto) {
        this.producto = producto;
    }

    @Override
    public String getId_producto() {
        return this.producto.getId_producto();
    }

    @Override
    public String getNombre_producto() {
        return this.producto.getNombre_producto();
    }

    @Override
    public float getPrecio() {
        return this.producto.getPrecio();
    }

    @Override
    public int getCantidad() {
        return this.producto.getCantidad();
    }

    @Override
    public String getTipo() {
        return this.producto.getTipo();
    }

    @Override
    public void setId_producto(String id_producto) {
        this.producto.setId_producto(id_producto);
    }

    @Override
    public void setNombre_producto(String nombre_producto) {
        this.producto.setNombre_producto(nombre_producto);
    }

    @Override
    public void setPrecio(float precio) {
        this.producto.setPrecio(precio);
    }

    @Override
    public void setCantidad(int cantidad) {
        this.producto.setCantidad(cantidad);
    }

    @Override
    public void setTipo(String tipo) {
        this.producto.setTipo(tipo);
    }

    @Override
    public void ventaProducto(int cantidad) {
        this.producto.ventaProducto(cantidad);
    }

    @Override
    public void compra(int cantidad) {
        this.producto.compra(cantidad);
    }
}

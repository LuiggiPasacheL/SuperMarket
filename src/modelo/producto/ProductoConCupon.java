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
public class ProductoConCupon extends DecoratorProducto {

    public ProductoConCupon(IProducto producto) {
        super(producto);
    }

    @Override
    public float getPrecio() {
        return this.producto.getPrecio() * 9 / 10;
    }


}

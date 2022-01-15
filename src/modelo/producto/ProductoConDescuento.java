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
public class ProductoConDescuento extends DecoratorProducto {

    public ProductoConDescuento(IProducto producto) {
        super(producto);
    }

    @Override
    public float getPrecio() {
        return this.producto.getPrecio() * 95 / 100;
    }

    @Override
    public String getDescuento() {
        return "5%"; //de descuento
    }

    @Override
    public String getPromocion() {
        return null;
    }

    @Override
    public IProducto quitarDecorador(){
        return this.producto;
    }

}

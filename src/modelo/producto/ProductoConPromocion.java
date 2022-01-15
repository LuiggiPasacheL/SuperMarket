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
public class ProductoConPromocion extends DecoratorProducto{

    private int promocion;
    
    public ProductoConPromocion(IProducto producto, int promocion) {
        super(producto);
        this.promocion = promocion;
    }
    
    @Override
    public void ventaProducto(int cantidad) {
        this.producto.ventaProducto(cantidad * promocion);
    }
    
    @Override
    public String getPromocion(){
        return (promocion) + "por 1";
    }
    
    public void setPromocion(int promocion){
        this.promocion = promocion;
    }

    @Override
    public String getDescuento() {
        return this.producto.getDescuento();
    }

    @Override
    public IProducto quitarDecorador() {
        return this.producto;
    }

}

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
    public void venta(int cantidad) {
        this.producto.venta(cantidad * promocion);
    }
    
    public int getPromocion(){
        return promocion;
    }
    
    public void setPromocion(int promocion){
        this.promocion = promocion;
    }

}

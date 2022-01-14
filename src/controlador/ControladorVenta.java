package controlador;

import General.DatosProductos;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import modelo.producto.IProducto;
import modelo.producto.ProductoConDescuento;
import vista.vistaComprarProd;
import vista.vistaProductos;

public class ControladorVenta {
    
    vistaComprarProd vista;
    IProducto producto;
    float precio;
    int cantidad;
    boolean tieneDescuento = false;
    DecimalFormat df = new DecimalFormat("###.##");
    
    public ControladorVenta(vistaComprarProd vista, IProducto productoSeleccionado) {
        this.vista = vista;
        this.producto = productoSeleccionado;
        cantidad = (int) vista.spinnerCantidad.getValue();
        precio = (float) cantidad * (float) producto.getPrecio();
        
        this.vista.btnComprar.addActionListener((ae) -> {
            cantidad = (int) vista.spinnerCantidad.getValue();
            
            if(cantidad <= 0){
                return;
            }
            
            if (!cantidadValida(cantidad)){
                return;
            }
            
            producto.venta(cantidad);
            int comprobar = confirmacionCompra();
            if(comprobar == 0){
                JOptionPane.showMessageDialog(vista, "¡Gracias por comprar en SuperMarket!");
                volver();
            }            
        });
        
        this.vista.spinnerCantidad.addChangeListener((ce) -> {
            cantidad = (int) vista.spinnerCantidad.getValue();
            
            if (!cantidadValida(cantidad)){
                return;
            }
            
            if(!tieneDescuento && cantidad > 10){
                producto = new ProductoConDescuento(producto);
                tieneDescuento = true;
            }
            
            if(tieneDescuento && cantidad <= 10){
                IProducto sinDecorador = producto.quitarDecorador();
                producto = sinDecorador == null ? producto : sinDecorador;
                tieneDescuento = false;
            }
            
            if(tieneDescuento){
                vista.lblOferta.setText(producto.getDescuento() + " de descuento");
                vista.lblOferta.setVisible(true);
            }else{
                vista.lblOferta.setVisible(false);
            }
            
            precio = (float) cantidad * (float) producto.getPrecio();
            vista.txtPrecio.setText(df.format(precio));
        });
        
        this.vista.btnVolver.addActionListener((ae) -> {
            volver();
        });
    }
    
    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.txtNom.setText(producto.getNombre_producto());
        vista.txtTipo.setText(producto.getTipo());
        vista.lblOferta.setVisible(false);
        vista.spinnerCantidad.setValue(1);
    }
    
    private void volver(){
        vista.dispose();
        vistaProductos vista1 = new vistaProductos();
        DatosProductos s = new DatosProductos();
        ControladorProductos ci = new ControladorProductos(vista1, s);
        ci.iniciar();
    }
    
    private int confirmacionCompra(){
        String confirmacionCompra = "¿Está seguro de comprar?:\n"
                    + "Producto: " + producto.getNombre_producto() + "\n"
                    + "Cantidad: " + cantidad + "\n"
                    + "Precio Final: " + df.format(precio);
            

        int confirmacion = JOptionPane.showConfirmDialog(vista, confirmacionCompra, "Confirmacion de compra", 0);

        return confirmacion;
    }
    
    private boolean cantidadValida(int cantidad){
        if (cantidad > producto.getCantidad() || cantidad < 0){
            JOptionPane.showMessageDialog(vista, "sobrepasa la cantidad de productos"
                    , "Error", 3);
            vista.spinnerCantidad.setValue(producto.getCantidad());
            return false;
        }
        return true;
    }
}

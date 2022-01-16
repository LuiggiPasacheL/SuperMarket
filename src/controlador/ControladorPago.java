/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.DatosProductos;
import General.DatosUsuarios;
import javax.swing.JOptionPane;
import modelo.compras.CarritoCompra;
import modelo.usuario.Cliente;
import vista.vistaCarrito;
import vista.vistaPago;
import vista.vistaProductos;

/**
 *
 * @author luigg
 */
public class ControladorPago {
    vistaPago vista;
    CarritoCompra carrito;

    public ControladorPago(CarritoCompra carrito, int[] cantidadesAdquirirProdSeleccionado) {
        vista = new vistaPago();
        this.carrito = carrito;
        
        vista.btnCompletarPago.addActionListener((al)->{
            String numTarjeta = vista.txtNumTarjeta.getText();
            String clave = vista.txtClave.getText();
            String direccion = vista.txtDireccion.getText();
            
            if(numTarjeta.isEmpty() || clave.isEmpty() || direccion.isEmpty()){
                return;
            }
            
            int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Esta seguro de realizar la compra?","Confirmacion de compra",0);
            if(confirmacion != 0){
                return;
            }
            
            Cliente conectado = (Cliente) DatosUsuarios.conectado;
            conectado.setPago(numTarjeta, clave, direccion);
            
            for(int i = 0; i < carrito.cantidadDeProductos(); i++){
                carrito.getProducto(i).ventaProducto(cantidadesAdquirirProdSeleccionado[i]);
                System.out.print(cantidadesAdquirirProdSeleccionado[i]);
            }
            
            JOptionPane.showMessageDialog(vista, "¡Gracias por comprar en SuperMarket!");
            volverAProductos();
        });
        
        vista.btnRegresar.addActionListener((as)->{
            regresar();
        });
        
    }
    
    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    private void volverAProductos(){
        vista.dispose();
        vistaProductos vSiguiente = new vistaProductos();
        DatosProductos dProductos = new DatosProductos();
        ControladorProductos cSiguiente = new ControladorProductos(vSiguiente, dProductos);
        cSiguiente.iniciar();
    }
    
    private void regresar(){
        vista.dispose();
        vistaCarrito vCarrito = new vistaCarrito();
        ControladorCarrito cCarrito = new ControladorCarrito(vCarrito, carrito);
        cCarrito.iniciar();
    }
}

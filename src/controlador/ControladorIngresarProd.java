/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.DatosProductos;
import javax.swing.JOptionPane;
import modelo.producto.Producto;
import vista.vistaIngresarProd;
import vista.vistaInventario;

/**
 *
 * @author OSCAR
 */
public class ControladorIngresarProd{

    private vistaIngresarProd vista;
    private DatosProductos datosProductos;

    public ControladorIngresarProd(vistaIngresarProd vista, DatosProductos datosProductos) {
        this.vista = vista;
        this.datosProductos = datosProductos;

        this.vista.btnVolver.addActionListener(e -> {
            vista.dispose();
            vistaInventario vista12 = new vistaInventario();
            ControladorInventario ci = new ControladorInventario(vista12, datosProductos);
            ci.iniciar();
        });

        this.vista.btnRegistrar.addActionListener(e -> {
            //TRAER
            try {
                String nombre = vista.txtNom.getText();
                String cantidad = vista.txtCant.getText();
                String precio = vista.txtPre.getText();
                String tipo = vista.txtTipo.getText();
                if ("".equals(nombre) || "".equals(cantidad) || "".equals(precio) || "".equals(tipo)) {
                    JOptionPane.showMessageDialog(vista, "Campo(s) vacio(s), ingrese los datos del producto correctamente");
                } else {
                    //CONVERSION
                    String cod = String.valueOf(datosProductos.asignarCodigo());
                    int cant = Integer.parseInt(cantidad);
                    float pre = Float.valueOf(precio);
                    //DESARROLLO
                    Producto producto1 = new Producto(cod, nombre, pre, cant, tipo);
                    datosProductos.actualizarProducto(producto1);
                    vista.dispose();
                    vistaInventario vista1 = new vistaInventario();
                    ControladorInventario ci = new ControladorInventario(vista1, datosProductos);
                    ci.iniciar();
                }
            } catch (NumberFormatException a) {
                System.out.println("Datos incorrectos, intentelo nuevamente");
            }
        });
    }

    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

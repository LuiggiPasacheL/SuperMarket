/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.Sistema;
import static General.Sistema.products;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;
import vista.vistaIngresarProd;
import vista.vistaInventario;

/**
 *
 * @author OSCAR
 */
public class ControladorIngresarProd{

    private vistaIngresarProd vista;
    private Sistema sistemaProducto;
    ArrayList<Producto> producto;

    public ControladorIngresarProd(vistaIngresarProd vista, Sistema sistemaProducto, ArrayList<Producto> producto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        this.producto = producto;
        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaInventario vista = new vistaInventario();
                Sistema s = new Sistema();
                ControladorInventario ci = new ControladorInventario(vista, s);
                ci.iniciar();
            }
        });

        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TRAER
                String nombre = vista.txtNom.getText();
                String cantidad = vista.txtCant.getText();
                String precio = vista.txtPre.getText();
                String tipo = vista.txtTipo.getText();
                if ("".equals(nombre) || "".equals(cantidad) || "".equals(precio) || "".equals(tipo)) {
                    JOptionPane.showMessageDialog(vista, "Campo(s) vacio(s), ingrese los datos del producto correctamente");
                } else {
                    //CONVERSION
                    String cod = String.valueOf(sistemaProducto.asignarCodigo());
                    int cant = Integer.parseInt(cantidad);
                    float pre = Float.valueOf(precio);
                    //DESARROLLO
                    Producto producto = new Producto(cod, nombre, pre, cant, tipo);
                    sistemaProducto.actualizarProducto(producto);
                    vista.dispose();
                    vistaInventario vista = new vistaInventario();
                    Sistema s = new Sistema();
                    ControladorInventario ci = new ControladorInventario(vista, s);
                    ci.iniciar();
                }

            }
        });

    }

    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

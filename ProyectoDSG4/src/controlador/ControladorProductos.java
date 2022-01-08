/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.Sistema;
import static General.Sistema.products;
import static General.Sistema.users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import vista.vistaIngresarProd;
import vista.vistaInventario;
import vista.vistaLogin;
import vista.vistaProductos;

/**
 *
 * @author OSCAR
 */
public class ControladorProductos {

    private vistaProductos vista;
    private Sistema sistemaProducto;
    ArrayList<Producto> producto;

    public ControladorProductos(vistaProductos vista, Sistema sistemaProducto, ArrayList<Producto> producto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        this.producto = producto;

        this.vista.btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.conectado.cerrarSesion();
                vista.dispose();
                vistaLogin abrir = new vistaLogin();
                Sistema sistemaUsuario = new Sistema();
                ControladorLogin cabrir = new ControladorLogin(abrir, users, sistemaUsuario);
                cabrir.iniciar();
            }
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        String[][] datos = sistemaProducto.getDatos();
        String[] cabecera = sistemaProducto.getCabecera();
        DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
        vista.tblProd.setModel(modeloProducto);

    }

    public void limpiarControles() {
        String[][] datos = sistemaProducto.getDatos();
        String[] cabecera = sistemaProducto.getCabecera();
        DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
        vista.tblProd.setModel(modeloProducto);
    }

}

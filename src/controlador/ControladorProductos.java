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

    public ControladorProductos(vistaProductos vista, Sistema sistemaProducto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;

        this.vista.btnComprar.addActionListener(e -> {

        });

        this.vista.btnBuscar.addActionListener(e -> {
            String dato = vista.txtBuscar.getText();
            String[][] datos = sistemaProducto.getDatosBusqueda(dato);
            String[] cabecera = sistemaProducto.getCabecera();
            DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
            vista.tblProd.setModel(modeloProducto);
        });

        this.vista.btnRefrescar.addActionListener(e -> {
            String[][] datos = sistemaProducto.getDatos();
            String[] cabecera = sistemaProducto.getCabecera();
            DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
            vista.tblProd.setModel(modeloProducto);
        });

        this.vista.btnVolver.addActionListener(e -> {
            Sistema.conectado.cerrarSesion();
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            Sistema sistemaUsuario = new Sistema();
            ControladorLogin cabrir = new ControladorLogin(abrir, sistemaUsuario);
            cabrir.iniciar();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.DatosProductos;
import General.DatosUsuarios;
import General.Sistema;
import static General.Sistema.admins;
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
import vista.vistaLoginAdmin;

/**
 *
 * @author OSCAR
 */
public class ControladorInventario {

    private vistaInventario vista;
    DatosProductos sistemaProducto;

    public ControladorInventario(vistaInventario vista, DatosProductos sistemaProducto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;

        this.vista.btnNuevo.addActionListener(e -> {
            vista.dispose();
            vistaIngresarProd vista1 = new vistaIngresarProd();
            ControladorIngresarProd ci = new ControladorIngresarProd(vista1, this.sistemaProducto);
            ci.iniciar();
        });

        this.vista.btnEliminar.addActionListener(e -> {
            int fila = vista.tblProd.getSelectedRow();
            int col = vista.tblProd.getSelectedColumn();
            String nomProd = vista.tblProd.getValueAt(fila, 1).toString();
            this.sistemaProducto.eliminarProductoxNombre(nomProd);
            iniciar();
            limpiarControles();
        });

        this.vista.btnVolver.addActionListener(e -> {
            DatosUsuarios.conectado.cerrarSesion();
            vista.dispose();
            vistaLoginAdmin abrir = new vistaLoginAdmin();
            DatosUsuarios sistemaUsuario = new DatosUsuarios();
            ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, sistemaUsuario);
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

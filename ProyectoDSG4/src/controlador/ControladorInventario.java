/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
    private Sistema sistemaProducto;
    ArrayList<Producto> producto;

    public ControladorInventario(vistaInventario vista, Sistema sistemaProducto, ArrayList<Producto> producto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        this.producto = producto;

        this.vista.btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaIngresarProd vista = new vistaIngresarProd();
                Sistema s = new Sistema();
                ControladorIngresarProd ci = new ControladorIngresarProd(vista, s, products);
                ci.iniciar();
            }
        });

        this.vista.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblProd.getSelectedRow();
                int col = vista.tblProd.getSelectedColumn();
                String nomProd = vista.tblProd.getValueAt(fila, 1).toString();
                sistemaProducto.eliminarProductoxNombre(nomProd);
                iniciar();
                limpiarControles();
            }
        });

        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sistema.conectado.cerrarSesion();
                vista.dispose();
                vistaLoginAdmin abrir = new vistaLoginAdmin();
                Sistema sistemaUsuario = new Sistema();
                ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, admins, sistemaUsuario);
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

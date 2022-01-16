/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.DatosProductos;
import General.DatosUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.compras.CarritoCompra;
import vista.vistaCarrito;
import vista.vistaLogin;
import vista.vistaProductos;

/**
 *
 * @author OSCAR
 */
public class ControladorProductos {

    private vistaProductos vista;
    private DatosProductos sistemaProducto;
    private CarritoCompra carrito;
    int[] indicesProductosSeleccionados;

    public ControladorProductos(vistaProductos vista, DatosProductos sistemaProducto) {
        this.vista = vista;
        this.sistemaProducto = sistemaProducto;
        carrito = new CarritoCompra();
        indicesProductosSeleccionados = vista.tblProd.getSelectedRows();

        this.vista.btnComprar.addActionListener(e -> {
            
            for (int i = 0; i < indicesProductosSeleccionados.length; i++) {
                carrito.añadirProducto(sistemaProducto.getProducto(indicesProductosSeleccionados[i]));
            }
            
            if(indicesProductosSeleccionados.length <= 0){
                JOptionPane.showMessageDialog(vista,"No se ha seleccionado ningun producto \n "
                        + "Nota: Puede seleccionar productos presionando la tecla "
                        + "control y haciendo click en el producto de la tabla");
                return;
            }
            vista.dispose();
            vistaCarrito vCarrito = new vistaCarrito();
            ControladorCarrito cCarrito = new ControladorCarrito(vCarrito, carrito);
            cCarrito.iniciar();
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
            vista.textProductosSeleccionados.setText("");
            DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
            vista.tblProd.setModel(modeloProducto);
        });
        
        this.vista.tblProd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                indicesProductosSeleccionados = vista.tblProd.getSelectedRows();
                String productos = "";
                for(int i = 0; i < indicesProductosSeleccionados.length; i++){
                    productos += sistemaProducto.getProducto(indicesProductosSeleccionados[i]).getNombre_producto()
                            + "\n";
                    System.out.println(indicesProductosSeleccionados[i]);
                }
                vista.textProductosSeleccionados.setText(productos);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });

        this.vista.btnVolver.addActionListener(e -> {
            DatosUsuarios.conectado.cerrarSesion();
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            DatosUsuarios sistemaUsuario = new DatosUsuarios();
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

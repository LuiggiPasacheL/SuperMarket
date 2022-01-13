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
import javax.swing.JOptionPane;

import modelo.Usuario;
import modelo.usuario.IUsuario;
import vista.vistaInventario;
import vista.vistaLogin;
import vista.vistaLoginAdmin;
import vista.vistaRegistro;
import vista.vistaTipoUsuario;

/**
 * @author OSCAR
 */
public class ControladorLoginAdmin {

    private vistaLoginAdmin vista;
    ArrayList<IUsuario> usuario;

    public ControladorLoginAdmin(vistaLoginAdmin vista, Sistema sistemaUsuario) {
        this.vista = vista;
        this.usuario = Sistema.admins;
        this.vista.txtUsuario.requestFocus();

        this.vista.btnIngresar.addActionListener(e -> {
            String usuario = vista.txtUsuario.getText();
            String contraseña = vista.txtContraseña.getText();

            if (usuario.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Campo usuario vacio, ingrese sus credenciales nuevamente");
                vista.txtUsuario.requestFocus();
                return;
            }
            if(contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Campo contraseña vacio, ingrese sus credenciales nuevamente");
                vista.txtContraseña.requestFocus();
                return;
            }

            Sistema.conectado = sistemaUsuario.verificarSesionAdmin(usuario, contraseña);
            if(Sistema.conectado == null){
                JOptionPane.showMessageDialog(vista, "Campo(s) incorrecto(s), ingrese sus credenciales nuevamente");
                return;
            }

            JOptionPane.showMessageDialog(vista,"Correcto, Bienvenido " + sistemaUsuario.datosAdmin(usuario).getUser());

            vista.dispose();
            vistaInventario vista1 = new vistaInventario();
            Sistema s = new Sistema();
            ControladorInventario ci = new ControladorInventario(vista1, sistemaUsuario);
            ci.iniciar();

        });

        this.vista.btnCerrar.addActionListener(e -> {
            vista.dispose();
            vistaTipoUsuario abrir = new vistaTipoUsuario();
            ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
            cabrir.iniciar();
        });

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

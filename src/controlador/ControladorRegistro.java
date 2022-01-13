/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.Sistema;
import static General.Sistema.users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.usuario.Cliente;
import modelo.usuario.IUsuario;
import org.jetbrains.annotations.NotNull;
import vista.vistaLogin;
import vista.vistaRegistro;

/**
 *
 * @author OSCAR
 */
public class ControladorRegistro {

    private vistaRegistro vista;

    public ControladorRegistro(vistaRegistro vista, Sistema sistemaUsuario) {
        this.vista = vista;
        this.vista.btnRegistrar.addActionListener(e -> {
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellido.getText();
            String user = vista.txtUsuario.getText();
            String contraseña = vista.txtContraseña.getText();
            String correo = vista.txtCorreo.getText();
            String direccion = vista.txtDireccion.getText();
            String telefono = vista.txtTelefono.getText();

            if (datosVacios(nombre, apellido, user, contraseña, correo, direccion, telefono)){
                return;
            }

            if (!sistemaUsuario.validarDatos(user)) {
                JOptionPane.showMessageDialog(vista, "El usuario ya existe, intentelo nuevamente");
                return;
            }

            IUsuario usuario1 = new Cliente(nombre, apellido, user, contraseña, direccion, telefono, correo);
            sistemaUsuario.registrarUsuario(usuario1);
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            Sistema s = new Sistema();
            ControladorLogin cabrir = new ControladorLogin(abrir, s);
            cabrir.iniciar();

        });

        this.vista.btnVolver.addActionListener(e -> {
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            Sistema s = new Sistema();
            ControladorLogin cAbrir = new ControladorLogin(abrir, s);
            cAbrir.iniciar();
        });

    }

    private boolean datosVacios(String nombre, String apellido, String user, String contraseña,
                                String correo, String direccion, String telefono){

        String campo = "";
        if (contraseña.isEmpty()){
            campo = "contraseña";
        }
        if (correo.isEmpty()){
            campo = "correo";
        }
        if (direccion.isEmpty()){
            campo = "direccion";
        }
        if (telefono.isEmpty()){
            campo = "telefono";
        }
        if (nombre.isEmpty()){
            campo = "nombre";
        }
        if (apellido.isEmpty()){
            campo = "apellido";
        }
        if (user.isEmpty()){
            campo = "usuario";
        }

        if(!campo.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Campo " + campo + " vacio, ingrese sus datos nuevamente");
            return true;
        }else{
            return false;
        }

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

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
import vista.vistaLogin;
import vista.vistaRegistro;

/**
 *
 * @author OSCAR
 */
public class ControladorRegistro {

    private vistaRegistro vista;
    private Sistema sistemaUsuario;
    private ArrayList<Usuario> usuario;

    public ControladorRegistro(vistaRegistro vista, ArrayList<Usuario> usuario, Sistema sistemaUsuario) {
        this.vista = vista;
        this.sistemaUsuario = sistemaUsuario;
        this.usuario = users;
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.txtNombre.getText();
                String apellido = vista.txtApellido.getText();
                String user = vista.txtUsuario.getText();
                String contraseña = vista.txtContraseña.getText();
                String correo = vista.txtCorreo.getText();
                String direccion = vista.txtDireccion.getText();
                String telefono = vista.txtTelefono.getText();
                if ("".equals(nombre) || "".equals(apellido) || "".equals(user) || "".equals(contraseña) || "".equals(correo) || "".equals(direccion) || "".equals(telefono)) {
                    JOptionPane.showMessageDialog(vista, "Campo(s) vacio(s), ingrese sus datos nuevamente");
                } else {
                    if (sistemaUsuario.validarDatos(user)) {
                        Usuario usuario = new Usuario(nombre, apellido, user, contraseña, direccion, telefono, correo);
                        sistemaUsuario.registrarUsuario(usuario);
                        vista.dispose();
                        vistaLogin abrir = new vistaLogin();
                        Sistema s = new Sistema();
                        ControladorLogin cabrir = new ControladorLogin(abrir, users, s);
                        cabrir.iniciar();
                    } else {
                        JOptionPane.showMessageDialog(vista, "El usuario ya existe, intentelo nuevamente");
                    }

                }
            }
        });

        this.vista.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaLogin abrir = new vistaLogin();
                Sistema s = new Sistema();
                ControladorLogin cAbrir = new ControladorLogin(abrir, users, s);
                cAbrir.iniciar();
            }
        });

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

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
import vista.vistaInventario;
import vista.vistaLogin;
import vista.vistaLoginAdmin;
import vista.vistaRegistro;
import vista.vistaTipoUsuario;

/**
 *
 * @author OSCAR
 */
public class ControladorLoginAdmin {

    private vistaLoginAdmin vista;
    private Sistema sistemaUsuario;
    ArrayList<Usuario> usuario;

    public ControladorLoginAdmin(vistaLoginAdmin vista, ArrayList<Usuario> usuario, Sistema sistemaUsuario) {
        this.vista = vista;
        this.sistemaUsuario = sistemaUsuario;
        this.usuario = admins;
        this.vista.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = vista.txtUsuario.getText();
                String contraseña = vista.txtContraseña.getText();
                if ("".equals(usuario) || "".equals(contraseña)) {
                    JOptionPane.showMessageDialog(vista, "Campo(s) vacio(s), ingrese sus credenciales nuevamente");
                } else {
                    Sistema.conectado = sistemaUsuario.verificarSesionAdmin(vista.txtUsuario.getText(), vista.txtContraseña.getText());
                    if (Sistema.conectado != null) {
                        System.out.println("Correcto, Bienvenido " + sistemaUsuario.datosAdmin(usuario).getUser());
                        vista.dispose();
                        vistaInventario vista = new vistaInventario();
                        Sistema s = new Sistema();
                        ControladorInventario ci = new ControladorInventario(vista, sistemaUsuario, products);
                        ci.iniciar();

                    } else {
                        JOptionPane.showMessageDialog(vista, "Campo(s) incorrecto(s), ingrese sus credenciales nuevamente");
                    }
                }

            }
        });

        this.vista.btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaTipoUsuario abrir = new vistaTipoUsuario();
                ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
                cabrir.iniciar();
            }
        });

    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

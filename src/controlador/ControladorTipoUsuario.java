/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.Sistema;
import static General.Sistema.admins;
import static General.Sistema.users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.vistaLogin;
import vista.vistaLoginAdmin;
import vista.vistaTipoUsuario;

/**
 *
 * @author OSCAR
 */
public class ControladorTipoUsuario {

    vistaTipoUsuario vista;

    public ControladorTipoUsuario(vistaTipoUsuario vista) {
        this.vista = vista;
        this.vista.btnAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaLoginAdmin abrir = new vistaLoginAdmin();
                Sistema sistemaUsuario = new Sistema();
                ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, admins, sistemaUsuario);
                cabrir.iniciar();
            }
        });
        this.vista.btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaLogin abrir = new vistaLogin();
                Sistema sistemaUsuario = new Sistema();
                ControladorLogin cabrir = new ControladorLogin(abrir, users, sistemaUsuario);
                cabrir.iniciar();
            }
        });
        this.vista.btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import General.DatosUsuarios;
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

        this.vista.btnAdministrador.addActionListener(e -> {
            vista.dispose();
            vistaLoginAdmin abrir = new vistaLoginAdmin();
            DatosUsuarios sistemaUsuario = new DatosUsuarios();
            ControladorLoginAdmin cabrir = new ControladorLoginAdmin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });

        this.vista.btnCliente.addActionListener(e -> {
            vista.dispose();
            vistaLogin abrir = new vistaLogin();
            DatosUsuarios sistemaUsuario = new DatosUsuarios();
            ControladorLogin cabrir = new ControladorLogin(abrir, sistemaUsuario);
            cabrir.iniciar();
        });

        this.vista.btnCerrar.addActionListener(e -> System.exit(0));
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}

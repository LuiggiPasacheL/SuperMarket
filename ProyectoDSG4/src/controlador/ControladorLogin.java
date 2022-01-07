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
public class ControladorLogin {
    private vistaLogin vista;
    private Sistema sistemaUsuario;
    ArrayList<Usuario> usuario;

    public ControladorLogin(vistaLogin vista, ArrayList<Usuario> usuario, Sistema sistemaUsuario) {
        this.vista = vista;
        this.sistemaUsuario = sistemaUsuario;
        this.usuario = users;
        this.vista.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = vista.txtUsuario.getText();
                String contraseña = vista.txtContraseña.getText();
                Sistema.conectado = sistemaUsuario.ingresarUsuario(vista.txtUsuario.getText(), vista.txtContraseña.getText());
                if (Sistema.conectado != null){
                    System.out.println("Correcto");
                }
                else{
                    System.out.println("Incorrecto");
                }
            }
        });
        
        this.vista.btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                vistaRegistro registrar = new vistaRegistro();
                Sistema s = new Sistema();
                ControladorRegistro cr = new ControladorRegistro(registrar, users, s);
                cr.iniciar();
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

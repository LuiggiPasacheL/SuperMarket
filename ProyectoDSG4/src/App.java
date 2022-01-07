
import General.Sistema;
import static General.Sistema.users;
import controlador.ControladorLogin;
import vista.vistaLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OSCAR
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vistaLogin abrir = new vistaLogin();
        Sistema sistemaUsuario = new Sistema();
        ControladorLogin cabrir = new ControladorLogin(abrir,users, sistemaUsuario);
        cabrir.iniciar();
    }
    
}

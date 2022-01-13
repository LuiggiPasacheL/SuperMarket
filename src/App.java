
import General.Sistema;
import static General.Sistema.admins;
import static General.Sistema.products;
import static General.Sistema.users;
import controlador.ControladorLogin;
import controlador.ControladorTipoUsuario;
import modelo.Producto;
import modelo.Usuario;
import vista.vistaLogin;
import vista.vistaTipoUsuario;

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
        
        //Creacion de administradores
        Usuario admin_1 = new Usuario("oscar.yanfer", "admin1");
        admins.add(admin_1);
        Usuario admin_2 = new Usuario("luiggi.pasache", "admin2");
        admins.add(admin_2);
        Usuario admin_3 = new Usuario("diego.montalvo", "admin3");
        admins.add(admin_3);
        Usuario admin_4 = new Usuario("rodrigo.reyes", "admin4");
        admins.add(admin_4);
        Usuario admin_5 = new Usuario("juan.alfaro", "admin5");
        admins.add(admin_5);
        Usuario admin_6 = new Usuario("wilker.atalaya", "admin6");
        admins.add(admin_6);
        
        
        //Creacion de productos
        Producto p1 = new Producto("1", "Detergente", (float) 2.0, 12, "Articulos de limpieza");
        Producto p2 = new Producto("2", "Lejia", (float) 3.5, 12, "Articulos de limpieza");
        Producto p3 = new Producto("3", "Sacagrasa", (float) 3.0, 12, "Articulos de limpieza");
        Producto p4 = new Producto("4", "Deshumecedor", (float) 6.0, 12, "Articulos de limpieza");
        Producto p5 = new Producto("5", "Ambientador", (float) 5.0, 12, "Articulos de limpieza");
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        
        //Iniciar sistema
        vistaTipoUsuario abrir = new vistaTipoUsuario();
        ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
        cabrir.iniciar();
    }
    
}

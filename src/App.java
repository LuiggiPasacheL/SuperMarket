
import General.Sistema;
import static General.Sistema.admins;
import static General.Sistema.products;
import static General.Sistema.users;
import controlador.ControladorLogin;
import controlador.ControladorTipoUsuario;
import modelo.Producto;
import modelo.Usuario;
import modelo.usuario.Administrador;
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
        Administrador admin_1 = new Administrador("oscar.yanfer", "admin1");
        Administrador admin_2 = new Administrador("luiggi", "123456");
        Administrador admin_3 = new Administrador("diego.montalvo", "admin3");
        Administrador admin_4 = new Administrador("rodrigo.reyes", "admin4");
        Administrador admin_5 = new Administrador("juan.alfaro", "admin5");

        admins.add(admin_1);
        admins.add(admin_2);
        admins.add(admin_3);
        admins.add(admin_4);
        admins.add(admin_5);
        
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

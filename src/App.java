
import General.DatosProductos;
import controlador.ControladorTipoUsuario;
import modelo.producto.Producto;
import modelo.usuario.FactoryAdministrador;
import modelo.usuario.FactoryCliente;
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
        
        //Creacion de administradores TERMINADO
        FactoryAdministrador factoryAdministrador = new FactoryAdministrador();
        try {
            factoryAdministrador.crearUsuario("oscar.yanfer", "admin1");
            factoryAdministrador.crearUsuario("luiggi", "123456");
            factoryAdministrador.crearUsuario("diego.montalvo", "admin3");
            factoryAdministrador.crearUsuario("rodrigo.reyes", "admin4");
            factoryAdministrador.crearUsuario("juan.alfaro", "admin5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        FactoryCliente factoryCliente = new FactoryCliente();
        try{
            factoryCliente.crearUsuario("luiggi", "pasache", "luiggi", "123456", 
                    "los olivos", "123456789", "luiggip2108@gmail.com");
        }catch( Exception e){
            e.printStackTrace();
        }

        
        //Creacion de productos
        Producto p1 = new Producto("1", "Detergente", (float) 2.0, 12, "Articulos de limpieza");
        Producto p2 = new Producto("2", "Lejia", (float) 3.5, 12, "Articulos de limpieza");
        Producto p3 = new Producto("3", "Sacagrasa", (float) 3.0, 12, "Articulos de limpieza");
        Producto p4 = new Producto("4", "Deshumecedor", (float) 6.0, 12, "Articulos de limpieza");
        Producto p5 = new Producto("5", "Ambientador", (float) 5.0, 12, "Articulos de limpieza");
        DatosProductos.products.add(p1);
        DatosProductos.products.add(p2);
        DatosProductos.products.add(p3);
        DatosProductos.products.add(p4);
        DatosProductos.products.add(p5);
        
        //Iniciar sistema
        vistaTipoUsuario abrir = new vistaTipoUsuario();
        ControladorTipoUsuario cabrir = new ControladorTipoUsuario(abrir);
        cabrir.iniciar();
    }
    
}

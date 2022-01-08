/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import modelo.Producto;
import modelo.Usuario;

/**
 *
 * @author OSCAR
 */
public class Sistema {

    //METODOS USUARIO
    public static Usuario conectado = null;

    public static ArrayList<Usuario> users = new ArrayList();
    public static ArrayList<Usuario> admins = new ArrayList();

    public void registrarUsuario(Usuario usuario) {
        users.add(usuario);
    }
    //CLIENTE
    public int tamañoUsuario() {
        int result;
        result = users.size();
        return result;
    }

    public Usuario buscarUsuario(int i) {
        return users.get(i);
    }

    public Usuario verificarSesion(String login, String contraseña) { 
        Usuario result = null;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (this.buscarUsuario(i).iniciarSesion(login, contraseña)) {
                result = this.buscarUsuario(i);
                break;
            }
        }
        return result;
    }
    
    public boolean validarDatos(String usuario){
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (usuario.equals(this.buscarUsuario(i).getUser())) {
                return false;
            }
        }
        return true;
    }
    
    public Usuario datosUsuario(String usuario){
        Usuario user = null;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (usuario.equals(this.buscarUsuario(i).getUser())) {
                user = this.buscarUsuario(i);
                break;
            }
        }
        return user;
    }
    
    //ADMIN
    
    public int tamañoAdmin() {
        int result;
        result = admins.size();
        return result;
    }

    public Usuario buscarAdmin(int i) {
        return admins.get(i);
    }

    public Usuario verificarSesionAdmin(String login, String contraseña) { 
        Usuario result = null;
        for (int i = 0; i < this.tamañoAdmin(); i++) {
            if (this.buscarAdmin(i).iniciarSesion(login, contraseña)) {
                result = this.buscarAdmin(i);
                break;
            }
        }
        return result;
    }
    
    public Usuario datosAdmin(String usuario){
        Usuario user = null;
        for (int i = 0; i < this.tamañoAdmin(); i++) {
            if (usuario.equals(this.buscarAdmin(i).getUser())) {
                user = this.buscarAdmin(i);
                break;
            }
        }
        return user;
    }
    
    public boolean faltanDatos() {
        boolean result = true;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if ("".equals(buscarUsuario(i).getNombre()) || "".equals(buscarUsuario(i).getApellido())
                    || "".equals(buscarUsuario(i).getCorreo()) || "".equals(buscarUsuario(i).getDireccion())
                    || "".equals(buscarUsuario(i).getTelefono()) || "".equals(buscarUsuario(i).getUser())) {
                result = false;
                break;
            }
        }
        return result;
    }
    
    //METODOS PRODUCTO
    public static ArrayList<Producto> products = new ArrayList();
    private final String[] cabecera = {"ID", "NOMBRE", "CANTIDAD", "TIPO", "PRECIO"};
    int cod;

    public void actualizarProducto(Producto producto) {
        products.add(producto);
    }

    public int tamañoProducto() {
        int result;
        result = products.size();
        return result;
    }

    public Producto getProducto(int i) {
        return products.get(i);
    }
    
    public String[][] getDatos(){
        String[][] result = new String[tamañoProducto()][5];
        for(int i=0; i<tamañoProducto(); i++){
            result[i][0] = getProducto(i).getId_producto();
            result[i][1] = getProducto(i).getNombre_producto();
            result[i][2] = String.valueOf(getProducto(i).getCantidad());
            result[i][3] = getProducto(i).getTipo();
            result[i][4] = Float.toString(getProducto(i).getPrecio());
        }  
        return result;      
    }
    
    public String[] getCabecera() {
        return this.cabecera;
    }
    
    public void eliminarProductoxNombre(String nomProd){
        Usuario user = null;
        for (int i = 0; i < this.tamañoProducto(); i++) {
            if (nomProd.equals(this.getProducto(i).getNombre_producto())) {
                products.remove(i);
                break;
            }
        }
    }
    
    public int asignarCodigo(){
        cod = this.tamañoProducto() + 1;
        return cod;
    }

}

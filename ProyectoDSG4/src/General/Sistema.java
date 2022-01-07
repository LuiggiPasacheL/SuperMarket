/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author OSCAR
 */
public class Sistema {

    //METODOS USUARIO
    public static Usuario conectado = null;

    public static ArrayList<Usuario> users = new ArrayList();

    public void registrarUsuario(Usuario usuario) {
        users.add(usuario);
    }

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

}

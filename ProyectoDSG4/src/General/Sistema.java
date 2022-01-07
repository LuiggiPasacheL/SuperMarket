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
    
    public static ArrayList <Usuario> users = new ArrayList();

    public void registrarUsuario(Usuario usuario){
        users.add(usuario);
    }
    
    public int tamañoUsuario(){
        int result;
        result = users.size();
        return result;
    }
    
    public Usuario getUsuario(int i){
        return users.get(i);
    }
    
    public Usuario ingresarUsuario( String login, String contraseña){
        Usuario result = null;
        for(int i=0; i< this.tamañoUsuario() ;i++){
            if ( this.getUsuario(i).iniciarSesion(login, contraseña) ){
                result = this.getUsuario(i);
                break;
            }
        }
        return result;
    }
    
    
}

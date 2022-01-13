/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

/**
 *
 * @author luigg
 */
public interface IUsuario {
    
    public boolean iniciarSesion(String user, String contraseña);
    public boolean cerrarSesion();
    public boolean isConectado();
    
    public String getUser();
    public String getContraseña();
    public void setUser(String user);
    public void setContraseña(String contraseña);
}

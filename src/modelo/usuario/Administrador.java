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
public class Administrador implements IUsuario {

    private String user;
    private String contraseña;
    private Boolean conectado;

    public Administrador(String user, String contraseña) {
        this.user = user;
        this.contraseña = contraseña;
        this.conectado = Boolean.FALSE;
    }

    @Override
    public boolean iniciarSesion(String user, String contraseña) {
        boolean result = false;
        if (this.user.equalsIgnoreCase(user)
                && this.contraseña.equals(contraseña)
                && !isConectado()) {
            result = true;
            this.conectado = Boolean.TRUE;
        }
        return result;
    }

    @Override
    public boolean cerrarSesion() {
        boolean result = false;
        if (isConectado()) {
            result = true;
            this.conectado = Boolean.FALSE;
        }
        return result;
    }

    @Override
    public boolean isConectado() {
        return conectado;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getContraseña() {
        return contraseña;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}

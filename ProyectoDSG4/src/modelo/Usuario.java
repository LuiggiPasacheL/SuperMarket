    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OSCAR
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String user;
    private String contraseña;
    private String direccion;
    private String telefono;
    private String correo;
    private Boolean conectado;

    //CONSTRUCTOR
    public Usuario(String nombre, String apellido, String user, String contraseña, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.conectado = Boolean.FALSE;
    }

    //METODOS
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

    public boolean cerrarSesion() {
        boolean result = false;
        if (isConectado()) {
            result = true;
            this.conectado = Boolean.FALSE;
        }
        return result;
    }

    public boolean isConectado() {
        return this.conectado;
    }

    //METODOS SET Y GET
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import modelo.compras.Pago;

/**
 *
 * @author luigg
 */
public class Cliente implements IUsuario {

    private String nombre;
    private String apellido;
    private String user;
    private String contraseña;
    private String direccion;
    private String telefono;
    private String correo;
    private Boolean conectado;
    private Pago pago;

    public Cliente(String nombre, String apellido, String user, String contraseña,
            String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
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
    
    public void setPago(String nroTarjeta, String clave, String direccion){
        this.pago = new Pago(nroTarjeta, clave, direccion);
    }
    
    public Pago getCredencialesPago(){
        return this.pago;
    }
    
    public boolean validarNombre(String dato){ //YA
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public boolean validarApellido(String dato){ //YA
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public boolean validarUser(String dato){
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public boolean validarCorreo(String dato){
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public boolean validarContraseña(String dato){
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public boolean validarTelefono(String dato){ //YA
        return dato.matches("[0-9]{9}");
    }
    
    public boolean validarDireccion(String dato){
        return dato.matches("[a-zA-Z]{1,50}");
    }
    
    public Pago getPago(){
        return this.pago;
    }
}

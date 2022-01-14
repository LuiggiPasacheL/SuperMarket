/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.usuario;

import General.DatosUsuarios;

/**
 *
 * @author luigg
 */
public class FactoryCliente implements IFactoryUsuario{

    @Override
    public IUsuario crearUsuario(String... datosUsuario) throws Exception{
        if(datosUsuario.length != 7){
            throw new Exception("Error al ingresar datos de cliente");
        }
        
        String nombre = datosUsuario[0];
        String apellido = datosUsuario[1];
        String usuario = datosUsuario[2];
        String contraseña = datosUsuario[3];
        String direccion = datosUsuario[4];
        String telefono = datosUsuario[5];
        String correo = datosUsuario[6];

        IUsuario cliente = new Cliente(nombre, apellido, usuario, contraseña, direccion, telefono, correo);

        DatosUsuarios.users.add(cliente);

        return cliente;

    }

}

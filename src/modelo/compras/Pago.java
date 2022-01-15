/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.compras;

/**
 *
 * @author luigg
 */
public class Pago {
    private String nroTarjeta;
    private String clave;
    private String direccionPago;

    public Pago(String nroTarjeta, String clave, String direccionPago) {
        this.nroTarjeta = nroTarjeta;
        this.clave = clave;
        this.direccionPago = direccionPago;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccionPago() {
        return direccionPago;
    }

    public void setDireccionPago(String direccionPago) {
        this.direccionPago = direccionPago;
    }
    
}

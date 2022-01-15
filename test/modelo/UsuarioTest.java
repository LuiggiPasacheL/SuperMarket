/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.usuario.Administrador;
import modelo.usuario.Cliente;
import modelo.usuario.IUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luigg
 */
public class UsuarioTest {
    
    IUsuario usuarioIncompleto;
    IUsuario usuarioCompleto;
    
    public UsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        usuarioIncompleto = new Administrador("testUser", "testPassword");
        usuarioCompleto = new Cliente("completoN", "completoA", "testU", "testP", "testD", "testTel", "testC");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of iniciarSesion method, of class Usuario.
     */
    @Test
    public void testIniciarSesion() {
        System.out.println("iniciarSesion");
        String user = usuarioIncompleto.getUser();
        String contraseña = usuarioIncompleto.getContraseña();
        IUsuario instance = usuarioIncompleto;
        boolean expResult = true;
        boolean result = instance.iniciarSesion(user, contraseña);
        assertEquals(expResult, result);
    }

    /**
     * Test of cerrarSesion method, of class Usuario.
     */
    @Test
    public void testCerrarSesion() {
        System.out.println("cerrarSesion");
        IUsuario instance = usuarioIncompleto;
        usuarioIncompleto.iniciarSesion(usuarioIncompleto.getUser(), usuarioIncompleto.getContraseña());
        boolean expResult = true;
        boolean result = instance.cerrarSesion();
        assertEquals(expResult, result);
    }

    /**
     * Test of isConectado method, of class Usuario.
     */
    @Test
    public void testIsConectado() {
        System.out.println("isConectado");
        IUsuario instance = usuarioIncompleto;
        usuarioIncompleto.iniciarSesion(usuarioIncompleto.getUser(), usuarioIncompleto.getContraseña());
        boolean expResult = true;
        boolean result = instance.isConectado();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cliente instance = (Cliente) usuarioCompleto;
        String expResult = "completoN";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "completoN1";
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    /**
     * Test of getApellido method, of class Usuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Cliente instance = (Cliente) usuarioCompleto;
        String expResult = "completoA";
        String result = instance.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellido method, of class Usuario.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "completoA1";
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setApellido(apellido);
        assertEquals(apellido, instance.getApellido());
    }

    /**
     * Test of getUser method, of class Usuario.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        IUsuario instance = usuarioIncompleto;
        String expResult = "testUser";
        String result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class Usuario.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "testUser1";
        IUsuario instance = usuarioIncompleto;
        instance.setUser(user);
        assertEquals(user, instance.getUser());
    }

    /**
     * Test of getContraseña method, of class Usuario.
     */
    @Test
    public void testGetContraseña() {
        System.out.println("getContrase\u00f1a");
        IUsuario instance = usuarioIncompleto;
        String expResult = "testPassword";
        String result = instance.getContraseña();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContraseña method, of class Usuario.
     */
    @Test
    public void testSetContraseña() {
        System.out.println("setContrase\u00f1a");
        String contraseña = "testPassword1";
        IUsuario instance = usuarioIncompleto;
        instance.setContraseña(contraseña);
        assertEquals(contraseña, instance.getContraseña());
    }

    /**
     * Test of getDireccion method, of class Usuario.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = (Cliente) usuarioCompleto;
        String expResult = "testD";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDireccion method, of class Usuario.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "testD1";
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setDireccion(direccion);
        assertEquals(direccion, instance.getDireccion());
    }

    /**
     * Test of getTelefono method, of class Usuario.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Cliente instance = (Cliente) usuarioCompleto;
        String expResult = "testTel";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefono method, of class Usuario.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "testTel";
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setTelefono(telefono);
        assertEquals(telefono, instance.getTelefono());
    }

    /**
     * Test of getCorreo method, of class Usuario.
     */
    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        Cliente instance = (Cliente) usuarioCompleto;
        String expResult = "testC";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCorreo method, of class Usuario.
     */
    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        String correo = "testC1";
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setCorreo(correo);
        assertEquals(correo, instance.getCorreo());
    }

    /**
     * Test of getConectado method, of class Usuario.
     */
    @Test
    public void testGetConectado() {
        System.out.println("getConectado");
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setConectado(Boolean.TRUE);
        Boolean expResult = true;
        Boolean result = instance.getConectado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConectado method, of class Usuario.
     */
    @Test
    public void testSetConectado() {
        System.out.println("setConectado");
        Boolean conectado = true;
        Cliente instance = (Cliente) usuarioCompleto;
        instance.setConectado(conectado);
        assertEquals(conectado, instance.getConectado());
    }
    
}

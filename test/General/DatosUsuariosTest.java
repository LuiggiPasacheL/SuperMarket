/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import modelo.usuario.Administrador;
import modelo.usuario.Cliente;
import modelo.usuario.FactoryAdministrador;
import modelo.usuario.FactoryCliente;
import modelo.usuario.IFactoryUsuario;
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
public class DatosUsuariosTest {
    
    DatosUsuarios datosUsuarios;
    Administrador a1;
    Cliente u1;
    
    public DatosUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        datosUsuarios = new DatosUsuarios();
        a1 = (Administrador) datosUsuarios.registrarUsuario(new FactoryAdministrador(),"testa1", "123testa");
        u1 = (Cliente) datosUsuarios.registrarUsuario(new FactoryCliente(),"testu1", "123testu",
                "testu1", "123testu", "testd", "123456", "test@test.com");
    }
    
    @After
    public void tearDown() {
        datosUsuarios.eliminarDatos();
    }

    /**
     * Test of registrarUsuario method, of class DatosUsuarios.
     */
    @Test
    public void testRegistrarUsuario_IUsuario() {
        System.out.println("registrarUsuario");
        //como el registro ya se hizo anteriormente en setUp
        assertEquals(u1, datosUsuarios.buscarUsuario(0));
    }

    /**
     * Test of tamañoUsuario method, of class DatosUsuarios.
     */
    @Test
    public void testTamañoUsuario() {
        System.out.println("tama\u00f1oUsuario");
        int expResult = 1;
        int result = datosUsuarios.tamañoUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarUsuario method, of class DatosUsuarios.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        int i = 0;
        IUsuario result = datosUsuarios.buscarUsuario(i);
        assertEquals(u1, result);
    }

    /**
     * Test of verificarSesion method, of class DatosUsuarios.
     */
    @Test
    public void testVerificarSesion() {
        System.out.println("verificarSesion");
        String login = u1.getUser();
        String contraseña = u1.getContraseña();
        IUsuario result = datosUsuarios.verificarSesion(login, contraseña);
        assertEquals(u1, result);
    }

    /**
     * Test of validarDatos method, of class DatosUsuarios.
     */
    @Test
    public void testValidarDatos() {
        System.out.println("validarDatos");
        String usuario = u1.getUser();
        boolean expResult = true;
        boolean result = datosUsuarios.validarDatos(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of datosUsuario method, of class DatosUsuarios.
     */
    @Test
    public void testDatosUsuario() {
        System.out.println("datosUsuario");
        String usuario = u1.getUser();
        IUsuario expResult = u1;
        IUsuario result = datosUsuarios.datosUsuario(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of tamañoAdmin method, of class DatosUsuarios.
     */
    @Test
    public void testTamañoAdmin() {
        System.out.println("tama\u00f1oAdmin");
        int expResult = 1;
        int result = datosUsuarios.tamañoAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarAdmin method, of class DatosUsuarios.
     */
    @Test
    public void testBuscarAdmin() {
        System.out.println("buscarAdmin");
        int i = 0;
        IUsuario expResult = a1;
        IUsuario result = datosUsuarios.buscarAdmin(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarSesionAdmin method, of class DatosUsuarios.
     */
    @Test
    public void testVerificarSesionAdmin() {
        System.out.println("verificarSesionAdmin");
        String login = a1.getUser();
        String contraseña = a1.getContraseña();
        IUsuario expResult = a1;
        IUsuario result = datosUsuarios.verificarSesionAdmin(login, contraseña);
        assertEquals(expResult, result);
    }

    /**
     * Test of datosAdmin method, of class DatosUsuarios.
     */
    @Test
    public void testDatosAdmin() {
        System.out.println("datosAdmin");
        String usuario = a1.getUser();
        IUsuario expResult = a1;
        IUsuario result = datosUsuarios.datosAdmin(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarDatos method, of class DatosUsuarios.
     */
    @Test
    public void testEliminarDatos() {
        System.out.println("eliminarDatos");
        DatosUsuarios instance = datosUsuarios;
        instance.eliminarDatos();
        int expResult = 0;
        int result = instance.tamañoUsuario() + instance.tamañoAdmin();
        assertEquals(expResult, result);
    }
    
}

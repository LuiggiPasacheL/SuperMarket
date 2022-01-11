/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import modelo.Producto;
import modelo.Usuario;
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
public class SistemaTest {
    
    Sistema sistema;
    
    Usuario u1;
    Usuario a1;
    Producto producto;
    
    public SistemaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sistema = new Sistema();
        u1 = new Usuario("testu1", "123testu");
        a1 = new Usuario("testa1", "123testa");
        producto = new Producto("1", "prodTest", 1, 1, "prueba");
        sistema.actualizarProducto(producto);
        sistema.registrarUsuario(u1);
        sistema.admins.add(a1);
    }
    
    @After
    public void tearDown() {
        sistema.vaciar();
    }

    /**
     * Test of registrarUsuario method, of class Sistema.
     */
    @Test
    public void testRegistrarUsuario() {
        System.out.println("registrarUsuario");
        sistema.registrarUsuario(u1);
        assertEquals(u1, sistema.buscarUsuario(0));
    }

    /**
     * Test of tamañoUsuario method, of class Sistema.
     */
    @Test
    public void testTamañoUsuario() {
        System.out.println("tama\u00f1oUsuario");
        int expResult = 1;
        int result = sistema.tamañoUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarUsuario method, of class Sistema.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        int i = 0;
        sistema.registrarUsuario(u1);
        Usuario result = sistema.buscarUsuario(0);
        assertEquals(u1, result);
    }

    /**
     * Test of verificarSesion method, of class Sistema.
     */
    @Test
    public void testVerificarSesion() {
        System.out.println("verificarSesion");
        String login = u1.getUser();
        String contraseña = u1.getContraseña();
        Usuario result = sistema.verificarSesion(login, contraseña);
        assertEquals(u1, result);
    }

    /**
     * Test of validarDatos method, of class Sistema.
     */
    @Test
    public void testValidarDatos() {
        System.out.println("validarDatos");
        String usuario = u1.getUser();
        boolean expResult = true;
        boolean result = sistema.validarDatos(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of datosUsuario method, of class Sistema.
     */
    @Test
    public void testDatosUsuario() {
        System.out.println("datosUsuario");
        String usuario = u1.getUser();
        Usuario expResult = u1;
        Usuario result = sistema.datosUsuario(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of tamañoAdmin method, of class Sistema.
     */
    @Test
    public void testTamañoAdmin() {
        System.out.println("tama\u00f1oAdmin");
        int expResult = 1;
        int result = sistema.tamañoAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscarAdmin method, of class Sistema.
     */
    @Test
    public void testBuscarAdmin() {
        System.out.println("buscarAdmin");
        int i = 0;
        Usuario expResult = a1;
        Usuario result = sistema.buscarAdmin(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of verificarSesionAdmin method, of class Sistema.
     */
    @Test
    public void testVerificarSesionAdmin() {
        System.out.println("verificarSesionAdmin");
        String login = a1.getUser();
        String contraseña = a1.getContraseña();
        Usuario expResult = a1;
        Usuario result = sistema.verificarSesionAdmin(login, contraseña);
        assertEquals(expResult, result);
    }

    /**
     * Test of datosAdmin method, of class Sistema.
     */
    @Test
    public void testDatosAdmin() {
        System.out.println("datosAdmin");
        String usuario = a1.getUser();
        Usuario expResult = a1;
        Usuario result = sistema.datosAdmin(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of faltanDatos method, of class Sistema.
     */
    @Test
    public void testFaltanDatos() {
        System.out.println("faltanDatos");
        boolean expResult = false;
        boolean result = sistema.faltanDatos();
        assertEquals(expResult, result);
    }

    /**
     * Test of actualizarProducto method, of class Sistema.
     */
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        assertEquals(producto, sistema.getProducto(0));
    }

    /**
     * Test of tamañoProducto method, of class Sistema.
     */
    @Test
    public void testTamañoProducto() {
        System.out.println("tama\u00f1oProducto");
        int expResult = 1;
        int result = sistema.tamañoProducto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProducto method, of class Sistema.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        int i = 0;
        Producto expResult = producto;
        Producto result = sistema.getProducto(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatos method, of class Sistema.
     */
    @Test
    public void testGetDatos() {
        System.out.println("getDatos");
        String[][] result = sistema.getDatos();
        String[][] expResult = new String[sistema.tamañoProducto()][5];
        int i = 0;
        expResult[i][0] = producto.getId_producto();
        expResult[i][1] = producto.getNombre_producto();
        expResult[i][2] = String.valueOf(producto.getCantidad());
        expResult[i][3] = producto.getTipo();
        expResult[i][4] = Float.toString(producto.getPrecio());
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getCabecera method, of class Sistema.
     */
    @Test
    public void testGetCabecera() {
        System.out.println("getCabecera");
        String[] expResult = {"ID", "NOMBRE", "CANTIDAD", "TIPO", "PRECIO"};;
        String[] result = sistema.getCabecera();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of eliminarProductoxNombre method, of class Sistema.
     */
    @Test
    public void testEliminarProductoxNombre() {
        System.out.println("eliminarProductoxNombre");
        String nomProd = producto.getNombre_producto();
        sistema.eliminarProductoxNombre(nomProd);
    }

    /**
     * Test of asignarCodigo method, of class Sistema.
     */
    @Test
    public void testAsignarCodigo() {
        System.out.println("asignarCodigo");
        int expResult = 2;
        int result = sistema.asignarCodigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatosBusqueda method, of class Sistema.
     */
    @Test
    public void testGetDatosBusqueda() {
        System.out.println("getDatosBusqueda");
        String dato = producto.getNombre_producto();
        String[][] expResult = new String[1][5];
        expResult[0][0] = producto.getId_producto();
        expResult[0][1] = producto.getNombre_producto();
        expResult[0][2] = String.valueOf(producto.getCantidad());
        expResult[0][3] = producto.getTipo();
        expResult[0][4] = Float.toString(producto.getPrecio());
        String[][] result = sistema.getDatosBusqueda(dato);
        assertArrayEquals(expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import modelo.producto.Producto;
import modelo.producto.IProducto;
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
public class DatosProductosTest {
    
    DatosProductos datosProductos;
    IProducto producto;
    
    public DatosProductosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        datosProductos = new DatosProductos();
        producto = new Producto("prodTest", 1, 1, "prueba");
        datosProductos.actualizarProducto(producto);
    }
    
    @After
    public void tearDown() {
        datosProductos.eliminarDatos();
    }

    /**
     * Test of actualizarProducto method, of class DatosProductos.
     */
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        assertEquals(producto, datosProductos.getProducto(0));
    }

    /**
     * Test of tamañoProducto method, of class DatosProductos.
     */
    @Test
    public void testTamañoProducto() {
        System.out.println("tama\u00f1oProducto");
        int expResult = 1;
        int result = datosProductos.tamañoProducto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProducto method, of class DatosProductos.
     */
    @Test
    public void testGetProducto() {
        System.out.println("getProducto");
        int i = 0;
        IProducto expResult = producto;
        IProducto result = datosProductos.getProducto(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatos method, of class DatosProductos.
     */
    @Test
    public void testGetDatos() {
        System.out.println("getDatos");
        String[][] result = datosProductos.getDatos();
        String[][] expResult = new String[datosProductos.tamañoProducto()][5];
        int i = 0;
        expResult[i][0] = producto.getId_producto();
        expResult[i][1] = producto.getNombre_producto();
        expResult[i][2] = String.valueOf(producto.getCantidad());
        expResult[i][3] = producto.getTipo();
        expResult[i][4] = Float.toString(producto.getPrecio());
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getCabecera method, of class DatosProductos.
     */
    @Test
    public void testGetCabecera() {
        System.out.println("getCabecera");
        String[] expResult = {"ID", "NOMBRE", "CANTIDAD", "TIPO", "PRECIO"};;
        String[] result = datosProductos.getCabecera();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of eliminarProductoxNombre method, of class DatosProductos.
     */
    @Test
    public void testEliminarProductoxNombre() {
        System.out.println("eliminarProductoxNombre");
        String nomProd = producto.getNombre_producto();
        datosProductos.eliminarProductoxNombre(nomProd);
    }

    /**
     * Test of asignarCodigo method, of class DatosProductos.
     */
    @Test
    public void testAsignarCodigo() {
        System.out.println("asignarCodigo");
        int expResult = 2;
        int result = datosProductos.asignarCodigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatosBusqueda method, of class DatosProductos.
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
        String[][] result = datosProductos.getDatosBusqueda(dato);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of editarProducto method, of class DatosProductos.
     */
    @Test
    public void testEditarProducto() {
        System.out.println("editarProducto");
        Producto prod = new Producto("Coca cola", (float) 2.5, 12, "Gaseosa");
        DatosProductos instance = datosProductos;
        instance.editarProducto(prod);
    }
    
}

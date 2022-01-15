/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.producto.IProducto;
import modelo.producto.Producto;
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
public class ProductoTest {
    
    IProducto producto;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        producto = new Producto("1", "producto de prueba", 1, 1, "prueba");
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getId_producto method, of class Producto.
     */
    @Test
    public void testGetId_producto() {
        System.out.println("getId_producto");
        String expResult = "1";
        String result = producto.getId_producto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre_producto method, of class Producto.
     */
    @Test
    public void testGetNombre_producto() {
        System.out.println("getNombre_producto");
        String expResult = "producto de prueba";
        String result = producto.getNombre_producto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        float expResult = 1.0F;
        float result = producto.getPrecio();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCantidad method, of class Producto.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        int expResult = 1;
        int result = producto.getCantidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class Producto.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        String expResult = "prueba";
        String result = producto.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId_producto method, of class Producto.
     */
    @Test
    public void testSetId_producto() {
        System.out.println("setId_producto");
        String id_producto = "";
        producto.setId_producto(id_producto);
        assertEquals(id_producto, producto.getId_producto());
    }

    /**
     * Test of setNombre_producto method, of class Producto.
     */
    @Test
    public void testSetNombre_producto() {
        System.out.println("setNombre_producto");
        String nombre_producto = "";
        producto.setNombre_producto(nombre_producto);
        assertEquals(nombre_producto, producto.getNombre_producto());
    }

    /**
     * Test of setPrecio method, of class Producto.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        float precio = 0.0F;
        producto.setPrecio(precio);
        assertEquals(precio, producto.getPrecio(),0.0);
    }

    /**
     * Test of setCantidad method, of class Producto.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        producto.setCantidad(cantidad);
        assertEquals(cantidad, producto.getCantidad());
    }

    /**
     * Test of setTipo method, of class Producto.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        producto.setTipo(tipo);
        assertEquals(tipo, producto.getTipo());
    }
    
}

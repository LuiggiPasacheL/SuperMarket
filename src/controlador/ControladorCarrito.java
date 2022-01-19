package controlador;

import General.DatosProductos;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.compras.CarritoCompra;
import modelo.producto.IProducto;
import modelo.producto.ProductoConDescuento;
import vista.vistaCarrito;
import vista.vistaProductos;

public class ControladorCarrito {

    vistaCarrito vista;
    CarritoCompra productos;
    IProducto productoSeleccionado;
    float precioTotal;
    int cantidadAdquirirProdSeleccionado;
    float precioProdSeleccionado;
    boolean tieneDescuento = false;
    DecimalFormat df = new DecimalFormat("###.##");
    float[] preciosProductosSeleccionados;
    int[] cantidadesAdquirirProdSeleccionado;
    int indiceProductoSeleccionado;

    public ControladorCarrito(vistaCarrito vista, CarritoCompra productosSeleccionado) {
        this.vista = vista;
        this.productos = productosSeleccionado;
        cantidadAdquirirProdSeleccionado = 0;

        int cantidadDeProductos = this.productos.cantidadDeProductos();
        preciosProductosSeleccionados = new float[cantidadDeProductos];
        cantidadesAdquirirProdSeleccionado = new int[cantidadDeProductos];

        precioTotal = 0;
        for (int i = 0; i < cantidadDeProductos; i++) {
            preciosProductosSeleccionados[i] = productos.getProducto(i).getPrecio();
            cantidadesAdquirirProdSeleccionado[i] = 1;
            precioTotal += preciosProductosSeleccionados[i];
        }

        this.vista.btnComprar.addActionListener((ae) -> {
            cantidadAdquirirProdSeleccionado = (int) vista.spinnerCantidad.getValue();

            if (cantidadAdquirirProdSeleccionado <= 0) {
                return;
            }

            if (!cantidadValida(cantidadAdquirirProdSeleccionado)) {
                return;
            }

            vista.dispose();
            ControladorPago siguiente = new ControladorPago(productos, cantidadesAdquirirProdSeleccionado);
            siguiente.iniciar();

        });

        this.vista.spinnerCantidad.addChangeListener((ce) -> {

            //Obtener producto seleciconado
            indiceProductoSeleccionado = vista.tblProd.getSelectedRow();

            cantidadAdquirirProdSeleccionado = (int) vista.spinnerCantidad.getValue();
            try {

                if (!cantidadValida(cantidadAdquirirProdSeleccionado)) {
                    return;
                }

                System.out.println("error");

                if (!tieneDescuento && cantidadAdquirirProdSeleccionado > 10) {
                    productos.setProducto(indiceProductoSeleccionado,
                            new ProductoConDescuento(productos.getProducto(indiceProductoSeleccionado)));
                    tieneDescuento = true;
                }

                if (tieneDescuento && cantidadAdquirirProdSeleccionado <= 10) {
                    IProducto sinDecorador = productos.getProducto(indiceProductoSeleccionado).quitarDecorador();
                    sinDecorador = sinDecorador == null ? productos.getProducto(indiceProductoSeleccionado) : sinDecorador;
                    productos.setProducto(indiceProductoSeleccionado, sinDecorador);
                    tieneDescuento = false;
                }

                if (tieneDescuento) {
                    vista.lblOferta.setText(productos.getProducto(indiceProductoSeleccionado).getDescuento() + " de descuento");
                    vista.lblOferta.setVisible(true);
                } else {
                    vista.lblOferta.setVisible(false);
                }

                preciosProductosSeleccionados[indiceProductoSeleccionado] = (float) cantidadAdquirirProdSeleccionado * (float) productos.getProducto(indiceProductoSeleccionado).getPrecio();
                cantidadesAdquirirProdSeleccionado[indiceProductoSeleccionado] = cantidadAdquirirProdSeleccionado;

                System.out.println("Error");

                precioTotal = 0;
                for (int i = 0; i < cantidadDeProductos; i++) {
                    precioTotal += preciosProductosSeleccionados[i];
                }

                vista.txtPrecioProd.setText(df.format(preciosProductosSeleccionados[indiceProductoSeleccionado]));

                System.out.println("Error");

                vista.txtPrecioTotal.setText(df.format(precioTotal));
            } catch (ArrayIndexOutOfBoundsException a) {
                System.out.println("Seleccione un producto");
            }

        });

        this.vista.tblProd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                try {
                    //Obtener producto seleciconado
                    indiceProductoSeleccionado = vista.tblProd.getSelectedRow();
                    productoSeleccionado = productos.getProducto(indiceProductoSeleccionado);
                    //Obtener cantidad del spinner
                    vista.spinnerCantidad.setValue(cantidadesAdquirirProdSeleccionado[indiceProductoSeleccionado]);
                    cantidadAdquirirProdSeleccionado = (int) vista.spinnerCantidad.getValue();
                    //Calcular precio del producto
                    preciosProductosSeleccionados[indiceProductoSeleccionado] = productoSeleccionado.getPrecio() * cantidadAdquirirProdSeleccionado;
                    //Mostrar en vistas
                    vista.txtNom.setText(productoSeleccionado.getNombre_producto());
                    vista.txtTipo.setText(productoSeleccionado.getTipo());
                    vista.txtPrecioProd.setText(String.valueOf(preciosProductosSeleccionados[indiceProductoSeleccionado]));
                    //Calculando y mostrando precio total
                    precioTotal = 0;
                    for (int i = 0; i < productos.cantidadDeProductos(); i++) {
                        precioTotal += preciosProductosSeleccionados[i];
                    }
                    vista.txtPrecioTotal.setText(String.valueOf(precioTotal));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Algo salio mal, intentelo nuevamente");
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

        this.vista.btnVolver.addActionListener((ae) -> {
            volver();
        });
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.txtNom.setText("");
        vista.txtTipo.setText("");
        vista.txtPrecioProd.setText("");
        vista.txtPrecioTotal.setText(String.valueOf(precioTotal)); // Suma del precio unitario de todos los productos
        vista.lblOferta.setVisible(false);
        vista.spinnerCantidad.setValue(0);
        String[][] datos = productos.getDatos();
        String[] cabecera = productos.getCabecera();
        DefaultTableModel modeloProducto = new DefaultTableModel(datos, cabecera);
        vista.tblProd.setModel(modeloProducto);
    }

    private void volver() {
        vista.dispose();
        vistaProductos vista1 = new vistaProductos();
        DatosProductos s = new DatosProductos();
        ControladorProductos ci = new ControladorProductos(vista1, s);
        ci.iniciar();
    }

    private int confirmacionCompra() {
        String confirmacionCompra = "¿Está seguro de comprar?:\n"
                + "Producto: " + productos.getProducto(indiceProductoSeleccionado).getNombre_producto() + "\n"
                + "Cantidad: " + cantidadAdquirirProdSeleccionado + "\n"
                + "Precio Final: " + df.format(precioTotal);

        int confirmacion = JOptionPane.showConfirmDialog(vista, confirmacionCompra, "Confirmacion de compra", 0);

        return confirmacion;
    }

    private boolean cantidadValida(int cantidad) {
        if (cantidad > productos.getProducto(indiceProductoSeleccionado).getCantidad() || cantidad < 0) {
            JOptionPane.showMessageDialog(vista, "sobrepasa la cantidad de productos",
                    "Error", 3);
            vista.spinnerCantidad.setValue(productos.getProducto(indiceProductoSeleccionado).getCantidad());
            return false;
        }
        return true;
    }
}

package General;

import modelo.Producto;
import modelo.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class DatosProductos {
    //METODOS PRODUCTO
    public static ArrayList<Producto> products = new ArrayList();
    private final String[] cabecera = {"ID", "NOMBRE", "CANTIDAD", "TIPO", "PRECIO"};
    int cod;

    public void actualizarProducto(Producto producto) {
        products.add(producto);
    }

    public int tamañoProducto() {
        int result;
        result = products.size();
        return result;
    }

    public Producto getProducto(int i) {
        return products.get(i);
    }

    public String[][] getDatos() {
        String[][] result = new String[tamañoProducto()][5];
        for (int i = 0; i < tamañoProducto(); i++) {
            result[i][0] = getProducto(i).getId_producto();
            result[i][1] = getProducto(i).getNombre_producto();
            result[i][2] = String.valueOf(getProducto(i).getCantidad());
            result[i][3] = getProducto(i).getTipo();
            result[i][4] = Float.toString(getProducto(i).getPrecio());
        }
        return result;
    }

    public String[] getCabecera() {
        return this.cabecera;
    }

    public void eliminarProductoxNombre(String nomProd) {
        Usuario user = null;
        for (int i = 0; i < this.tamañoProducto(); i++) {
            if (nomProd.equals(this.getProducto(i).getNombre_producto())) {
                products.remove(i);
                break;
            }
        }
    }

    public int asignarCodigo() {
        cod = this.tamañoProducto() + 1;
        return cod;
    }

    public String[][] getDatosBusqueda(String dato) {
        String[][] result = new String[tamañoProducto()][5];
        for (int i = 0; i < tamañoProducto(); i++) {
            if (dato.equalsIgnoreCase(getProducto(i).getNombre_producto())) {
                result[i][0] = getProducto(i).getId_producto();
                result[i][1] = getProducto(i).getNombre_producto();
                result[i][2] = String.valueOf(getProducto(i).getCantidad());
                result[i][3] = getProducto(i).getTipo();
                result[i][4] = Float.toString(getProducto(i).getPrecio());
            }
        }
        return result;
    }

    public void editarProducto(String dato) {
        for (int i = 0; i < tamañoProducto(); i++) {
            if (dato == getProducto(i).getNombre_producto()) {
                try {
                    int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Editar datos de " + getProducto(i).getNombre_producto() + ":\n" + "1. Nombre\n2. Cantidad\n3. Precio\n4. Tipo"));
                    switch (opc) {
                        case 1:
                            String nombre = JOptionPane.showInputDialog(null, "Dato actual: " + getProducto(i).getNombre_producto() + "\nNuevo dato:");
                            getProducto(i).setNombre_producto(nombre);
                            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                            break;
                        case 2:
                            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Dato actual: " + getProducto(i).getCantidad() + "\nNuevo dato:"));
                            getProducto(i).setCantidad(cantidad);
                            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                            break;
                        case 3:
                            float precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Dato actual: " + getProducto(i).getPrecio() + "\nNuevo dato:"));
                            getProducto(i).setPrecio(precio);
                            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                            break;
                        case 4:
                            String tipo = JOptionPane.showInputDialog(null, "Dato actual: " + getProducto(i).getTipo() + "\nNuevo dato:");
                            getProducto(i).setTipo(tipo);
                            JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Cancelar edición, intentelo nuevamente");
                }

            }
        }

    }

    public void eliminarDatos(){
        products.removeAll(products);
    }
}

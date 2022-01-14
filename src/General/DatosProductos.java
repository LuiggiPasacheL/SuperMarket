package General;

import modelo.Producto;
import modelo.Usuario;

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

    public void eliminarDatos(){
        products.removeAll(products);
    }
}

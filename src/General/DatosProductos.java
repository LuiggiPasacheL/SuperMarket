package General;

import javax.swing.*;
import java.util.ArrayList;
import modelo.producto.IProducto;

public class DatosProductos {
    //METODOS PRODUCTO
    public static ArrayList<IProducto> products = new ArrayList();
    private final String[] cabecera = {"ID", "NOMBRE", "CANTIDAD", "TIPO", "PRECIO"};
    int cod;

    public void actualizarProducto(IProducto producto) {
        products.add(producto);
    }

    public int tamañoProducto() {
        int result;
        result = products.size();
        return result;
    }

    public IProducto getProducto(int i) {
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

    public void editarProducto(IProducto producto){
        int opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Editar datos de " + producto.getNombre_producto() + ":\n" + "1. Nombre\n2. Cantidad\n3. Precio\n4. Tipo"));
        switch (opc) {
            case 1:
                String nombre = JOptionPane.showInputDialog(null, "Dato actual: " + producto.getNombre_producto() + "\nNuevo dato:");
                if(nombre == null ){
                    return;
                }
                if(nombre.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No se pueden ingresar nombres vacios");
                    return;
                }
                producto.setNombre_producto(nombre);
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                break;
            case 2:
                try {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Dato actual: " + producto.getCantidad() + "\nNuevo dato:"));
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No se puede ingresar cantidad vacia");
                }
                break;
            case 3:
                try{
                    float precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Dato actual: " + producto.getPrecio() + "\nNuevo dato:"));
                    producto.setPrecio(precio);
                    JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "No se puede ingresar precio vacio");
                }
                break;
            case 4:
                String tipo = JOptionPane.showInputDialog(null, "Dato actual: " + producto.getTipo() + "\nNuevo dato:");
                if(tipo == null){
                    return;
                }
                if(tipo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No se pueden ingresar tipos vacios");
                    return;
                }
                producto.setTipo(tipo);
                JOptionPane.showMessageDialog(null, "Actualizado correctamente");
                break;
            default:
                break;
        }
    }

    public void eliminarDatos(){
        products.removeAll(products);
    }
}

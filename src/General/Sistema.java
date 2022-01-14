/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Usuario;
import modelo.producto.IProducto;
import modelo.usuario.IUsuario;

import java.util.ArrayList;

/**
 *
 * @author OSCAR
 */
public class Sistema {

    //METODOS USUARIO
    public static IUsuario conectado;
    public static IProducto productoSeleccionado;
    public static ArrayList<IUsuario> users = new ArrayList();
    public static ArrayList<IUsuario> admins = new ArrayList();
    
    public void registrarUsuario(IUsuario usuario) {
        users.add(usuario);
    }

    //CLIENTE
    public int tamañoUsuario() {
        int result;
        result = users.size();
        return result;
    }

    public IUsuario buscarUsuario(int i) {
        return users.get(i);
    }

    public IUsuario verificarSesion(String login, String contraseña) {
        IUsuario result = null;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (this.buscarUsuario(i).iniciarSesion(login, contraseña)) {
                result = this.buscarUsuario(i);
                break;
            }
        }
        return result;
    }

    public boolean validarDatos(String usuario) {
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (usuario.equals(this.buscarUsuario(i).getUser())) {
                return false;
            }
        }
        return true;
    }

    public IUsuario datosUsuario(String usuario) {
        IUsuario user = null;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if (usuario.equals(this.buscarUsuario(i).getUser())) {
                user = this.buscarUsuario(i);
                break;
            }
        }
        return user;
    }

    //ADMIN
    public int tamañoAdmin() {
        int result;
        result = admins.size();
        return result;
    }

    public IUsuario buscarAdmin(int i) {
        return admins.get(i);
    }

    public IUsuario verificarSesionAdmin(String login, String contraseña) {
        IUsuario result = null;
        for (int i = 0; i < this.tamañoAdmin(); i++) {
            if (this.buscarAdmin(i).iniciarSesion(login, contraseña)) {
                result = this.buscarAdmin(i);
                break;
            }
        }
        return result;
    }

    public IUsuario datosAdmin(String usuario) {
        IUsuario user = null;
        for (int i = 0; i < this.tamañoAdmin(); i++) {
            if (usuario.equals(this.buscarAdmin(i).getUser())) {
                user = this.buscarAdmin(i);
                break;
            }
        }
        return user;
    }

    /*
    public boolean faltanDatos() {
        boolean result = true;
        for (int i = 0; i < this.tamañoUsuario(); i++) {
            if ("".equals(buscarUsuario(i).getNombre()) || "".equals(buscarUsuario(i).getApellido())
                    || "".equals(buscarUsuario(i).getCorreo()) || "".equals(buscarUsuario(i).getDireccion())
                    || "".equals(buscarUsuario(i).getTelefono()) || "".equals(buscarUsuario(i).getUser())) {
                result = false;
                break;
            }
        }
        return result;
    }*/

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

    public void vaciar() {
        users.removeAll(users);
        admins.removeAll(admins);
        products.removeAll(products);
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
    //TERMINAR TEST, TRY CATCH
}

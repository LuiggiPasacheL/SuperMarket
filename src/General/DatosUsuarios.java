package General;

import modelo.producto.IProducto;
import modelo.usuario.IUsuario;

import java.util.ArrayList;

public class DatosUsuarios {
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

    public void eliminarDatos(){
        users.removeAll(users);
        admins.removeAll(admins);

    }
}

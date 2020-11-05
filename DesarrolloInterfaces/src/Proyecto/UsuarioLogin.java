package Proyecto;

public class UsuarioLogin {
    String usuario; 
    char[] contraseña;

    public UsuarioLogin(String usuario, char[] contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
}
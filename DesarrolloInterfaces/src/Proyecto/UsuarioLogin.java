package Proyecto;

public class UsuarioLogin {
    String usuario, profesion, contraseña;

    public UsuarioLogin(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + "}";
    }
    
}
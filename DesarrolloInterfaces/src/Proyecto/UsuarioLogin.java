package Proyecto;

public class UsuarioLogin {
    String usuario, profesion, contraseņa;

    public UsuarioLogin(String usuario, String contraseņa) {
        this.usuario = usuario;
        this.contraseņa = contraseņa;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseņa + "}";
    }
    
}
package Proyecto;

public class UsuarioLogin {
    String usuario, profesion, contrase�a;

    public UsuarioLogin(String usuario, String contrase�a) {
        this.usuario = usuario;
        this.contrase�a = contrase�a;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrase\u00f1a=" + contrase�a + "}";
    }
    
}
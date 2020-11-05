package Proyecto;

public class Usuario extends UsuarioLogin {
    
    String nombre, apellidos, NUSS, correo, profesi�n, DNI;
    int sueldoBase;

    public Usuario(String DNI,String usuario, char[] contrase�a, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesi�n) {
        super(usuario, contrase�a);
        this.nombre = nombre;
        this.apellidos = apellido;
        this.NUSS = NUSS;
        this.correo = correo;
        this.profesi�n = profesi�n;
        this.DNI = DNI;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return nombre + ";"+ apellidos +";" + NUSS + ";" + correo + ";" + profesi�n + ";" + DNI + ";" + sueldoBase;
    }
    
}
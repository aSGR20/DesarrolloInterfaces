package Proyecto;

public class Usuario extends UsuarioLogin {
    
    String nombre, apellidos, NUSS, correo, DNI;
    int sueldoBase;

    public Usuario(String DNI, String usuario, String contrase�a, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesi�n) {
        super(usuario, contrase�a);
        this.nombre = nombre;
        this.apellidos = apellido;
        this.profesion = profesion;
        this.NUSS = NUSS;
        this.correo = correo;
        this.DNI = DNI;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return nombre + ";"+ apellidos +";" + NUSS + ";" + correo + ";" + DNI + ";" + sueldoBase;
    }
    
}
package Proyecto;

public class Usuario extends UsuarioLogin {
    
    String nombre, apellidos, NUSS, correo, profesión, DNI;
    int sueldoBase;

    public Usuario(String DNI,String usuario, char[] contraseña, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesión) {
        super(usuario, contraseña);
        this.nombre = nombre;
        this.apellidos = apellido;
        this.NUSS = NUSS;
        this.correo = correo;
        this.profesión = profesión;
        this.DNI = DNI;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return nombre + ";"+ apellidos +";" + NUSS + ";" + correo + ";" + profesión + ";" + DNI + ";" + sueldoBase;
    }
    
}
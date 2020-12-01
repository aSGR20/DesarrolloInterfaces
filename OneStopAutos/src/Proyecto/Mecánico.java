package Proyecto;

public class Mecánico extends Usuario {

    boolean esJefe;
    String especialidad;

    public Mecánico(String DNI, String usuario, String contraseña, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesión,
            boolean esJefe, String especialidad) {
        super(DNI, usuario, contraseña, nombre, apellido, NUSS, sueldoBase, correo, profesión);
        this.esJefe = esJefe;
        this.especialidad = especialidad;
    }
    @Override
    public String toString() {
        return esJefe + " " + especialidad + " " + DNI + " " + usuario + " " + contraseña
                + " " + nombre + " " + apellidos + " " + NUSS + " " + sueldoBase + " " + correo
                + " " + profesion;
    }
}
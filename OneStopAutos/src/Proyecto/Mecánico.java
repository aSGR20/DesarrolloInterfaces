package Proyecto;

public class Mec�nico extends Usuario {

    boolean esJefe;
    String especialidad;

    public Mec�nico(String DNI, String usuario, String contrase�a, String nombre,
            String apellido, String NUSS, int sueldoBase, String correo, String profesi�n,
            boolean esJefe, String especialidad) {
        super(DNI, usuario, contrase�a, nombre, apellido, NUSS, sueldoBase, correo, profesi�n);
        this.esJefe = esJefe;
        this.especialidad = especialidad;
    }
    @Override
    public String toString() {
        return esJefe + " " + especialidad + " " + DNI + " " + usuario + " " + contrase�a
                + " " + nombre + " " + apellidos + " " + NUSS + " " + sueldoBase + " " + correo
                + " " + profesion;
    }
}
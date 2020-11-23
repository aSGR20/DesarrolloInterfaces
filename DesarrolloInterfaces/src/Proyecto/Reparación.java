package Proyecto;

public class Reparación {

    int numIncidencia, coste;
    String DNICliente, DNIUsuario, problema, tiempoEstimado, piezas;

    public Reparación(int numIncidencia, String DNICliente, String DNIUsuario, String problema, int coste, String tiempoEstimado, String piezas) {
        this.numIncidencia = numIncidencia;
        this.coste = coste;
        this.DNICliente = DNICliente;
        this.DNIUsuario = DNIUsuario;
        this.problema = problema;
        this.tiempoEstimado = tiempoEstimado;
        this.piezas = piezas;
    }
    @Override
    public String toString() {
        return numIncidencia + " " + coste + " " + DNICliente + " " + DNIUsuario
                + " " + problema + " " + tiempoEstimado + " " + piezas;
    }
}
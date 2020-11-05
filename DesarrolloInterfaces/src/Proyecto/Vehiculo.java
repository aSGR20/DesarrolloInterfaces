package Proyecto;

public class Vehiculo {
    int numSerial, precio;
    String modelo, marca, tipo, fechaEntrada, infoAdicional;

    public Vehiculo(int numSerial, String modelo, String marca, String tipo, int precio, String fechaEntrada, String infoAdicional) {
        this.numSerial = numSerial;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.infoAdicional = infoAdicional;
    }

    @Override
    public String toString() {
        return numSerial + ";" + modelo + ";" + marca + ";" + tipo + ";" + precio + ";" + fechaEntrada + ";" + infoAdicional;
    }
}


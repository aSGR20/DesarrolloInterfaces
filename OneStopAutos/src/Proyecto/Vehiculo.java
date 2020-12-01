package Proyecto;

public class Vehiculo {
    int numSerial, precio, anyo, kilometros;
    String modelo, marca, tipo, fechaEntrada, combustible, infoAdicional;

    public Vehiculo(int numSerial, String modelo, String marca, String tipo, int precio, String fechaEntrada, int anyo, int kilometros, String combustible, String infoAdicional) {
        this.numSerial = numSerial;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.anyo = anyo;
        this.kilometros = kilometros;
        this.combustible = combustible;
        this.infoAdicional = infoAdicional;
    }

    @Override
    public String toString() {
        return numSerial + ";" + modelo + ";" + marca + ";" + tipo + ";" + precio + ";" + fechaEntrada + ";" + anyo + ";" + kilometros + ";" + combustible + ";" + infoAdicional;
    }
}


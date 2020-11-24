package Proyecto;

import java.sql.*;
import java.util.*;

public class DAO_Vehiculo extends DAO_Abstract{

    /**
     * Crea un array de vehículos con los datos de la tabla vehículos de la base de datos.
     * 
     * @return array de vehículos
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.vehículo");
            while(rs.next()){
                datosVehículos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla vehículos de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Vehiculo datoVehículo=(Vehiculo)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehículo` "
                    + "(`Num_Serial`, `Modelo`, `Marca`, "
                    + "`Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES"
                    + " ("+datoVehículo.numSerial+", '"+datoVehículo.modelo+
                    "', '"+datoVehículo.marca+"', '"+datoVehículo.tipo+"', "+
                    datoVehículo.precio+", '"+datoVehículo.fechaEntrada+"', '"+
                    datoVehículo.infoAdicional+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void agregarDatos(Object[]datos) {
        try {
        	if(datos.length==6) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehículo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+"');");
        	}else if (datos.length==7) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehículo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+"', '"+datos[6]+"');");
        	}
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public ArrayList<Object> buscarVehiculos(Object[]datos) {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehículo WHERE `Modelo` = '"+datos[0]+"' `Marca` = '"+datos[1]+"', `Tipo` = '"+datos[2]+"';");
            while(rs.next()){
                datosVehículos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }
    
    public ArrayList<Object> buscarVehiculosModelo(String modelo) {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehículo WHERE `Modelo` = '"+modelo+"';");
            while(rs.next()){
                datosVehículos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }
    
    public ArrayList<Object> buscarVehiculosMarca(String marca) {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehículo WHERE `Marca` = '"+marca+"';");
            while(rs.next()){
                datosVehículos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }
    
    public ArrayList<Object> buscarVehiculosTipos(String tipo) {
        ArrayList<Object> datosVehículos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehículo WHERE `Tipo` = '"+tipo+"';");
            while(rs.next()){
                datosVehículos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehículos;
    }
    
    public void venderVehiculo(int numSerie, String DNI_Cliente, String plazo, String DNI_Usuario) {
    	try {
    		int beneficios = 0;
    		rs = stm.executeQuery("SELECT Precio FROM vehículo WHERE `Num_Serial` = '"+numSerie+"'");
    		while(rs.next()) {
    			beneficios = rs.getInt(1);
    		}
    		System.out.println(beneficios);
        	stm.executeUpdate("INSERT INTO `venta` (`Num_Serial`, `DNI_Cliente`, `DNI_Usuario`, `Beneficios`, `Plazo`) VALUES ("+numSerie+", '"+DNI_Cliente+"', '"+DNI_Usuario+"', "+beneficios+", '"+plazo+"');");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificarDatos(int num_serie, Object[]data) {
        try {
        	stm.executeUpdate("UPDATE `vehículo` SET `Marca` = '"+data[0]+"', `Modelo` = '"+data[1]+"', `Precio` = '"+data[2]+"' WHERE `vehículo`.`Num_Serial` = '"+num_serie+"'");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}

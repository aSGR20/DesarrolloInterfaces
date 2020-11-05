package Proyecto;

import java.sql.*;
import java.util.*;

public class DAO_Cliente extends DAO_Abstract{

    /**
     * Crea un array de clientes con los datos de la tabla clientes de la base de datos.
     * 
     * @return array de clientes
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosClientes= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.cliente");
            while(rs.next()){
                datosClientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosClientes;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla clientes de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Cliente datoCliente=(Cliente)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`cliente` "
                    + "(`DNI_Cliente`, `Nombre`, `Apellidos`, "
                    + "`Teléfono`, `Domicilio`, `Correo`) VALUES ('"+datoCliente.DNI+"', '"+datoCliente.nombre+
                    "', '"+datoCliente.apellidos+"', '"+datoCliente.teléfono+"', '"+
                    datoCliente.domicilio+"', '"+datoCliente.correo+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void modificarDatos(String DNI, Object[]data) {
        try {
        	stm.executeUpdate("UPDATE `cliente` SET `Nombre` = '"+data[0]+"', `Apellidos` = '"+data[1]+"', `Teléfono` = '"+data[2]+"', `Domicilio` = '"+data[3]+"' WHERE `cliente`.`DNI_Cliente` = '"+DNI+"'");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void agregarDatos(Object[]datos) {
        try {
        	if(datos.length==6) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`cliente` (`DNI_Cliente`, `Nombre`, `Apellidos`, `Teléfono`, `Domicilio`, `Correo`) VALUES ('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"');");
        	}else if (datos.length==5) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`cliente` (`DNI_Cliente`, `Nombre`, `Apellidos`, `Teléfono`, `Domicilio`) VALUES ('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"');");
        	}
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void eliminarDatos(String DNI, Object[]data) {
        try {
        	stm.executeUpdate("DELETE FROM `cliente` WHERE `DNI_Cliente` = '"+DNI+"'");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public ArrayList<Object> buscarDNI(String dni) {
        ArrayList<Object> datosClientes= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.cliente WHERE `DNI_Cliente` = '"+dni+"';");
            while(rs.next()){
                datosClientes.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosClientes;
    }
    
}

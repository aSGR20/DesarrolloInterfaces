package Proyecto;

import java.sql.*;
import java.util.*;

public class DAO_Vehiculo extends DAO_Abstract{

    /**
     * Crea un array de vehÝculos con los datos de la tabla vehÝculos de la base de datos.
     * 
     * @return array de vehÝculos
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.vehÝculo");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }

    /**
     * Inserta los datos pasados como parßmetro en la tabla vehÝculos de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Vehiculo datoVehÝculo=(Vehiculo)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` "
                    + "(`Num_Serial`, `Modelo`, `Marca`, "
                    + "`Tipo`, `Precio`, `Fecha_Entrada`, `Inf_Adicional`) VALUES"
                    + " ("+datoVehÝculo.numSerial+", '"+datoVehÝculo.modelo+
                    "', '"+datoVehÝculo.marca+"', '"+datoVehÝculo.tipo+"', "+
                    datoVehÝculo.precio+", '"+datoVehÝculo.fechaEntrada+"', '"+
                    datoVehÝculo.infoAdicional+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public void agregarDatos(Object[]datos) {
        try {
        	if(datos.length==9) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`, `Anyo`,"
        				+ " `Kilometros`, `Combustible`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+", '"+datos[5]+"',"
        						+ " '"+datos[6]+"', '"+datos[7]+"', '"+datos[8]+"');");
        	}else if (datos.length==10) {
        		stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`vehÝculo` (`Num_Serial`, `Modelo`, `Marca`, `Tipo`, `Precio`, `Fecha_Entrada`, `Anyo`,"
        				+ " `Kilometros`, `Combustible`, `Inf_Adicional`) VALUES ("+datos[0]+", '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', "+datos[4]+","
        						+ " '"+datos[5]+"', '"+datos[6]+"', '"+datos[7]+"', '"+datos[8]+"', '"+datos[9]+"');");
        	}
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
    public ArrayList<Object> buscarVehiculos(Object[]datos) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Modelo` = '"+datos[0]+"' `Marca` = '"+datos[1]+"', `Tipo` = '"+datos[2]+"';");
            while(rs.next()){
            	datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosModelo(String modelo) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Modelo` = '"+modelo+"';");
            while(rs.next()){
            	datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosMarca(String marca) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Marca` = '"+marca+"';");
            while(rs.next()){
                datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosTipos(String tipo) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Tipo` = '"+tipo+"';");
            while(rs.next()){
            	datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosPrecio(String precio) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Precio` <= "+precio+";");
            while(rs.next()){
            	datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosAnyo(String anyo) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Anyo` = '"+anyo+"';");
            while(rs.next()){
            	datosVehÝculos.add(rs.getInt(1)+ ";"+rs.getString(2)+ ";"+rs.getString(3)+ ";"+rs.getString(4)+ ";"+rs.getInt(5)+
            			";"+rs.getString(6)+ ";"+rs.getInt(7)+ ";"+rs.getInt(8)+ ";"+rs.getString(9)+ ";"+rs.getString(10));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosKilometros(String kilometros) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Kilometros` = "+kilometros+";");
            while(rs.next()){
            	datosVehÝculos.add(rs.getInt(1)+ ";"+rs.getString(2)+ ";"+rs.getString(3)+ ";"+rs.getString(4)+ ";"+rs.getInt(5)+
            			";"+rs.getString(6)+ ";"+rs.getInt(7)+ ";"+rs.getInt(8)+ ";"+rs.getString(9)+ ";"+rs.getString(10));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public ArrayList<Object> buscarVehiculosCombustible(String combustible) {
        ArrayList<Object> datosVehÝculos= new ArrayList<>();
        try {
            rs = stm.executeQuery("SELECT * FROM desarrollodeinterfaces.vehÝculo WHERE `Combustible` = '"+combustible+"';");
            while(rs.next()){
            	datosVehÝculos.add(new Vehiculo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosVehÝculos;
    }
    
    public void venderVehiculo(int numSerie, String DNI_Cliente, String plazo, String DNI_Usuario) {
    	try {
    		int beneficios = 0;
    		rs = stm.executeQuery("SELECT Precio FROM vehÝculo WHERE `Num_Serial` = '"+numSerie+"'");
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
        	stm.executeUpdate("UPDATE `vehÝculo` SET `Marca` = '"+data[0]+"', `Modelo` = '"+data[1]+"', `Precio` = "+data[2]+", `Anyo` = "+data[3]+", `Kilometros` = "+data[4]+", `Combustible` = '"+data[5]+"' WHERE `vehÝculo`.`Num_Serial` = '"+num_serie+"'");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    
}

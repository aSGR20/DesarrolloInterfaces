package Proyecto;

import java.sql.*;
import java.util.*;

public abstract class DAO_Abstract {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/desarrollodeinterfaces";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    Connection cn = null;
    Statement stm = null;
    ResultSet rs = null;

    public DAO_Abstract() {
        try {
            cn= DriverManager.getConnection(URL, USUARIO, CLAVE);
            stm = cn.createStatement();
            System.out.println("Conexion realizada");
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
        }
    }
    
    static {
        try {
            Class.forName(CONTROLADOR);
            System.out.println("Controlador Cargado");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador com.mysql.jdbc.Driver");
        }
    }
    
    public abstract ArrayList<Object> recibirDatos();
    
    public abstract void subirDatos(ArrayList<Object> datos);
}

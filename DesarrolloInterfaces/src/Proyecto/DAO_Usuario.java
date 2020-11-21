package Proyecto;

import java.sql.SQLException;
import java.util.ArrayList;

import Ventas.GUI_Ventas;

public class DAO_Usuario extends DAO_Abstract {
	
	public static String username;
	public static String passwd;
	public static String nombre;

    /**
     * Devuelve true si el usuario existe y la contraseña es correcta, o false
     * si no. Las contraseñas son case-sensitive, los nombres de usuario no.
     *
     * @param usuario
     * @return boolean
     */
    public boolean comprobarUsuario(UsuarioLogin usuario) {
    	this.username = usuario.usuario;
    	this.passwd = usuario.contraseña;
        try {
            rs = stm.executeQuery("select nombre, usuario, contraseña from desarrollodeinterfaces.usuario");
            while (rs.next()) {
                if (rs.getString(2).toLowerCase().equals(usuario.usuario.toLowerCase()) && rs.getString(3).equals(usuario.contraseña)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return false;
    }
    
    public String profesion(UsuarioLogin usuario) {
        try {
            rs = stm.executeQuery("select profesión from desarrollodeinterfaces.usuario where usuario = '"+usuario.usuario+"' and contraseña = '"+usuario.contraseña+"'");
            while (rs.next()) {
            	return rs.getString(1).toLowerCase();
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
		return null;
    }
    
    /**
     * Crea un array de usuarios con los datos de la tabla usuarios de la base de datos.
     * 
     * @return array de usuarios
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosUsuarios= new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.usuario");
            /*while(rs.next()){
                datosUsuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), 
                        rs.getString(8), rs.getString(9)));
            }*/
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosUsuarios;
    }
    
    public String getName() {
    	try {
            rs = stm.executeQuery("select nombre from desarrollodeinterfaces.usuario where `usuario` = '"+username+"' and `contraseña` = '"+passwd+"';");
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    	return null;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public String getPasswd() {
    	return passwd;
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla usuarios de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Usuario datoUsuario=(Usuario)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`usuario` "
                    + "(`DNI_Usuario`, `Usuario`, `Contraseña`, `Nombre`, `Apellidos`, "
                    + "`NUSS`, `SueldoBase`, `Correo`, `Profesión`) VALUES ('"+datoUsuario.DNI+"', '"+
                    datoUsuario.usuario+"', '"+datoUsuario.contraseña+"', '"+datoUsuario.nombre+
                    "', '"+datoUsuario.apellidos+"', '"+datoUsuario.NUSS+"', "+
                    datoUsuario.sueldoBase+", '"+datoUsuario.correo+"', '"+datoUsuario.profesion+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }

}

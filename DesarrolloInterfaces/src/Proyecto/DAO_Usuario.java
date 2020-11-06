package Proyecto;

import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_Usuario extends DAO_Abstract {

    /**
     * Devuelve true si el usuario existe y la contrase�a es correcta, o false
     * si no. Las contrase�as son case-sensitive, los nombres de usuario no.
     *
     * @param usuario
     * @return boolean
     */
    public boolean comprobarUsuario(UsuarioLogin usuario) {
        try {
            rs = stm.executeQuery("select usuario, contrase�a from desarrollodeinterfaces.usuario");
            while (rs.next()) {
                if (rs.getString(1).toLowerCase().equals(usuario.usuario.toLowerCase()) && rs.getString(2).equals(usuario.contrase�a)) {
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
            rs = stm.executeQuery("select profesi�n from desarrollodeinterfaces.usuario where usuario = '"+usuario.usuario+"' and contrase�a = '"+usuario.contrase�a+"'");
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

    /**
     * Inserta los datos pasados como par�metro en la tabla usuarios de la BD.
     * 
     * @param datos 
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        try {
            for (Object dato : datos){
                Usuario datoUsuario=(Usuario)dato;
            stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`usuario` "
                    + "(`DNI_Usuario`, `Usuario`, `Contrase�a`, `Nombre`, `Apellidos`, "
                    + "`NUSS`, `SueldoBase`, `Correo`, `Profesi�n`) VALUES ('"+datoUsuario.DNI+"', '"+
                    datoUsuario.usuario+"', '"+datoUsuario.contrase�a+"', '"+datoUsuario.nombre+
                    "', '"+datoUsuario.apellidos+"', '"+datoUsuario.NUSS+"', "+
                    datoUsuario.sueldoBase+", '"+datoUsuario.correo+"', '"+datoUsuario.profesion+"');");
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }

}

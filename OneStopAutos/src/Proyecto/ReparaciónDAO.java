package Proyecto;

import java.sql.*;
import java.util.*;

public class Reparaci�nDAO extends DAO_Abstract {

    /**
     * Crea un array de reparaciones con los datos de la tabla reparaci�n de la
     * base de datos.
     *
     * @return array de reparaciones
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosReparaciones = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.reparaci�n");
            while (rs.next()) {
                datosReparaciones.add(new Reparaci�n(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosReparaciones;
    }

    /**
     * @deprecated usar mejor la funci�n buscarDatos
     * 
     * Sobrecarga de recibirDatos que devuelve solo las reparaciones asignadas
     * al mec�nico con el DNI pasado como par�metro
     *
     * @param DNIMec�nico
     * @return array de reparaciones
     */
    public ArrayList<Object> recibirDatos(String DNIMec�nico) {
        ArrayList<Object> datosReparaciones = recibirDatos();
        ArrayList<Object> nuevosDatosReparaciones = new ArrayList<>();
        for (Object dato : datosReparaciones) {
            Reparaci�n rep = (Reparaci�n) dato;
            if (rep.DNIUsuario.equals(DNIMec�nico)) {
                nuevosDatosReparaciones.add(rep);
            }
        }
        return nuevosDatosReparaciones;
    }

    /**
     * @deprecated usar mejor la funci�n buscarDatos
     * 
     * Otra sobrecarga de recibirDatos, esta vez con un objeto Mec�nico como
     * par�metro
     *
     * @param mec�nico
     * @return array de reparaciones
     */
    public ArrayList<Object> recibirDatos(Mec�nico mec�nico) {
        return recibirDatos(mec�nico.DNI);
    }

    /**
     * Inserta los datos pasados como par�metro en la tabla reparaciones de la
     * BD. Adem�s, antes de insertarlos comprueba que las claves for�neas tienen
     * valores correctos.
     *
     * @param datos
     */
    @Override
    public void subirDatos(ArrayList<Object> datos) {
        DAO_Usuario usudao = new DAO_Usuario();
        DAO_Cliente cliendao = new DAO_Cliente();
        ArrayList<Object> usuarios = usudao.recibirDatos(), clientes = cliendao.recibirDatos();
        boolean coincideCliente = false, coincideUsuario = false;

        try {
            for (Object dato : datos) {
                Reparaci�n datoReparaci�n = (Reparaci�n) dato;

                for (Object usu : usuarios) {
                    Usuario usuario = (Usuario) usu;
                    if (usuario.DNI.equals(datoReparaci�n.DNIUsuario) && "Mec�nico".equals(usuario.profesion)) {
                        coincideUsuario = true;
                    }
                }
                for (Object clien : clientes) {
                    Cliente cliente = (Cliente) clien;
                    if (cliente.DNI.equals(datoReparaci�n.DNICliente)) {
                        coincideCliente = true;
                    }
                }
                if (coincideUsuario && coincideCliente) {
                    stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`reparaci�n` "
                            + "(`NumIncidencia`, `DNI_Cliente`, `DNI_Usuario`, `Problema`, `Coste`, "
                            + "`Tiempo_Estimado`, `Piezas`) VALUES (" + datoReparaci�n.numIncidencia + ", '"
                            + datoReparaci�n.DNICliente + "', '" + datoReparaci�n.DNIUsuario + "', '" + datoReparaci�n.problema
                            + "', " + datoReparaci�n.coste + ", '" + datoReparaci�n.tiempoEstimado + "', '"
                            + datoReparaci�n.piezas + "');");
                }
                coincideUsuario = false;
                coincideCliente = false;
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    /**
     * Elimina una reparaci�n de la BD
     *
     * @param reparaci�n
     */
    public void eliminarDato(Reparaci�n reparaci�n) {
        try {
            stm.executeUpdate("delete from `desarrollodeinterfaces`.`reparaci�n` "
                    + "where NumIncidencia=" + reparaci�n.numIncidencia + ";");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
}
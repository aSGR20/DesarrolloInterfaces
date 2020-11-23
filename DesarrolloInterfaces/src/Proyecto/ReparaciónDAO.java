package Proyecto;

import java.sql.*;
import java.util.*;

public class ReparaciónDAO extends DAO_Abstract {

    /**
     * Crea un array de reparaciones con los datos de la tabla reparación de la
     * base de datos.
     *
     * @return array de reparaciones
     */
    @Override
    public ArrayList<Object> recibirDatos() {
        ArrayList<Object> datosReparaciones = new ArrayList<>();
        try {
            rs = stm.executeQuery("select * from desarrollodeinterfaces.reparación");
            while (rs.next()) {
                datosReparaciones.add(new Reparación(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
        return datosReparaciones;
    }

    /**
     * @deprecated usar mejor la función buscarDatos
     * 
     * Sobrecarga de recibirDatos que devuelve solo las reparaciones asignadas
     * al mecánico con el DNI pasado como parámetro
     *
     * @param DNIMecánico
     * @return array de reparaciones
     */
    public ArrayList<Object> recibirDatos(String DNIMecánico) {
        ArrayList<Object> datosReparaciones = recibirDatos();
        ArrayList<Object> nuevosDatosReparaciones = new ArrayList<>();
        for (Object dato : datosReparaciones) {
            Reparación rep = (Reparación) dato;
            if (rep.DNIUsuario.equals(DNIMecánico)) {
                nuevosDatosReparaciones.add(rep);
            }
        }
        return nuevosDatosReparaciones;
    }

    /**
     * @deprecated usar mejor la función buscarDatos
     * 
     * Otra sobrecarga de recibirDatos, esta vez con un objeto Mecánico como
     * parámetro
     *
     * @param mecánico
     * @return array de reparaciones
     */
    public ArrayList<Object> recibirDatos(Mecánico mecánico) {
        return recibirDatos(mecánico.DNI);
    }

    /**
     * Inserta los datos pasados como parámetro en la tabla reparaciones de la
     * BD. Además, antes de insertarlos comprueba que las claves foráneas tienen
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
                Reparación datoReparación = (Reparación) dato;

                for (Object usu : usuarios) {
                    Usuario usuario = (Usuario) usu;
                    if (usuario.DNI.equals(datoReparación.DNIUsuario) && "Mecánico".equals(usuario.profesion)) {
                        coincideUsuario = true;
                    }
                }
                for (Object clien : clientes) {
                    Cliente cliente = (Cliente) clien;
                    if (cliente.DNI.equals(datoReparación.DNICliente)) {
                        coincideCliente = true;
                    }
                }
                if (coincideUsuario && coincideCliente) {
                    stm.executeUpdate("INSERT INTO `desarrollodeinterfaces`.`reparación` "
                            + "(`NumIncidencia`, `DNI_Cliente`, `DNI_Usuario`, `Problema`, `Coste`, "
                            + "`Tiempo_Estimado`, `Piezas`) VALUES (" + datoReparación.numIncidencia + ", '"
                            + datoReparación.DNICliente + "', '" + datoReparación.DNIUsuario + "', '" + datoReparación.problema
                            + "', " + datoReparación.coste + ", '" + datoReparación.tiempoEstimado + "', '"
                            + datoReparación.piezas + "');");
                }
                coincideUsuario = false;
                coincideCliente = false;
            }
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
    /**
     * Elimina una reparación de la BD
     *
     * @param reparación
     */
    public void eliminarDato(Reparación reparación) {
        try {
            stm.executeUpdate("delete from `desarrollodeinterfaces`.`reparación` "
                    + "where NumIncidencia=" + reparación.numIncidencia + ";");
        } catch (SQLException ex) {
            System.out.println("Oh no!");
        }
    }
}
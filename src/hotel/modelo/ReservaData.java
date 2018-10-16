/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ReservaData {
   
    private Connection connection = null;

    public ReservaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion");
        }
    }
    
    
    public void guardarReserva(Reserva reserva){
       
        try {
            
            String sql = "INSERT INTO reserva (cantidadDePersonas, fechaEntrada, fechaSalida, importeTotal, huesped, habitacion, estado) VALUES ( ? , ? , ? , ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, reserva.getCantidadDePersonas());
            statement.setDate (2, reserva.getFechaEntrada());
            statement.setDate (3, reserva.getFechaSalida());
            statement.setDouble (4, reserva.getImporteTotal());
            statement.setObject (5, reserva.getHuesped());
            statement.setInt (6, reserva.getHabitacion().getNHabitacion());
            statement.setBoolean (7, reserva.getEstado());
            
            
            statement.executeUpdate();
            
                        ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                reserva.setNroReserva(rs.getInt( /*      ????     */  ));
            } else {
                System.out.println("No se pudo obtener el id luego de ingresar una reserva");
            }
            statement.close();
          
        } catch (SQLException ex) {
            System.out.println("Error al insertar una reserva: " + ex.getMessage());
        }
    }
    
    public List<Reserva> obtenerReservas(){
        List<Reserva> reservas = new ArrayList<Reserva>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setCantidadDePersonas (resultSet.getInt("CantidadDePersonas"));
                reserva.setFechaEntrada (resultSet.getDate("fechaEntrada"));
                reserva.setFechaSalida (resultSet.getDate("fechaSalida"));
                reserva.setImporteTotal (resultSet.getDouble("importeTotal"));
                reserva.setHuesped (resultSet.getHuesped ("huesped"));
                reserva.setHabitacion (resultSet.getHabitacion ("habitacion"));
                reserva.setEstado (resultSet.getBoolean ("estado"));
                

                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al listar reservas: " + ex.getMessage());
        }
        
        
        return reservas;
    }
    
    public void eliminarReserva (int nroReserva){
    try {
            
            String sql = "DELETE FROM reserva WHERE nroReserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt( /* ??? */ , nroReserva);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una reserva: " + ex.getMessage());
        }
        
    
    }
    
    public void modificarReserva (Reserva reserva){
    
        try {
            
            String sql = "UPDATE reserva SET cantidadDePersonas = ?, fechaEntrada = ? , fechaSalida =? , importeTotal =? , huesped =? , habitacion =? , estado =? WHERE nroReserva = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, reserva.getCantidadDePersonas());
            statement.setDate(2, reserva.getFechaEntrada());
            statement.setDate(3, reserva.getFechaSalida());
            statement.setDouble (4, reserva.getImporteTotal());
            statement.setObject(5, reserva.getHuesped());
            statement.setInt (6, reserva.getHabitacion().getNHabitacion());
            statement.setBoolean (7, reserva.getEstado());
            
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al ingresar una reserva: " + ex.getMessage());
        }
    
    }
    
    public Reserva buscarReserva (int nroReserva){
    Reserva reserva =null;
    try {
            
            String sql = "SELECT * FROM reserva WHERE nroReserva =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt( /* ??? */ , nroReserva);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                reserva.setCantidadDePersonas(resultSet.getInt("CantidadDePersonas"));
                reserva.setFechaEntrada(resultSet.getDate("fechaEntrada"));
                reserva.setFechaSalida(resultSet.getDate("fechaSalida"));
                reserva.setImporteTotal(resultSet.getDouble("importeTotal"));
                reserva.setHuesped (resultSet.getHuesped ("huesped"));
                reserva.setHabitacion (resultSet.getHabitacion ("habitacion"));
                reserva.setEstado (resultSet.getBoolean ("estado"));
   
            }      
            statement.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Error al ingresar una reserva: " + ex.getMessage());
        }
        
        return reserva;
    }
    
}


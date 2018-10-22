package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ReservaData {
    private Connection connection = null;

    public ReservaData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarReserva (Reserva reserva) {
        try {
            String sql = "INSERT INTO reserva (nroReserva, cantidadDePersonas, fechaEntrada, fechaSalida, importeTotal, huesped, habitacion, estado) VALUES (? , ? , ? , ? , ? , ? , ? , ?);";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, reserva.getNroReserva());
            statement.setInt (2, reserva.getCantidadDePersonas());
            statement.setDate(3, reserva.getFechaEntrada());
            statement.setDate(4, reserva.getFechaSalida());
            statement.setDouble (5, reserva.getImporteTotal());
            statement.setObject(6, reserva.getHuesped());
            statement.setObject (7, reserva.getHabitacion());
            statement.setBoolean (8, reserva.getEstado());
            
          
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al ingresar reserva: " + ex.getMessage());
        }
    }
       
            

    
public ArrayList <Reserva> obtenerReserva(){
       ArrayList <Reserva> reservas = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Reserva reserva;
            while(resultSet.next()){
                reserva = new Reserva();
              
                reserva.setNroReserva (resultSet.getInt ("nroReserva"));
                reserva.setCantidadDePersonas (resultSet.getInt ("cantidadDePersonas"));
                reserva.setFechaEntrada (resultSet.getDate ("fechaEntrada"));
                reserva.setFechaSalida (resultSet.getDate ("fechaSalida"));
                reserva.setImporteTotal (resultSet.getDouble ("importeTotal"));
                reserva.setHuesped((Huesped) resultSet.getObject("huesped"));
                reserva.setHabitacion ((Habitacion) resultSet.getObject ("habitacion"));
                reserva.setEstado (resultSet.getBoolean ("estado"));

                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de reservas: " + ex.getMessage());
        }
         
        return reservas;
    }

}


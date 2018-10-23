package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaData {
    private Connection connection = null;
    private Conexion conexion;

    public ReservaData(Conexion conexion) {
        this.conexion = conexion;
        connection = conexion.getConexion();
    }
    
    public void guardarReserva (Reserva reserva) {
        try {
            String sql = "INSERT INTO reserva (cantidad_de_personas, fecha_entrada, fecha_salida, importe_total, dni, nro_habitacion, estado) " + 
                         "VALUES ( ? , ? , ? , ? , ? , ? , ?);";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, reserva.getCantidadDePersonas());
            statement.setDate(2, reserva.getFechaEntrada());
            statement.setDate(3, reserva.getFechaSalida());
            statement.setDouble (4, reserva.getImporteTotal());
            statement.setObject(5, reserva.getHuesped().getDni());
            statement.setObject (7, reserva.getHabitacion().getNHabitacion());
            statement.setBoolean (8, reserva.getEstado());
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reserva.setNroReserva(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
          
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al ingresar reserva: " + ex.getMessage());
        }
    }
              
    public ArrayList<Reserva> obtenerReserva(){
        ArrayList<Reserva> reservas = new ArrayList<>();            
        Reserva reserva;
        Huesped huesped;
        Habitacion habitacion;
        
        try {
            String sql = "SELECT * FROM reserva;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                reserva = new Reserva();
                
                huesped = buscarHuesped(resultSet.getInt("dni"));
                habitacion = buscarHabitacion(resultSet.getInt("nro_habitacion"));
                
                reserva.setNroReserva(resultSet.getInt ("nro_reserva"));
                reserva.setCantidadDePersonas(resultSet.getInt ("cantidad_de_personas"));
                reserva.setFechaEntrada(resultSet.getDate ("fecha_entrada"));
                reserva.setFechaSalida(resultSet.getDate ("fecha_salida"));
                reserva.setImporteTotal(resultSet.getDouble ("importe_total"));
                reserva.setEstado(resultSet.getBoolean ("estado"));
                reserva.setHuesped(huesped);
                reserva.setHabitacion(habitacion);
                        
                reservas.add(reserva);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de reservas: " + ex.getMessage());
        }
         
        return reservas;
    }
    
    public ArrayList<Reserva> buscarReservasPorHuesped(int dni) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        Reserva reserva;
        Huesped huesped;
        Habitacion habitacion;
        PreparedStatement statement;
        
        String sql = "SELECT * FROM reserva WHERE dni = ?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dni);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                reserva = new Reserva();

                huesped = buscarHuesped(resultSet.getInt("dni"));
                habitacion = buscarHabitacion(resultSet.getInt("nro_habitacion"));
                
                reserva.setNroReserva(resultSet.getInt ("nro_reserva"));
                reserva.setCantidadDePersonas(resultSet.getInt ("cantidad_de_personas"));
                reserva.setFechaEntrada(resultSet.getDate ("fecha_entrada"));
                reserva.setFechaSalida(resultSet.getDate ("fecha_salida"));
                reserva.setImporteTotal(resultSet.getDouble ("importe_total"));
                reserva.setEstado(resultSet.getBoolean ("estado"));
                reserva.setHuesped(huesped);
                reserva.setHabitacion(habitacion);
                
                reservas.add(reserva);
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reservas;
    }
    
    public ArrayList<Reserva> buscarReservasPorHuesped(String nombre) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Huesped> huespedes;
        Reserva reserva;
        Habitacion habitacion;
        PreparedStatement statement;
        
        String sql = "SELECT * FROM reserva WHERE dni = ?;";
        
        huespedes = buscarHuesped(nombre);
        
        for(Huesped huesped : huespedes) {
            try {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, huesped.getDni());

                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()) {
                    reserva = new Reserva();

                    huesped = buscarHuesped(resultSet.getInt("dni"));
                    habitacion = buscarHabitacion(resultSet.getInt("nro_habitacion"));

                    reserva.setNroReserva(resultSet.getInt ("nro_reserva"));
                    reserva.setCantidadDePersonas(resultSet.getInt ("cantidad_de_personas"));
                    reserva.setFechaEntrada(resultSet.getDate ("fecha_entrada"));
                    reserva.setFechaSalida(resultSet.getDate ("fecha_salida"));
                    reserva.setImporteTotal(resultSet.getDouble ("importe_total"));
                    reserva.setEstado(resultSet.getBoolean ("estado"));
                    reserva.setHuesped(huesped);
                    reserva.setHabitacion(habitacion);

                    reservas.add(reserva);
                }
                
                statement.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
        return reservas;
    }
    
    public ArrayList<Habitacion> buscarHabitacionesLibres(int cantidadPersonas, int idTipoHabitacion) {
        ArrayList<Habitacion> habLibres = new ArrayList<>();
        
        String sql = "SELECT * FROM `tipo_de_habitacion` " +
                     "WHERE cantidad_maxima_personas";
    }
    
    private Huesped buscarHuesped(int dni){
        HuespedData h = new HuespedData(conexion);
        
        return h.buscarHuesped(dni);    
    }
    
    private ArrayList<Huesped> buscarHuesped(String nombre) {
        HuespedData h = new HuespedData(conexion);
        
        return h.buscarHuesped(nombre);
    }
    
    private Habitacion buscarHabitacion(int nro){
        HabitacionData h = new HabitacionData(conexion);
        
        return h.buscarHabitacion(nro);    
    }
}
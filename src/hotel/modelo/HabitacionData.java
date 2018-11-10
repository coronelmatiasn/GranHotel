
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;


public class HabitacionData {
    private Connection connection = null;
    private Conexion conexion;

    public HabitacionData(Conexion conexion) {    
        this.conexion = conexion;
        connection = conexion.getConexion();
    }
    
    public void guardarHabitacion(Habitacion habitacion) {
        try {
            String sql = "INSERT INTO habitacion (nro_Habitacion, piso, estado, id_tipo_Habitacion) " + 
                         "VALUES ( ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, habitacion.getNHabitacion());
            statement.setInt(2, habitacion.getPiso());
            statement.setBoolean(3, habitacion.getEstado());
            statement.setInt(4, habitacion.getTipoHabitacion().getId());            
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar habitacion: " + ex.getMessage());
        }
    }
       
            

    
    public ArrayList<Habitacion> obtenerHabitaciones(){
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setNHabitacion(resultSet.getInt("nro_Habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean ("estado"));
                TipoHabitacion th = buscarTipoHabitacion(resultSet.getInt("id_tipo_habitacion"));
                habitacion.setTipoHabitacion(th);
                
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de habitaciones: " + ex.getMessage());
        }
         
        return habitaciones;
    }


    public Habitacion buscarHabitacion(int id){
        Habitacion habitacion=null;
         
        try {           
            String sql = "SELECT * FROM habitacion WHERE nro_habitacion = ? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);           
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setNHabitacion(resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoHabitacion th = buscarTipoHabitacion(resultSet.getInt("id_tipo_habitacion"));
                habitacion.setTipoHabitacion(th);                  
            }      
            
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar el Huesped" + ex.getMessage());
        }
         
        return habitacion;
    }
 
 
    public ArrayList <Habitacion> obtenerHabitacionPorTipo(boolean estado, int id_tipo_habitacion){
        ArrayList <Habitacion> habitaciones = new ArrayList<>();
            
        try {
            String sql = "SELECT nro_habitacion, piso, estado, categoria_habitacion FROM `habitacion` " + 
                         "INNER JOIN `tipo_de_habitacion` " + 
                         "ON habitacion.id_tipo_habitacion = tipo_de_habitacion.id_tipo_habitacion " + 
                         "WHERE habitacion.id_tipo_habitacion = ? AND estado = ?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_tipo_habitacion);
            statement.setBoolean(2, estado);
            
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setNHabitacion (resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado (resultSet.getBoolean("estado"));
                TipoHabitacion th = buscarTipoHabitacion(id_tipo_habitacion);
                habitacion.setTipoHabitacion(th);
                
                habitaciones.add(habitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de habitaciones: " + ex.getMessage());
        }
         
        return habitaciones;
    }

    public ArrayList <Habitacion> obtenerHabitacionPorTipo(int id_tipo_habitacion){
        ArrayList <Habitacion> habitaciones = new ArrayList<>();
            
        try {
            String sql = "SELECT nro_habitacion, piso,estado, categoria_habitacion " + 
                         "FROM `habitacion`INNER JOIN `tipo_de_habitacion` " + 
                         "ON habitacion.id_tipo_habitacion = tipo_de_habitacion.id_tipo_habitacion " + 
                         "WHERE habitacion.id_tipo_habitacion = ?;";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_tipo_habitacion);
            
            ResultSet resultSet = statement.executeQuery();
            Habitacion habitacion;
            while(resultSet.next()){
                habitacion = new Habitacion();
                habitacion.setNHabitacion(resultSet.getInt("nro_habitacion"));
                habitacion.setPiso(resultSet.getInt("piso"));
                habitacion.setEstado(resultSet.getBoolean("estado"));
                TipoHabitacion th = buscarTipoHabitacion(id_tipo_habitacion);
                habitacion.setTipoHabitacion(th);                

                habitaciones.add(habitacion);
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de habitaciones: " + ex.getMessage());
        }
         
        return habitaciones;
    }
 
    public TipoHabitacion buscarTipoHabitacion(int id){   
        TipoHabitacionData tc = new  TipoHabitacionData(conexion);
        
        return tc.buscartipohabitacion(id);     
    }
 
    public void cuentaHabitacion(boolean estado, int id , JTextField texto){
        int cuenta = 0;
        String cuentas;
        
        try {
            String sql = "SELECT COUNT(*) AS total FROM `habitacion` " + 
                         "WHERE id_tipo_habitacion = ? AND estado = ?;";
            
            PreparedStatement statement;
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, id);
            statement.setBoolean(2, estado);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){             
                cuenta = resultSet.getInt("total");       
            }
            
            cuentas = Integer.toString(cuenta);
            texto.setText(cuentas);
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
           
    public void CuentaHabitacionsinestado(int id, JTextField texto){
     int cuenta = 0;
     String cuentas;
        try {
            String sql = "SELECT COUNT(*) AS total FROM `habitacion` WHERE id_tipo_habitacion = ?;";
            
            PreparedStatement statement;
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){                
              cuenta = resultSet.getInt("total");                
            }
            
            cuentas = Integer.toString(cuenta);
            texto.setText(cuentas);
            
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
     
    public void setEstadoHabitacion(int nHabitacion, boolean estado) {
        PreparedStatement statement;
        
        String sql = "UPDATE habitacion SET estado = ? WHERE nro_habitacion = ?;";
        
        try {
            statement = connection.prepareStatement(sql);
            
            statement.setBoolean(1, estado);
            statement.setInt(2, nHabitacion);
            
            statement.executeUpdate();
            
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarHabitacion(int nro_habitacion){
        try {
            String sql = "DELETE FROM habitacion WHERE nro_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, nro_habitacion);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
           System.out.println("Error al borrar Habitacion: " + ex.getMessage());
        }
    }
} 


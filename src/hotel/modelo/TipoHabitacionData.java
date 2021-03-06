
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TipoHabitacionData {
    private Connection connection = null;
    private Conexion conexion;

    public TipoHabitacionData(Conexion conexion) {
        this.conexion = conexion;
        connection = conexion.getConexion();
    }
    
    public void guardarTipoHabitacion (TipoHabitacion tipoHabitacion) {
        
        try {
            String sql = "INSERT INTO tipo_de_Habitacion (categoria_habitacion, cantidad_maxima_personas, precio_por_noche, id_tipo_cama) VALUES ( ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString (1, tipoHabitacion.getCategoria());
            statement.setInt (2, tipoHabitacion.getCantidadMaxPersonas());
            statement.setDouble (3, tipoHabitacion.getPrecioXNoche());
            statement.setInt(4, tipoHabitacion.getTipoCama().getId_tipo_cama());
           
            statement.executeUpdate();
            statement.close();
           
        }  catch (SQLException ex) {
            System.out.println("Error al insertar tipo de habitacion: " + ex.getMessage());
        }
    }
    
    public void modificarTipoHabitacion(String categoria, TipoHabitacion tHabitacion) {
        try {
            String sql = "UPDATE `tipo_de_habitacion` SET `cantidad_maxima_personas` = ?, `precio_por_noche` = ?, `id_tipo_cama` = ? WHERE categoria_habitacion = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tHabitacion.getCantidadMaxPersonas());
            statement.setDouble(2, tHabitacion.getPrecioXNoche());
            statement.setInt(3, tHabitacion.getTipoCama().getId_tipo_cama());
            statement.setString(4, tHabitacion.getCategoria());
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar tipo de habitacion: " + ex.getMessage());
        }
    }
    
    public void borrarTipoHabitacion(String categoria){
        try {
            String sql = "DELETE FROM tipo_de_habitacion WHERE categoria_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoria);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
           System.out.println("Error al borrar Tipo de Habitacion: " + ex.getMessage());
        }
    }
 
    public ArrayList <TipoHabitacion> obtenerTipoHabitacion(){
        ArrayList <TipoHabitacion> tipoHabitaciones = new ArrayList<>();     

        try {
            String sql = "SELECT * FROM tipo_de_habitacion;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoHabitacion tipoHabitacion;
            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama tc = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipoHabitacion.setTipoCama(tc);
                tipoHabitaciones.add(tipoHabitacion);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista tipoHabitaciones: " + ex.getMessage());
        }
         
        return tipoHabitaciones;
    }

    public TipoHabitacion buscartipohabitacion(int id){
        TipoHabitacion tipohabitacion = null;

        try {  
            String sql = "SELECT * FROM tipo_de_habitacion WHERE id_tipo_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);


            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                tipohabitacion = new TipoHabitacion();
                tipohabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipohabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipohabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipohabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama c = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipohabitacion.setTipoCama(c);
            }      

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }

        return  tipohabitacion;
    }
    
    public TipoHabitacion buscartipohabitacion(String categoria){
        TipoHabitacion tipohabitacion = null;

        try {  
            String sql = "SELECT * FROM tipo_de_habitacion WHERE categoria_habitacion = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria);


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                tipohabitacion = new TipoHabitacion();
                tipohabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipohabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipohabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipohabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama c = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipohabitacion.setTipoCama(c);
            }      

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar tipo de habitacion: " + ex.getMessage());
        }

        return  tipohabitacion;
    }
    
    public ArrayList<TipoHabitacion> buscartipohabitacion(String categoria, int cantPersonas){
        TipoHabitacion tipoHabitacion = null;
        ArrayList<TipoHabitacion> tiposHabitacion = new ArrayList<>();

        try {  
            String sql = "SELECT * FROM tipo_de_habitacion " + 
                         "WHERE categoria_habitacion = ? " +
                         "AND cantidad_maxima_personas >= ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria);
            statement.setInt(2, cantPersonas);


            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setId(resultSet.getInt("id_tipo_habitacion"));
                tipoHabitacion.setCategoria(resultSet.getString("categoria_habitacion"));
                tipoHabitacion.setCantidadMaxPersonas(resultSet.getInt("cantidad_maxima_personas"));
                tipoHabitacion.setPrecioXNoche(resultSet.getDouble("precio_por_noche"));
                TipoDeCama c = buscarTipoCama(resultSet.getInt("id_tipo_cama"));
                tipoHabitacion.setTipoCama(c);
                
                tiposHabitacion.add(tipoHabitacion);
            }      

            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }

        return  tiposHabitacion;
    }
    
    public ArrayList<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<>();     

        try {
            String sql = "SELECT DISTINCT categoria_habitacion FROM `tipo_de_habitacion`;";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                categorias.add(resultSet.getString("categoria_habitacion"));
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de categorías: " + ex.getMessage());
        }
         
        return categorias;
    }

    public TipoDeCama buscarTipoCama(int id){
        TipoDeCamaData tc= new TipoDeCamaData(conexion);
        
        return tc.buscarTipoCama(id);    
    }
    
    public boolean existeTipoHabitacion(String categoria) {
        int total = 0;

        try {
            
            String sql = "SELECT SUM(categoria_habitacion = ?) AS total FROM tipo_de_habitacion";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoria);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                total = resultSet.getInt("total");
            }
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar tipo de habitacion: " + ex.getMessage());
        }
        
        return total != 0;
    }
}


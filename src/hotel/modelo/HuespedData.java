
package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class HuespedData {
    private Connection connection = null;

    public HuespedData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarHuesped (Huesped huesped) {
        try {
            String sql = "INSERT INTO huesped (dni, nombre_apellido, domicilio, celular, correo) VALUES ( ? , ? , ? , ? , ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt (1, huesped.getDni());
            statement.setString (2, huesped.getNombre());
            statement.setString (3, huesped.getDomicilio());
            statement.setString (4, huesped.getCelular());
            statement.setString (5, huesped.getCorreo());
            
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar un huesped: " + ex.getMessage());
        }
    }
       
            

    
public ArrayList <Huesped> obtenerHuesped(){
       ArrayList <Huesped> huespedes = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM huesped;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Huesped huesped;
            while(resultSet.next()){
                huesped = new Huesped();
                huesped.setDni(resultSet.getInt("dni"));
                huesped.setNombre(resultSet.getString("nombre_apellido"));
                huesped.setDomicilio(resultSet.getString("domicilio"));
                huesped.setCelular(resultSet.getString("celular"));
                huesped.setCorreo(resultSet.getString("correo"));

                huespedes.add(huesped);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de huesped: " + ex.getMessage());
        }
         
        return huespedes;
    }

public void borrarHuesped(int dni){
    try {
        
          String sql = "DELETE FROM huesped WHERE dni =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
           
            
            statement.executeUpdate();
            
            
             statement.close();
    
    } catch (SQLException ex) {
        
       System.out.println("Error al borrar Huesped: " + ex.getMessage());
    }
 
    
}


public void actualizarHuesped(Huesped huesped){
    
     try {
            
            String sql = "UPDATE huesped SET nombre_apellido = ?, domicilio = ? ,celular =?, correo=? WHERE dni = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,huesped.getNombre());
            statement.setString(2, huesped.getDomicilio());
            statement.setString(3, huesped.getCelular());
            statement.setInt(4, huesped.getDni());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Huesped " + ex.getMessage());
        }
    
}


     public Huesped buscarHuesped(int dni){
         Huesped huesped=null;
         
         try {
            
            String sql = "SELECT * FROM huesped WHERE dni =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, dni);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                huesped = new Huesped();
                 huesped.setDni(resultSet.getInt("dni"));
                 huesped.setNombre(resultSet.getString("nombre_apellido"));
                 huesped.setDomicilio(resultSet.getString("domicilio"));
                 huesped.setCelular(resultSet.getString("celular"));
                 huesped.setCorreo(resultSet.getString("correo"));
                 
                 

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar el Huesped" + ex.getMessage());
        }
         
          return huesped;
     }

}

package hotel.modelo;

import hotel.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class TipoDeCamaData {
    private Connection connection = null;

    public TipoDeCamaData(Conexion conexion) {
        connection = conexion.getConexion();
    }
    
    public void guardarTipoDeCama (String categoria) {
        try {
            String sql = "INSERT INTO tipo_de_cama (categoria_cama) VALUES ( ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString (1, categoria);
          
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar una cama: " + ex.getMessage());
        }
    }
    
     public void modificarTipoDeCama(int id, String categoria) {
        try {
            String sql = "UPDATE `tipo_de_cama` SET `categoria_cama` = ? WHERE id_tipo_cama = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoria);
            statement.setInt(2, id);
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar tipo de cama: " + ex.getMessage());
        }
    }
    
    public void borrarTipoDeCama(int id){
        try {
            String sql = "DELETE FROM tipo_de_cama WHERE id_tipo_cama = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException ex) {
           System.out.println("Error al borrar Tipo de cama: " + ex.getMessage());
        }
    }
    
    public ArrayList<TipoDeCama> obtenerTipoDeCama(){
        ArrayList <TipoDeCama> tiposDeCamas = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM tipo_de_cama;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeCama tipodecama;
            while(resultSet.next()){
                tipodecama = new TipoDeCama();
                tipodecama.setId_tipo_cama(resultSet.getInt("id_tipo_cama"));
                tipodecama.setCategoria(resultSet.getString("categoria_cama"));
            
                tiposDeCamas.add(tipodecama);
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de camas: " + ex.getMessage());
        }
         
        return tiposDeCamas;
    }

    public ArrayList<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<>();     

        try {
            String sql = "SELECT categoria_cama FROM `tipo_de_cama`;";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                categorias.add(resultSet.getString("categoria_cama"));
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de categorías: " + ex.getMessage());
        }
         
        return categorias;
    }

    public TipoDeCama buscarTipoCama(int id){
        TipoDeCama tipodecama = null;
        try {
            String sql = "SELECT * FROM tipo_de_cama WHERE id_tipo_cama =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);

            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                tipodecama = new TipoDeCama();
                tipodecama.setId_tipo_cama(resultSet.getInt("id_tipo_cama"));
                tipodecama.setCategoria(resultSet.getString("categoria_cama"));
            }      
            
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al ingresar tipo de cama : " + ex.getMessage());
        }

        return tipodecama;
    }
    
    public TipoDeCama buscarTipoCama(String categoria){
        TipoDeCama tipodecama = null;
        
        try {
            String sql = "SELECT * FROM tipo_de_cama WHERE categoria_cama = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, categoria);

            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                tipodecama = new TipoDeCama();
                tipodecama.setId_tipo_cama(resultSet.getInt("id_tipo_cama"));
                tipodecama.setCategoria(resultSet.getString("categoria_cama"));
            }      
            
            statement.close();

        } catch (SQLException ex) {
            System.out.println("Error al ingresar tipo de cama : " + ex.getMessage());
        }

        return tipodecama;
    }
    
    public boolean existeTipoDeCama(String categoria) {
        int total = 0;

        try {
            
            String sql = "SELECT SUM(categoria_cama = ?) AS total FROM tipo_de_cama";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoria);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                total = resultSet.getInt("total");
            }
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar tipo de cama: " + ex.getMessage());
        }
        
        return total != 0;
    }
}
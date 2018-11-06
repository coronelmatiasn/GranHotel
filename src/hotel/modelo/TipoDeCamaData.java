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
    
    public void guardarTipoDeCama (TipoDeCama tipoDeCama) {
        try {
            String sql = "INSERT INTO tipoDeCama (categoria) VALUES ( ? );";
            
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString (1, tipoDeCama.getCategoria());
          
            statement.executeUpdate();
            statement.close();
            
        }  catch (SQLException ex) {
            System.out.println("Error al insertar una cama: " + ex.getMessage());
        }
    }      
    
    public List <TipoDeCama> obtenerTipoDeCama(){
        ArrayList <TipoDeCama> tiposDeCamas = new ArrayList<>();
            

        try {
            String sql = "SELECT * FROM tipoDeCama;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            TipoDeCama tipodecama;
            while(resultSet.next()){
                tipodecama = new TipoDeCama();
                tipodecama.setId_tipo_cama(resultSet.getInt("id"));
                tipodecama.setCategoria(resultSet.getString("categoria"));
            
                tiposDeCamas.add(tipodecama);
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener lista de camas: " + ex.getMessage());
        }
         
        return tiposDeCamas;
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
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return tipodecama;
    }


public void cargarComboxConTipodeCama(JComboBox comboxTipo){
        String sql= "SELECT * FROM tipo_de_cama;";

        try {
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();

           while(resultSet.next()){
                comboxTipo.addItem(resultSet.getString("categoria_cama"));
           }
           statement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }



}

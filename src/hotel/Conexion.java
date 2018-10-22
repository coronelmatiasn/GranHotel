package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
  
    private String url;
    private String usuario;
    private String password;
    
    private Connection conexion;
    
    public Conexion(String url, String usuario, String password) {
        
        this.url = url;
        this.usuario = usuario;
        this.password = password;
        
        try {
            //cargar las clases de mariadb que implementan JDBC
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConexion() {
        if(conexion == null){
            try {
                //configuración de la conexion con la base de datos
                conexion = DriverManager
                           .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                                          + "&user=" + usuario + "&password=" + password);
                
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;       
    }
}

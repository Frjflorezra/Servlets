
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDatos {
    
    Connection conexion;
    Statement manipular_db;
    
    public BaseDatos(){
        
        String user_db = "root";
        String password_db = "";
        String url = "jdbc:mysql://localhost:3306/actividad_bd";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en cargar la libreria "+ex.getMessage());
        }
        
        try {
            
            conexion = DriverManager.getConnection(url, user_db, password_db);
            manipular_db = conexion.createStatement();
            System.out.println("Conexion exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en la conexion: "+ ex.getMessage());
        }
    }
    
    public boolean insertarPersona(String cedula, String nombres, String apellidos, String telefono, String email){
        try {
                int proceso = manipular_db.executeUpdate("INSERT INTO personas(cedula, nombres, apellidos, telefono, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+email+"')");
            
                if (proceso == 1){
                    System.out.println("Se inserto con exito");
                    return true;
                }else {
                    System.out.println("Error al insertar");
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Error al insertar: "+ ex.getMessage());
                return false;
            }
    }
    public Connection getConexion(){
        return conexion;
    }
    public boolean autenticacion(String email, String cedula){
            ResultSet rs = null;  
        try {
            String consulta;
                consulta = "SELECT * FROM personas WHERE email = ? and cedula = ? ";
            PreparedStatement pst = conexion.prepareStatement(consulta);
            pst.setString(1, email);
            pst.setString(2, cedula);
            rs = pst.executeQuery();
            if (rs.absolute(1)){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }finally{
            try {
                if(getConexion() != null) getConexion().close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        return false;
    }
    
}

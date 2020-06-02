package universidad;
import java.sql.*;

public class Conexion {
    private static String url;
    private static String usuario;
    private static String clave;

    private static Connection conexion;
    
    public Conexion(){
        this.url = "jdbc:mariadb://localhost:3306/universidad";
        this.usuario = "root";
        this.clave = "";
    }
    
    public Conexion(String url, String usuario, String password){
        this.url = url;
        this.usuario = usuario;
        this.clave = password;
    }
    
    public static Connection get(){
        if(conexion == null){
            try{
                conexion = DriverManager.getConnection(url, usuario, clave);
                System.out.println("¡Conexión exitosa!");
            } catch (SQLException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return conexion;
    }
}


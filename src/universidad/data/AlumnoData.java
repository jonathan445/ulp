package universidad.data;

import universidad.entidades.Alumno;
import universidad.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class AlumnoData {
    public void altaAlumno(Alumno alumno){
        try {
            String sql = "INSERT INTO alumno (nombre, fecNac, activo) VALUES ('" + alumno.getNombre() + "', '" + alumno.getFecNac() + "', " + (alumno.getActivo() ? "1" : "0") + ");";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
           
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public ArrayList<Alumno> obtenerAlumnos(){
        ArrayList<Alumno> resultados = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM alumno";
            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()){
                resultados.add(new Alumno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getDate("FECNAC").toLocalDate(), rs.getBoolean("ACTIVO")));
            }
            s.close();
        } catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
        
        return resultados;
    }
    
    public void bajaAlumno(int id){
        try {
            String sql = "DELETE FROM alumno WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.executeQuery(sql);
            
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public void actualizarAlumno(int id, Alumno alumno){
        try {
            String sql = "UPDATE alumno SET nombre = " + alumno.getNombre() + ", fecNac = " + alumno.getFecNac() + " , activo = " + (alumno.getActivo() ? "1" : "0") + " WHERE id = " + id + ";";
            Statement s = Conexion.get().createStatement();
            s.execute(sql);
            
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public Alumno obtenerAlumno(int id){
        Alumno alumno = null;
        try {
            String sql = "SELECT * FROM alumno WHERE id = " + id + ";";

            Statement s = Conexion.get().createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                alumno = new Alumno(rs.getInt("ID"), rs.getString("NOMBRE"), rs.getDate("FECNAC").toLocalDate(), rs.getBoolean("ACTIVO"));
            }      
            s.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return alumno;
    }
}

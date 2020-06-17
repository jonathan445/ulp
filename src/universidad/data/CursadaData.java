package universidad.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import universidad.Conexion;
import universidad.entidades.*;

public class CursadaData {

    public Cursada altaCursada(Cursada cursada){
        try {
            String sql;
            if (cursada.getNota() != 0)
                sql = "INSERT INTO cursada (IDMATERIA, IDALUMNO, NOTA) VALUES (" + cursada.getMateria().getId() + " , " + cursada.getAlumno().getId() + ", " + cursada.getNota() + ");";
            else
                sql = "INSERT INTO cursada (IDMATERIA, IDALUMNO) VALUES (" + cursada.getMateria().getId() + " , " + cursada.getAlumno().getId() + ");";
            
            Statement s = Conexion.get().createStatement();
            s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS); 
            ResultSet rs = s.getGeneratedKeys();
            
            if (rs.first())
                cursada.setId(rs.getInt(1));
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar una cursada: " + ex.getMessage());
        }
        return cursada;
    }
    
    public List<Cursada> obtenerCursadas(){
        List<Cursada> cursadas = new ArrayList<Cursada>();
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        try {
            String sql = "SELECT * FROM cursada;";
            PreparedStatement statement = Conexion.get().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));
                
                cursada.setAlumno(ad.obtenerAlumno(resultSet.getInt("idAlumno")));
                cursada.setMateria(md.obtenerMateria(resultSet.getInt("idMateria")));
                cursada.setNota(resultSet.getInt("nota"));
               
                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las cursadas: " + ex.getMessage());
        }
        
        
        return cursadas;
    }
    
    public List<Cursada> obtenerCursadas(int idAlumno, int idMateria){
        List<Cursada> cursadas = new ArrayList<Cursada>();
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + ";";
            
            PreparedStatement statement = Conexion.get().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                cursada.setId(resultSet.getInt("id"));
                
                cursada.setAlumno(ad.obtenerAlumno(resultSet.getInt("idAlumno")));
                cursada.setMateria(md.obtenerMateria(resultSet.getInt("idMateria")));
                cursada.setNota(resultSet.getInt("nota"));
               
                cursadas.add(cursada);
            }   
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las cursadas: " + ex.getMessage());
        }
        
        
        return cursadas;
    }
    
    public Cursada obtenerCursada(int idAlumno, int idMateria){
        Cursada cursada = new Cursada();
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno = " + idAlumno + " AND idMateria = " + idMateria + ";";
            
            PreparedStatement statement = Conexion.get().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                cursada.setId(resultSet.getInt("id"));
                
                cursada.setAlumno(ad.obtenerAlumno(resultSet.getInt("idAlumno")));
                cursada.setMateria(md.obtenerMateria(resultSet.getInt("idMateria")));
                cursada.setNota(resultSet.getInt("nota"));
                break;
            }   
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las cursadas: " + ex.getMessage());
        }
        
        return cursada;
    }
    
    public List<Cursada> obtenerCursadasAlumno(int idAlumno){
        List<Cursada> cursadas = new ArrayList<>();
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno = ?;";
            PreparedStatement statement = Conexion.get().prepareStatement(sql);
            statement.setInt(1,idAlumno);
            ResultSet resultSet = statement.executeQuery();
            Cursada cursada;
            while(resultSet.next()){
                cursada = new Cursada();
                
                cursada.setId(resultSet.getInt("ID"));
                cursada.setAlumno(ad.obtenerAlumno(resultSet.getInt("idAlumno")));
                cursada.setMateria(md.obtenerMateria(resultSet.getInt("idMateria")));
                cursada.setNota(resultSet.getInt("nota"));

                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las cursadas del alumno: " + ex.getMessage());
        }
        
        return cursadas;
    }
    
    public List<Cursada> obtenerCursadasMateria(int idMateria){
        List<Cursada> cursadas = new ArrayList<>(); 
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        try {
            String sql = "SELECT * FROM cursada WHERE IDMATERIA = ?";
            PreparedStatement statement = Conexion.get().prepareStatement(sql);
            statement.setInt(1, idMateria);
            ResultSet rs = statement.executeQuery();
            Cursada cursada;
            while(rs.next()){
                cursada = new Cursada();
                cursada.setAlumno(ad.obtenerAlumno(rs.getInt("IDALUMNO")));
                cursada.setMateria(md.obtenerMateria(rs.getInt("IDMATERIA")));
                cursada.setNota(rs.getInt("NOTA"));
                
                cursadas.add(cursada);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las cursadas de la materia: " + ex.getMessage());
        }
        
        return cursadas;
    }
        
    
    public void bajaCursada(int idAlumno,int idMateria)
    {
        try {
            
            String sql = "DELETE FROM cursada WHERE idAlumno =? and idMateria =?;";

            PreparedStatement statement = Conexion.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, idAlumno);
            statement.setInt(2, idMateria);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar una cursada: " + ex.getMessage());
        }
       
    }
    
    
    public void actualizarCursada(int idAlumno,int idMateria, int nota)
    {
        try {
            
            String sql = "UPDATE cursada SET nota = ? WHERE idAlumno = ? and idMateria =?;";

            PreparedStatement statement = Conexion.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,nota);
            statement.setInt(2, idAlumno);
            statement.setInt(3, idMateria);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar una cursada: " + ex.getMessage());
        }
      
    }
   
}

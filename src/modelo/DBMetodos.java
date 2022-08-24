/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dachapi
 */
public class DBMetodos {
    
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
    //Metodo que inserta datos dentro de la base de datos
    public void insertDB(Curso_Virtual curso){
        int r = 0;

        try {
            Statement st = Conexion.getConexion().createStatement();

            String metodo = "Exec Insertar_Curso '"+curso.getId_Curso()+"', '" + curso.getNombre_Curso() + "', '" + curso.getTema_Curso() + "', " + curso.getCreditos() + "";

            r = st.executeUpdate(metodo);
                    
            if (r == 1) {
                System.out.println("Completado");
            } else {
                System.out.println("Fallo");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public int agregarCursos(Curso_Virtual user) {
//
//        int r = 0;
//        String sql = "INSERT INTO Curso_Virtual (Id_Curso, Nombre, Tema, Creditos) VALUES (?,?,?,?);";
//
//        try {
//            con = conectar.getConexion();// 1: Abrir conexion con la BD
//            ps = con.prepareStatement(sql);// 2: Prepara el query de sql
//            ps.setInt(1, user.getId_Curso());//3: Completar el query
//            ps.setString(2, user.getNombre_Curso());
//            ps.setString(3, user.getTema_Curso());
//            ps.setInt(4, user.getCreditos());
//
//            r = ps.executeUpdate();//4. Ejecutar query 0=Fallo 1= success modificacion en la base de datos
//        } catch (Exception e) {
//        }
//        return r;
//    }
    
    //Metodo que inserta datos dentro del arbol binario
    public NodoArbol crearArbol() {

        Curso_Virtual curso = null;
        
        MetodosAVLTree tree = new MetodosAVLTree();
        
        try {
            Statement st = Conexion.getConexion().createStatement();

            String metodo = "Exec Datos";

            ResultSet rs = st.executeQuery(metodo);

            while (rs.next()) {
                curso = new Curso_Virtual();
                curso.setId_Curso(rs.getInt(1));
                curso.setNombre_Curso(rs.getString(2));
                curso.setTema_Curso(rs.getString(3));
                curso.setCreditos(rs.getInt(4));
                
                tree.setRoot(tree.insert(tree.getRoot(), curso));
                
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tree.getRoot();
    }
    
    //Metodo que elemina un registro de la base de datos
    public void delecteDB(Curso_Virtual curso){
        
        int r = 0;

        try {
            Statement st = Conexion.getConexion().createStatement();

            String metodo = "Exec Eliminar_Curso "+curso.getId_Curso()+"";

            r = st.executeUpdate(metodo);
                    
            if (r == 1) {
                System.out.println("Completado");
            } else {
                System.out.println("Fallo");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

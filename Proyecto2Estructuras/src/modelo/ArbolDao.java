/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dachapi
 */
public class ArbolDao {
    
    
    //Metodo que inserta datos dentro de la base de datos
    public void insertDB(String nombre, String tema, int creditos){
        int r = 0;

        try {
            Statement st = Conexion.getConexion().createStatement();

            String metodo = "Exec Insertar_Curso '" + nombre + "', '" + tema + "', " + creditos + "";

            r = st.executeUpdate(metodo);
                    
            if (r == 1) {
                System.out.println("Completado");
            } else {
                System.out.println("Fallo");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                
                tree.root = tree.insert(tree.root, curso);
                
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tree.root;
    }
    
    //Metodo que elemina un registro de la base de datos
    public void delecteDB(int id_Curso){
        
        int r = 0;

        try {
            Statement st = Conexion.getConexion().createStatement();

            String metodo = "Exec Eliminar_Curso "+id_Curso+"";

            r = st.executeUpdate(metodo);
                    
            if (r == 1) {
                System.out.println("Completado");
            } else {
                System.out.println("Fallo");
            }
        } catch (SQLServerException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArbolDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    

}
    


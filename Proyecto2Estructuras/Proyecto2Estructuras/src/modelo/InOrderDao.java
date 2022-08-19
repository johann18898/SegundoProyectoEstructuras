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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Dachapi
 */
public class InOrderDao {
    
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    Conexion conectar = new Conexion();
    
    
    
    public void filtrarTablaPorNombre(JTable table, String filtro, MetodosAVLTree node) {
        ArrayList<Curso_Virtual> lC = new ArrayList<>();
        
        lC = node.inOrder(node.getRoot(), lC);
        
        String[] titulos = {"ID CURSO", "NOMBRE","TEMA","CREDITOS"};
        String[] registros = new String[4];
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(null, titulos);

        for (Curso_Virtual vuelta : lC) {
            
            registros[0] = String.valueOf(vuelta.getId_Curso());
            registros[1] = vuelta.getNombre_Curso();
            registros[2] = vuelta.getTema_Curso();
            registros[3] = String.valueOf(vuelta.getCreditos());
            modelo.addRow(registros);
        }
        table.setModel(modelo);

    }


    
    
    

}
    


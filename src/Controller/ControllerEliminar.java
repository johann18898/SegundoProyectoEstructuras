/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso_Virtual;
import modelo.DBMetodos;
import vista.frmEliminarDatos;

/**
 *
 * @author vboni
 */
public class ControllerEliminar implements ActionListener {

    frmEliminarDatos vistaEliminarDatos = new frmEliminarDatos();
    Curso_Virtual c = new Curso_Virtual();
    DBMetodos DAO = new DBMetodos();

    public ControllerEliminar(frmEliminarDatos frm) {
        this.vistaEliminarDatos = frm;
        this.vistaEliminarDatos.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // paso #2
        if (e.getSource() == vistaEliminarDatos.btnEliminar) {
            eliminarCursos();
            limpiarCampos();
        }
    }

    public void eliminarCursos() {

        String id = vistaEliminarDatos.txtIdCurso.getText();

        c.setId_Curso(Integer.parseInt(id));
        c.setNombre_Curso("");
        c.setTema_Curso("");
        c.setCreditos(0);

        DAO.delecteDB(c);
    }
    
    public void limpiarCampos() {
        vistaEliminarDatos.txtIdCurso.setText("");
    }

}

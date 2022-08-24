/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso_Virtual;
import modelo.DBMetodos;
import vista.frmInsertarDatos;

/**
 *
 * @author vboni
 */
public class ControllerInsertar implements ActionListener {

    frmInsertarDatos vistaInsetarDatos = new frmInsertarDatos();
    Curso_Virtual c = new Curso_Virtual();
    DBMetodos DAO = new DBMetodos();

    public ControllerInsertar(frmInsertarDatos frm) {
        this.vistaInsetarDatos = frm;
        this.vistaInsetarDatos.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // paso #2
        if (e.getSource() == vistaInsetarDatos.btnAgregar) {
            agregarCursos();
            limpiarCampos();
        }
    }

    public void agregarCursos() {

        String id = vistaInsetarDatos.txtIdCurso.getText();
        String nombre = vistaInsetarDatos.txtNombreCurso.getText();
        String tema = vistaInsetarDatos.txtTemaCurso.getText();
        String creditos = vistaInsetarDatos.txtCreditos.getText();

        c.setId_Curso(Integer.parseInt(id));
        c.setNombre_Curso(nombre);
        c.setTema_Curso(tema);
        c.setCreditos(Integer.parseInt(creditos));

        DAO.insertDB(c);
    }

    public void limpiarCampos() {
        vistaInsetarDatos.txtIdCurso.setText("");
        vistaInsetarDatos.txtNombreCurso.setText("");
        vistaInsetarDatos.txtTemaCurso.setText("");
        vistaInsetarDatos.txtCreditos.setText("");
    }

}

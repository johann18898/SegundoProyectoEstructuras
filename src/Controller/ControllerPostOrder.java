/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import modelo.PreOrderDao;
import modelo.Curso_Virtual;
import vista.frmPostOrder;

/**
 *
 * @author vboni
 */
public class ControllerPostOrder {
    
    frmPostOrder vistaPostOrder = new frmPostOrder();
    Curso_Virtual c = new Curso_Virtual();
    PreOrderDao dao = new PreOrderDao();

    public ControllerPostOrder (frmPostOrder frm) {
        this.vistaPostOrder = frm;
    }

    public void inicio() {
      filtrarTablaPorNombre(vistaPostOrder.tblPostOrder, "");
    }
     public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }
}

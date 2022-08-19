/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import modelo.PreOrderDao;
import modelo.Curso_Virtual;
import vista.frmPreOrder;

/**
 *
 * @author vboni
 */
public class ControllerPreOrder {
    
    frmPreOrder vistaPreOrder = new frmPreOrder();
    Curso_Virtual c = new Curso_Virtual();
    PreOrderDao dao = new PreOrderDao();

    public ControllerPreOrder (frmPreOrder frm) {
        this.vistaPreOrder = frm;
    }

    public void inicio() {
       filtrarTablaPorNombre(vistaPreOrder.tblPreOrder, "");
    }
    public void filtrarTablaPorNombre(JTable table, String filtro) {
        dao.filtrarTablaPorNombre(table, filtro);
    }
}

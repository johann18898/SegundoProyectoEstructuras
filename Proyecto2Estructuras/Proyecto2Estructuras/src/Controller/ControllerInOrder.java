/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import modelo.PreOrderDao;
import modelo.Curso_Virtual;
import modelo.InOrderDao;
import modelo.MetodosAVLTree;
import vista.frmInOrder;

/**
 *
 * @author vboni
 */
public class ControllerInOrder  {
    
    
    frmInOrder vistaInOrder = new frmInOrder();
    Curso_Virtual c = new Curso_Virtual();
    InOrderDao dao = new InOrderDao();

    public ControllerInOrder (frmInOrder frm) {
        this.vistaInOrder = frm;
    }
    public void filtrarTablaPorNombre(JTable table, String filtro, MetodosAVLTree node) {
        dao.filtrarTablaPorNombre(table, filtro, node);
    }
    public void inicio(MetodosAVLTree node) {
        filtrarTablaPorNombre(vistaInOrder.tblInOrder, "", node);
    }
}

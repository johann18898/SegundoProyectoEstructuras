/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import modelo.PreOrderDao;
import modelo.Curso_Virtual;
import modelo.MetodosAVLTree;
import modelo.PostOrderDao;
import vista.frmPostOrder;

/**
 *
 * @author vboni
 */
public class ControllerPostOrder {
    
    frmPostOrder vistaPostOrder = new frmPostOrder();
    Curso_Virtual c = new Curso_Virtual();
    PostOrderDao dao = new PostOrderDao();

    public ControllerPostOrder (frmPostOrder frm) {
        this.vistaPostOrder = frm;
    }

    public void inicio(MetodosAVLTree node) {
      filtrarTablaPorNombre(vistaPostOrder.tblPostOrder, "", node);
    }
     public void filtrarTablaPorNombre(JTable table, String filtro, MetodosAVLTree node) {
        dao.filtrarTablaPorNombre(table, filtro, node);
    }
}

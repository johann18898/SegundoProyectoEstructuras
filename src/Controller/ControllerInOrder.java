/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import modelo.DBMetodos;
import modelo.InOrderDao;
import modelo.MetodosAVLTree;
import vista.frmInOrder;

/**
 *
 * @author vboni
 */
public class ControllerInOrder  {

    frmInOrder vistaInOrder = new frmInOrder();
    InOrderDao dao = new InOrderDao();
    DBMetodos DAO = new DBMetodos();


    public ControllerInOrder(frmInOrder frm) {
        this.vistaInOrder = frm;
    }

    public void filtrarTablaPorNombre(JTable table, String filtro, MetodosAVLTree node) {
        dao.filtrarTablaPorNombre(table, filtro, node);
    }

    public void inicio(MetodosAVLTree node) {
        filtrarTablaPorNombre(vistaInOrder.tblInOrder, "", node);
    }
}

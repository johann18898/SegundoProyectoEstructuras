/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dachapi
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodosAVLTree avlTree = new MetodosAVLTree();
        ArrayList<Curso_Virtual> lC = new ArrayList<>();
        
        
        Curso_Virtual cv1 = new Curso_Virtual(10, "Calculo", "Matematicas", 4);
        Curso_Virtual cv2 = new Curso_Virtual(20, "Humanidades", "Saber del mundo", 6);
        Curso_Virtual cv3 = new Curso_Virtual(30, "Principios de programacion", "Programar", 4);
        Curso_Virtual cv4 = new Curso_Virtual(50, "Fisica", "Hacer fisicamatematica", 4);
        Curso_Virtual cv5 = new Curso_Virtual(40, "Ingles", "Saber Ingles", 3);
        Curso_Virtual cv6 = new Curso_Virtual(25, "Artes", "Saber del arte", 2);
        
//        avlTree.root = avlTree.insert(avlTree.root, cv1);
//        avlTree.root = avlTree.insert(avlTree.root, cv2);
//        avlTree.root = avlTree.insert(avlTree.root, cv3);
//        avlTree.root = avlTree.insert(avlTree.root, cv4);
//        avlTree.root = avlTree.insert(avlTree.root, cv5);
//        avlTree.root = avlTree.insert(avlTree.root, cv6);
//        
//        System.out.println("Imprimir arbol de formar transversal Preorder: ");
//        lC = avlTree.preOrder(avlTree.root, lC);
//        System.out.println(" ");
//        
//        for (int i = 0; i < lC.size(); i++) {
//            System.out.println(lC.get(i).getId_Curso());
//        }
//        
    }
    
}

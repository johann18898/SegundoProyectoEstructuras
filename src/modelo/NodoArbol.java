/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Dachapi
 */
public class NodoArbol {
    
    private Curso_Virtual data;
    private int height;
    
    private NodoArbol left;
    private NodoArbol right;

    public NodoArbol(Curso_Virtual data) {
        this.data = data;
        height = 1;
    }

    public Curso_Virtual getData() {
        return data;
    }

    public void setData(Curso_Virtual data) {
        this.data = data;
    }

    public NodoArbol getLeft() {
        return left;
    }

    public void setLeft(NodoArbol left) {
        this.left = left;
    }

    public NodoArbol getRight() {
        return right;
    }

    public void setRight(NodoArbol right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    //Metodo que inserta datos en el arbol
    public void insert(Curso_Virtual value) {
        
        if (value.getId_Curso() <= this.getData().getId_Curso()) {
            if (left == null) {
                left = new NodoArbol(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new NodoArbol(value);
            } else {
                right.insert(value);
            }
        }
    }
    
    //Metodo que busca datos dentro de un arbol
    public boolean contains(Curso_Virtual value) {
        
        if (value.getId_Curso() == this.getData().getId_Curso()) {
            return true;
        } else if (value.getId_Curso() < data.getId_Curso()) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }
}

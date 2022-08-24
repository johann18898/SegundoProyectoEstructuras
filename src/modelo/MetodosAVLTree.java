
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dachapi
 */
public class MetodosAVLTree {
    
    private NodoArbol root;

    public NodoArbol getRoot() {
        return root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }
    
    //Metodo que devuelve la altura de un nodo
    public int height(NodoArbol node){
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }
    
    //Devuelve el numero mayor entre dos numeros
    public int max(int num1, int num2){
        return (num1 > num2) ? num1 : num2;
    }
    
    //Metodo de rotacion hacia la derecha
    public NodoArbol rightRotation(NodoArbol root){
        NodoArbol newRoot = root.getLeft();
        NodoArbol nodeTemp2 = newRoot.getRight();

        //Se ejecuta la rotacion
        newRoot.setRight(root);
        root.setLeft(nodeTemp2);

        //se actualizacion las alturas de los nodos        
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) +1);
        
        newRoot.setHeight(max(height(newRoot.getLeft()), height(newRoot.getRight())) +1);
        
        //retorna la nueva raiz (root)
        return newRoot;
    }
    
    
    //Metodo de rotacion hacia la izquierda
    public NodoArbol leftRotation(NodoArbol root){
        NodoArbol newRoot = root.getRight();
        NodoArbol nodeTemp2 = newRoot.getLeft();

        //Se ejecuta la rotacion
        newRoot.setLeft(root);
        root.setRight(nodeTemp2);

        //Se actualizacion las alturas de los nodos
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) +1);
        
        newRoot.setHeight(max(height(newRoot.getLeft()), height(newRoot.getRight()))+1);
        
        //Retorna la nueva raiz (root)
        return newRoot;
    }
    
    
    // Obtener el factor de balance del nodo
    public int getBalance(NodoArbol node){
        if (node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
    
    public NodoArbol getNodoConValorMaximo(NodoArbol node){
        NodoArbol current = node;
        
        while (current.getRight() != null) {            
            current = current.getRight();
        }
        
        return current;
    }
    
    
    public NodoArbol insert(NodoArbol node, Curso_Virtual data){
        //1. Insercion normal en un arbol de busqueda binaria
        if (node == null) {
            return (new NodoArbol(data));
        }

        //Recurden que este "if" tambien se puede hacer en una sola linea
        //if (node == null) return (new Node(data));
        if (data.getId_Curso() < node.getData().getId_Curso()) {

            node.setLeft(insert(node.getLeft(), data));

        } else if (data.getId_Curso() > node.getData().getId_Curso()) {

            node.setRight(insert(node.getRight(), data));

        } else { //Duplicados no son permitidos
            return node;
        }

        //2. Actualizar la altura del nodo
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        //3. Obtener el factor de balance del nodo para posteriormente determinar si esta balanceado o no
        int balanceFactor = getBalance(node);

        //4. Si la insercion del nodo combierte al arbol en un arbol desbalanceado los cuatro posibles escenarios
        // Rotacion derecha
        // Rotacion izquierda
        // Rotacion izquierda derecha
        // Rotacion derecha izquierda
        // Rotacion derecha
        if (balanceFactor > 1 && data.getId_Curso() < node.getRight().getData().getId_Curso()) {
            return rightRotation(node);
        }

        // Rotacion izquierda
        if (balanceFactor < -1 && data.getId_Curso() > node.getRight().getData().getId_Curso()) {
            return leftRotation(node);
        }

        // Rotacion izquierda derecha
        if (balanceFactor > 1 && data.getId_Curso() > node.getLeft().getData().getId_Curso()) {
            node.setLeft(leftRotation(node.getLeft()));
            return rightRotation(node);
        }

        // Rotacion derecha izquierda
        if (balanceFactor < -1 && data.getId_Curso() < node.getRight().getData().getId_Curso()) {
            node.setRight(rightRotation(node.getRight()));
            return leftRotation(node);
        }
        return node;
    }
    
    public NodoArbol eliminarAVL(NodoArbol nodoActual, Curso_Virtual key){
        if (nodoActual == null) {
            return nodoActual;
        }
        
        if (key.getId_Curso() < nodoActual.getData().getId_Curso()) {
            
            nodoActual.setLeft(eliminarAVL(nodoActual.getLeft(), key));

        }else if (key.getId_Curso() > nodoActual.getData().getId_Curso()){
            
            nodoActual.setRight(eliminarAVL(nodoActual.getRight(), key));
            
        }else {
            //El nodo es igual a la clave, se elimina
            //Nodo con un unico hijo o es hoja
            if ((nodoActual.getLeft() == null) || (nodoActual.getRight() == null)) {
                NodoArbol temp = null;
                if (temp == nodoActual.getLeft()) {
                    temp = nodoActual.getRight();
                }else{
                    temp = nodoActual.getLeft();
                }
                
                //Caso donde no tiene hijos
                if (temp == null) {
                    nodoActual = null; //Eliminado y colocando null
                } else{
                    //Caso con un hijo
                    nodoActual = temp;  //Eliminando el nodo actual por su hijo
                }
            }else {
                //Nodo con 2 hijos, buscando el predecesor
                NodoArbol temp = getNodoConValorMaximo(nodoActual.getLeft());
                
                //Se copia el dato del predecesor
                nodoActual.setData(temp.getData()); 
                
                //Se elimina el predecesor
                nodoActual.setLeft(eliminarAVL(nodoActual.getLeft(), temp.getData()));
            }
        }
        if (nodoActual == null) {
            return nodoActual;
        }
        
        //Actualizar altura;
        nodoActual.setHeight(max(height(nodoActual.getLeft()), height(nodoActual.getRight())) + 1);
        
        //Calcular factor de equilibrio (FE)
        int fe = getBalance(nodoActual);
        
        //Se realizan las rotaciones pertinentes dado el FE
        //Caso rotacion simple derecha
        if (fe > 1 && getBalance(nodoActual.getLeft()) >= 0) {
            return rightRotation(nodoActual);
        }
        
        //Caso Rotacion simple izquierda
        if (fe < -1 && getBalance(nodoActual.getRight()) <= 0) {
            return leftRotation(nodoActual);
        }
        
        //Caso rotacion doble izquierda-Derecha
        if (fe > 1 && getBalance(nodoActual.getLeft()) < 0) {
            nodoActual.setLeft(leftRotation(nodoActual.getLeft()));
            return rightRotation(nodoActual);
        }
        
        //Caso rotacion doble derecha-izquierda
        
        if (fe < -1 && getBalance(nodoActual.getRight()) > 0) {
            nodoActual.setRight(rightRotation(nodoActual.getRight()));
            return leftRotation(nodoActual);
        }
        
        return nodoActual;
    }
    
    
    public ArrayList<Curso_Virtual> preOrder(NodoArbol node, ArrayList<Curso_Virtual> data){
        //Intentar implementar un arraylist(de tipo NodoArbol) que reciba los datos y retorne dichos datos
        if (node != null){
            System.out.print(node.getData().getId_Curso() + " -> ");
            
            data.add(node.getData());
            
            preOrder(node.getLeft(), data);
            preOrder(node.getRight(), data);
        }
        
        return data;
    }

    public ArrayList<Curso_Virtual> inOrder(NodoArbol node, ArrayList<Curso_Virtual> data){
        //Intentar implementar un arraylist(de tipo NodoArbol) que reciba los datos y retorne dichos datos
        if (node == null) {
            return null;
        }
        
        inOrder(node.getLeft(), data);

        System.out.print(node.getData().getId_Curso() + "->");

        data.add(node.getData());

        inOrder(node.getRight(), data);

        return data;
    }
    
    public ArrayList<Curso_Virtual> postOrder(NodoArbol node, ArrayList<Curso_Virtual> data){
        if (node == null) {
            return null;
        }

        postOrder(node.getLeft(), data);

        postOrder(node.getRight(), data);

        System.out.print(node.getData().getId_Curso() + "->");
        
        data.add(node.getData());
        
        return data;
    }
    
}

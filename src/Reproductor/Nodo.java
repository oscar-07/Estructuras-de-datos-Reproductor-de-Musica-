
package Reproductor;


public class Nodo {
    String dato;
    Nodo anterior;
    Nodo siguiente;
    
    
    Nodo(String dato) {
        this.dato=dato;
        anterior=siguiente=this;
    }
}
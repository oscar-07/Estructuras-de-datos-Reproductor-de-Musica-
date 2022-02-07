
package Reproductor;

public class LDLCCancion {
    Nodo inicio;
    Nodo ultimo;
 
    
    public LDLCCancion(){
        inicio=null;
        ultimo=null;
    }
    public boolean estaVacia(){
        return inicio== null;
    }
    
    public void Insertar(String dato){
        Nodo nuevo= new Nodo(dato);

        if(inicio==null){
            inicio=nuevo;
            inicio.siguiente=inicio;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
        }else{
            ultimo.siguiente=nuevo;
            nuevo.siguiente=inicio;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
            inicio.anterior=ultimo;
        }
    
    }
    
    
    public String derecha(String x){
        Nodo indice;
        indice=inicio;
        String dd=null;
        if(estaVacia()){
            System.out.println("vacia");
        }else{
        do{
            if (indice.dato.equals(x)){
                System.out.println(indice.siguiente.dato); 
                return dd=indice.siguiente.dato;
            }   
           indice=indice.siguiente;
        }while(indice!=inicio);
        }
       return dd;
    }
    
    public String izquierda(String x){
        Nodo indice;
        indice=ultimo;         
        String dd=null;
        if(estaVacia()){
            System.out.println("vacia");
        }else{
        do{
             if (indice.dato.equals(x)){
                System.out.println(indice.anterior.dato); 
                return dd=indice.anterior.dato;
            }   
           indice=indice.anterior;
        }while(indice!=ultimo);
        }
        return dd;
    }
    

    
    public void Buscar(String dato){
        Nodo indice;
        indice=inicio;
        if(estaVacia()){
            System.out.println("vacia");
        }else{
        do{
            if(indice.dato.equals(dato))
          
           indice=indice.anterior;
        }while(indice!=inicio);
        }
    }
    
    public void Eliminar(String dato){
        Nodo actual;
        Nodo anterior;
        actual=inicio;
        anterior=ultimo;
        if(estaVacia()){
            System.out.println("esta vacia");
        }else{
        do{
            if (actual.dato.equals(dato)){
             if (inicio==ultimo){
                    inicio=null;
                    ultimo=null;
                    break;
            }
            }
 
            if(actual.dato.equals(dato)){
                if(actual==inicio){
                    inicio=inicio.siguiente;
                    ultimo.siguiente=inicio;
                    inicio.anterior=ultimo;
                }
                else{
                    if(actual==ultimo){
                        ultimo= anterior;
                        inicio.anterior=ultimo;
                        ultimo.siguiente=inicio;
                    }
                    else{
                        anterior.siguiente=actual.siguiente;
                        actual.siguiente.anterior=anterior;
                    }
                }
            }
            anterior=actual;
            actual=actual.siguiente;
        }while(actual!=inicio);
        }
         
    }
    
    @Override
    public String toString(){
        Nodo actual;
        actual=inicio;
        
        if(estaVacia()){
            return "Lista Vacia";
        }else{
        do{
            
            System.out.print("<--"+actual.dato+"-->");
            actual=actual.siguiente;
        }while(actual!= inicio);
        return "";
        }
        
        
    }
}


package Reproductor;

import java.util.Scanner;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class TestMain {

  public static void main(String[] args) { 
     Interfaz vl =new Interfaz();
     Scanner sa=new Scanner (System.in);
     LDLCCancion lcc=new LDLCCancion();
     LDLCImagen  lci=new LDLCImagen();
     LDLCNombre  lcn=new LDLCNombre();  
     vl.setDefaultCloseOperation(EXIT_ON_CLOSE);
     vl.setVisible(true);
     vl.setSize(380,500);
     vl.setResizable(false);
     vl.setTitle("Proyecto Estructuras De Datos");
     vl.setLocationRelativeTo(null);
    
       
        int op=0;

        while (op!=5){
            System.out.println();
            System.out.println("(1) insertar ");
            System.out.println("(2) imprimir ");
            System.out.println("(3) Buscar ");
            System.out.println("(4) borrar ");
            System.out.println("(5) Salir");
            op=sa.nextInt();
            sa.nextLine();
            switch(op){
                case 1: 
                      
                         System.out.println("Prop el dato");
                         lcc.Insertar(sa.nextLine());
                         
                        break;
                
                case 2:
                         if (lcc.estaVacia())
                             System.out.println("vacia");
                         else
                         lcc.toString();
                        break;
                case 3:
                          if (lcc.estaVacia())
                              System.out.println("vacia");
                          else{
                          System.out.println("Buscar");
                          lcc.Buscar(sa.nextLine());
                          }
                        break;
                case 4:
                          if (lcc.estaVacia())
                            System.out.println("vacia");
                          else{
                        System.out.println("eliminar");
                        lcc.Eliminar(sa.nextLine());
                          }
                        break;
                case 5: 
                       System.out.println("Adios");
                        break;
                default:
                        System.out.println("Opcion invalida");
                
            }
      
      
    }
        
        
        
     
    }
    
}

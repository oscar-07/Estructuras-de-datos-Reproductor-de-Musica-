
package Reproductor;

import TelematicoTools.Platillos.DiscoOne;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interfaz extends JFrame{
       JPanel panel = new JPanel();
       DiscoOne d1=new DiscoOne();
       JLabel eti=new JLabel();
       JLabel foto=new JLabel();
       JLabel fondo=new JLabel();
       JFrame fra=new JFrame();
       LDLCCancion lcc=new LDLCCancion();
       LDLCImagen  lci=new LDLCImagen();
       LDLCNombre  lcn=new LDLCNombre();
       

       int cont=0;
       String ruta;
       String imagen="/Imagenes/3.png";
       String nombre;
       String basuraruta;
       String basuranombre;
       String basuraimagen;
       
  
    public Interfaz (){ 
        aqui();
    }

    private void aqui(){
        pane();
        agregar();
        play();
        apagar();
        adelante();
        atras();   
        stop();
        pausa();
        eliminar();
        papel();
    }
    
    private void play(){
        JButton play=new JButton();
          play.setBounds(200, 300, 75, 50);
          ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/play.png"));
          play.setIcon(new ImageIcon(PP.getImage().getScaledInstance(play.getWidth(),play.getHeight(),Image.SCALE_SMOOTH)));
          play.setOpaque(false);
          play.setContentAreaFilled(false);
          panel.add(play);
          
         Image icon = new ImageIcon(getClass().getResource("/imagenes/22.jpg")).getImage();
         setIconImage(icon);
             
          
          //letras
          eti=new JLabel();
          eti.setBounds(50,120,400,300);
          eti.setFont(new Font("cooper black",0,13));
          eti.setForeground(Color.yellow);
          panel.add(eti);
          
          
          
          
         //Imagen de inicio
          foto.setBounds(130,150,120,100);
          ImageIcon uno=new ImageIcon(getClass().getResource(imagen));
          Icon xx=new ImageIcon(uno.getImage().getScaledInstance(120, 100,Image.SCALE_AREA_AVERAGING));
          foto.setIcon(xx);
          panel.add(foto);
          

          
          ActionListener pl=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            if (lcc.estaVacia())
                   System.out.println("no hay cancion");
            else{
              if (cont==0)  {  
                  cont++;                 
                   byte[] musica = d1.getBytes(ruta);
                   d1.PlayMP3(musica);
              }else
                  d1.continuar();
                   
            eti.setText(nombre);
            }
           }
         };
          play.addActionListener(pl);
          
          

      }
 
    private void agregar(){
        JButton agregar=new JButton();
        agregar.setBounds(33, 30, 70, 50);
        ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/guardar.png"));
        agregar.setIcon(new ImageIcon(PP.getImage().getScaledInstance(agregar.getWidth(),agregar.getHeight(),Image.SCALE_SMOOTH)));
        agregar.setOpaque(false);
        agregar.setContentAreaFilled(false);
        panel.add(agregar);
        

        ActionListener al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cont=0;
         JFileChooser fc=new JFileChooser(); 
    
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
         
         FileNameExtensionFilter filtro1 = new FileNameExtensionFilter(".mp3", "MP3");
         FileNameExtensionFilter filtro2 = new FileNameExtensionFilter(".jpg", "JPG");
         

         //aqui es ruta, filtro y condicion
         fc.setFileFilter(filtro1);
         int resp=fc.showOpenDialog(fc);
         if (resp==JFileChooser.APPROVE_OPTION){
             lcc.Insertar(fc.getSelectedFile().getAbsolutePath());
             ruta = fc.getSelectedFile().getAbsolutePath();
         
             //aqui es nombre
             nombre = fc.getSelectedFile().getName();
             lcn.Insertar(nombre);
                
         
         
             //aqui es imagen
             fc.setFileFilter(filtro2);
             fc.showOpenDialog(fc);
             lci.Insertar(fc.getSelectedFile().getAbsolutePath());
             imagen=fc.getSelectedFile().getAbsolutePath();
         
            //aqui pone la imagen
            foto.setBounds(130,150,120,100);
            Image uno=getToolkit().getImage(imagen);
            uno =uno.getScaledInstance(120, 100,1);
            foto.setIcon(new ImageIcon(uno));
            eti.setText(nombre);
        }else
                    System.out.println("error");
            }
        };
        agregar.addActionListener(al);
    }
    
    private void apagar(){
       JButton apagar=new JButton();
        apagar.setBounds(280, 20, 90, 60);
        ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/turn_off_25836.png"));
        apagar.setIcon(new ImageIcon(PP.getImage().getScaledInstance(apagar.getWidth(),apagar.getHeight(),Image.SCALE_SMOOTH)));
        apagar.setOpaque(false);
        apagar.setContentAreaFilled(false);
        panel.add(apagar);
          
          
          
          panel.add(apagar);
          ActionListener apa=new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               System.exit(0);
           }
          };
         apagar.addActionListener(apa);
          
          
          
    }
    
    private void pausa(){
       JButton pausa=new JButton();
          pausa.setBounds(120, 300, 80, 50);
          ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/pause.png"));
        pausa.setIcon(new ImageIcon(PP.getImage().getScaledInstance(pausa.getWidth(),pausa.getHeight(),Image.SCALE_SMOOTH)));
        pausa.setOpaque(false);
        pausa.setContentAreaFilled(false);
        panel.add(pausa);
          
          
          panel.add(pausa);
          ActionListener pau=new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               d1.pause();
           }
          
          };
          pausa.addActionListener(pau);
    }
    
    private void adelante(){
       JButton adelante=new JButton();
        adelante.setBounds(250, 350, 75, 50);
        ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/derecha.png"));
        adelante.setIcon(new ImageIcon(PP.getImage().getScaledInstance(adelante.getWidth(),adelante.getHeight(),Image.SCALE_SMOOTH)));
        adelante.setOpaque(false);
        adelante.setContentAreaFilled(false);
        panel.add(adelante);
          
          
          panel.add(adelante);
          ActionListener ade=new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               if (lcc.estaVacia())
                   System.out.println("no hay cancion");
               else{
             d1.stop();
             ruta = lcc.derecha(ruta);
             byte[] musica = d1.getBytes(ruta);
             d1.PlayMP3(musica);
             
             imagen=lci.derecha(imagen);
             //Imagen derecha
             Image uno=getToolkit().getImage(imagen);
             uno =uno.getScaledInstance(120, 100,1);
             foto.setIcon(new ImageIcon(uno));
             
             
             
             nombre=lcn.derecha(nombre);           
             eti.setText(nombre);
               }
               
           }
       };
          
          adelante.addActionListener(ade);
          
    }
    
    private void atras(){
       JButton atras=new JButton();
          atras.setBounds(60, 350, 75, 50);
          ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/izquier.png"));
         atras.setIcon(new ImageIcon(PP.getImage().getScaledInstance(atras.getWidth(),atras.getHeight(),Image.SCALE_SMOOTH)));
         atras.setOpaque(false);
         atras.setContentAreaFilled(false);
          
          
          panel.add(atras);
          ActionListener atr=new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              if (lcc.estaVacia())
                   System.out.println("no hay cancion");
               else{  
             d1.stop();
             ruta = lcc.izquierda(ruta);
             byte[] musica = d1.getBytes(ruta);
             d1.PlayMP3(musica);
             imagen=lci.izquierda(imagen);
             
             //imagen izquierda
             Image uno=getToolkit().getImage(imagen);
             uno =uno.getScaledInstance(120, 100,1);
             foto.setIcon(new ImageIcon(uno));
             //pone nombre
                  
             nombre=lcn.izquierda(nombre);
             eti.setText(nombre);
            }
           }
       };
          atras.addActionListener(atr);
          
          
    }
    
    private void eliminar(){
       JButton eliminar=new JButton();
          eliminar.setBounds(33, 100, 70, 50);
          ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/eliminar.png"));
         eliminar.setIcon(new ImageIcon(PP.getImage().getScaledInstance(eliminar.getWidth(),eliminar.getHeight(),Image.SCALE_SMOOTH)));
         eliminar.setOpaque(false);
         eliminar.setContentAreaFilled(false);
          panel.add(eliminar);
         
          ActionListener eli=new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               if(lcc.estaVacia())
                   System.out.println("no se puede");
               else{
                 cont=0;
                 d1.stop();
                 basuraruta=ruta;
                 basuranombre=nombre;
                 basuraimagen=imagen;
                 ruta = lcc.derecha(ruta);
                 nombre=lcn.derecha(nombre);
                 imagen=lci.derecha(imagen);
                 lcc.Eliminar(basuraruta);
                 lcn.Eliminar(basuranombre);
                 lci.Eliminar(basuraimagen);
                
                //eliminar imagen
                Image uno=getToolkit().getImage(imagen);
                uno =uno.getScaledInstance(120, 100,1);
                foto.setIcon(new ImageIcon(uno));
                

                 eti.setText(nombre);
                 
            if(lcc.estaVacia()){
                    foto.setIcon(null);
                   nombre=null;
                   eti.setText(nombre);
            }    
                 
           }
           }     
          };
          eliminar.addActionListener(eli);     
    }
    
    private void stop(){
       JButton stop=new JButton();
          stop.setBounds(155, 350, 80, 50);
          ImageIcon PP=new ImageIcon(getClass().getResource("/imagenes/stop.png"));
         stop.setIcon(new ImageIcon(PP.getImage().getScaledInstance(stop.getWidth(),stop.getHeight(),Image.SCALE_SMOOTH)));
         stop.setOpaque(false);
         stop.setContentAreaFilled(false);
          
          panel.add(stop);
          ActionListener sto=new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {               
               d1.stop();             
           }            
          };
          
          stop.addActionListener(sto);
          
    }
    
    private void papel(){
        ImageIcon pp = new ImageIcon(this.getClass().getResource("/imagenes/2.gif"));
        fondo.setIcon(pp);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, pp.getIconWidth(), pp.getIconHeight());
        panel.add(fondo);
    
    }
    
     private void pane(){
         
       panel.setLayout(null);
       this.getContentPane().add(panel);
   
    }

    
}

package Gráficos;
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;

public class Eventos_VI {

    public static void main(String[] args) {
        Marcoraton raton = new Marcoraton();
        raton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }  
}

class Marcoraton extends JFrame{

    public Marcoraton(){
        setVisible(true);
        setTitle("EVENTO RATON I");
        setSize(400, 300); 
        setLocationRelativeTo(null); //PONE EL FRAME EN EL CENTRO DE LA PANTALLA
        
        Eventoraton raton2 = new Eventoraton();
        addMouseListener(raton2);
        addMouseMotionListener(raton2);
    }
}

class Eventoraton extends MouseAdapter implements MouseMotionListener{

    public void mouseClicked(MouseEvent e){
        System.out.println("Coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());
        System.out.println(e.getClickCount());
    }
    
    public void mousePressed(MouseEvent e){
        if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK){
            System.out.println("Boton izquierdo");
        }
        else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK){ 
            System.out.println("Rueda del raton");
        }
        else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK){ 
            System.out.println("Boton derecho");
        }  
    }
    public void mouseDragged(MouseEvent e){ //METODO DE MOUSEMOTIONLISTENER
        System.out.println("Arrastrando el mouse");

    }
    public void mouseMoved(MouseEvent e){ //METODO DE MOUSEMOTIONLISTENER
        System.out.println("Moviendo el mouse");

    }
}


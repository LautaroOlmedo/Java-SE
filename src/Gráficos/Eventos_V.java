package Gráficos;
import javax.swing.*;
import java.awt.Frame;
import java.awt.event.*;

public class Eventos_V {
    public static void main(String[] args) {

        marcoteclado teclado = new marcoteclado();
        teclado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    
}

class marcoteclado extends JFrame{

    public marcoteclado(){
        setVisible(true);
        setTitle("EVENTOS TECLADO I");
        setBounds(70, 0, 300, 500);
        EventoTeclado eventito = new EventoTeclado();
        addKeyListener(eventito);
    }
    
}

class EventoTeclado implements KeyListener{

    public void keyPressed(KeyEvent e){
        //int codigo = e.getKeyCode();
        //System.out.println(codigo);
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){
        char codigo2 = e.getKeyChar();
        System.out.println(codigo2);
    }
}

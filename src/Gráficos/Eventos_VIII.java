package Gráficos;
import javax.swing.*;
import java.awt.event.*;

public class Eventos_VIII extends JFrame implements WindowFocusListener {

    public static void main(String[] args) {

        Eventos_VIII mv = new Eventos_VIII();
        mv.iniciar();
    }

    public void iniciar(){

        marco1 = new Eventos_VIII();
        marco2 = new Eventos_VIII();
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setBounds(300, 100, 600, 350);
        marco2.setBounds(1200, 100, 600, 350);
        marco1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);

    }

    public void windowGainedFocus(WindowEvent e){
        if(e.getSource() == marco1){
            marco1.setTitle("Tengo el foco");
        }
        else{
            marco2.setTitle("Tengo el foco");
        }
    }

    
    public void windowLostFocus(WindowEvent e){
        if(e.getSource() == marco1){
            marco1.setTitle("");
        }
        else{
            marco2.setTitle("");
        }
        
    }

    Eventos_VIII marco1;
    Eventos_VIII marco2;
}

   
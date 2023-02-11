package Gráficos;

import javax.swing.*;

import java.awt.Frame;
import java.awt.event.*;

public class Eventos_IV {
    public static void main(String[] args) {

        marcodedibujitos marcodedibujitos2 = new marcodedibujitos();
        marcodedibujitos2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcodedibujitos extends JFrame{

    public marcodedibujitos(){

        setVisible(true);
        setBounds(300, 100, 400, 500);
        setTitle("EVENTO VENTANA IV");

        cambioestado cambioestado2 = new cambioestado();
        addWindowStateListener(cambioestado2);
    }
}

class cambioestado implements WindowStateListener{

    public void windowStateChanged(WindowEvent e){
        //System.out.println("La ventana ha cambiado de estado");
        //System.out.println(e.getNewState());

        if(e.getNewState()==Frame.MAXIMIZED_BOTH){
            System.out.println("La ventana está a pantalla completa");
        }
        else if(e.getNewState()==Frame.NORMAL){
            System.out.println("La ventana está normal");
        }
        else if(e.getNewState()==Frame.ICONIFIED){
            System.out.println("La ventana está minimizada");
        }
    }
}

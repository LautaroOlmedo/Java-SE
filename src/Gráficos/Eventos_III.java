package Gráficos;

import javax.swing.*;
import java.awt.event.*;

public class Eventos_III {

    public static void main(String[] args) {

        marcodeventana marcodeventana2 = new marcodeventana();
        marcodeventana2.setTitle("FRAME I");
        marcodeventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marcodeventana marcodeventana3 = new marcodeventana();
        marcodeventana3.setTitle("FRAME II");
        marcodeventana3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }
}

class marcodeventana extends JFrame{

    marcodeventana(){
        setVisible(true);
        //setTitle("Eventos de ventana I");
        setBounds(300, 400, 300, 450);
        setResizable(true);
        M_Ventana oyente = new M_Ventana();

        addWindowListener(oyente);
    }
}

class M_Ventana extends WindowAdapter{

    public void windowIconified(WindowEvent e){
        
        System.out.println("Ventana minimizada");
    }
}

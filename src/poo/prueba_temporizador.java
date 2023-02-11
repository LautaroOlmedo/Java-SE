package poo;
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class prueba_temporizador{

    public static void main(String[] args) {

        damelahora oyente = new damelahora();

        Timer mitemporizador = new Timer(5000, oyente);

        mitemporizador.start();
        JOptionPane.showMessageDialog(null, "pulsa aceptar para detener");
    }   
}

class damelahora implements ActionListener{

    public void actionPerformed(ActionEvent e){
        Date ahora = new Date();
        System.out.println("La hora cada 5 segundos es; " + ahora);
        Toolkit.getDefaultToolkit().beep();
        //System.exit(0);
    }
    
}




package Gráficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos_I {

    public static void main(String[] args) {

        miMarco miMarco1 = new miMarco();
        //miMarco1.setVisible(true);
        //miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//PARA TERMINAR EL PROGRAMA CUANDO SE CIERRA LA VENTANA
        //EXIT_ON_CLOSE ES UN VALOR NUMERICO POR ESO EL METODO NOS PIDE UN INT Y JFRAME. PORQUE EXIT_ON_CLOSE ES UNA CONSTANTE ESTÁTICA

        //miMarco1.setLocation(500,300);


    }

    
}

class miMarco extends JFrame{

    public miMarco(){

        setVisible(true);
        setBounds(500, 300, 250, 250);
        setTitle("Arriba la vagancia");
        //setExtendedState(Frame.MAXIMIZED_BOTH); MAXIMIZA A PAMTALLA COMPLETA LA VENTANA

        //setResizable(false); PARA PERMITIR SI SE PUEDE AMPLEAR O NO LA VENTANA 
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//PARA TERMINAR EL PROGRAMA CUANDO SE CIERRA LA VENTANA
    }

    private int ancho;
    private int largo;
    private boolean visible;
}


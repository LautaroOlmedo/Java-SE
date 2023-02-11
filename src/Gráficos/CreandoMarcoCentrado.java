package Gráficos;

import java.awt.Toolkit;
import java.util.MissingFormatWidthException;

import javax.swing.*;
import java.awt.*;



public class CreandoMarcoCentrado {

    public static void main(String[] args) {
    
    MarcoCentrado mimoco = new MarcoCentrado();

    mimoco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mimoco.setVisible(true);


    }
    
    
}

class MarcoCentrado extends JFrame{

    public MarcoCentrado(){

        Toolkit mipantalla = Toolkit.getDefaultToolkit(); //ALMACENAMOS EN LA VARIABLE EL SISTEMA NAVITO DE VENTANAS (MONITOR)

        Dimension tamanoPantalla = mipantalla.getScreenSize(); // ALMACENAMOS DENTRO DE TAMANOPANTALLA LA RESOLUCIÓN DE PANTALLA

        int alturapantalla = tamanoPantalla.height;
        int anchopantalla = tamanoPantalla.width;

        setSize(anchopantalla/2, alturapantalla/2);
        setLocation(anchopantalla/4, alturapantalla/4);
        setTitle("Lautaro Olmedo");
        //Image miIcono= mipantalla.getImage("icono.gif"); //ALMACENA EN LA VARIABLE miIcono EL ICONO DE LA PANTALLA
        //setIconImage(miIcono); //CAMBIA EL ICONO DE LA PANTALLA


    }

   
    


}

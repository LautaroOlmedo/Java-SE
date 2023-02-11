package Gráficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoenMarco {

    public static void main(String[] args) {

        MarcoConTexto miMARCOCONTEXTO = new MarcoConTexto();
        miMARCOCONTEXTO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        


    }

    
}

class MarcoConTexto extends JFrame{

    public MarcoConTexto(){

        setVisible(true);
        setTitle("Primer Frame con texto en lámina");
         setSize(600, 450);
         setLocation(400, 200);
         lamina milamina = new lamina();

         add(milamina);

    }

}

class lamina extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawString("Estamos aprendiendo swing",3 , 12);

    }

}

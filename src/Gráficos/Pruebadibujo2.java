package Gráficos;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;

public class Pruebadibujo2 {
    public static void main(String[] args) {
    mimarcO mimarcO2 = new mimarcO();
    mimarcO2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
}

class mimarcO extends JFrame{

    public mimarcO(){
        setVisible(true);
        setTitle("EL NOBA");
        setSize(400, 300);
    
        milaminita milaminita2 = new milaminita();
        add(milaminita2);
    }
    
}

class milaminita extends JPanel{

    public void paintComponent(Graphics z){
        super.paintComponent(z);
        File miimagen = new File("src/Gráficos/descarga.png");
        try{
            imagen=ImageIO.read(miimagen);
        }
        catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }
        z.drawImage(imagen,5, 5, null);
        Graphics2D z2 = (Graphics2D) z;
        Rectangle2D rectangulito = new Rectangle2D.Double(100, 100, 200, 150);
        z2.draw(rectangulito);

        Ellipse2D elipsita = new Ellipse2D.Double();
        elipsita.setFrame(rectangulito);
        z2.draw(elipsita);
        z2.setPaint(Color.BLUE);
    }
    private Image imagen;
}


    

    


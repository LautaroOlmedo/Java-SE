package Gráficos;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;

public class Pruebadibujo {
    public static void main(String[] args) {
        marcocondibujos mimarcocondibujos = new marcocondibujos();
        mimarcocondibujos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
class marcocondibujos extends JFrame{

    public marcocondibujos(){
        setVisible(true);
        setTitle("gallo cabeza de oruga");
        setSize(400, 400);
        milaminaconfiguras milaminaconfiguras2 = new milaminaconfiguras();
        add(milaminaconfiguras2);
        setLocationRelativeTo(null);
    }
}
class milaminaconfiguras extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        File miimagen = new File("src/Gráficos/descarga.png");
        try{
            imagen=ImageIO.read(miimagen);
        }
        catch(IOException e){
            System.out.println("La imagen no se encuentra");
        }
        g.drawImage(imagen,5, 5, null);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.setPaint(new ColorUIResource(250, 100, 35));

        g2.draw(rectangulo);
        
        Ellipse2D elipse = new Ellipse2D.Double();
        g2.setPaint(Color.BLUE);

        elipse.setFrame(rectangulo);

        g2.draw(elipse);  

        g2.draw(new Line2D.Double(100,100, 300, 250));

        Double centroenx = rectangulo.getCenterX(); //ALMACENAMOS EN LAS VARIABLES EL CENTRO DEL RECTANGULO
        Double centroeny = rectangulo.getCenterY();

        double radio = 150;

        Ellipse2D Circulo = new Ellipse2D.Double();
        g2.setPaint(new ColorUIResource(240, 235, 176));

        Circulo.setFrameFromCenter(centroenx, centroeny, centroenx + radio, centroeny + radio);

        g2.draw(Circulo);

    }

    private Image imagen;
}

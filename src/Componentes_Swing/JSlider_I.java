package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;


public class JSlider_I {
    public static void main(String[] args) {

    Marco_1 marco = new Marco_1();
    marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class Marco_1 extends JFrame{

    public Marco_1(){

        setVisible(true);
        setTitle("JSlider I");
        setSize(500, 450);
        setLocationRelativeTo(null);

        Lamina_1 lamina = new Lamina_1();
        add(lamina);
    }
}

class Lamina_1 extends JPanel{

    public Lamina_1(){

        JSlider control = new JSlider(0, 100, 50);

        control.setMajorTickSpacing(25);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);
        control.setPaintLabels(true);

        add(control);

    }
}


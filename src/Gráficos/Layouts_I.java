package Gráficos;
import javax.swing.*;
import java.awt.FlowLayout;


public class Layouts_I{
    public static void main(String[] args) {

        marcolayout marcolayout = new marcolayout();
        marcolayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcolayout extends JFrame{

    public marcolayout(){
        setVisible(true);
        setTitle("Layouts I");
        setLocationRelativeTo(null);
        setSize(350, 250);

        laminalayout laminaoyente = new laminalayout();
        add(laminaoyente);

        FlowLayout disposicion = new FlowLayout(FlowLayout.CENTER, 15, 50); // INSTANCIAMOS LA VARIABLE DISPOSICIÓN PERTENECIENTE A LA CLASE FLOWLAYOUT
        laminaoyente.setLayout(disposicion); // ESTABLECEMOS LA DISPOSICIÓN DENTRO DE LA LÁMINA
    }
}

class laminalayout extends JPanel{

    public laminalayout(){
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 2");

        add(boton1);
        add(boton2);
        add(boton3);
    }

}


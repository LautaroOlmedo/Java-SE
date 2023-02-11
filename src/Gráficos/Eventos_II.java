package Gráficos;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class Eventos_II {

    public static void main(String[] args) {

        marcoski marcoski2 = new marcoski();
        marcoski2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}

class marcoski extends JFrame{

    public marcoski(){
        setVisible(true);
        setTitle("Cambio de color forma 2");
        setBounds(300, 400, 300, 450);

        laminoski laminiski2 = new laminoski();
        add(laminiski2);
    }
}

class laminoski extends JPanel{

    JButton botonAzul = new JButton("Azul");
    JButton botonRojo = new JButton("Rojo");
    JButton botonVerde = new JButton("Verde");

    public laminoski(){

        add(botonAzul);
        add(botonRojo);
        add(botonVerde);
        
        colorfondo Azul = new colorfondo(Color.BLUE);
        colorfondo Rojo = new colorfondo(Color.RED);
        colorfondo Verde = new colorfondo(Color.GREEN);

        botonAzul.addActionListener(Azul);
        botonRojo.addActionListener(Rojo);
        botonVerde.addActionListener(Verde);
    }

    private class colorfondo implements ActionListener{

        public colorfondo(Color c){
    
            colorDEFONFO = c;
        }
    
        public void actionPerformed(ActionEvent e){
            setBackground(colorDEFONFO);
        }
    
        private Color colorDEFONFO;
    }
}



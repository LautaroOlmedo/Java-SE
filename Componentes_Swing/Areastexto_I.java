package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;

public class Areastexto_I {
    public static void main(String[] args) {

        Marcotexto marco = new Marcotexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class Marcotexto extends JFrame{

    public Marcotexto(){
        
        setVisible(true);
        setTitle("Areas de texto I");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Laminatexto lamina = new Laminatexto();
        add(lamina);
    }

}

class Laminatexto extends JPanel{

    public Laminatexto(){

        miarea = new JTextArea(8,20);
        
        laminabarra = new JScrollPane(miarea); // CREAMOS UNA LAMINA PARA QUE EL JTEXTAREA TENGA UNA BARRA Y NO CREZCA LA ZONA DE AREA
        miarea.setLineWrap(true);
        add(laminabarra);

        JButton boton = new JButton("Dale");
        boton.addActionListener(new Gestionarea());
        add(boton);

    }

    private class Gestionarea implements ActionListener{

        public void actionPerformed(ActionEvent e){

            System.out.println(miarea.getText());
        }
    }

    private JScrollPane laminabarra;
    JTextArea miarea;
}

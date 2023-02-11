package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class CheckBox_III {
    public static void main(String[] args) {

        Marco_Check2 marco = new Marco_Check2();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    

}

class Marco_Check2 extends JFrame{

    public Marco_Check2(){

        setVisible(true);
        setTitle("CHECK BOX III");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_Check2 laminacheck = new Lamina_Check2();
        add(laminacheck);

    }
}

class Lamina_Check2 extends JPanel{

    public Lamina_Check2(){

        setLayout(new BorderLayout());
        texto = new JLabel("La banda del expreso ya llegó");
        texto.setFont(new Font("Serif", Font.PLAIN, 12));
        add(texto, BorderLayout.CENTER);

        CreaBotones("Pequeño", false, 10);
        CreaBotones("Mediano", true, 15);
        CreaBotones("Grande", false, 20);
        CreaBotones("Muy Grande", false, 28);


        migrupo = new ButtonGroup();
        lamina = new JPanel();
        add(lamina, BorderLayout.SOUTH);
    }

    public void CreaBotones(String nombre, boolean foco, final int tamano){

        JRadioButton boton = new JRadioButton(nombre, foco);

        migrupo.add(boton);
        lamina.add(boton);

        ActionListener oyente = new ActionListener(){

            public void actionPerformed(ActionEvent e){

                texto.setFont(new Font("Serif", Font.PLAIN, tamano));

            }
        };

        boton.addActionListener(oyente);

    }

    private JLabel texto;
    private JPanel lamina;
    private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup migrupo;
}

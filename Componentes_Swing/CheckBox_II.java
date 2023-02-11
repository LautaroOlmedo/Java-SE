package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class CheckBox_II {

    public static void main(String[] args) {

        Marco_Check marco = new Marco_Check();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marco_Check extends JFrame{

    public Marco_Check(){

        
        setVisible(true);
        setTitle("CHECK BOX II");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_Check lamina = new Lamina_Check();
        add(lamina);

        
        

    }
}

class Lamina_Check extends JPanel{

    public Lamina_Check(){

        setLayout(new BorderLayout());

        texto = new JLabel("La banda del expreso ya llegó...");
        add(texto, BorderLayout.CENTER);

        ButtonGroup migrupo = new ButtonGroup();

        boton1 = new JRadioButton("Pequeño", false);
        boton2 = new JRadioButton("Mediano", true);
        boton3 = new JRadioButton("Grande", false);
        boton4 = new JRadioButton("Muy grande", false);

        Evento_Radio mievento = new Evento_Radio();

        boton1.addActionListener(mievento);
        boton2.addActionListener(mievento);
        boton3.addActionListener(mievento);
        boton4.addActionListener(mievento);

        JPanel laminaradio = new JPanel();
        migrupo.add(boton1);
        migrupo.add(boton2);
        migrupo.add(boton3);
        migrupo.add(boton4);

        laminaradio.add(boton1);
        laminaradio.add(boton2);
        laminaradio.add(boton3);
        laminaradio.add(boton4);

        add(laminaradio, BorderLayout.SOUTH);
    }

    private class Evento_Radio implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == boton1){

                texto.setFont(new Font("Serif", Font.PLAIN, 10));
            }else if(e.getSource() == boton2){

                texto.setFont(new Font("Serif", Font.PLAIN, 12));
            }else if(e.getSource() == boton3){

                texto.setFont(new Font("Serif", Font.PLAIN, 18));
            }else if(e.getSource() == boton4){

                texto.setFont(new Font("Serif", Font.PLAIN, 24));
            }
        }
    }
    
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;
}

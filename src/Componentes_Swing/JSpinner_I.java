package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;

public class JSpinner_I {

    public static void main(String[] args) {

        Marco_JSpinner marco = new Marco_JSpinner();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marco_JSpinner extends JFrame{

    public Marco_JSpinner(){

        setVisible(true);
        setTitle("JSpinner I");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_JSpinner lamina = new Lamina_JSpinner();
        add(lamina);
    }
}

class Lamina_JSpinner extends JPanel{

    public Lamina_JSpinner(){

        setLayout(new FlowLayout());

        model = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1){ // ACÁ APLICAMOS CLASE INTERNA ANÓNIMA

            public Object getNextValue(){

                return super.getPreviousValue();
            }
    
            public Object getPreviousValue(){
    
                return super.getNextValue();
            }
        });

        Dimension d = new Dimension(75, 20);
        model.setPreferredSize(d);

        add(model);   
    }

    private JSpinner model;
    
}


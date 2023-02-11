package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.event.*;

public class JSlider_II {

    public static void main(String[] args) {

        Marco_JSlider marco = new Marco_JSlider();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marco_JSlider extends JFrame{

    public Marco_JSlider(){

        setVisible(true);
        setTitle("JSlider II");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_JSlider lamina = new Lamina_JSlider();
        add(lamina);
    }
}

class Lamina_JSlider extends JPanel{

    public Lamina_JSlider(){

        setLayout(new BorderLayout());
        rotulo = new JLabel("La banda del expreso ya llegó...");
        add(rotulo, BorderLayout.CENTER);

        control = new JSlider(8, 50, 12);
        control.setMajorTickSpacing(20);
        control.setMinorTickSpacing(5);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.ITALIC, 10));

        control.addChangeListener(new Evento_JSlider());

        lamina2 = new JPanel();
        lamina2.add(control);

        add(lamina2, BorderLayout.NORTH);
    }

    class Evento_JSlider implements ChangeListener{

        public void stateChanged(ChangeEvent e){

            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));

        }
    }

    private JLabel rotulo;
    private JSlider control;
    private JPanel lamina2;
}

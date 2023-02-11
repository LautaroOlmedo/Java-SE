package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class ComboBox_I {

    public static void main(String[] args) {

        MarcoCombo marco = new MarcoCombo();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoCombo extends JFrame{

    public MarcoCombo(){

        setVisible(true);
        setTitle("COMBO BOX I");
        setSize(500, 450);
        setLocationRelativeTo(null);

        LaminaCombo lamina = new LaminaCombo();
        add(lamina);
    }
}

class LaminaCombo extends JPanel{

    public LaminaCombo(){

        setLayout(new BorderLayout());
        texto = new JLabel("La banda del expreso ya llegó...");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        add(texto, BorderLayout.CENTER);
        laminanorte = new JPanel();

        micombo = new JComboBox();
        micombo.setEditable(true);
        micombo.addItem("Serif");
        micombo.addItem("SansSerif");
        micombo.addItem("Monospaced");
        micombo.addItem("Dialog");
        EventoCombo mievento = new EventoCombo();
        micombo.addActionListener(mievento);
        laminanorte.add(micombo);
        add(laminanorte, BorderLayout.NORTH);

    }

    private class EventoCombo implements ActionListener{

        public void actionPerformed(ActionEvent e){

            texto.setFont(new Font((String)micombo.getSelectedItem(), Font.PLAIN, 18)); // CAMBIA LA FUENTE DE LA LETRA A LA QUE SE SELECCIONE EN EL COMBOBOX. UTILIZAMOS UN CASTING DE OBJECT A STRING
        }
    }

    private JLabel texto;
    private JComboBox micombo;
    private JPanel laminanorte;
}

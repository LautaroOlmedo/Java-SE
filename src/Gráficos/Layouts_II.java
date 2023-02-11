package Gráficos;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class Layouts_II {
    
    public static void main(String[] args) {

        marco_layout marco = new marco_layout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

} 

class marco_layout extends JFrame{

    public marco_layout(){
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("LAYOUTS II");
        setSize(450, 300);


        panellayout panelito = new panellayout();
        add(panelito, BorderLayout.NORTH);

        panellayout2 panelito2 = new panellayout2();
        add(panelito2, BorderLayout.SOUTH);
    }
}

class panellayout extends JPanel{

    public panellayout(){

        setLayout(new BorderLayout());
        add(new JButton("Amarillo"), BorderLayout.WEST);
        add(new JButton("Azul"), BorderLayout.CENTER);
        add(new JButton("Rojo"), BorderLayout.EAST);

    }
}

class panellayout2 extends JPanel{

    public panellayout2(){

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Turqueza"));
        add(new JButton("Marron"));
    }
}

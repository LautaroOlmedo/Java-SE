package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class CheckBox_I {
    public static void main(String[] args) {

        Marco marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    } 
}

class Marco extends JFrame{

    public Marco(){
        
        setVisible(true);
        setTitle("CHECK BOX I");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina lamina = new Lamina();
        add(lamina);



    }
}

class Lamina extends JPanel{

    Lamina(){

        setLayout(new BorderLayout());

        Font miletra = new Font("Serif", Font.PLAIN, 24);

        texto = new JLabel("La banda del Expreso ya llego..");
        texto.setFont(miletra);
        JPanel laminatexto = new JPanel();
        laminatexto.add(texto);
        add(laminatexto, BorderLayout.CENTER);

        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");

        check1.addActionListener(new manejachecks());
        check2.addActionListener(new manejachecks());

        JPanel laminachecks = new JPanel();
        laminachecks.add(check1);
        laminachecks.add(check2);
        add(laminachecks, BorderLayout.SOUTH);

    }

    private class manejachecks implements ActionListener{

        public void actionPerformed(ActionEvent e) {

            int tipo = 0;

            if(check1.isSelected()) tipo += Font.BOLD; // SI ESTA SELECIONADO CHECK 1 AUMENTA LA VARIABLE TIPO EN 1 QUE ES EL VALOR DE LA CONSTANTE BOLD BOLD = PONER EN NEGRITO
            if(check2.isSelected()) tipo += Font.ITALIC; // MISMA HISTORIA QUE ARRIBA SOLO QUE CON ITALIC QUE VALE 2 

            texto.setFont(new Font("Serif", tipo, 24)); // SI ESTÁN LAS DOS ACTIVADAS SUMAN 3 Y SE CUMPLEN LAS DOS CONDICIONES 
            
            
        }

    }

    private JLabel texto;
    private JCheckBox check1, check2;
}

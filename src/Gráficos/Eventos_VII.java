package Gráficos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Eventos_VII {
    public static void main(String[] args) {
        marcodefoco1 marcodefoco = new marcodefoco1();
        marcodefoco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}

class marcodefoco1 extends JFrame{

    public marcodefoco1(){
        setTitle("EVENTOS DE FOCO I");
        setVisible(true);
        setSize(600, 450); 
        setLocationRelativeTo(null);

        laminadefoco1 laminadefoco = new laminadefoco1();
        add(laminadefoco);
    }

}

class laminadefoco1 extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setLayout(null);
        cuadro1 = new JTextField();
        cuadro2 = new JTextField();
        cuadro1.setBounds(120, 10, 150, 20);
        cuadro2.setBounds(120, 50, 150, 20);
        add(cuadro1);
        add(cuadro2);

        LanzaFocos elfoco = new LanzaFocos();
        cuadro1.addFocusListener(elfoco);

    }
    JTextField cuadro1;
    JTextField cuadro2;

    private class LanzaFocos implements FocusListener{

        public void focusGained(FocusEvent e){

        }

        public void focusLost(FocusEvent e){

            String email = cuadro1.getText();
            boolean comprobacion = false;

            for(int i=0; i<email.length(); i++){

                if(email.charAt(i) == '@'){
                    comprobacion = true;

                }
            }
            if(comprobacion){
                System.out.println("Correcto");
            }
            else{
                System.out.println("Incorrecto");
            }

        }
    }
}



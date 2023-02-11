package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class Cuadrodetexto_I {

    public static void main(String[] args) {

        marcocuadrotexto cuadro = new marcocuadrotexto();
        cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class marcocuadrotexto extends JFrame{

    public marcocuadrotexto(){
        setVisible(true);
        setTitle("Cuadros de texto I");
        setLocationRelativeTo(null);
        setSize(450, 300);

        laminacuadrotexto lamina = new laminacuadrotexto();
        add(lamina);
    }
}

class laminacuadrotexto extends JPanel{

    public laminacuadrotexto(){

        setLayout(new BorderLayout());
        JPanel laminacuadrotexto2 = new JPanel();
        laminacuadrotexto2.setLayout(new FlowLayout());

        resultado = new JLabel("", JLabel.CENTER);
        JLabel Texto1 = new JLabel("Email: "); // CREA ETIQUETAS 
        laminacuadrotexto2.add(Texto1);
        campo1 = new JTextField(20);
        laminacuadrotexto2.add(campo1);
        add(resultado, BorderLayout.CENTER);
        // System.out.println(campo1.getText().trim()); // TRIM() QUITA LOS ESPACIOS ADICIONALES 
        JButton miboton = new JButton("Comprobar");
        
        DameTexto evento = new DameTexto();
        miboton.addActionListener(evento);
        laminacuadrotexto2.add(miboton);
        add(laminacuadrotexto2, BorderLayout.NORTH);
    }

    private class DameTexto implements ActionListener{

        public void actionPerformed(ActionEvent e){

            int correcto = 0;
            String email = campo1.getText().trim();
    
            for(int i = 0; i < email.length(); i++){

                if(email.charAt(i) == '@'){
                    correcto++;
                }
                
            }
            if(correcto == 1 & email.charAt(0) != '.'){ 

                resultado.setText("Correcto");
            }
            else{
                resultado.setText("Incorrecto");
            }  
        }
    }
    private JTextField campo1;
    private JLabel resultado;
}



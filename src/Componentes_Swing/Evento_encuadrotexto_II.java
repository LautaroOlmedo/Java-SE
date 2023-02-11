package Componentes_Swing;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class Evento_encuadrotexto_II {


    public static void main(String[] args) {

        marcotexto marco = new marcotexto();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marcotexto extends JFrame{

    public marcotexto(){

        setVisible(true);
        setTitle("Eventos en cuadro de texto I");
        setLocationRelativeTo(null);
        setSize(500, 450);
        
        laminatexto lamina = new laminatexto();
        add(lamina);
    }
}

class laminatexto extends JPanel{

    public laminatexto(){

        setLayout(new BorderLayout());

        laminasuperior = new JPanel();
        laminasuperior.setLayout(new GridLayout(2,2));
        add(laminasuperior, BorderLayout.NORTH);
        JLabel etiqueta1 = new JLabel("Usuario:");
        JLabel etiqueta2 = new JLabel("Contraseña:");
        EscuchaTexto mievento = new EscuchaTexto();
        JTextField c_usuario = new JTextField(15);
        c_contra = new JPasswordField(15); // CREA UN CUADRO DE TEXTO TIPO CONTRASEÑA
        c_contra.getDocument().addDocumentListener(mievento);
        laminasuperior.add(etiqueta1);
        laminasuperior.add(c_usuario);
        laminasuperior.add(etiqueta2);
        laminasuperior.add(c_contra);
        

        JButton enviar = new JButton("Enviar");
        add(enviar,BorderLayout.SOUTH); 
    }

    private class EscuchaTexto extends JPanel implements DocumentListener{

        public void changedUpdate(DocumentEvent e){

        }
        public void insertUpdate(DocumentEvent e){

            char [] contrasena;
            contrasena = c_contra.getPassword();
            
            if(contrasena.length < 8 || contrasena.length > 12){

                c_contra.setBackground(Color.RED);
            }
            else{
                c_contra.setBackground(Color.WHITE);
            }
        }
        public void removeUpdate(DocumentEvent e){

            char [] contrasena;
            contrasena = c_contra.getPassword();
            
            if(contrasena.length < 8 || contrasena.length > 12){

                c_contra.setBackground(Color.RED);

            }
            else{
                c_contra.setBackground(Color.WHITE);
            }
        }
    }

    private JPasswordField c_contra;
    private JPanel laminasuperior;  
}

    


package Componentes_Swing;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Evento_encuaxdrotexto_I {

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

        JTextField campo1 = new JTextField(20);
        EscuchaTexto el_evento = new EscuchaTexto();
        Document mi_doc = campo1.getDocument(); // CREAMOS UNA VARIABLE PERTENECIENTE A DOCUMENT EN LA CUAL SE VA A CREAR UNA COPIA DE LO QUE ESCRIBAMOS/BORRAMOS O CAMBIAMOS EN EL CUADRO JTEXT
        add(campo1);
        mi_doc.addDocumentListener(el_evento);
    }

    private class EscuchaTexto implements DocumentListener{

        public void changedUpdate(DocumentEvent e){

        }
        public void insertUpdate(DocumentEvent e){

            System.out.println("Haz insertado texto");

        }
        public void removeUpdate(DocumentEvent e){

            System.out.println("Haz borrado texto");

        }

    }
}

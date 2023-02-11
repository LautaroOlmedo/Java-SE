package Gráficos;
import javax.swing.*;
import java.awt.event.*;

public class Eventos_X {
    public static void main(String[] args) {

        marcoX marcox = new marcoX();
        marcox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class marcoX extends JFrame{

    public marcoX(){
        setVisible(true);
        setTitle("EVENTOS X");
        setLocationRelativeTo(null);
        setSize(600, 300);
        laminaX laminax = new laminaX();
        add(laminax);
    }

    
}

class laminaX extends JPanel{

    public laminaX(){

        JButton Nuevo = new JButton("Nuevo");
        
        add(Nuevo);
        add(Cerrar_todo);

        oyenteX oyenteX = new oyenteX();
        Nuevo.addActionListener(oyenteX);
    }
    JButton Cerrar_todo = new JButton("Cerrar todo"); // INSTANCIAMOS ESTE BOTON AFUERA DEL CONSTRUCTOR PORQUE UTILIZAREMOS EL NOMBRE DE INSTANCIA EN OTROS MÉTODOS

    private class oyenteX implements ActionListener{

        public void actionPerformed(ActionEvent e){

            Marcoemergente marcoo= new Marcoemergente(Cerrar_todo);
            marcoo.setVisible(true);

        }

    }
}

class Marcoemergente extends JFrame{

    public Marcoemergente(JButton boton_principal){

        contador ++;
        setTitle("Ventana" + contador);
        setBounds(40 * contador, 40 * contador, 300, 150); // ABRE LOS FRAMES EN DISTINTAS POSICIONES
        cierratodos oyentecerrar = new cierratodos();
        boton_principal.addActionListener(oyentecerrar);

    }
    private static int contador = 0; // VARIABLE ESTÁTICA QUE COMPARTEN LOS MARCOS
    
    private class cierratodos implements ActionListener{

        public void actionPerformed(ActionEvent e){

            dispose();

        }
    }
}





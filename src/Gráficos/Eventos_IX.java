package Gráficos;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Eventos_IX {

    public static void main(String[] args) {

        marcodemultiplesfuentes marcote = new marcodemultiplesfuentes();
        marcote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class marcodemultiplesfuentes extends JFrame{

    public marcodemultiplesfuentes(){
        setTitle("EVENTOS MULTIPLES FUENTES I");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600, 300);

        laminademultiplesfuentes laminita = new laminademultiplesfuentes();
        add(laminita);
    }

}

class laminademultiplesfuentes extends JPanel{

    public laminademultiplesfuentes(){

        ActionColor ActionAzul = new ActionColor("Azul", Color.BLUE);
        ActionColor ActionRojo = new ActionColor("Rojo", Color.RED);
        ActionColor ActionVerde = new ActionColor("Verde", Color.GREEN);

        add(new JButton(ActionAzul)); //CREACION DE BOTON CON CÓDIGO SIMPLIFICADO
        add(new JButton(ActionRojo));//ESTOS BOTON LLEVA ASOCIADO EL NOMBRE DEL BOTON, EL COLOR Y LA ACCION ASOCIADA
        add(new JButton(ActionVerde));

        InputMap mapaEntrada = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT); // PASO 1
        

        KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl A"); // PASO 2
        mapaEntrada.put(teclaAzul, "fondo_azul"); // PASO 3
        ActionMap mapaAccion = getActionMap(); // PASO 4
        mapaAccion.put("fondo_azul", ActionAzul);


        KeyStroke teclaRoja = KeyStroke.getKeyStroke("ctrl R");
        mapaEntrada.put(teclaRoja, "fondo_rojo");
        mapaAccion.put("fondo_rojo", ActionRojo);


        KeyStroke teclaVerde = KeyStroke.getKeyStroke("ctrl T");
        mapaEntrada.put(teclaVerde, "fondo_verde");
        mapaAccion.put("fondo_verde", ActionVerde);

        
    }
    private class ActionColor extends AbstractAction{

        public ActionColor(String nombre, Color color_boton){
            putValue(Action.NAME, nombre); //CUANDO INSTANCIEMOS LA CLASE LA VARIABLE NOMBRE SE ALMACENA CON PUTVALUE EN FORMATO CLAVE/VALOR SIENDO NOMBRE LA CLAVE
            //putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
            putValue("Color_de_fondo", color_boton);
    
        }
    
        public void actionPerformed(ActionEvent e){
    
            Color c = (Color)getValue("Color_de_fondo"); //PERMITE RESCATAR DEL OBJETO DEL EVENTO EL VALOR CORRESPONDIENTE A UNA CLAVE
            setBackground(c);

            System.out.println("Nombre: " + getValue(Action.NAME) +"\nDescipcion: " + getValue(Action.SHORT_DESCRIPTION));
    
        }
    }
}


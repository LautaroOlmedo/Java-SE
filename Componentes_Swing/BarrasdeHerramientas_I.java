package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class BarrasdeHerramientas_I {
    public static void main(String[] args) {
        marcodemultiplesfuentes2 marcote2 = new marcodemultiplesfuentes2();
        marcote2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}

class marcodemultiplesfuentes2 extends JFrame{

    public marcodemultiplesfuentes2(){
        setTitle("EVENTOS MULTIPLES FUENTES I");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(600, 300);
        lamina = new JPanel();
        add(lamina);

        ActionColor ActionAzul = new ActionColor("Azul", Color.BLUE);
        ActionColor ActionRojo = new ActionColor("Rojo", Color.RED);
        ActionColor ActionVerde = new ActionColor("Verde", Color.GREEN);
        Action accionsalir = new AbstractAction("Salir"){

            public void actionPerformed(ActionEvent e) {
                System.exit(0); // SALE DE LA APLICACION CLIQUEANDO EN EL BOTON SALIR
                
            }
        };
        JMenu menu = new JMenu("Color");
        menu.add(ActionAzul);
        menu.add(ActionRojo);
        menu.add(ActionVerde);
        

        JMenuBar barramenu = new JMenuBar();

        barramenu.add(menu);

        setJMenuBar(barramenu); // SETJMENUBAR PERMITE AGREGAR UNA BARRA DE MENU DIRECTAMENTE AL MARCO

        // CREACIÓN DE BARRA DE HERRAMIENTAS
        JToolBar barra = new JToolBar();
        barra.add(ActionAzul);
        barra.add(ActionRojo);
        barra.add(ActionVerde);
        barra.addSeparator();
        barra.add(accionsalir);
        add(barra, BorderLayout.NORTH); // AL ESPECIFICARLE UN BORDER LAYOUT PERMITIMOS QUE LA BARRA SE PUEDA DESPLAZAR
    }
    private class ActionColor extends AbstractAction{

        public ActionColor(String nombre, Color color_boton){
            putValue(Action.NAME, nombre); //CUANDO INSTANCIEMOS LA CLASE LA VARIABLE NOMBRE SE ALMACENA CON PUTVALUE EN FORMATO CLAVE/VALOR SIENDO NOMBRE LA CLAVE
            //putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre); // DESCRIPCIÓN DE LA ACCIÓN
            putValue("Color_de_fondo", color_boton); // QUE ES LO QUE HACE ESTA ACCIÓN
    
        }
    
        public void actionPerformed(ActionEvent e){
    
            Color c = (Color)getValue("Color_de_fondo"); //PERMITE RESCATAR DEL OBJETO DEL EVENTO EL VALOR CORRESPONDIENTE A UNA CLAVE
            lamina.setBackground(c);

            System.out.println("Nombre: " + getValue(Action.NAME) +"\nDescipcion: " + getValue(Action.SHORT_DESCRIPTION));
    
        }
    }
    JPanel lamina;
}

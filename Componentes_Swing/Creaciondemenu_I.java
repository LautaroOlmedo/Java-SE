package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;

public class Creaciondemenu_I {

    public static void main(String[] args) {

        Marco_Menu marco = new Marco_Menu();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class Marco_Menu extends JFrame{
    Marco_Menu(){

        setVisible(true);
        setTitle("CREACIÓN DE MENU I");
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_Menu lamina = new Lamina_Menu();
        add(lamina);
    }
}

class Lamina_Menu extends JPanel{

    public Lamina_Menu(){

        JMenuBar mibarra = new JMenuBar();

        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones");

        JMenuItem guardar1 = new JMenuItem("Guardar");
        JMenuItem guardar2 = new JMenuItem("Guardar Como");
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("Pegar");
        JMenuItem generales = new JMenuItem("Generales");
        JMenuItem opcion1 = new JMenuItem("Opcion 1");
        JMenuItem opcion2 = new JMenuItem("Opcion 2");

        archivo.add(guardar1);
        archivo.add(guardar2);
        edicion.add(copiar);
        edicion.add(cortar);
        edicion.add(pegar);

        edicion.addSeparator();
        
        herramientas.add(generales);
        opciones.add(opcion1);
        opciones.add(opcion2);
        edicion.add(opciones); // EDICION AGREGA A OPCIONES PARA QUE OPCIONES CUELGUE DE EL 

        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);

        add(mibarra);
    }
}

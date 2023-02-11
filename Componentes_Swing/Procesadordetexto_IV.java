package Componentes_Swing;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.text.*;

public class Procesadordetexto_IV {
    public static void main(String[] args) {

        Marco_DOS marco = new Marco_DOS();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class Marco_DOS extends JFrame{

    public Marco_DOS(){

        setVisible(true);
        setTitle("PROCESADOR DE LAUTARO");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_DOS lamina = new Lamina_DOS();
        add(lamina);
    }
}

class Lamina_DOS extends JPanel{

    public Lamina_DOS(){

        setLayout(new BorderLayout());
        laminamenu = new JPanel();
        area = new JTextPane();
        barra = new JMenuBar();
        // ---------------------------------------------

        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");
        // ---------------------------------------------

        CreacionMenu("Arial", "Fuente", "Arial", 10, 9);
        CreacionMenu("Courier", "Fuente", "Courier", 10, 9);
        CreacionMenu("Verdana", "Fuente", "Verdana", 10, 9);
        // ---------------------------------------------

        CreacionMenu("Negrita", "Estilo", "", Font.BOLD, 9);
        CreacionMenu("Cursiva", "Estilo", "", Font.ITALIC, 9);
        // ---------------------------------------------

        CreacionMenu("14", "Tamaño", "", 10, 14);
        CreacionMenu("16", "Tamaño", "", 10, 16);
        CreacionMenu("20", "Tamaño", "", 10, 20);
        CreacionMenu("24", "Tamaño", "", 10, 24);
        // ---------------------------------------------

        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamagno);
        laminamenu.add(barra);
        add(laminamenu, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
    }

    public void CreacionMenu(String nombre, String menu, String tipo_letra, int estilos, int tam){

        if(nombre == "Arial" || nombre == "Courier" || nombre == "Verdana"){
            JRadioButtonMenuItem elemento = new JRadioButtonMenuItem(nombre);
            if(menu == "Fuente"){
                fuente.add(elemento);
                if(tipo_letra == "Arial"){
                    elemento.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
                }else if(tipo_letra == "Courier"){
                    elemento.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Courier"));
                }else{
                    elemento.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
                }
            }
        }else if(tam == 14 || tam == 16 || tam == 20 || tam == 24){

            JRadioButtonMenuItem elemento = new JRadioButtonMenuItem(nombre);
            if(menu == "Tamaño"){
                tamagno.add(elemento);
                elemento.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tam));
            }
        }else if(nombre== "Negrita" || nombre == "Cursiva"){
            JCheckBoxMenuItem elemento = new JCheckBoxMenuItem(nombre);
            if(menu == "Estilo"){
                estilo.add(elemento);
                if(estilos == Font.BOLD){
                    elemento.addActionListener(new StyledEditorKit.BoldAction());
                }else{
                    elemento.addActionListener(new StyledEditorKit.ItalicAction());
                }
            }
        }
    }
    JPanel laminamenu;
    JMenuBar barra;
    JMenu fuente, estilo, tamagno;
    JTextPane area;

}

        

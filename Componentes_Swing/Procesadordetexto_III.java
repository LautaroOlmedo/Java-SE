package Componentes_Swing;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.text.*;
import java.awt.*;


public class Procesadordetexto_III {
    public static void main(String[] args) {

        Marco_Proce marco = new Marco_Proce();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco_Proce extends JFrame{

    public Marco_Proce(){

        setVisible(true);
        setTitle("PROCESADOR DE LAUTARO");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_Proce lamina = new Lamina_Proce();
        add(lamina);
    }
}

class Lamina_Proce extends JPanel{

    public Lamina_Proce(){

        setLayout(new BorderLayout());
        laminamenu = new JPanel();
        area = new JTextPane();
        // ---------------------------------------------

        barra = new JMenuBar();
        // ---------------------------------------------

        fuente = new JMenu("fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");
        // --------------------------------------------- 

        CreaMenu("Arial", "fuente", "Arial", 9, 10);
        CreaMenu("Courier", "fuente", "Courier", 9, 10);
        CreaMenu("Verdana", "fuente", "Verdana", 9, 10);
        // --------------------------------------------- 

        CreaMenu("Negrita","estilo", "", Font.BOLD, 9);
        CreaMenu("Cursiva","estilo", "", Font.ITALIC, 9);
        // --------------------------------------------- 

        CreaMenu("14", "Tamaño", "", 9, 14);
        CreaMenu("16", "Tamaño", "", 9, 16);
        CreaMenu("20", "Tamaño", "", 9, 20);
        CreaMenu("24", "Tamaño", "", 9, 24);
        // --------------------------------------------- 

        JToolBar barra2 = new JToolBar();
        JButton negritabarra = new JButton(new ImageIcon("src/Componentes_Swing/Negrita.jpg"));
        barra2.add(negritabarra);
        // --------------------------------------------- 

        barra.add(fuente);
        barra.add(estilo);
        barra.add(tamagno);
        // --------------------------------------------- 

        laminamenu.add(barra);
        add(laminamenu, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
        add(barra2, BorderLayout.WEST);
        // --------------------------------------------- 
    }

    public void CreaMenu(String rotulo, String menu, String tipo_letra, int estilos, int tam){

        JMenuItem elem_menu = new JMenuItem(rotulo);

        if(menu == "fuente"){
            fuente.add(elem_menu);
            if(tipo_letra == "Arial"){
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Arial"));
            }else if(tipo_letra == "Courier"){
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Courier"));
            }else{
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia Letra", "Verdana"));   
            }
        }else if(menu == "estilo"){
            estilo.add(elem_menu);
            if(estilos == Font.BOLD){
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            }else{
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }else{
            tamagno.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tam));
        }
    }

    JMenuBar barra;
    JMenu fuente, estilo, tamagno;
    JPanel laminamenu;
    JTextPane area;
}

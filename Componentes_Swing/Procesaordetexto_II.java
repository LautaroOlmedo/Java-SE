package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.event.*;
import javax.swing.text.*;

public class Procesaordetexto_II {

    public static void main(String[] args) {
        

            Marco_Procesador2 marco = new Marco_Procesador2();
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    class Marco_Procesador2 extends JFrame{
    
        public Marco_Procesador2(){
    
            setVisible(true);
            setTitle("PROCESADOR DE TEXTO");
            setLocationRelativeTo(null);
            setSize(500, 450);
    
            Lamina_Procesador2 lamina = new Lamina_Procesador2();
            add(lamina);
        }
    }
    
    class Lamina_Procesador2 extends JPanel{
    
        public Lamina_Procesador2(){
    
            setLayout(new BorderLayout());
    
            laminamenu = new JPanel();
            // --------------------------------------------- // CREACIÓN DE LA BARRA
    
            JMenuBar mibarra = new JMenuBar();
            // --------------------------------------------- // CREACIÓN DE ELEMENTOS QUE VAN EN LA BARRA
    
            fuente = new JMenu("Fuente");
            estilo = new JMenu("Estilo");
            tamagno = new JMenu("Tamaño");
            // --------------------------------------------- // CREACIÓN DE ELEMENTOS PERTENECINTES A FUENTE
    
            Configura_Menu("Arial", "fuente", "Arial", 9, 10);
            Configura_Menu("Courier", "fuente", "Courier", 9, 10);
            Configura_Menu("Verdana", "fuente", "Verdana", 9, 10);
            // --------------------------------------------- CREACIÓN DE ELEMENTOS PERTENECINTES A ESTILO
    
            Configura_Menu("Cursiva", "estilo", "", Font.ITALIC, 1);
            Configura_Menu("Negrita", "estilo", "", Font.BOLD, 1);
            // --------------------------------------------- CREACIÓN DE ELEMENTOS PERTENECINTES A TAMAÑO
    
            Configura_Menu("12", "Tamaño", "", 9, 12);
            Configura_Menu("16", "Tamaño", "", 9, 16);
            Configura_Menu("20", "Tamaño", "", 9, 20);
            Configura_Menu("24", "Tamaño", "", 9, 24);
            // ---------------------------------------------
    
            mibarra.add(fuente);
            mibarra.add(estilo);
            mibarra.add(tamagno);
            // ---------------------------------------------
            
            laminamenu.add(mibarra);
            add(laminamenu, BorderLayout.NORTH);
            miarea = new JTextPane();
            add(miarea, BorderLayout.CENTER);
        }
    
        public void Configura_Menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
    
            JMenuItem elem_menu = new JMenuItem(rotulo);
    
            if(menu == "fuente"){
                fuente.add(elem_menu);
                if(tipo_letra == "Arial"){
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
                }else if(tipo_letra == "Courier"){
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Courier"));
                }else if(tipo_letra == "Verdana"){
                    elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
                }
            }else if(menu == "estilo"){
                estilo.add(elem_menu);
                if(estilos == Font.BOLD){
                    elem_menu.addActionListener(new StyledEditorKit.BoldAction());
                }else if(estilos == Font.ITALIC){
                    elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
                }
            }else{
                tamagno.add(elem_menu);
            }


            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tam));
        }
        private JPanel laminamenu;
        private JTextPane miarea; 
        private JMenu fuente, estilo, tamagno;
        private Font letra;
    }

    


package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.event.*;

public class Procesadordetexto {

    public static void main(String[] args) {

        Marco_Procesador marco = new Marco_Procesador();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco_Procesador extends JFrame{

    public Marco_Procesador(){

        setVisible(true);
        setTitle("PROCESADOR DE TEXTO");
        setLocationRelativeTo(null);
        setSize(500, 450);

        Lamina_Procesador lamina = new Lamina_Procesador();
        add(lamina);
    }
}

class Lamina_Procesador extends JPanel{

    public Lamina_Procesador(){

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
        }else if(menu == "estilo"){
            estilo.add(elem_menu);
        }else{
            tamagno.add(elem_menu);
        }

        elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
    }

    private class Gestiona_Eventos implements ActionListener{

        String tipo_texto, menu;
        int estilo_letra, tamagno_letra;

        Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra){

            tipo_texto = texto2;
            estilo_letra = estilo2;
            tamagno_letra = tam_letra;
            menu = elemento;
        }

        public void actionPerformed(ActionEvent e) {

            letra = miarea.getFont();

            if(menu == "Arial" || menu == "Courier" || menu == "Verdana"){
                estilo_letra = letra.getStyle();
                tamagno_letra = letra.getSize();
            }else if(menu == "Cursiva" || menu == "Negrita"){
                if(letra.getStyle() == 1 || letra.getStyle() == 2){
                    estilo_letra = 3;
                }
                tipo_texto = letra.getFontName();
                tamagno_letra = letra.getSize();
            }else if( menu == "12" || menu == "16" || menu == "20" || menu == "24"){
                estilo_letra = letra.getStyle();
                tipo_texto = letra.getFontName();
            }

            miarea.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));
            //System.out.println("Tipo: " + tipo_texto, "Estilo: " + estilo_letra, "Tamaño: " + tamagno_letra);
        }
    }

    private JPanel laminamenu;
    private JTextPane miarea; 
    private JMenu fuente, estilo, tamagno;
    private Font letra;
}

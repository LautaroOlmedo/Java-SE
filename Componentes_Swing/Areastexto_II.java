package Componentes_Swing;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Areastexto_II {
    public static void main(String[] args) {

        Marcote marco = new Marcote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class Marcote extends JFrame implements ActionListener{

    public Marcote(){
        
        setVisible(true);
        setTitle("Areas de texto II");
        setLocationRelativeTo(null);
        setSize(500, 450);
        setLayout(new BorderLayout());

        laminabotones = new JPanel();
        botonincertar = new JButton("Incertar");
        botonincertar.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                areaTexto.append("En un lugar");

            }

        });
        laminabotones.add(botonincertar);
        botonsaltolinea = new JButton("Salto linea");
        botonsaltolinea.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){ // BOTON ON/OFF

                boolean saltar =! areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);
                if(saltar == true){
                    botonsaltolinea.setText("Quitar salto");
                }
                else{
                    botonsaltolinea.setText("Salto linea");
                }

            }
        });

        laminabotones.add(botonsaltolinea);
        add(laminabotones, BorderLayout.SOUTH);

        areaTexto = new JTextArea(8,20);
        laminabarras = new JScrollPane(areaTexto);
        add(laminabarras,BorderLayout.CENTER);
        

        
    }

    private JPanel laminabotones;
    private JButton botonincertar, botonsaltolinea;
    private JTextArea areaTexto;
    private JScrollPane laminabarras;
    
    public void actionPerformed(ActionEvent e) {
        
        
    }
}

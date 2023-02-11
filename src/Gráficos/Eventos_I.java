package Gráficos;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;


public class Eventos_I {

    public static void main(String[] args) {

        marcodedibujo marcodedibujo2 = new marcodedibujo();
        marcodedibujo2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}

class marcodedibujo extends JFrame{

    public marcodedibujo(){
        setVisible(true);
        setTitle("Cambio de color forma 1");
        setBounds(700,300,500,300);
        setResizable(true);

        laminadeventos laminadeventos2 = new laminadeventos();
        add(laminadeventos2);
        
    }
}

class laminadeventos extends JPanel implements ActionListener{ //IMPLEMENTA ACTIONLISTENER PORQUE ES EL OBJETO QUE ESPERA EL EVENTO

        JButton botonAzul = new JButton("Azul");
        JButton botonRojo = new JButton("Rojo");
        JButton botonVerde = new JButton("Verde");

        public laminadeventos(){

            add(botonAzul);
            botonAzul.addActionListener(this); //THIS PORQUE EL OYENTE QUE ESPERA ES LA MISMA LAMINA
            add(botonRojo);
            botonRojo.addActionListener(this);
            add(botonVerde);
            botonVerde.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){ //CUANDO EL EVENTO OCURRE SE CREA UN PBJETO TIPO EVEBT Y SE ALMACENA EN E. EL METODO ES DE LA INTERFAZ

        Object botonpulsado = e.getSource(); //GETSOURCE CAPTURA EL ORIGEN DE LA FUENTE

        if(botonpulsado == botonAzul){
            setBackground(Color.BLUE);
        }
        else if(botonpulsado == botonRojo){
            setBackground(Color.RED);
        }
        else{
            setBackground(Color.GREEN);
        }
              
    }
}

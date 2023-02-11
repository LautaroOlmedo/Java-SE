package Gráficos;
import javax.swing.*;
import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Layouts_III {

    public static void main(String[] args) {

        MarcoCalculadora Calculadora = new MarcoCalculadora();
        Calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoCalculadora extends JFrame{
    public MarcoCalculadora(){
        setTitle("Calculadora (Layouts III)");
        setSize(450, 350);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

        Laminacalculadora1 milamina = new Laminacalculadora1();
        add(milamina);
        //pack();  Se utiliza para adaptar el marco al tamaño por defecto del contenido que tiene 
    }
}

class Laminacalculadora1 extends JPanel{

    public Laminacalculadora1(){

        principio = true;
        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false); // MÉTODO PARA QUE EL BOTON ESTÉ INACTIVO
        add(pantalla, BorderLayout.NORTH);

        Laminacalculadora2 = new JPanel();
        Laminacalculadora2.setLayout(new GridLayout(4,4));

        ActionListener insertar = new Insertanumero();  // CREAMOS UNA INSTANCIA PERTENECIENTE A INSERTARNUMERO
        ActionListener orden = new Accionorden();

        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", orden);

        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", orden);

        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", orden);

        ponerBoton("0", insertar);
        ponerBoton(",", insertar);
        ponerBoton("+", orden);
        ponerBoton("=", orden);

        add(Laminacalculadora2, BorderLayout.CENTER);
        ultimaOperacion = "=";

    }

    private void ponerBoton(String rotulo, ActionListener oyente){

        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente);
        Laminacalculadora2.add(boton);

    }

    private class Insertanumero implements ActionListener{

        public void actionPerformed(ActionEvent e){

            String  entrada = e.getActionCommand();
            if(principio){ //NO CONCATENA EL PRIMER VALOR QUE AGREGAMOS AL 0, SI NO QUE LO AGREGA COMO UN VALOR NUEVO
                pantalla.setText("");
                principio = false;
            }
            pantalla.setText(pantalla.getText() + entrada); // AGREGA CADA BOTÓN QUE VAMOS CLICKEANDO

        } 
    }

    private class Accionorden implements ActionListener{

        public void actionPerformed(ActionEvent e){

            String operacion = e.getActionCommand();
            
            calcular(Double.parseDouble(pantalla.getText()));
            ultimaOperacion = operacion;
            principio = true;

        }
        
        public void calcular(Double x){

            if(ultimaOperacion.equals("+")){

                resultado += x;
                System.out.println(resultado);
            }


        }
    }

    private JPanel Laminacalculadora2;
    private JButton pantalla;
    private boolean principio;
    private Double resultado;
    private String ultimaOperacion;

}


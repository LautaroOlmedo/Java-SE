package poo;

import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class prueba_temporizador2 {

    public static void main(String[] args) {

        reloj mi_reloj = new reloj(3000, true);
        mi_reloj.en_marcha();
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para finalizar");


    }
}

class reloj{

    public reloj(int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void en_marcha(){
         class DameLaHora2 implements ActionListener{ //CLASE INTERNA LOCAL 

            public void actionPerformed(ActionEvent e){
                Date ahora = new Date();
                System.out.println("Te pongo la hora cada 3 segundos"+  ahora);
                if(sonido = true){
                    Toolkit.getDefaultToolkit().beep();
                }
    
            }
        }
    
        ActionListener oyente = new DameLaHora2();
        Timer mitemporizador = new Timer(intervalo, oyente);
        mitemporizador.start();
    }

    private int intervalo;
    private boolean sonido;   
}

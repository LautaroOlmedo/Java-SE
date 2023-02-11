package poo;
//import javax.swing.JOptionPane;

public class Uso_Vehiculo {
    public static void main(String[] args) {

       
        /*Coche micoche= new Coche();

        micoche.establece_color(JOptionPane.showInputDialog("Elegí el color: "));
        micoche.establece_asientos(JOptionPane.showInputDialog("Elegí el tipo de asiento (cuero/de serie): "));
        micoche.establece_climatizacion(JOptionPane.showInputDialog("¿Tiene climatizador?: "));
        micoche.establece_peso(4500);
        micoche.establece_nombre("Citroen");


        System.out.println(micoche.dime_nombre());
        System.out.println(micoche.dime_color());
        System.out.println(micoche.dime_caracteristicas());
        System.out.println(micoche.dime_asientos());
        System.out.println(micoche.dime_climatizador());
        System.out.println(micoche.dime_peso());
        
        System.out.println("El precio final del coche es de: " + micoche.precio_coche() + " $");*/
        Coche micoche1 = new Coche();
        micoche1.establece_color("Verde");

        Furgoneta mifurgoneta1 = new Furgoneta(7, 580);
        mifurgoneta1.establece_color("Rojo");
        mifurgoneta1.establece_asientos("cuero");
        mifurgoneta1.establece_climatizacion("si");

        System.out.println(micoche1.dime_caracteristicas() + " " + micoche1.dime_color());
        System.out.println(mifurgoneta1.dime_caracteristicas() + " " + mifurgoneta1.dimedatosFurgoneta());
        
    }
    
}

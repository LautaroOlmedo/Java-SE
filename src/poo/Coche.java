package poo;


public class Coche {

    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_plataforma;

    private String color;
    private int peso_total;
    private Boolean asientos_cuero;
    private Boolean climatizador;
    private String nombre_marca;

    public Coche(){
        ruedas = 4;
        largo = 200;
        ancho = 300;
        motor = 1600;
        peso_plataforma = 500;
    }

    public String dime_caracteristicas(){

        return "El coche tiene " + ruedas + " ruedas."+ " Tiene un largo de " + largo/100 + " metros," + " un ancho de " + ancho + " cm. " + "El motor tiene " +
        motor + " cm3." + " la plataforma tiene un peso de " + peso_plataforma + " kg";
    }

    public void establece_color(String color_coche){ //SETTER
        
        color = color_coche;
    }
    

    public String dime_color(){

        return "El color del coche es: " + color;
    }

    
    public void establece_asientos(String asientos_cuero){

        if(asientos_cuero.equalsIgnoreCase("cuero")){
            this.asientos_cuero = true;
        }
        else{
            this.asientos_cuero = false;
            }
    }


    public String dime_asientos(){

    if(asientos_cuero == true){
        return "El coche tiene asientos de cuero";
    }
    else{
        return "El coche tiene asientos de serie";
    }
    
    }
    

    public void establece_climatizacion(String climatizador){

        if(climatizador.equalsIgnoreCase("si")){

            this.climatizador = true;
        }else{
            this.climatizador = false;
        }
    }
            
        

    public String dime_climatizador(){
        if(climatizador == true){
            return "El coche tiene climatización";
        }else{
            return "El coche tiene aire acondicionado";
        }
    }


    public void establece_peso(int peso){

        peso_total = peso;

    }
    public String dime_peso(){
        return "El peso total del coche es de: " + peso_total + " kg";

    }


    public void establece_nombre(String nombre){
        nombre_marca = nombre;

    }


    public String dime_nombre(){
        return "La marca del coche es: " + nombre_marca;
    }

    public int precio_coche(){

        int precio_final=10000;
        if(asientos_cuero==true){
            precio_final+=2000;
        }
        if(climatizador==true){
            precio_final+=1500;
        }
        return  precio_final;
    }


    
}
    
    

        
        
    

    





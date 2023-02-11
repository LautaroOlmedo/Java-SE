package poo;

public class Constantes_usofinal {
    public static void main(String[] args) {

        Empleados trabajador1=new Empleados("Juan");
        Empleados trabajador2=new Empleados("Paco");
        Empleados trabajador3=new Empleados("Pepe");


        trabajador1.cambiasección("Director");


        System.out.println(trabajador1.devuelvedatos());
        System.out.println(trabajador2.devuelvedatos());
        System.out.println(trabajador3.devuelvedatos());
        System.out.println(Empleados.devuelvesiguienteID());

    }
    
}
class Empleados{
    public Empleados(String nom){
        nombre=nom;
        sección="Administración";
        ID=IDsiguiente;
        IDsiguiente++;
        
    }
    public void cambiasección(String sección){
        this.sección=sección;
    }
    public String devuelvedatos(){
        return "El nombre es: " + nombre + " y la sección es: " + sección + ". El ID es: " + ID;
    }
    public static String devuelvesiguienteID(){
        return "El siguiente ID es " + IDsiguiente;

    }

    //CAMPOS DE EJEMPLAR/CAMPOS DE CLASE
    private final String nombre;
    private String sección;
    private int ID;
    private static int IDsiguiente=1;


}

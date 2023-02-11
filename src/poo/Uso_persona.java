package poo;
import java.util.*;
//(IMPORTAMOS JAVA.UTIL PARA PODER UTILIZAR EL TIPO DE DATO "DATE", QUE PERTENECE A ESTA CLASE Y GREGORIANCALENDAR)
public class Uso_persona {
    public static void main(String[] args) {

        persona[] lasPersonas = new persona[2];
        lasPersonas[0] = new Empleado2("Javier", 100.5, 2021, 10, 5);
        lasPersonas[1] = new Alumno("Lautaro", "Ingeniería informática");

        for(persona e: lasPersonas){
            System.out.println("Nombre: " + e.dameNombre()
            + ". Descripción: " + e.dameDescripcion());
        }

                
        
    }

    
}

abstract class persona{

    public persona(String nom){

        nombre = nom;
    }


    public abstract String dameDescripcion();
    private String nombre;

    public String dameNombre(){
        return "El nombre es: " + nombre;
    }
    
}


class Empleado2 extends persona{

    public Empleado2(String nom, Double sue, int agno, int mes, int día){
        super(nom);
        sueldo = sue;
        this.agno = agno;
        this.mes = mes;
        this.día = día;
        GregorianCalendar calendario=new GregorianCalendar(agno, mes-1, día);
        fechaalta=calendario.getTime();
    }


    private Double sueldo;
    private int agno;
    private int mes;
    private int día;
    private Date fechaalta;


    public String dameDescripcion(){
        return "El empleado tiene un id";
    }
    public Double dame_sueldo(){

        return sueldo;
    }
}

class Alumno extends persona{

    public Alumno(String nom, String carre){
        super(nom);
        carrera = carre;
    }


    private String carrera;


    public String dameDescripcion(){
        return "El alumno cursa la carrera de: " + carrera;
    }
    

}



    
package poo;
import java.util.*;

public class Uso_empleado {
    public static void main(String[] args) {

    Empleado empleado1 = new Empleado("Lautaro Olmedo", 21, "Isla Lennox 571", "Argentino", 85000.5, "Backend", 2021, 12, 18);
    Empleado empleado2 = new Empleado("Joel Quinteros", 22, "Darragueira 602", "Argentino", 90000.5, "Fronted", 2020, 10, 1);
    Jefatura jefe_RRHH= new Jefatura("Juani", 22, "Carometal 778", "Argentino", 120000.5, "Jefe RRHH", 2019, 5, 7);
    jefe_RRHH.establece_incentivo(2500.70);
    
    Empleado [] misempleados = new Empleado[5];
    misempleados [0]= empleado1;
    misempleados [1]= empleado2;
    misempleados [2] = new Empleado("David Luis");
    misempleados [3] = jefe_RRHH; //POLIMORFISMO EN ACCIÓN
    misempleados [4] = new Jefatura("Maria", 22, "Carbometal 800", "Argentino", 100000.10, "Jefa FINANZAS", 2019, 5, 15);

    Jefatura jefe_FINANZAS = (Jefatura) misempleados [4]; //REFUNDICIÓN DE OBJETOS (CASTING), LO HACEMOS PARA PODER APLICARLE EL INCENTIVO PORQUE EN EL ARRAY SE COMPORTA COMO OBJETO EMPLEADO (POLIMORFISMO)

    jefe_FINANZAS.establece_incentivo(10000);

    Empleado director_comercial = new Jefatura("Sandra", 30, "Balcarce 71", "Argentina", 86000.96, "Directora Comercial", 2021, 5, 10);
    Comparable ejemplo = new Empleado("Ernesto", 45, "Vietnam 1", "Argentino", 46340.06, "Backend", 2021, 7, 6);

    if(director_comercial instanceof Empleado){
        System.out.println("director_comercial es de tipo Jefatura");
    }

    if(ejemplo instanceof Comparable){
        System.out.println("ejemplo implementa la interfaz comparable");
    }
    empleado1.establece_sueldo(5);
    empleado2.establece_sueldo(5);

    System.out.println(jefe_FINANZAS.tomar_decisiones("Dar más días de vacaciones a los empleados"));

    System.out.println("El jefe " + jefe_FINANZAS.dame_nombre() + " Tiene un bonus de: " + 
    jefe_FINANZAS.establece_bonus(500));
    System.out.println(misempleados[0].dame_nombre() + "Tiene un bonus de: " + misempleados[0].establece_bonus(200));

    Arrays.sort(misempleados); //ORDENA LOS ELEMNTOS DEL ARRAY 

    for(Empleado e: misempleados){
        System.out.println("Nombre: " + e.dame_nombre()
         + " Sueldo: " + e.dame_sueldo()
         + " Fecha de alta: " + e.dame_fechaalta()
         + " Puesto: " + e.dame_puesto());
       }
    }
}




class Empleado implements Comparable, Trabajadores{
    public Empleado(String nom, int agno, String direc, String nacio, Double sue, String pue, int agnoo, int mes, int día){
    
        nombre=nom;
        edad=agno;
        dirección=direc;
        nacionalidad=nacio;
        sueldo=sue;
        puesto=pue;
        GregorianCalendar calendario=new GregorianCalendar(agnoo, mes-1, día);
        fechaalta=calendario.getTime();
    }
    public Empleado(String nom){
        this(nom, 23, "Isla Georgia 234", "Chileno", 30000.8, "Pasante", 2000, 01, 01);
    }

    private String nombre;
    private int edad;
    private String dirección;
    private String nacionalidad;

    private Double sueldo;
    private String puesto;
    private Date fechaalta;

    //INICIO GETTERS Y SETTERS
    
    public String dame_nombre(){
    
        return nombre;
    }



    public int dame_edad(){

        return edad;
    }



    public String dame_dirección(){

        return dirección;
    }



    public String dame_nacionalidad(){

        return nacionalidad;
    }


    public void establece_sueldo(double porcentaje){

        double aumento = sueldo * porcentaje/100;
        sueldo+=aumento;

    }



    
    public Double dame_sueldo(){

        return sueldo;
    }


    public String dame_puesto(){

        return puesto;
    }


    public Date dame_fechaalta(){

        return fechaalta;
    }


    public int compareTo(Object miObjeto){ //ORDENA LOS ELEMENTOS DEL ARRAY SEGUN EL SUELDO (CONSULTAMOS A LA API DE JAVA)
        Empleado otroEmpleado = (Empleado) miObjeto;

        if(this.sueldo<otroEmpleado.sueldo){
            return -1;
        }

        if(this.sueldo>otroEmpleado.sueldo){
            return 1;
        }

        return 0;
    }

    public double establece_bonus(double gratificacion){

        return Trabajadores.bonus_base + gratificacion;

    }


}




class Jefatura extends Empleado implements Jefes{

    public Jefatura(String nom, int agno, String direc, String nacio,  double sue, String pue, int agnoo, int mes, int día){

        super(nom, agno, direc, nacio, sue, pue, agnoo, mes, día);

    }

    public String tomar_decisiones(String decision){

        return "Un miembro de la dirección ha tomado la decisión de: " + decision;

    }

    public double establece_bonus(double gratificacion){
        double prima = 2000;
        return Trabajadores.bonus_base + gratificacion + prima;
    }



    public void establece_incentivo(double b){
        incentivo=b;
    }
    //METODO QUE SUPERMOPONE A OTRO DENTRO DE UNA CLASE
    public Double dame_sueldo(){
       double sueldojefe= super.dame_sueldo();
       return sueldojefe + incentivo;
    }

    private double incentivo;



}




/**
 * Clase Reporte
 *
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Josue Isaac Morales Gonzalez 21116
 */
import java.util.*;
public class Reporte{
    private int estado;
    
    /**
     * Constructor for objects of class Reporte
     */
    public Reporte(){
        this.estado = 0;
    }

    /**
     * Metodo que sirve para determinar el estado del usuario, entre positivo y negativo segun
     * la respuesta a las preguntas del usuario,
     * @param respuestas de las preguntas
     * @return el mensaje correspondiente al resultado
     */
    public String ReporteDiario(String rp1,String rp2, String rp3,String rp4, String rp5, String rp6, String rp7, String rp8){
        estado = 0;
        int sintomas = 0;
        ArrayList<String> rps = new ArrayList<String>();
        rps.add(rp1);
        rps.add(rp2);
        rps.add(rp3);
        rps.add(rp4);
        rps.add(rp5);
        rps.add(rp6);
        
        for(String e: rps){ 
            if (e.equals("si")){
                sintomas ++;
            }
        }
        if (sintomas > 2 &&(rp7.equals("no")||rp8.equals("no"))){
            estado = 1;
        }
        if (sintomas > 2 &&(rp7.equals("si")||rp8.equals("si"))){
            estado = 2;
        }
        if (sintomas <= 2 &&(rp7.equals("no")||rp8.equals("no"))){
            estado = 2;
        }
        if (sintomas <= 2 &&(rp7.equals("si")||rp8.equals("si"))){
            estado = 3;
        }
        
        String mensaje = "";
        if (estado == 1){
            mensaje += "\nExiste una posibilidad alta de que usted padezca de COVID19, vaya a hacerse una prueba y tome las precuaciones necesarias.\n";
        }else if (estado == 2){
            mensaje += "\nLa posibilidad de que usted padezca de COVID19 es media, ya que tiene algunos sintomas pero ya tiene las defensas, para estar 100% seguro hagase una prueba medica.\n";
        }else if (estado == 3){
            mensaje += "\nLa posibilidad de que usted padezca de COVID19 es baja, para estar 100% seguro hagase una prueba medica.\n";
        }
        return mensaje;
    }

}

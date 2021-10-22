/**
 * Clase Tienda.
 * 
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Josue Isaac Morales Gonzalez 21116
 */
public class Tienda{
    private String nombre;
    private int espacios;
    
    /**
     * Constructor para objetos de la clase Tienda
     */
    public Tienda(String nombre, int espacios){
        this.nombre = nombre;
        this.espacios = espacios;
    }
    
    /**
     * Metodo que devuelve el nombre de la tienda
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Metodo que disminuye los espacios segun cuantas personas lleguen
     * @param int personas
     */
    public void ocuparEspacio(int personas){
        espacios -= personas;
    }
    
    /**
     * Metodo que devuelve los espacios disponibles
     */
    public int espaciosDisponibles(){
        return espacios;
    }
    
    /**
     * Metodo que libera espacios ocupados cuando las personas se retiran.
     * @param int personas
     */
    public void liberarEspacio(int personas){
        espacios += personas;
    }
    
}

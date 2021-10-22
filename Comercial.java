import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * Clase Comercial
 * 
 * @author  Josue Isaac Morales Gonzalez 21116
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 */
public class Comercial{
    private String nombre;
    private int cantidadTiendas, capacidadTotalComercial;
    private ArrayList<Tienda> listaTiendas = new ArrayList<Tienda>();
    
    /**
     * Constructor para objetos de la clase Comercial
     * @param String nombre
     * @param ArrayList<Tienda> listaTiendas
     */
    public Comercial(String nombre, ArrayList<Tienda> listaTiendas){
        this.nombre = nombre;
        this.listaTiendas = listaTiendas;
        this.cantidadTiendas = listaTiendas.size();
        
        this.capacidadTotalComercial = 0;
        for(Tienda tienda: listaTiendas){
            this.capacidadTotalComercial += tienda.espaciosDisponibles();
        }
    }
    
    /**
     * Constructor para objetos de la clase Comercial
     * @param String nombre
     * @param String archivo
     */
    public Comercial(String nombre, String datosTiendas){
        this.nombre = nombre;
        this.listaTiendas = generarListadoTiendas(datosTiendas) ;
        this.cantidadTiendas = listaTiendas.size();
        
        this.capacidadTotalComercial = 0;
        for(Tienda tienda: listaTiendas){
            this.capacidadTotalComercial += tienda.espaciosDisponibles();
        }
    }
    
    /**
     * Funcion que devuelve una lista de tipo Tienda con los datos obtenidos del csv.
     */
    public ArrayList<Tienda> generarListadoTiendas(String archivo){
        List<List<String>> lines = new ArrayList<>();
        File datos = new File(archivo);
        try{
            Scanner inputStream = new Scanner(datos);
            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(System.getProperty("line.separator"));
                lines.add(Arrays.asList(values));
            }
            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Tienda> listadoTiendasFinal = new ArrayList<Tienda>();
        
        for(List<String> line: lines) {
            for (String value: line) {
                String[] partes = value.split(",");
                String nombrePrograma = partes[0]; 
                String espacioOcupaString = partes[1];
                int espacioOcupaInt = Integer.parseInt(espacioOcupaString);
                listadoTiendasFinal.add( new Tienda(nombrePrograma, espacioOcupaInt) );
            }
        }        
        
        return listadoTiendasFinal;
    }
    

    /**
     * Metodo que recibe la tienda en texto a la cual se desea asistir con la cantidad de personas que acompanan
     * @param String queTienda
     * @param int cuantasPersonas
     */
    public String asistirTienda(String queTienda, int cuantasPersonas ){
        String mensaje = "";
        ArrayList<String> nombresTiendas = new ArrayList<String>();
        for(Tienda t: listaTiendas){
            nombresTiendas.add(t.getNombre());
        }
        if(nombresTiendas.indexOf(queTienda) == -1){
            mensaje += "El nombre de la tienda ingresada esta incorrecta";
        }else{
            for(Tienda tienda: listaTiendas){
                if( (tienda.getNombre()).equals(queTienda) ){
                    if(tienda.espaciosDisponibles() >= cuantasPersonas){
                        tienda.ocuparEspacio(cuantasPersonas);
                        mensaje += "Usted puede asistir con " + cuantasPersonas + " personas a "+ queTienda;
                    }else{
                        mensaje += "No hay espacio suficiente en "+ queTienda +" para que asistan "+ cuantasPersonas + " personas";
                    }
                }
            }
        }
        return mensaje;
    }
    
    
    /**
     * Metodo que recibe la tienda en texto a la cual se desea retirar con la cantidad de personas que acompanan
     * @param String queTienda
     * @param int cuantasPersonas
     */
    public String retirarTienda(String queTienda, int cuantasPersonas){
        String mensaje = "";
        
        ArrayList<String> nombresTiendas = new ArrayList<String>();
        
        for(Tienda t: listaTiendas){
            nombresTiendas.add(t.getNombre());
        }
        
        if(nombresTiendas.indexOf(queTienda) == -1){
            mensaje += "El nombre de la tienda ingresada est� incorrecta";
        }else{
            for(Tienda tienda: listaTiendas){
                if( (tienda.getNombre()).equals(queTienda) ){
                    tienda.liberarEspacio(cuantasPersonas);
                    mensaje += "Se retirar�n  " + cuantasPersonas + " personas, de la tienda "+ queTienda;                
                }
            }
        }
        return mensaje;
    }
    
    
    
    /**
     * Metodo que da un formato para mostrar las tiendas que contiene el comercial
     */
    public String tiendasEnElComercial(){
        String tiendas = "\nTiendas disponibles en *" + nombre + "* y su respectivo espacio disponible. \n";
        for(Tienda tienda : listaTiendas){
            tiendas += "\t["+tienda.getNombre()+"]";
        }
        tiendas += "\n";
        for(Tienda tienda : listaTiendas){
            tiendas += "\t["+tienda.espaciosDisponibles()+"]";
        }
        return tiendas;
    }
    
    /**
     * Metodo toString para mostrar con un formato las tiendas y sus caracteristicas
     */
    public String toString(){
        int espacioDisponible = 0;
        for(Tienda tienda: listaTiendas){
            espacioDisponible += tienda.espaciosDisponibles();
        }
        return "\n\t\t*"+nombre+"*"+"\tNo. Tiendas: "+cantidadTiendas + "\tEspacio Total: "+ capacidadTotalComercial + "\tEspacio Disponible: " + espacioDisponible;
    }
    // -------------- FUNCIONES DE GRAFICAS

}

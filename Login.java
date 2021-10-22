/**
 * 
 * Clase Login
 * 
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Josue Isaac Morales Gonzalez 21116
 */
import java.util.*;
import java.io.*;

public class Login{
    private Scanner x;
    /**
     * Constructor for objects of class Login
     */
    public Login(){
        
    }

    public String verificarUsuario(String usuario, String contra, String archivo){
        boolean existe = false;
        String usuarioTemp = "";
        String contraTemp = "";
        String mensaje = "";

        try{
            x = new Scanner(new File(archivo));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !existe){
                usuarioTemp = x.next();
                contraTemp = x.next();
                
                if(usuarioTemp.trim().equals(usuario.trim()) && contraTemp.trim().equals(contra.trim())){
                    existe = true;
                }
            }
            x.close();
            if(existe){
                mensaje += "Bienvenido usuario "+usuario;
            }else{
                mensaje += "Error, usuario y/o contrasena incorrecto\nIntentelo de nuevo";
            }
            
        }catch(Exception e){
            mensaje += "Error, usuario y/o contrasena incorrecto\nIntentelo de nuevo.";
        }
        
        return mensaje;
    }
    
    public void crearUsuario(String texto, String archivo){
        File doc = new File(archivo);
        if(!doc.exists()){
            try{
                doc.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        if(doc.exists()){
            try{
                FileWriter escribir = new FileWriter(doc,true);
                PrintWriter linea = new PrintWriter(escribir);
                linea.println(texto);
                linea.close();
                escribir.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

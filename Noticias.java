/**
 * Clase Noticia
 *
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Josue Isaac Morales Gonzalez 21116
 */
import java.awt.Desktop;
import java.net.URI; 
public class Noticias {
    /**
     * Constructor for objects of class Noticia
     */
    public Noticias ()
    {
        
        
    }

    /**
     * Metodo que permite mostrar las noticias de ultima hora, a traves de la creacion de una ventana
     * del navegador default y abre un link
     *
     * @param  no aplica
     * @return no aplica
     */
    public static void PopUpNoticias() throws Exception{
        //Creacion del objeto desktop
        Desktop d=Desktop.getDesktop();

        //Ir al link
        d.browse(new URI("https://n9.cl/noticiascobicho"));

        }
}

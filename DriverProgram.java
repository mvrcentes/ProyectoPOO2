import java.util.*;
/**
 * 
 * Clase DriverProgram
 * 
 * Programa Principal en donde se ejecutara el menu
 * @author Javier Luis Angel Chavez Escobar 21016
 * @author Josue Isaac Morales Gonzalez 21116
 * @author Marco Vinicio Ramirez Centes 21032 
 * @author Andres Eduardo Quezada Bendana 21085
 */

public class DriverProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        boolean sesion = false;
        int opcion;
        
        Comercial OaklandMall = new Comercial("Oakland Mall", "Oakland.txt");
        Comercial MirafloresMall = new Comercial("Miraflores", "Miraflores.txt");
        
        Reporte reportador = new Reporte();
        Noticias noticiero = new Noticias();
        
        Login login = new Login();
        
        while(!sesion){
            salir = false;
            boolean UsuarioVerificado = false;
            System.out.println("\n1. Iniciar sesion");
            System.out.println("2. Crear usuario");
            System.out.println("3. Cerrar sesion");
            try {
                System.out.println("Opcion -> ");
                opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        /**
                         * Esta opcion permite al usurio iniciar sesión por medio de su nombre de usuario y contraseña.
                         */
                        System.out.println( "usuario: " );
                        String usuario = input.nextLine();
                        
                        System.out.println( "contrasena: " );
                        String contra = input.nextLine();
                        
                        
                        String mensaje = login.verificarUsuario(usuario, contra, "usuarios.txt");
                        System.out.println( mensaje );
                        if(mensaje.contains("Bienvenido usuario") ){
                            UsuarioVerificado = true;
                        }else{
                            UsuarioVerificado = false;
                        }
                        
                        break;
                    case 2:
                        /**
                         * Esta opcion permite al usuario crear su nombre de usuario y contraseña para poder logearse al programa y así poder usarlo.
                         */
                        System.out.println( "usuario: " );
                        String crearUsuario = input.nextLine();
                        
                        System.out.println( "contrasena: " );
                        String crearContra = input.nextLine();
                        
                        String datos = crearUsuario.trim()+","+crearContra.trim();
                        login.crearUsuario( datos, "usuarios.txt");
                        System.out.println( "Su usuario fue creado con exito" );
                        
                        break;
                    case 3:
                        /**
                         * Opción que permite al usuario terminar la sesión y salir del programa.
                         */
                        System.out.println("**********************************\n");
                        System.out.println("\tUsted ha cerrado su sesion :)\n");
                        System.out.println("**********************************\n");
                        sesion = true;
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingresa una opcion valida\n");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("\nDebes insertar un numero\n");
                input.next();
            }
            
            while(!salir && UsuarioVerificado){
                System.out.println("\n1. Asistir a una tienda en un comercial");
                System.out.println("2. Reporte Diario");
                System.out.println("3. Noticias");
                System.out.println("4. Retirarse");
                System.out.println("5. Salir del programa"); //simulador
                try {
                    System.out.println("Opcion -> ");
                    opcion = input.nextInt();
                    input.nextLine();
                    switch (opcion) {
                        case 1:
                            /**
                             * Permite el ingreso del usuario a las diferentes tiendas, para que su asistencia sea registrada y se descuenten los espacios que ocupa el usuario con sus acompañantes.
                             */
                            System.out.println( "\n\t\t\tComerciales Disponibles" );
                            System.out.print(OaklandMall.toString());
                            System.out.println(MirafloresMall.toString() );
                            int comercialElegido;
                            do{
                                System.out.println( "A cual deseas asistir? 1 o 2" );
                                comercialElegido = input.nextInt();
                                input.nextLine();
                            }while(comercialElegido > 2 || comercialElegido < 0 );
                            
                            if(comercialElegido == 1){
                                System.out.println(OaklandMall.tiendasEnElComercial());
                                System.out.println( "A cual deseas asistir? (escribir igual)" );
                                String queTienda = input.nextLine();
                                System.out.println( "Cuantos van asistir? " );
                                int cuantasPersonas = input.nextInt();
                                input.nextLine();
                                
                                System.out.println(OaklandMall.asistirTienda(queTienda, cuantasPersonas));
                            }else if(comercialElegido == 2){
                                System.out.println(MirafloresMall.tiendasEnElComercial());
                                System.out.println( "A cual deseas asistir? (escribir igual)" );
                                String queTienda = input.nextLine();
                                System.out.println( "Cuantos van asistir? " );
                                int cuantasPersonas = input.nextInt();
                                input.nextLine();
                                System.out.println( "Cuanto tiempo estara en la tienda? " );
                                int tiempo = input.nextInt();
                                input.nextLine();
                                
                                System.out.println(MirafloresMall.asistirTienda(queTienda, cuantasPersonas));
                            }
                            break;
                        case 2:
                            /**
                             * Caso 2, imprime todas las preguntas del reporte diario que verifica si el usuario se encuentra infectado, permite que se almacenen las respuestas del usuario y por ultimo verifica las respuestas para determinar el riesgo del usuario.
                             */
                            System.out.println( "\nPorfavor responda con 'si' o 'no' a las siguientes preguntas:" );
                            System.out.println( "En los �ltimos d�as ha mostrado fiebre?" );
                            String rp1 = input.nextLine();
                            System.out.println( "En los �ltimos d�as ha mostrado tos?" );
                            String rp2 = input.nextLine();
                            System.out.println( "En los �ltimos d�as ha mostrado congestion nasal?" );
                            String rp3 = input.nextLine();
                            System.out.println( "En los �ltimos d�as ha mostrado problemas respiratorios?" );
                            String rp4 = input.nextLine();
                            System.out.println( "Ha estado en contacto recientemente con alguien que se haya contagiado de COVID-19?" );
                            String rp5 = input.nextLine();
                            System.out.println( "Ha notado una perdida de su sentido del olfato?" );
                            String rp6 = input.nextLine();
                            System.out.println( "Ha padecido COVID-19 en los ultimos dos meses?");
                            String rp7 = input.nextLine();
                            System.out.println( "Ha sido vacunado en contra del COVID-19?" );
                            String rp8 = input.nextLine();
                            String mensaje = reportador.ReporteDiario(rp1, rp2, rp3,rp4,rp5,rp6,rp7,rp8);
                            if(!mensaje.equals("")){
                                System.out.println( mensaje );
                            }
                            
                            break;
                        case 3:
                            /**
                             * Caso 3 que redirige al usuario a google a una página de noticias acerca de COVID-19 
                             */
                            try{
                                noticiero.PopUpNoticias();
                            }catch(Exception e){
                                System.out.println( e );
                            }
                            
                            break;
                        case 4:
                            /**
                             * Caso 4 permite que el usuario se retire de la tienda con todas las personas que le acompanan y permite que los espacios se desocupen gracias a los metodos liberarEspacio y retirarTienda.
                             */
                            System.out.println("Nos encanta que nos visites y es una lastima que te vayas :( Vuelve pronto triple sapo");
                            System.out.println( "\n\t\t\tComerciales Disponibles" );
                            System.out.print(OaklandMall.toString());
                            System.out.println(MirafloresMall.toString() );
                            do{
                                System.out.println( "De que centro comercial deseas retirarte? 1 o 2" );
                                comercialElegido = input.nextInt();
                                input.nextLine();
                            }while(comercialElegido > 2 || comercialElegido < 0 );
    
                            if(comercialElegido == 1){
                                System.out.println(OaklandMall.tiendasEnElComercial());
                                System.out.println( "De que tienda te deseas retirar? (escribir igual)" );
                                String queTienda = input.nextLine();
                                System.out.println( "Cuantas personas se retiraran? " );
                                int cuantasPersonas = input.nextInt();
                                input.nextLine();
                                System.out.println(OaklandMall.retirarTienda(queTienda, cuantasPersonas));
                            }else if(comercialElegido == 2){
                                System.out.println(MirafloresMall.tiendasEnElComercial());
                                System.out.println( "De que tienda te deseas retirar?(escribir igual)" );
                                String queTienda = input.nextLine();
                                System.out.println( "Cuantas personas se retiraran? " );
                                int cuantasPersonas = input.nextInt();
                                input.nextLine();
                                System.out.println(MirafloresMall.retirarTienda(queTienda, cuantasPersonas));
                            }
                            break;
                        case 5:
                            /**
                             * Para salir del ciclo while
                             */
                            System.out.println("**********************************\n");
                            System.out.println("\tGracias por usar el programa :)\n");
                            System.out.println("**********************************\n");
                            salir = true;
                            break;
                        default:
                            System.out.println("Ingresa una opcion valida\n");
                            break;
                    }
                }catch(InputMismatchException e){
                    System.out.println("\nDebes insertar un número\n");
                    input.next();
                }
            }
        }
    }
}
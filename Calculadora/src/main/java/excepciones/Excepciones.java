package excepciones;

import java.io.IOException;

/**
 * Menjo de excepciones que podemos controlar: Ingreso de los datos.
 * 
 * @author Maria Segura
 */

public class Excepciones {
    public static void manejoIOException(IOException e) {
        System.err.println("Ocurrió un error de IO: " + e);
        System.out.println("Hubo un error de IO: " + e);
    }

    public static void manejoException(Exception e) {
        System.err.println("Ocurrió un error grave: " + e);
    }
    
}
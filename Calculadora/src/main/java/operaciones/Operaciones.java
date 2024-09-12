package operaciones;


import java.io.BufferedReader;
import java.io.IOException;

/**
 * Operaciones: 
 * - Convertir el tipo de dato de decimal a base 10
 * - Suma, resta, multiplicacion y division
 * - Opcion de mostrar reultado en binario o en base 10
 * 
 * Menjo de excepciones que podemos controlar: Ingreso de los datos.
 * 
 * @author Maria Segura
 */
public class Operaciones {

    //Se definen la soperaciones suma y resta
    public static void suma(BufferedReader bIn, double x, double y) {
        try {
            System.out.println("El resultado de la suma es: " + (x + y));
        } catch (Exception e) {
            System.err.println("Error al realizar la suma: " + e.getMessage());
        }
    }

    public static void resta(BufferedReader bIn, double x, double y) {
        try {
            System.out.println("El resultado de la resta es: " + (x - y));
        } catch (Exception e) {
            System.err.println("Error al realizar la resta: " + e.getMessage());
        }
    }
    
    public static void multiplicacion(BufferedReader bIn, double x, double y) {
        try {
            System.out.println("El resultado de la multiplicacion es: " + (x * y));
        } catch (Exception e) {
            System.err.println("Error al realizar la multiplicacion: " + e.getMessage());
        }
    }
    
    public static void division(BufferedReader bIn, double x, double y) {
        if(y==0)
            throw new ArithmeticException("No se puede dividir entre cero");//Excepcion al intentar dividir entre cero
        try {
            System.out.println("El resultado de la division es: " + (x / y));
        } catch (Exception e) {
            System.err.println("Error al realizar la division: " + e.getMessage());
        }
    }
}
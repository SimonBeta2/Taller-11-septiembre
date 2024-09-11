package menu;

import excepciones.Excepciones;
import operaciones.Operaciones;
import java.io.BufferedReader;
import java.io.IOException;
import operaciones.BinarioDecimal;

/**
 * Menu:
 * 1. Elegir tipo de dato para realizar op: Decial o entero
 * 2. Elegir tipo de op entre suma, resta, multiplicacion y division.
 * 
 * @author Maria Segura
 */

public class Menu {

    public static void logica(BufferedReader bIn) throws IOException {
        int op = (int) tecladoNumero(bIn, "1. para sumar\n2. para restar\n3. para multiplicar\n4. para dividir\nOpcion = ");

        switch (op) {
            case 1 -> operar(bIn, "suma");
            case 2 -> operar(bIn, "resta");
            case 3 -> operar(bIn, "multiplicacion");
            case 4 -> operar(bIn, "division");
            default -> System.out.println("Opción no válida.");
        }
    }

    public static void operar(BufferedReader bIn, String operacion) {
        try {
            // Preguntar por el tipo de datos
            System.out.println("Seleccione el tipo de datos para los valores:");
            System.out.println("1. Binario\n2. Entero\n3. Decimal");
            int tipoDato1 = (int) tecladoNumero(bIn, "Tipo para el primer número: ");
            int tipoDato2 = (int) tecladoNumero(bIn, "Tipo para el segundo número: ");
            
            double valor1 = obtenerValor(bIn, tipoDato1, "primer");
            double valor2 = obtenerValor(bIn, tipoDato2, "segundo");

            // Realizar la operación utilizando la clase Operaciones
            switch (operacion) {
                case "suma":
                    Operaciones.suma(bIn, valor1, valor2); // Pasar los valores a la suma
                    break;
                case "resta":
                    Operaciones.resta(bIn, valor1, valor2); // Pasar los valores a la resta
                    break;
                case "multiplicacion":
                    Operaciones.multiplicacion(bIn, valor1, valor2); // Pasar los valores a la multiplicacion
                    break;
                case "division":
                    try{
                    Operaciones.division(bIn, valor1, valor2); // Pasar los valores a la division
                    }catch(ArithmeticException e){
                        System.err.println("Error " + e.getMessage());
                    }
                default:
                    break;
            }
            
        } catch (IOException e) {
            Excepciones.manejoIOException(e);
        }
    }

    // Método que obtiene el valor del usuario dependiendo de si es binario o decimal
    public static double obtenerValor(BufferedReader bIn, int tipoDato, String orden) throws IOException {
        if (tipoDato == 1) { // Binario
            while (true) {
                String binario = tecladoCadena(bIn, "Ingrese el " + orden + " número en binario: ");
                int decimal = BinarioDecimal.convertirBinarioADecimal(binario);
                if (decimal != -1) {
                    return decimal;
                } else {
                    System.out.println("Número binario inválido. Intente nuevamente.");
                }
            }
        } 
        else if(tipoDato==2){ // Entero
            return  (int)tecladoNumeroPositivo(bIn, "Ingrese el " + orden + " número entero: ");
        }
        
        else if(tipoDato==3)// Decimal
            return tecladoNumeroPositivo(bIn, "Ingrese el " + orden + " número decimal: ");
        
        else{
            System.out.println("La opcion " + tipoDato + " no existe");
        return 0;
        }
    }

    public static double tecladoNumero(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                return Double.parseDouble(bIn.readLine());
            } catch (NumberFormatException e) {
                System.err.println("Debe ingresar un dato numérico.");
            }
        } while (true);
    }

    public static String tecladoCadena(BufferedReader bIn, String label) throws IOException {
        System.out.print(label);
        return bIn.readLine();
    }

    // Método para solo permitir números positivos
    public static double tecladoNumeroPositivo(BufferedReader bIn, String label) throws IOException {
        do {
            System.out.print(label);
            try {
                double num = Double.parseDouble(bIn.readLine());
                if (num < 0) {
                    System.err.println("Debe ingresar un número positivo.");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.err.println("Debe ingresar un dato numérico.");
            }
        } while (true);
    }
    
}
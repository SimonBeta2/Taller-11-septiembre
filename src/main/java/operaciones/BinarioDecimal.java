package operaciones;

import menu.Menu;
import java.io.BufferedReader;
import java.io.IOException;

public class BinarioDecimal {

    // Método para convertir un número binario (como String) a base 10 (entero)
    public static int convertirBinarioADecimal(String binario) {
        try {
            return Integer.parseInt(binario, 2); // Convierte el binario a decimal
        } catch (NumberFormatException e) {
            System.err.println("Formato de número binario inválido.");
            return -1; // Devuelve -1 si el formato es incorrecto
        }
    }

    // Método para manejar la lógica de la conversión
    public static void convertirYOperar(BufferedReader bIn) throws IOException {
        String binario = Menu.tecladoCadena(bIn, "Ingrese el número binario: ");
        int decimal = convertirBinarioADecimal(binario);

        if (decimal != -1) {
            System.out.println("El número binario " + binario + " convertido a decimal es: " + decimal);
            operarConDecimal(bIn, decimal);
        }
    }

    // Método para operar el número decimal obtenido con suma o resta
    public static void operarConDecimal(BufferedReader bIn, int decimal) throws IOException {
        int op = (int) Menu.tecladoNumero(bIn, "1. Sumar este número\n2. Restar este número\n");
        switch (op) {
            case 1 ->                 {
                    int num = (int) Menu.tecladoNumero(bIn, "Ingrese el número con el que desea sumar: ");
                    System.out.println("Resultado de la suma: " + (decimal + num));
                }
            case 2 ->                 {
                    int num = (int) Menu.tecladoNumero(bIn, "Ingrese el número con el que desea restar: ");
                    System.out.println("Resultado de la resta: " + (decimal - num));
                }
            default -> System.out.println("Opción no válida.");
        }
    }
}
package com.mycompany.calculadora;

import menu.Menu;
import excepciones.Excepciones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PRACTICA 2: Calculadora operativa
 * Integrantes: Maria del Carmen Segura Ortiz
 *              Simon Betancur Sosa
 * Menu:
 * 1. Elegir tipo de dato para realizar op: Decial o entero
 * 2. Elegir tipo de op entre suma, resta, multiplicacion y division.
 * 
 * Operaciones: 
 * - Convertir el tipo de dato de decimal a base 10
 * - Suma, resta, multiplicacion y division
 * - Opcion de mostrar reultado en binario o en base 10
 * 
 * Menjo de excepciones que podemos controlar: Ingreso de los datos.
 * 
 * @author Maria Segura
 */
public class Calculadora {
    public static void main(String[] args) {
        try {
            Menu.logica(new BufferedReader(new InputStreamReader(System.in)));
        } catch (IOException e) {
            Excepciones.manejoException(e);
        }
    }
}
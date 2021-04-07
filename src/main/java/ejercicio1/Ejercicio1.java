/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        String idFichero = "matriz.txt";
        String tmp;
        String[] tokens;
        String linea;

        int[][] matrizNumeros = new int[5][8];
        int inicial = 100;
        int resultadoFila = 0;
        int resultadoTotal = 0;
        
        //Para que se cree
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < matrizNumeros.length; i++) {
                inicial = 100 * (i + 1);
                matrizNumeros[i][0] = inicial;

                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    matrizNumeros[i][j] = inicial + j;
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(matrizNumeros[i][j]);
                    resultadoFila += matrizNumeros[i][j];
                    flujo.write(tmp + "\t");
                }

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
                System.out.println("El resultado es: " + resultadoFila);
                
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

            //Es un try with resources y sirve para cerrar todos los recursos 
            //que estamos usando cuando acabamos de usarlo(automáticamente)
            //Debido a que consume espacio y memoria
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Para que se muestre
        System.out.println("Leyendo el proyecto " + idFichero);

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println();
                for (int i = 0; i < matrizNumeros.length; i++) {
                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    resultadoFila += matrizNumeros[i][j];
                }
                for (int k = 0; k < resultadoFila; k++) {
                    resultadoTotal += resultadoFila;

                }
                }
            }
                System.out.println("resultado total " + resultadoTotal);
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

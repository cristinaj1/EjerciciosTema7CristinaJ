/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

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
public class Ejercicio2 {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String idFichero = "teclado.txt";
        String fin = "EOF";
        String finMinus = "eof";
        final int LINEAS = 100;
        String[] tokens;
        String linea;
        //PREGUNTAR PORQUE NO SE ME CIERRA:))
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < LINEAS; i++) {
                System.out.println("Introduzca una línea: " + teclado.nextLine());
                if (teclado.nextLine() == fin || teclado.nextLine() == finMinus) {
                    
                    flujo.close();
                } else {
                    flujo.write(teclado.nextLine() + "\n");
                }
                flujo.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

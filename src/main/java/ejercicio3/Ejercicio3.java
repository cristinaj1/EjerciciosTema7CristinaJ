/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class Ejercicio3 {

    public static void main(String[] args) throws IOException {
        String idFichero = "numeros.txt";
        String letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int largo = letra.length();
        Random rd = new Random();
        char letraAleatoria;
        final int NUMERO_LINEA = 50;
        String[] tokens;
        String linea;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < NUMERO_LINEA; i++) {
                letraAleatoria = letra.charAt(rd.nextInt(largo));
                if (letraAleatoria == 'X' || letraAleatoria == 'x') {
                    flujo.write(letraAleatoria + " , ");
                    flujo.newLine();
                } else {
                    flujo.write(letraAleatoria + " , ");
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

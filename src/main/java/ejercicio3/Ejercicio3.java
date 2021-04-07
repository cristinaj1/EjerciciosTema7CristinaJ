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
        String idFichero = "letras.txt";
        Random rd = new Random();
        String[] tokens;
        String linea;

        boolean tipoLetra;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (int i = 0; i < 50; i++) {

                String letraFinal;
                do {
                    String letras = "abcdefghijklmnñopqrstuvwxyz";
                    String mayusculas= letras.toUpperCase();
                    letras+=mayusculas;
                    int indiceLetraSacar = rd.nextInt(letras.length());
                    
                    char letra = letras.charAt(indiceLetraSacar);
                    letraFinal= Character.toString(letra);
                    
                    i++;

                    if(letraFinal.equalsIgnoreCase("x")){
                        flujo.write(letraFinal);
                        break;
                    }
                    
                    flujo.write(letraFinal+",");
                    
                } while (!letraFinal.equalsIgnoreCase("x"));

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
                i-=1;
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
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

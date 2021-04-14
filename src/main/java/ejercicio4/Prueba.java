/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class Prueba {

    private static String[] marca = {"Audi", "Seat", "Renault"};
    private static String[] modelo = {"Nuevo", "Clásico", "Semi nuevo(2 años como mucho de antigüedad)"};
    private static String[] color = {"Blanco", "Negro", "Rojo", "Amarillo", "Azul"};

    private static ArrayList<Vehiculo> lista = new ArrayList<>();

    public static String generarPlaca() {
        String matricula = "";
        Random rnd = new Random();

// Creamos un ciclo que se ejecute 7 veces, que corresponden al
// texto de la matrícula.
        for (int i = 0; i < 7; i++) {
            //Para los números
            if (i < 4) {
                matricula += rnd.nextInt(10);
            } else {
                //Para las letras
                matricula += (char) (rnd.nextInt(90 - 65 + 1) + 65);
            }
        }

        return matricula;
    }

    public static void main(String[] args) {
        String[] tokens;
        String linea;
        Random rd = new Random();
        Boolean disponible = rd.nextBoolean();
        String idFichero = "vehiculos.csv";

        for (int i = 0; i < 30; i++) {
            //Para el color
            int n = rd.nextInt(4);
            String colorcito = color[n];
            //para la marca
            int aleatorioMarca = rd.nextInt(2);
            String marquita = marca[aleatorioMarca];
            //para el modelo
            int aleatorioModel = rd.nextInt(2);
            String modelito = modelo[aleatorioModel];
            Vehiculo turismo = new Turismo(rd.nextLong(), generarPlaca(), marquita, modelito, colorcito, rd.nextDouble() + 100, disponible, 5);
            lista.add(turismo);
        }
        for (int i = 0; i < 30; i++) {
            //Para el color
            int n = rd.nextInt(4);
            String colorcito = color[n];
            //para la marca
            int aleatorioMarca = rd.nextInt(2);
            String marquita = marca[aleatorioMarca];
            //para el modelo
            int aleatorioModel = rd.nextInt(2);
            String modelito = modelo[aleatorioModel];
            Vehiculo deportivo = new Deportivo(rd.nextLong(), generarPlaca(), marquita, modelito, colorcito, rd.nextDouble() + 100, disponible, rd.nextInt(5 - 1 + 1) + 1);
            lista.add(deportivo);
        }
        for (int i = 0; i < 30; i++) {
            //Para el color
            int n = rd.nextInt(4);
            String colorcito = color[n];
            //para la marca
            int aleatorioMarca = rd.nextInt(2);
            String marquita = marca[aleatorioMarca];
            //para el modelo
            int aleatorioModel = rd.nextInt(2);
            String modelito = modelo[aleatorioModel];
            Vehiculo furgo = new Furgoneta(rd.nextLong(), generarPlaca(), marquita, modelito, colorcito, rd.nextDouble() + 100, disponible, rd.nextInt(1000 - 1 + 1) + 1);
            lista.add(furgo);
        }

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.write("TipoVehiculo:Matricula:Marca:Modelo:Color:Precio:Bastidor:Disponible:Especifico");
            flujo.newLine();

            for (Vehiculo coche : lista) {
                //Para saber a cual pertenece
                if (coche instanceof Turismo) {
                    flujo.write(((Turismo) coche).toString());
                } else if (coche instanceof Deportivo) {
                    flujo.write(((Deportivo) coche).toString());
                } else if (coche instanceof Furgoneta) {
                    flujo.write(((Furgoneta) coche).toString());
                }
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //Lectura(Ejercicio 7)
        ArrayList<Vehiculo> lista2 = new ArrayList<>();

        try ( Scanner datosFichero = new Scanner(new File(idFichero),"UTF-8")) {
            System.out.println("hey");
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                
                System.out.println("yuju");
                linea = datosFichero.nextLine();
                tokens = linea.split(";");
                Vehiculo tmp = new Vehiculo();
                
                for (String coche : tokens) {
                    if (tmp instanceof Turismo) {
                        ((Turismo) tmp).setMatricula(tokens[1]);
                        ((Turismo) tmp).setMarca(tokens[2]);
                        ((Turismo) tmp).setModelo(tokens[3]);
                        ((Turismo) tmp).setColor(tokens[4]);
                        ((Turismo) tmp).setTarifa(Double.parseDouble(tokens[5]));
                        ((Turismo) tmp).setBastidor(Long.parseLong(tokens[6]));
                        ((Turismo) tmp).setDisponible(Boolean.parseBoolean(tokens[7]));
                        ((Turismo) tmp).setNumeroPuertas(Integer.parseInt(tokens[8]));
                    } else if (tmp instanceof Deportivo) {
                        ((Deportivo) tmp).setMatricula(tokens[1]);
                        ((Deportivo) tmp).setMarca(tokens[2]);
                        ((Deportivo) tmp).setModelo(tokens[3]);
                        ((Deportivo) tmp).setColor(tokens[4]);
                        ((Deportivo) tmp).setTarifa(Double.parseDouble(tokens[5]));
                        ((Deportivo) tmp).setBastidor(Long.parseLong(tokens[6]));
                        ((Deportivo) tmp).setDisponible(Boolean.parseBoolean(tokens[7]));
                    } else if (tmp instanceof Furgoneta) {
                        ((Furgoneta) tmp).setMatricula(tokens[1]);
                        ((Furgoneta) tmp).setMarca(tokens[2]);
                        ((Furgoneta) tmp).setModelo(tokens[3]);
                        ((Furgoneta) tmp).setColor(tokens[4]);
                        ((Furgoneta) tmp).setTarifa(Double.parseDouble(tokens[5]));
                        ((Furgoneta) tmp).setBastidor(Long.parseLong(tokens[6]));
                        ((Furgoneta) tmp).setDisponible(Boolean.parseBoolean(tokens[7]));
                    }

                }
                System.out.println();
                lista2.add(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (Vehiculo c : lista2) {
           
            System.out.println(lista2);
        }

    }

}

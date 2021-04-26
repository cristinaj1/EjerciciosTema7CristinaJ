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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static ArrayList<Vehiculo> listaD = new ArrayList<>();
    private static ArrayList<Vehiculo> listaT = new ArrayList<>();
    private static ArrayList<Vehiculo> listaF = new ArrayList<>();

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
    //Es el ejercicio 9B
    private static void escribirDeportivo(ArrayList<Vehiculo> a) {
        String idFichero2 = "Deportivos.csv";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2))) {
            flujo.write("Color,Marca,Matricula,Modelo,Bastidor,Tarifa");
            flujo.newLine();
            for (int i = 0; i < a.size(); i++) {
                flujo.write(a.get(i).getColor() + ",");
                flujo.write(a.get(i).getMarca() + ",");
                flujo.write(a.get(i).getMatricula() + ",");
                flujo.write(a.get(i).getModelo() + ",");
                flujo.write(a.get(i).getBastidor() + ",");
                flujo.write(a.get(i).getTarifa() + ",");
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escribirFurgoneta(ArrayList<Vehiculo> a) {
        String idFichero2 = "Furgonetas.csv";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2))) {
            flujo.write("Color,Marca,Matricula,Modelo,Bastidor,Tarifa");
            flujo.newLine();
            for (int i = 0; i < a.size(); i++) {
                flujo.write(a.get(i).getColor() + ",");
                flujo.write(a.get(i).getMarca() + ",");
                flujo.write(a.get(i).getMatricula() + ",");
                flujo.write(a.get(i).getModelo() + ",");
                flujo.write(a.get(i).getBastidor() + ",");
                flujo.write(a.get(i).getTarifa() + ",");
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escribirTurismo(ArrayList<Vehiculo> a) {
        String idFichero2 = "Turismos.csv";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2))) {
            flujo.write("Color,Marca,Matricula,Modelo,Bastidor,Tarifa");
            flujo.newLine();
            for (int i = 0; i < a.size(); i++) {
                flujo.write(a.get(i).getColor() + ",");
                flujo.write(a.get(i).getMarca() + ",");
                flujo.write(a.get(i).getMatricula() + ",");
                flujo.write(a.get(i).getModelo() + ",");
                flujo.write(a.get(i).getBastidor() + ",");
                flujo.write(a.get(i).getTarifa() + ",");
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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

        System.out.println("Leyendo el fichero: " + idFichero);
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(":");

                switch (Integer.parseInt(tokens[0])) { //swicht permite string(atenta porque puede servir)
                    case 0:
                        Turismo t1 = new Turismo();
                        t1.setMatricula(tokens[1]);
                        t1.setMarca(tokens[2]);
                        t1.setModelo(tokens[3]);
                        t1.setColor(tokens[4]);
                        t1.setTarifa(Double.parseDouble(tokens[5]));
                        t1.setBastidor(Long.parseLong(tokens[6]));
                        t1.setDisponible(Boolean.parseBoolean(tokens[7]));
                        t1.setNumeroPuertas(Integer.parseInt(tokens[8]));
                        listaT.add(t1);
                        lista2.add(t1);
                        break;
                    case 1:
                        Deportivo d1 = new Deportivo();
                        d1.setMatricula(tokens[1]);
                        d1.setMarca(tokens[2]);
                        d1.setModelo(tokens[3]);
                        d1.setColor(tokens[4]);
                        d1.setTarifa(Double.parseDouble(tokens[5]));
                        d1.setBastidor(Long.parseLong(tokens[6]));
                        d1.setDisponible(Boolean.parseBoolean(tokens[7]));
                        d1.setCilindrada(Integer.parseInt(tokens[8]));
                        listaD.add(d1);
                        lista2.add(d1);
                        break;
                    case 2:
                        Furgoneta f1 = new Furgoneta();
                        f1.setMatricula(tokens[1]);
                        f1.setMarca(tokens[2]);
                        f1.setModelo(tokens[3]);
                        f1.setColor(tokens[4]);
                        f1.setTarifa(Double.parseDouble(tokens[5]));
                        f1.setBastidor(Long.parseLong(tokens[6]));
                        f1.setDisponible(Boolean.parseBoolean(tokens[7]));
                        f1.setCarga(Integer.parseInt(tokens[8]));
                        listaF.add(f1);
                        lista2.add(f1);
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Ejercicio 9B
        for (Vehiculo lista : lista2) {
            System.out.println(lista);
        }
        for (Vehiculo lista : listaD) {
            System.out.println(lista);
            escribirDeportivo(listaD);
        }
        for (Vehiculo lista : listaT) {
            System.out.println(lista);
            escribirFurgoneta(listaT);
        }
        for (Vehiculo lista : listaF) {
            System.out.println(lista);
            escribirTurismo(listaF);
        }
        
    }
}

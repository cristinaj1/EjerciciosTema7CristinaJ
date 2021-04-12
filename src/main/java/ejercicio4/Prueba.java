/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Cris
 */
public class Prueba {

    private Long bastidor;
    private String matricula;
    private static String[] marca = {"Audi", "Seat", "Renault"};
    private static String[] modelo = {"Nuevo", "Clásico", "Semi nuevo(2 años como mucho de antigüedad)"};
    private static String[] color = {"Blanco", "Negro", "Rojo", "Amarillo", "Azul"};
    private double tarifa;
    private boolean disponible;
    //Turismo
    int numeroPuertas;
    //Furgo 
    private int carga; // En kg
    private int volumen; // En m3
    //Deportivo 
    private int cilindrada;

    public static String generarPlaca() {
        String matricula = "";
// Inicializamos la instancia de la clase Random con la que
// generaremos el valor aleatorio.
        Random rnd = new Random();

// Creamos un ciclo que se ejecute 7 veces, que corresponden al
// texto de la matrícula.
        for (int i = 0; i < 7; i++) {
            // Con este condicional verificamos si estamos en la parte
            // numérica o alfabética de la matrícula.
            // Solo debe entrar al condicional si estamos generando los
            // números de la matrícula.
            if (i < 4) {
                // Con esta instrucción se genera un número aleatorio entre
                // 0 y 9, no se incluye el 10.
                matricula += rnd.nextInt(10);
            } // Entrará en esta parte del condicional cuando estemos generando
            // las letras de la matrícula.
            else {
                // Con esta instrucción se genera un número aleatorio entre
                // 65 y 90, no se incluye el 91. Luego se convierte a un 
                // caracter ASCII.
                matricula += (char) (rnd.nextInt(91) + 65);
            }
        }

        return matricula;
    }

    public static void main(String[] args) {
        Random rd = new Random();

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
            Vehiculo turismo = new Turismo(rd.nextInt(5 - 1 + 1) + 1, rd.nextLong(), generarPlaca(), marquita, modelito, colorcito, rd.nextDouble() + 100, rd.nextBoolean());

            System.out.println(turismo);
        }
    }

}
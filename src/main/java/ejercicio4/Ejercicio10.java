/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cris
 */
public class Ejercicio10 {public static void main(String[] args) {
        
        // Copiar los tres ficheros a un directorio previamente creado en â€œ./copiasâ€�.
        // Creo el directorio
        crearDirectorio("./copias");
        // Copio los archivos a la nueva ruta
        copiarFicheros("./turismo.csv", "./copias/turismo.csv");
        copiarFicheros("./deportivo.csv", "./copias/deportivo.csv");
        copiarFicheros("./furgoneta.csv", "./copias/furgoneta.csv");
        
        // Mostrar por consola el nombre de los ficheros contenidos en â€œcopiasâ€�.
        listarDirectorio("./copias");
        
        // Leer los ficheros de la carpeta â€œcopiasâ€� e ir guardando los objetos 
        // en una lista de VehÃ­culos e imprimir la lista por pantalla. 
        leerFicheros("./copias/turismo.csv");
        leerFicheros("./copias/deportivo.csv");
        leerFicheros("./copias/furgoneta.csv");
        
        borrarElemento("./turismo.csv");
        borrarElemento("./deportivo.csv");
        borrarElemento("./furgoneta.csv");
    }
    
    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta estÃ¡ mal escrita o no existe");
        }

    }
    
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }
    }
    
    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }
    
    public static void leerFicheros (String idFichero){
        System.out.println("Leyendo el fichero: " + idFichero);

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList <Vehiculo> vehiculos = new ArrayList<>();
        
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(":");
                Vehiculo tmp;
                switch (tokens[0]) {
                case "0":
			// Turismo
			tmp = new Turismo();
			break;
		case "1":
			// Deportivo
			tmp = new Deportivo();
			break;
                default:
                    // Furgoneta
                    tmp = new Furgoneta();
                    break;
		}
                // Saltamos el 0 por ser el tipo de vehiculo
		tmp.setBastidor(Long.parseLong(tokens[1]));
		tmp.setMatricula(tokens[2]);
		tmp.setMarca(tokens[3]);
		tmp.setModelo(tokens[4]);
                tmp.setColor(tokens[5]);
		tmp.setTarifa(Double.parseDouble(tokens[6]));
		tmp.setDisponible(Boolean.valueOf(tokens[7]));
		if (tmp instanceof Turismo) {
			((Turismo) tmp).setNumeroPuertas(Integer.parseInt(tokens[8]));
		} else if (tmp instanceof Furgoneta) {
                        ((Furgoneta) tmp).setCarga(Integer.parseInt(tokens[8]));
			((Furgoneta) tmp).setCarga(Integer.parseInt(tokens[9]));
                } else if (tmp instanceof Deportivo) {
			((Deportivo) tmp).setCilindrada(Integer.parseInt(tokens[8]));
		}
                vehiculos.add(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Imprimir la lista por pantalla. 
        for (Vehiculo veh1 : vehiculos) {
            System.out.println(veh1);
        }
    }
    
    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no estÃ¡ vacÃ­o");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }
}

    


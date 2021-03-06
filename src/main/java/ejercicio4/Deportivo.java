/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Cris
 */
public class Deportivo extends Vehiculo {

    private int cilindrada; // Atributo específico para Deportivo

    public Deportivo(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible, int cilindrada) {
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public Deportivo() {
        cilindrada = 4;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "1:" + super.toString() + ":" + cilindrada;
    }

    public void metodoDeportivo() {
        System.out.println("Este método es de la clase Deportivo");
    }
}

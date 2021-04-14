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
public class Furgoneta extends Vehiculo {

    private int carga; // En kg

    public Furgoneta(Long bastidor, String matricula, String marca, String modelo, String color, double tarifa, boolean disponible, int carga) {
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
    }

    public Furgoneta() {
        this.carga = 1000;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return "2:" + super.toString() + ":" + carga;
    }

    public void metodoFurgoneta() {
        System.out.println("Este método es de la clase Furgoneta");
    }
}

package model;

public class Gato extends Animal {
    
    private int sociabilidad;
    private String pelaje;
    
    public Gato () {
        super();
    }
    public Gato (String nombre, String raza, int edad, boolean disponibilidad, String centro, boolean sano, int sociabilidad, String pelaje) {
        super(nombre, raza, edad, disponibilidad, centro, sano);
        this.sociabilidad = sociabilidad;
        this.pelaje = pelaje;
    }
    public int getSociabilidad() {
        return sociabilidad;
    }
    public void setSociabilidad(int sociabilidad) {
        this.sociabilidad = sociabilidad;
    }
    public String getPelaje() {
        return pelaje;
    }
    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }
    public String toString () {
        return super.toString() + " Sociabilidad: " + sociabilidad + " Pelaje: " + pelaje;
    }
    public String acariciar() {
        if (this.sociabilidad < 10) {
            this.sociabilidad++;
        }

        if (this.sociabilidad > 7) {
            return this.getNombre() + " ronronea de felicidad.";
        } else if (this.sociabilidad >= 4) {
            return this.getNombre() + " te deja acariciarle con cautela.";
        } else {
            return "¡Cuidado! " + this.getNombre() + " te ha bufado.";
        }
    }
}

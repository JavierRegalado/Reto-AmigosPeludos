package model;

public class Gato extends Animal {
    
    private int sociabilidad;
    private String pelaje;
    
    public Gato() {
        super();
    }

    // Constructor adaptado a la nueva clase Animal y con asignación directa
    public Gato(String idAnimal, String idCentro, String nombreAnim, int edadMeses, String caracteristicas, String necesidadesEspeciales, int sociabilidad, String pelaje) {
        super(idAnimal, idCentro, nombreAnim, edadMeses, Especie.Gato, caracteristicas, necesidadesEspeciales);
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

    @Override
    public String toString() {
        return super.toString() + " -> Gato [Sociabilidad: " + sociabilidad + ", Pelaje: " + pelaje + "]";
    }

    public String acariciar() {
        if (this.sociabilidad < 10) {
            this.sociabilidad++;
        }

        // Usamos getNombreAnim() que es el getter de la clase Animal actual
        if (this.sociabilidad > 7) {
            return this.getNombreAnim() + " ronronea de felicidad.";
        } else if (this.sociabilidad >= 4) {
            return this.getNombreAnim() + " te deja acariciarle con cautela.";
        } else {
            return "¡Cuidado! " + this.getNombreAnim() + " te ha bufado.";
        }
    }
}
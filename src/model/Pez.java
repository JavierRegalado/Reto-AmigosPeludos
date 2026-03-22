package model;

public class Pez extends Animal {

    private String color;
    private boolean aguaDulce;
    
    public Pez() {
        super();
    }

    public Pez(String idAnimal, String idCentro, String nombreAnim, int edadMeses, String caracteristicas, String necesidadesEspeciales, String color, boolean aguaDulce) {
        super(idAnimal, idCentro, nombreAnim, edadMeses, Especie.Pez, caracteristicas, necesidadesEspeciales);
        this.color = color;
        this.aguaDulce = aguaDulce;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAguaDulce() {
        return aguaDulce;
    }

    public void setAguaDulce(boolean aguaDulce) {
        this.aguaDulce = aguaDulce;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Pez [Color=" + color + ", Agua dulce=" + aguaDulce + "]";
    }
}
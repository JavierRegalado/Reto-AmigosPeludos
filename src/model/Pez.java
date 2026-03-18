package model;

public class Pez extends Animal {

  private String color;
    private boolean aguaDulce;
    
    public Pez() {
        
    }
    public Pez(String nombre, String raza, int edad, boolean disponibilidad, String centro, boolean sano, String color, boolean aguaDulze) {
        super(nombre, raza, edad, disponibilidad, centro, sano);
        this.color = color;
        this.aguaDulce = aguaDulze;
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
        return super.toString() + "Pez [color=" + color + ", agua dulce=" + aguaDulce + "]";
    }
}

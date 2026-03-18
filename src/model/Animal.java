package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Animal {
    
    private static final Pattern PATRON_LETRAS = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ ]+$");


    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private boolean disponibilidad;
    private String centro;
    private boolean sano;
    
    private static int contadorId = 0;
    
    public Animal() {
        contadorId++;
        this.id = contadorId;
    }

    public Animal(String nombre, String raza, int edad, boolean disponibilidad, String centro, boolean sano) {
        
        contadorId++;
        this.id = contadorId;
        
        this.setNombre(nombre);
        this.setRaza(raza);
        this.setEdad(edad);
        this.setDisponibilidad(disponibilidad);
        this.setCentro(centro);
        this.setSano(sano);
    }


    public int getId() {
        return id;
    }
    public static int getContadorId() {
        return contadorId;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        validarYAsignar(nombre, "Nombre");
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        validarYAsignar(raza, "Raza");
        this.raza = raza;
    }

    public String getCentro() {
        return centro;
    }
    public void setCentro(String centro) {
        validarYAsignar(centro, "Centro");
        this.centro = centro;
    }
    
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("La edad no puede ser negativa");
        this.edad = edad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean isSano() {
        return sano;
    }
    public void setSano(boolean sano) {
        this.sano = sano;
    }

    //metodo para validar
    private void validarYAsignar(String texto, String nombreCampo) {
        //Comprueba si es nulo (seguridad básica)
        if (texto == null) throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
        
        //Comprueba si cumple el patrón (SOLO LETRAS)
        Matcher matcher = PATRON_LETRAS.matcher(texto);
        if (!matcher.matches()) {
            //Si falla, lanza la "bomba" (Excepción) con un mensaje
            throw new IllegalArgumentException(nombreCampo + " '" + texto + "' no es válido. Solo se permiten letras.");
        }
    }

    @Override
    public String toString() {
        return "[ID= " + id + ", Nombre= " + nombre + ", Raza= " + raza + ", Edad= " + edad + ", Disponible= " + (disponibilidad ? "Sí" : "No") + ", Centro= " + centro + ", Sano= " + (sano ? "Sí" : "No") + "]";
    }
    //metodo equals 
    public boolean equals(Object obj) {

        if (this == obj) return true;
        
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Animal anim = (Animal) obj;
        return this.id == anim.id;
    }
}
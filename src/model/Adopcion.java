package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adopcion {
    
    private static final Pattern PATRON_LETRAS = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ ]+$");

    public static int contadorId = 0;
    private int id;
    private String Solicitante;
    private String AnimalSolicitado;
    private String RazaAnimal;
    
    public Adopcion() {
        contadorId++;
        this.id = contadorId;
    }
    
    public Adopcion(String solicitante, String animalSolicitado, String razaAnimal) {
        contadorId++;
        this.id = contadorId;
        this.setSolicitante(solicitante);
        this.setAnimalSolicitado(animalSolicitado);
        this.setRazaAnimal(razaAnimal);
    }


    public int getId() {
        return id;
    }
    public static int getContadorId() {
        return contadorId;
    }
    public String getSolicitante() {
        return Solicitante;
    }
    public void setSolicitante(String solicitante) {
        validarYAsignar(solicitante, "Nombre del Solicitante");
        this.Solicitante = solicitante;
    }

    public String getAnimalSolicitado() {
        return AnimalSolicitado;
    }
    public void setAnimalSolicitado(String animalSolicitado) {
        validarYAsignar(animalSolicitado, "Nombre del Animal");
        this.AnimalSolicitado = animalSolicitado;
    }

    public String getRazaAnimal() {
        return RazaAnimal;
    }
    public void setRazaAnimal(String razaAnimal) {
        validarYAsignar(razaAnimal, "Raza del Animal");
        this.RazaAnimal = razaAnimal;
    }
    
    private void validarYAsignar(String texto, String nombreCampo) {
        if (texto == null) throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
        
        Matcher matcher = PATRON_LETRAS.matcher(texto);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(nombreCampo + " '" + texto + "' contiene caracteres inválidos (números o símbolos).");
        }
    }
    
    
    @Override
    public String toString() {
        return "[ID= " + id + ", Solicitante= " + Solicitante + ", Animal= " + AnimalSolicitado + ", Raza= "+ RazaAnimal + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Adopcion other = (Adopcion) obj;
        return this.id == other.id;
    }
}
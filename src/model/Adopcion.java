package model;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adopcion {
    
    
    private static final Pattern PATRON_ID = Pattern.compile("^[A-Z]{3}[0-9]{3}$");
    private static final Pattern PATRON_DNI = Pattern.compile("^[0-9]{8}[A-Za-z]$");

    // Enum para reflejar el campo ENUM de la base de datos
    public enum EstadoAdopcion {
        Pendiente, Aprobada, Rechazada
    }

    private String idSolicitud;
    private String idAnimal;
    private String dniAdoptante;
    private LocalDate fechaSolicitud;
    private EstadoAdopcion estado;
    
    // Constructor vacío
    public Adopcion() {
        this.fechaSolicitud = LocalDate.now();
        this.estado = EstadoAdopcion.Pendiente; 
    }
    
 // Constructor con parámetros (Asignación directa sin validaciones ni setters)
    public Adopcion(String idSolicitud, String idAnimal, String dniAdoptante, LocalDate fechaSolicitud, EstadoAdopcion estado) {
        this.idSolicitud = idSolicitud;
        this.idAnimal = idAnimal;
        this.dniAdoptante = dniAdoptante;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    // --- GETTERS Y SETTERS ---

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        validarConPatron(idSolicitud, PATRON_ID, "ID de Solicitud (ej. SOL001)");
        this.idSolicitud = idSolicitud;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        validarConPatron(idAnimal, PATRON_ID, "ID del Animal (ej. ANI001)");
        this.idAnimal = idAnimal;
    }

    public String getDniAdoptante() {
        return dniAdoptante;
    }

    public void setDniAdoptante(String dniAdoptante) {
        validarConPatron(dniAdoptante, PATRON_DNI, "DNI del Adoptante");
        this.dniAdoptante = dniAdoptante.toUpperCase(); // Guardar siempre la letra en mayúscula
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        if (fechaSolicitud == null) throw new IllegalArgumentException("La fecha de solicitud no puede ser nula.");
        this.fechaSolicitud = fechaSolicitud;
    }

    public EstadoAdopcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAdopcion estado) {
        if (estado == null) throw new IllegalArgumentException("El estado no puede ser nulo.");
        this.estado = estado;
    }
    

    private void validarConPatron(String texto, Pattern patron, String nombreCampo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
        }
        
        Matcher matcher = patron.matcher(texto.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException(nombreCampo + " '" + texto + "' no tiene un formato válido.");
        }
    }
    
    
    @Override
    public String toString() {
        return "Adopcion [ID Solicitud=" + idSolicitud + 
               ", ID Animal=" + idAnimal + 
               ", DNI Adoptante=" + dniAdoptante + 
               ", Fecha=" + fechaSolicitud + 
               ", Estado=" + estado + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Adopcion other = (Adopcion) obj;
        return this.idSolicitud != null && this.idSolicitud.equals(other.idSolicitud);
    }
}
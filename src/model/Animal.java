package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Animal {

	// Patrones de validación
	private static final Pattern PATRON_ID_ANIMAL = Pattern.compile("^ANI[0-9]{3}$"); // Ej: ANI001
	private static final Pattern PATRON_ID_CENTRO = Pattern.compile("^CEN[0-9]{3}$"); // Ej: CEN001
	// Patrón más permisivo para nombres y descripciones (permite espacios, comas y
	// puntos)
	private static final Pattern PATRON_TEXTO = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ0-9 .,]+$");

	// Enum para reflejar el campo ENUM 'Especie' de la base de datos
	public enum Especie {
		Perro, Gato, Pez
	}

	private String idAnimal;
	private String idCentro;
	private String nombreAnim;
	private int edadMeses;
	private Especie especie;
	private String caracteristicas;
	private String necesidadesEspeciales;

// --- CONSTRUCTORES ---

	// Constructor vacío
	public Animal() {
	}

	public Animal(String idAnimal, String idCentro, String nombreAnim, int edadMeses, Especie especie,
			String caracteristicas, String necesidadesEspeciales) {
		this.idAnimal = idAnimal;
		this.idCentro = idCentro;
		this.nombreAnim = nombreAnim;
		this.edadMeses = edadMeses;
		this.especie = especie;
		this.caracteristicas = caracteristicas;
		this.necesidadesEspeciales = necesidadesEspeciales;
	}

	// --- GETTERS Y SETTERS ---

	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		validarConPatron(idAnimal, PATRON_ID_ANIMAL, "ID del Animal", false);
		this.idAnimal = idAnimal;
	}

	public String getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(String idCentro) {
		validarConPatron(idCentro, PATRON_ID_CENTRO, "ID del Centro", false);
		this.idCentro = idCentro;
	}

	public String getNombreAnim() {
		return nombreAnim;
	}

	public void setNombreAnim(String nombreAnim) {
		validarConPatron(nombreAnim, PATRON_TEXTO, "Nombre del Animal", false);
		this.nombreAnim = nombreAnim;
	}

	public int getEdadMeses() {
		return edadMeses;
	}

	public void setEdadMeses(int edadMeses) {
		if (edadMeses < 0)
			throw new IllegalArgumentException("La edad en meses no puede ser negativa.");
		this.edadMeses = edadMeses;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		if (especie == null)
			throw new IllegalArgumentException("La especie no puede estar vacía.");
		this.especie = especie;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		validarConPatron(caracteristicas, PATRON_TEXTO, "Características", true);
		this.caracteristicas = caracteristicas;
	}

	public String getNecesidadesEspeciales() {
		return necesidadesEspeciales;
	}

	public void setNecesidadesEspeciales(String necesidadesEspeciales) {
		validarConPatron(necesidadesEspeciales, PATRON_TEXTO, "Necesidades Especiales", true);
		this.necesidadesEspeciales = necesidadesEspeciales;
	}

	// --- MÉTODOS DE VALIDACIÓN ---

	private void validarConPatron(String texto, Pattern patron, String nombreCampo, boolean permiteNull) {
		// Si el campo permite nulos (como caracteristicas o necesidades en la BD) y
		// viene nulo/vacío, lo damos por bueno
		if (permiteNull && (texto == null || texto.trim().isEmpty())) {
			return;
		}

		// Si no permite nulos y viene vacío, lanza error
		if (!permiteNull && (texto == null || texto.trim().isEmpty())) {
			throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
		}

		// Comprobación con la expresión regular
		Matcher matcher = patron.matcher(texto.trim());
		if (!matcher.matches()) {
			throw new IllegalArgumentException(
					nombreCampo + " '" + texto + "' contiene caracteres inválidos o no tiene el formato correcto.");
		}
	}

	// --- TOSTRING Y EQUALS ---

	@Override
	public String toString() {
		return "Animal [ID=" + idAnimal + ", Centro=" + idCentro + ", Nombre=" + nombreAnim + ", Edad(meses)="
				+ edadMeses + ", Especie=" + especie + ", Caracteristicas="
				+ (caracteristicas != null ? caracteristicas : "Ninguna") + ", Necesidades="
				+ (necesidadesEspeciales != null ? necesidadesEspeciales : "Ninguna") + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return this.idAnimal != null && this.idAnimal.equals(other.idAnimal);
	}
}
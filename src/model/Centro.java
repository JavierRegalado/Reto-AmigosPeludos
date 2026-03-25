package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Centro {

	// --- PATRONES DE VALIDACIÓN ---
	private static final Pattern PATRON_ID = Pattern.compile("^CEN[0-9]{3}$"); // Ej: CEN001
	private static final Pattern PATRON_LETRAS = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ ]+$");
	private static final Pattern PATRON_DIRECCION = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ0-9,ºª\\. -]+$");

	// --- ATRIBUTOS ---
	private String idCentro;
	private String nombre;
	private String localidad;
	private int capaMax;

	// --- CONSTRUCTORES ---

	public Centro() {
		// Constructor vacío listo para ser llenado desde la BD
	}

	public Centro(String idCentro, String nombre, String localidad, int capaMax) {
		this.idCentro = idCentro;
		this.nombre = nombre;
		this.localidad = localidad;
		this.capaMax = capaMax;
	}

	// --- GETTERS Y SETTERS ---
	// (Se mantienen por si en el futuro necesitas modificar un centro ya creado o
	// para el DAO)

	public String getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(String idCentro) {
		validarConPatron(idCentro, PATRON_ID, "ID del Centro (ej. CEN001)");
		this.idCentro = idCentro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		validarConPatron(nombre, PATRON_DIRECCION, "Dirección");
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		validarConPatron(localidad, PATRON_LETRAS, "Provincia");
		this.localidad = localidad;
	}

	public int getCapMax() {
		return capaMax;
	}

	public void setCapaMax(int CapaMax) {
		this.capaMax = CapaMax;
	}

	// --- MÉTODO DE VALIDACIÓN UNIFICADO ---

	private void validarConPatron(String texto, Pattern patron, String nombreCampo) {
		if (texto == null || texto.trim().isEmpty()) {
			throw new IllegalArgumentException(nombreCampo + " no puede estar vacío.");
		}

		Matcher matcher = patron.matcher(texto.trim());
		if (!matcher.matches()) {
			throw new IllegalArgumentException(
					nombreCampo + " '" + texto + "' contiene caracteres inválidos o no tiene el formato correcto.");
		}
	}

	// --- TO STRING Y EQUALS ---

	@Override
	public String toString() {
		return "Centro [ID=" + idCentro + ", Nombre= " + nombre + ", Localidad= " + localidad + ", Capacidad maxima = " + capaMax
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Centro other = (Centro) obj;
		return this.idCentro != null && this.idCentro.equals(other.idCentro);
	}
}
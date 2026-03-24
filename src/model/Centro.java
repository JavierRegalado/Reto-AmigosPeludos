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
	private String direccion;
	private String provincia;
	private String ciudad;

	// --- CONSTRUCTORES ---

	public Centro() {
		// Constructor vacío listo para ser llenado desde la BD
	}

	public Centro(String idCentro, String direccion, String provincia, String ciudad) {
		this.idCentro = idCentro;
		this.direccion = direccion;
		this.provincia = provincia;
		this.ciudad = ciudad;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		validarConPatron(direccion, PATRON_DIRECCION, "Dirección");
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		validarConPatron(provincia, PATRON_LETRAS, "Provincia");
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		validarConPatron(ciudad, PATRON_LETRAS, "Ciudad");
		this.ciudad = ciudad;
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
		return "Centro [ID=" + idCentro + ", Dirección=" + direccion + ", Provincia=" + provincia + ", Ciudad=" + ciudad
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
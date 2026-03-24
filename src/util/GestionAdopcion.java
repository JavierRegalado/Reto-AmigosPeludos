package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import BD.Conector;
import model.Adopcion;
import model.Adopcion.EstadoAdopcion;

public class GestionAdopcion {

	// 1. LEER TODAS LAS ADOPCIONES
	public ArrayList<Adopcion> getListaAdopciones() throws SQLException {
		ArrayList<Adopcion> listaAdopcion = new ArrayList<>();
		String query = "SELECT * FROM adopcion";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		ResultSet myRs = myStmt.executeQuery();

		while (myRs.next()) {
			String idSolicitud = myRs.getString("id_solicitud");
			String idAnimal = myRs.getString("id_animal");
			String dniAdoptante = myRs.getString("dni_adoptante");
			LocalDate fechaSolicitud = myRs.getDate("fecha_solicitud").toLocalDate();
			EstadoAdopcion estado = EstadoAdopcion.valueOf(myRs.getString("estado"));

			Adopcion adop = new Adopcion(idSolicitud, idAnimal, dniAdoptante, fechaSolicitud, estado);
			listaAdopcion.add(adop);
		}

		// Cerramos conexiones manualmente
		myRs.close();
		myStmt.close();
		con.close();

		return listaAdopcion;
	}

	// 2. BUSCAR UNA ADOPCIÓN POR ID
	public Adopcion buscarAdopcionId(String idBusqueda) throws SQLException {
		Adopcion adop = null;
		String query = "SELECT * FROM adopcion WHERE id_solicitud = ?";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		myStmt.setString(1, idBusqueda);

		ResultSet myRs = myStmt.executeQuery();

		if (myRs.next()) {
			String idSolicitud = myRs.getString("id_solicitud");
			String idAnimal = myRs.getString("id_animal");
			String dniAdoptante = myRs.getString("dni_adoptante");
			LocalDate fechaSolicitud = myRs.getDate("fecha_solicitud").toLocalDate();
			EstadoAdopcion estado = EstadoAdopcion.valueOf(myRs.getString("estado"));

			adop = new Adopcion(idSolicitud, idAnimal, dniAdoptante, fechaSolicitud, estado);
		}

		// Cerramos conexiones
		myRs.close();
		myStmt.close();
		con.close();

		return adop;
	}

	// 3. AÑADIR (INSERTAR) UNA ADOPCIÓN
	public boolean añadirAdop(Adopcion adop) throws SQLException {
		String insert = "INSERT INTO adopcion (id_solicitud, id_animal, dni_adoptante, fecha_solicitud, estado) VALUES (?, ?, ?, ?, ?)";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(insert);

		myStmt.setString(1, adop.getIdSolicitud());
		myStmt.setString(2, adop.getIdAnimal());
		myStmt.setString(3, adop.getDniAdoptante());
		myStmt.setDate(4, java.sql.Date.valueOf(adop.getFechaSolicitud()));
		myStmt.setString(5, adop.getEstado().name());

		int rows = myStmt.executeUpdate();

		// Cerramos conexiones (aquí no hay ResultSet)
		myStmt.close();
		con.close();

		return rows > 0;
	}

	// 4. MODIFICAR (ACTUALIZAR) UNA ADOPCIÓN
	public boolean modAdop(Adopcion adop) throws SQLException {
		String update = "UPDATE adopcion SET id_animal = ?, dni_adoptante = ?, fecha_solicitud = ?, estado = ? WHERE id_solicitud = ?";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(update);

		myStmt.setString(1, adop.getIdAnimal());
		myStmt.setString(2, adop.getDniAdoptante());
		myStmt.setDate(3, java.sql.Date.valueOf(adop.getFechaSolicitud()));
		myStmt.setString(4, adop.getEstado().name());
		myStmt.setString(5, adop.getIdSolicitud());

		int rows = myStmt.executeUpdate();

		// Cerramos conexiones
		myStmt.close();
		con.close();

		return rows > 0;
	}

	// 5. ELIMINAR (BORRAR) UNA ADOPCIÓN
	public Adopcion elimAdop(String idABuscar) throws SQLException {
		String delete = "DELETE FROM adopcion WHERE id_solicitud = ?";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(delete);

		myStmt.setString(1, idABuscar);

		int rows = myStmt.executeUpdate();

		// Cerramos conexiones
		myStmt.close();
		con.close();

		return rows > 0;
	}
}
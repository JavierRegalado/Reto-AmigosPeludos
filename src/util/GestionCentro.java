package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conector;
import model.Centro;

public class GestionCentro {

	// 1. LEER TODOS LOS CENTROS (listarCentros)
	public ArrayList<Centro> listarCentros() throws SQLException {
		ArrayList<Centro> listaCentros = new ArrayList<>();
		String query = "SELECT * FROM centro";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		ResultSet myRs = myStmt.executeQuery();

		while (myRs.next()) {
			String idCentro = myRs.getString("id_centro");
			String nombre = myRs.getString("Nombre");
			String localidad = myRs.getString("Localidad");
			int capaMax = myRs.getInt("CapacidadMaxima");

			Centro cen = new Centro(idCentro, nombre, localidad, capaMax);
			listaCentros.add(cen);
		}

		myRs.close();
		myStmt.close();
		con.close();

		if (listaCentros.isEmpty()) {
			return null;
		}
		return listaCentros;
	}

	// 2. BUSCAR UN CENTRO POR ID
	public Centro buscarCentroID(String idBusqueda) throws SQLException {
		Centro cen = null;
		String query = "SELECT * FROM centro WHERE id_centro = ?";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		myStmt.setString(1, idBusqueda);

		ResultSet myRs = myStmt.executeQuery();

		if (myRs.next()) {
			String idCentro = myRs.getString("id_centro");
			String nombre = myRs.getString("Nombre");
			String localidad = myRs.getString("Localidad");
			int capaMax = myRs.getInt("CapacidadMaxima");

			cen = new Centro(idCentro, nombre, localidad, capaMax);
		}

		myRs.close();
		myStmt.close();
		con.close();

		return cen;
	}

	// 3. AÑADIR (INSERTAR) UN CENTRO
	public void anadirCentro(Centro cen) throws SQLException {
		String insert = "CALL crearCentro(?, ?, ?, ?)";

	
		PreparedStatement myStmt = Conector.getConexion().prepareStatement(insert);

		myStmt.setString(1, cen.getIdCentro());
		myStmt.setString(2, cen.getNombre());
		myStmt.setString(3, cen.getLocalidad());
		myStmt.setInt(4, cen.getCapMax());

		myStmt.executeUpdate();

		myStmt.close();
	}

	// 4. MODIFICAR (ACTUALIZAR) UN CENTRO
	// Pasamos el objeto Centro entero en lugar de las variables sueltas
	public Centro modCentro(Centro cen) throws SQLException {
		String update = "CALL modCen(?, ?, ?)";


		PreparedStatement myStmt = Conector.getConexion().prepareStatement(update);

		myStmt.setString(1, cen.getIdCentro());
		myStmt.setString(2, cen.getNombre());
		myStmt.setInt(3, cen.getCapMax());

		myStmt.executeUpdate();

		myStmt.close();

		return cen;
	}

	// 5. ELIMINAR UN CENTRO
	public Centro eliminarCentro(String idABuscar) throws SQLException {
		// Buscamos primero el centro para poder devolverlo, como hacía tu método
		// original
		Centro cenEliminado = buscarCentroID(idABuscar);

		if (cenEliminado != null) {
			String delete = "CALL elimCentro(?)";

			Connection con = Conector.getConexion();
			PreparedStatement myStmt = con.prepareStatement(delete);
			myStmt.setString(1, idABuscar);

			myStmt.executeUpdate();

			myStmt.close();
			con.close();
		}

		return cenEliminado;
	}
}
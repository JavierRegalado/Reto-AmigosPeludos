package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.Conector;
import model.Animal;
import model.Animal.Especie;
import model.Gato;
import model.Perro;
import model.Pez;

public class GestionAnimal {

	// 1. LEER TODOS LOS ANIMALES (Usamos LEFT JOIN para traer los datos de las
	// tablas hijas)
	public ArrayList<Animal> getListaAnimales() throws SQLException {
		ArrayList<Animal> listaAnimales = new ArrayList<>();
		String query = "SELECT a.IDanimal, a.IDcentro, a.NombreAnim, a.EdadMeses, a.Especie, a.Caracteristicas, a.NecesidadesEspeciales, "
				+ "p.Raza AS RazaPerro, p.Tamano, p.Entrenado, " + "g.Raza AS RazaGato, g.TipoPelo, g.Sociabilidad, "
				+ "pz.AguaDulce, pz.EspeciePez, pz.CompatibleComunidad " + "FROM animales a "
				+ "LEFT JOIN perros p ON a.IDanimal = p.IDanimal " + "LEFT JOIN gatos g ON a.IDanimal = g.IDanimal "
				+ "LEFT JOIN peces pz ON a.IDanimal = pz.IDanimal";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		ResultSet myRs = myStmt.executeQuery();

		while (myRs.next()) {
			Animal ani = instanciarAnimalDesdeResultSet(myRs);
			listaAnimales.add(ani);
		}

		myRs.close();
		myStmt.close();
		con.close();

		return listaAnimales;
	}

	// 2. BUSCAR UN ANIMAL POR ID
	public Animal buscarAnimalId(String idBusqueda) throws SQLException {
		Animal ani = null;
		String query = "SELECT a.IDanimal, a.IDcentro, a.NombreAnim, a.EdadMeses, a.Especie, a.Caracteristicas, a.NecesidadesEspeciales, "
				+ "p.Raza AS RazaPerro, p.Tamano, p.Entrenado, " + "g.Raza AS RazaGato, g.TipoPelo, g.Sociabilidad, "
				+ "pz.AguaDulce, pz.EspeciePez, pz.CompatibleComunidad " + "FROM animales a "
				+ "LEFT JOIN perros p ON a.IDanimal = p.IDanimal " + "LEFT JOIN gatos g ON a.IDanimal = g.IDanimal "
				+ "LEFT JOIN peces pz ON a.IDanimal = pz.IDanimal " + "WHERE a.IDanimal = ?";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		myStmt.setString(1, idBusqueda);

		ResultSet myRs = myStmt.executeQuery();

		if (myRs.next()) {
			ani = instanciarAnimalDesdeResultSet(myRs);
		}

		myRs.close();
		myStmt.close();
		con.close();

		return ani;
	}

	// 3. AÑADIR (INSERTAR) UN ANIMAL (Se hace en dos pasos)
	public void añadirAnimal(Animal ani) throws SQLException {
		Connection con = Conector.getConexion();

		// Paso 1: Insertar en la tabla padre 'animales'
		String insertAnimal = "INSERT INTO animales (IDanimal, IDcentro, NombreAnim, EdadMeses, Especie, Caracteristicas, NecesidadesEspeciales) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmtAnimal = con.prepareStatement(insertAnimal);

		stmtAnimal.setString(1, ani.getIdAnimal());
		stmtAnimal.setString(2, ani.getIdCentro());
		stmtAnimal.setString(3, ani.getNombreAnim());
		stmtAnimal.setInt(4, ani.getEdadMeses());
		stmtAnimal.setString(5, ani.getEspecie().name());
		stmtAnimal.setString(6, ani.getCaracteristicas());
		stmtAnimal.setString(7, ani.getNecesidadesEspeciales());

		stmtAnimal.executeUpdate();
		stmtAnimal.close();

		// Paso 2: Insertar en la tabla hija correspondiente
		if (ani instanceof Perro p) {
			String insertPerro = "INSERT INTO perros (IDanimal, Raza, Tamano, Entrenado) VALUES (?, ?, ?, ?)";
			PreparedStatement stmtPerro = con.prepareStatement(insertPerro);
			stmtPerro.setString(1, p.getIdAnimal());
			stmtPerro.setString(2, p.getRaza()); // Asumiendo que añadiste getRaza() a tu clase Perro
			stmtPerro.setString(3, p.getTamano());
			stmtPerro.setBoolean(4, p.isEntrenado());
			stmtPerro.executeUpdate();
			stmtPerro.close();

		} else if (ani instanceof Gato g) {
			String insertGato = "INSERT INTO gatos (IDanimal, Raza, TipoPelo, Sociabilidad) VALUES (?, ?, ?, ?)";
			PreparedStatement stmtGato = con.prepareStatement(insertGato);
			stmtGato.setString(1, g.getIdAnimal());
			stmtGato.setString(2, g.getRaza()); // Asumiendo que añadiste getRaza() a tu clase Gato
			stmtGato.setString(3, g.getPelaje()); // Antes lo llamabas 'pelaje'
			stmtGato.setInt(4, g.getSociabilidad());
			stmtGato.executeUpdate();
			stmtGato.close();

		} else if (ani instanceof Pez pz) {
			String insertPez = "INSERT INTO peces (IDanimal,AguaDulce, EspeciePez, CompatibleComunidad) VALUES (?, ?, ?, ?)";
			PreparedStatement stmtPez = con.prepareStatement(insertPez);
			stmtPez.setString(1, pz.getIdAnimal());
			stmtPez.setBoolean(2, pz.isAguaDulce()); // Antes era boolean aguaDulce
			stmtPez.setString(3, pz.getEspeciePez());
			stmtPez.setBoolean(4, pz.isCompatibleComunidad());
			stmtPez.executeUpdate();
			stmtPez.close();
		}

		con.close();
	}

	// 4. MODIFICAR (ACTUALIZAR) UN ANIMAL (Se hace en dos pasos)
	public Animal modAnimal(Animal ani) throws SQLException {
		Connection con = Conector.getConexion();

		// Paso 1: Actualizar tabla 'animales'
		String updateAnimal = "UPDATE animales SET IDcentro = ?, NombreAnim = ?, EdadMeses = ?, Caracteristicas = ?, NecesidadesEspeciales = ? WHERE IDanimal = ?";
		PreparedStatement stmtAnimal = con.prepareStatement(updateAnimal);

		stmtAnimal.setString(1, ani.getIdCentro());
		stmtAnimal.setString(2, ani.getNombreAnim());
		stmtAnimal.setInt(3, ani.getEdadMeses());
		stmtAnimal.setString(4, ani.getCaracteristicas());
		stmtAnimal.setString(5, ani.getNecesidadesEspeciales());
		stmtAnimal.setString(6, ani.getIdAnimal());

		stmtAnimal.executeUpdate();
		stmtAnimal.close();

		// Paso 2: Actualizar tabla hija correspondiente
		if (ani instanceof Perro p) {
			String updatePerro = "UPDATE perros SET Raza = ?, Tamano = ?, Entrenado = ? WHERE IDanimal = ?";
			PreparedStatement stmtPerro = con.prepareStatement(updatePerro);
			stmtPerro.setString(1, p.getRaza());
			stmtPerro.setString(2, p.getTamano());
			stmtPerro.setBoolean(3, p.isEntrenado());
			stmtPerro.setString(4, p.getIdAnimal());
			stmtPerro.executeUpdate();
			stmtPerro.close();

		} else if (ani instanceof Gato g) {
			String updateGato = "UPDATE gatos SET Raza = ?, TipoPelo = ?, Sociabilidad = ? WHERE IDanimal = ?";
			PreparedStatement stmtGato = con.prepareStatement(updateGato);
			stmtGato.setString(1, g.getRaza());
			stmtGato.setString(2, g.getPelaje());
			stmtGato.setInt(3, g.getSociabilidad());
			stmtGato.setString(4, g.getIdAnimal());
			stmtGato.executeUpdate();
			stmtGato.close();

		} else if (ani instanceof Pez pz) {
			String updatePez = "UPDATE peces SET AguaDulce = ?, EspeciePez = ?, CompatibleComunidad = ? WHERE IDanimal = ?";
			PreparedStatement stmtPez = con.prepareStatement(updatePez);
			stmtPez.setBoolean(1, pz.isAguaDulce());
			stmtPez.setString(2, pz.getEspeciePez());
			stmtPez.setBoolean(3, pz.isCompatibleComunidad());
			stmtPez.setString(4, pz.getIdAnimal());
			stmtPez.executeUpdate();
			stmtPez.close();
		}

		con.close();
		return ani;
	}

	// 5. ELIMINAR UN ANIMAL (Gracias al ON DELETE CASCADE, esto borra de las hijas
	// también)
	public Animal eliminarAnimal(String idABuscar) throws SQLException {
		Animal aniEliminado = buscarAnimalId(idABuscar);

		if (aniEliminado != null) {
			String delete = "DELETE FROM animales WHERE IDanimal = ?";

			Connection con = Conector.getConexion();
			PreparedStatement myStmt = con.prepareStatement(delete);
			myStmt.setString(1, idABuscar);

			myStmt.executeUpdate();

			myStmt.close();
			con.close();
		}

		return aniEliminado;
	}

	// 6. TOTAL DE ANIMALES
	public int totAnimales() throws SQLException {
		int total = 0;
		String query = "SELECT COUNT(*) FROM animales";

		Connection con = Conector.getConexion();
		PreparedStatement myStmt = con.prepareStatement(query);
		ResultSet myRs = myStmt.executeQuery();

		if (myRs.next()) {
			total = myRs.getInt(1);
		}

		myRs.close();
		myStmt.close();
		con.close();

		return total;
	}

	// MÉTODO AUXILIAR PRIVADO
	private Animal instanciarAnimalDesdeResultSet(ResultSet myRs) throws SQLException {
		String idAnimal = myRs.getString("IDanimal");
		String idCentro = myRs.getString("IDcentro");
		String nombre = myRs.getString("NombreAnim");
		int edad = myRs.getInt("EdadMeses");
		Especie especie = Especie.valueOf(myRs.getString("Especie"));
		String caracteristicas = myRs.getString("Caracteristicas");
		String necesidades = myRs.getString("NecesidadesEspeciales");

		switch (especie) {
		case Perro:
			String razaPerro = myRs.getString("RazaPerro"); // Usamos el alias de la query
			String tamano = myRs.getString("Tamano");
			boolean entrenado = myRs.getBoolean("Entrenado");
			return new Perro(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, razaPerro, tamano,
					entrenado);

		case Gato:
			String razaGato = myRs.getString("RazaGato");
			String tipoPelo = myRs.getString("TipoPelo");
			int sociabilidad = myRs.getInt("Sociabilidad");
			return new Gato(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, razaGato, sociabilidad,
					tipoPelo);

		case Pez:
			boolean tipoAgua = myRs.getBoolean("AguaDulce");
			String especiePez = myRs.getString("EspeciePez");
			boolean compatible = myRs.getBoolean("CompatibleComunidad");
			return new Pez(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, especiePez, tipoAgua,
					compatible);

		default:
			return null;
		}
	}
}
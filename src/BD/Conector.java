package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	// Atributo de clase. estatico
	private static Connection conexion;

	// Metoso statico para realizar la conexión
	public static void conectar() {

		try {
			// Cargamos el driver, el driver es la libreria que nos permite conectarnos a la
			// BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado");

		} catch (Exception e) {
			System.out.println("Error en el driver");
		}
	}

	// Metoso statico para cerrar la conexión
	public static void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public static Connection getConexion() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/amigospelu2";
		String user = "root";
		String password = "1DAW3_BBDD";
		// Crea una conexión NUEVA cada vez
		return DriverManager.getConnection(url, user, password);
	}
}
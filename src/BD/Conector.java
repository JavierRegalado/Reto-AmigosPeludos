package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	private static Connection conexion;
	// Método estático para cargar el driver (se suele llamar una vez al arrancar la
	// app)
	public static void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver cargado correctamente.");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: No se encontró el driver de MySQL.");
			e.printStackTrace();
		}
	}

	// Método que fabrica y entrega una conexión fresca cada vez que se le pide
	public static Connection getConexion() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/amigospelu2";
		String user = "root";
		String password = "1DAW3_BBDD";

		return DriverManager.getConnection(url, user, password);
	}
    public static void cerrarConexion() throws SQLException {
	conexion.close();
    }
}
package app;

import java.sql.SQLException;

import BD.Conector;
import View.VistaAmigosPeludos;

public class MenuApp {

	public static void main(String[] args) throws SQLException {
		
		
		Conector.conectar();

		VistaAmigosPeludos viewMain = new VistaAmigosPeludos();
		
		viewMain.iniciar();
		
		Conector.cerrarConexion();
	}
}
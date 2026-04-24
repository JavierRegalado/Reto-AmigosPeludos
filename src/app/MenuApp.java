package app;

import java.sql.SQLException;

import BD.Conector;
import View.VistaMenuUsu;
import controller.ControllerMenuUsu;

public class MenuApp {

	public static void main(String[] args) throws SQLException {
		
		
		Conector.conectar();

		VistaMenuUsu menuUsu = new VistaMenuUsu();
		
		ControllerMenuUsu controlador = new ControllerMenuUsu(menuUsu);
		
		controlador.iniciar();
		
		Conector.cerrarConexion();
	}
}
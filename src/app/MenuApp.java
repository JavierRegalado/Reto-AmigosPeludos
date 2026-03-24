package app;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Animal;
import model.Perro;
import model.Gato;
import model.Pez;
import util.GestionAnimal;
import BD.Conector;

public class MenuApp {

	public static void main(String[] args) throws SQLException {
		
		GestionAnimal gestion = new GestionAnimal();
		
		Conector.conectar();
		try {
			System.out.println("--- INICIANDO PRUEBAS DE GESTIÓN ANIMAL ---");

			// 1. PROBAR INSERCIÓN (Añadir un Perro y un Gato)
			System.out.println("\n1. Insertando animales...");
			Perro perro1 = new Perro("ANI019", "CEN001", "Rex", 24, "Juguetón", "Ninguna","Galgo", "Grande", true);
			Gato gato1 = new Gato("ANI020", "CEN001", "Misifu", 12, "Tranquilo", "Comida especial","Persa", 8, "Largo");

			gestion.añadirAnimal(perro1);
			gestion.añadirAnimal(gato1);
			System.out.println("Animales insertados correctamente.");

			// 2. PROBAR CONTAR TOTAL
			int total = gestion.totAnimales();
			System.out.println("\n2. Total de animales en la BD: " + total);

			// 3. PROBAR LEER TODOS
			System.out.println("\n3. Listado de animales:");
			ArrayList<Animal> lista = gestion.getListaAnimales();
			for (Animal a : lista) {
				System.out.println(
						"- [" + a.getEspecie() + "] Nombre: " + a.getNombreAnim() + " (ID: " + a.getIdAnimal() + ")");
			}

			// 4. PROBAR BUSCAR POR ID
			System.out.println("\n4. Buscando animal con ID 'ANI001'...");
			Animal buscado = gestion.buscarAnimalId("ANI001");
			if (buscado != null) {
				System.out.println("Encontrado: " + buscado.getNombreAnim());
			}

			// 5. PROBAR MODIFICAR
			System.out.println("\n5. Modificando edad de Rex...");
			if (buscado instanceof Perro p) {
				p.setEdadMeses(30); // Cambiamos la edad
				gestion.modAnimal(p);
				System.out.println("Edad actualizada en la base de datos.");
			}

			// 6. PROBAR ELIMINAR
			System.out.println("\n6. Eliminando el animal 'ANI001'...");
			Animal eliminado = gestion.eliminarAnimal("ANI001");
			if (eliminado != null) {
				System.out.println("Animal " + eliminado.getNombreAnim() + " eliminado con éxito.");
			}

			// Verificación final
			System.out.println("\nTotal final de animales: " + gestion.totAnimales());

		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error general: " + e.getMessage());
		}
	}
}
package View;

import model.Gato;
import model.Perro;
import model.Pez;
import model.Animal;
import model.Adopcion;
import model.Centro;
import java.sql.SQLException;

import util.GestionAdopcion;
import util.GestionAnimal;
import util.GestionCentro;
import util.Logger;
import java.time.LocalDate;

import java.util.Scanner;

public class VistaAmigosPeludos {
	
	static Scanner sc = new Scanner(System.in);
    static GestionAnimal gestionAni = new GestionAnimal();
    static GestionCentro gestionCen = new GestionCentro();
    static GestionAdopcion gestionAdop = new GestionAdopcion();
    
    public void iniciar() throws SQLException {
    	
    	Logger.inicializar();
    	
    	int opcion = 0;
        
        do {
        	System.out.println("Como desea iniciar como admin(1) o como usuario(2)"
    				+ " o desea cerrar el programa(0)");
    		opcion = leerNum("Elige opcion: ");
    		
    		switch(opcion) {
    			case 1: 
    				do {
    		            mostrarMenuGestionAdmin();
    		            opcion = leerNum("Elige una opción: ");
    		            
    		            eleccionDeGestion(opcion);
    		            
    		        } while (opcion != 4);
    				break;
    			case 2:
    				do {
    					mostrarMenuUsu();
    		            opcion = leerNum("Introduce la opcion: ");
    		            switch (opcion) {
    		        
    		            case 1:
    		                do {
    		                		mostrarMenuEntidad("Adopcion");
    		                    opcion = leerNum("Introduce opcion: ");
    		                    
    		                    switch (opcion) {
    		                    case 1:
    		                        añadirAdop();
    		                        break;
    		                    case 2:
    		                        modificarAdop();
    		                        break;
    		                    case 3:
    		                        mostrarAdop();
    		                        break;
    		                    case 4:
    		                        borrarAdop();
    		                        break;
    		                    case 5:
    		                    	buscarAdop();
    		                    	break;
    		                    case 6:
    		                    		System.out.println("Saliendo del menu de adopcion");
    		                    		break;
    		                    default:
    		                        System.out.println("Opcion no valida");
    		                    }
    		                } while (opcion != 6);
    		                break;
    		            case 2:
    		                mostrarAnimales();
    		                break;
    		            case 3:
    		                mostrarCentro();
    		                break;
    		            case 4:
    		            		System.out.println("Saliendo del menu de usuario");
    		            		break;
    		            default:
    		                System.out.println("Opcion no valida");
    		            }
    				} while (opcion!=4);
    				break;
    			case 3:
    				System.out.println("Saliendo del programa");
    			break;
    			default:
    				System.out.println("Opcion no valida");
    		}
        	
        }while(opcion != 3);
    }
    
    public static void mostrarMenuGestionAdmin() {
        System.out.println("\n--- GESTIÓN DEL ADMINISTRADOR ---");
        System.out.println("1. Gestionar animales");
        System.out.println("2. Gestionar centros");
        System.out.println("3. Gestionar adopciones");
        System.out.println("4. Salir");
    }
    
    public static void mostrarMenuUsu() {
        System.out.println("Bienvenido usuario que es lo que quiere hacer hoy");
        System.out.println("1. Gestionar sus solicitudes de adopcion");
        System.out.println("2. comprobar informacion de los animales");
        System.out.println("3. Comprobar la informacion de los centros");
        System.out.println("4. Salir");
    }
    
    public static void mostrarMenuEntidad(String entidad) {
        System.out.println("\n--- GESTIÓN DE " + entidad.toUpperCase() + " ---");
        System.out.println("1. Añadir " + entidad);
        System.out.println("2. Mostrar " + entidad);
        System.out.println("3. Eliminar " + entidad);
        System.out.println("4. Modificar " + entidad);
        System.out.println("5. Buscar " + entidad);
        System.out.println("6. Volver");
    }
    
    private static void eleccionDeGestion(int opcion) throws SQLException {
        
        switch(opcion) {
        case 1:         
            do {
                mostrarMenuEntidad("Animal");
                opcion = leerNum("Elige una opción: ");

                switch (opcion) {
                    case 1: 
                    	añadirAnimal(); 
                    	break;
                    case 2: 
                    	mostrarAnimales(); 
                    	break;
                    case 3: 
                    	eliminarAnimal(); 
                    	break;
                    case 4: 
                    	modificarAnimal(); 
                    	break;
                    case 5: 
                    	buscarAnimal(); 
                    	break;
                    case 6: 
                    	System.out.println("Volviendo al menú principal..."); 
                    	break;
                    default: 
                    	System.out.println("Opción no válida");
                }
            } while (opcion != 6);
            break;
            
        case 2:
            do {
                mostrarMenuEntidad("Centro");
                opcion = leerNum("Elige una opción: ");
                
                switch (opcion) {
                    case 1: 
                    	crearCentro(); 
                    	break;
                    case 2: 
                    	mostrarCentro(); 
                    	break;
                    case 3: 
                    	eliminarCentro(); 
                    	break;
                    case 4: 
                    	modificarCentro(); 
                    	break;
                    case 5: 
                    	buscarCentro();
                    	break;
                    case 6: 
                    	System.out.println("Volviendo al menú principal..."); 
                    	break;
                    default: 
                    	System.out.println("Opción no válida");
                }
            } while (opcion != 6);
            break;
            
        case 3:
            do {
                mostrarMenuEntidad("Adopcion");
                opcion = leerNum("Elige una opción: ");
                
                switch (opcion) {
                    case 1: 
                    	añadirAdop(); 
                    	break;
                    case 2: 
                    	mostrarAdop(); 
                    	break;
                    case 3: 
                    	borrarAdop(); 
                    	break;
                    case 4: 
                    	modificarAdop(); 
                    	break;
                    case 5: 
                    	buscarAdop(); 
                    	break;
                    case 6: 
                    	System.out.println("Volviendo al menú principal..."); 
                    	break;
                    default: 
                    	System.out.println("Opción no válida");
                }
            } while (opcion != 6);
            break;
            
        case 4:
            System.out.println("Cerrando interfaz de gestion...");
            break;
        default:
            System.out.println("Introduce una de las opciones mostradas por favor");
        }
        
    }
   
	public static void añadirAnimal() throws SQLException {
		int opcion;
        System.out.println("\n--- Nuevo Animal ---");
        do {
            mostrarOpcionAnim();
            opcion = leerNum("Introduce opcion: ");
            
           switch (opcion) {
            case 1:
            	Perro nuevoPerro = crearPerro();
            	gestionAni.añadirAnimal(nuevoPerro);
            	System.out.println("Perro añadido");
                break;
            case 2:
            	Pez nuevoPez = crearPez();
            	gestionAni.añadirAnimal(nuevoPez);
            	System.out.println("Pez añadido");
                break;
            case 3:
            	Gato nuevoGato = crearGato();
            	gestionAni.añadirAnimal(nuevoGato);
            	System.out.println("Gato añadido");
                break;
            case 4:
                System.out.println("Volviendo al menu principal");
                break;
            default:
                System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
        
        Logger.registrar("Añadir", "Animal", "se ha añadido un animal");
	}
	
	public static void mostrarAnimales() throws SQLException {
		
		if(gestionAni.totAnimales() == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE ANIMALES ---");
        
        for(Animal a : gestionAni.getListaAnimales()) {
            System.out.println(a.toString());
        }
        Logger.registrar("Mostrar", "Animal", "se ha mostrado la lista de animales");
	}
    
	public static void eliminarAnimal() throws SQLException {
		mostrarAnimales();
        if (gestionAni.totAnimales() == 0) return;

        String id = leerTexto("\nIntroduce el ID del animal que quieres eliminar: ");

        Animal eliminado = gestionAni.eliminarAnimal(id);

        if (eliminado != null) {
            System.out.println("Se ha eliminado correctamente a: " + eliminado.getNombreAnim());
        } else {
            System.out.println("Error: No se ha encontrado ningún animal con el ID " + id);
        }
        Logger.registrar("Eliminar", "Animal", "se ha eliminado un animal");
	}
	
	public static void modificarAnimal() throws SQLException {
		mostrarAnimales();
        if (gestionAni.totAnimales() == 0) return;

        String id = leerTexto("\n Introduce el ID del animal que quieres modificar: ");
        
        Animal animalExistente = gestionAni.buscarAnimalId(id);

        if (gestionAni.buscarAnimalId(id) == null) {
            System.out.println("Error: No existe ese ID.");
            return;
          
        }

        System.out.println("--- Introduce los nuevos datos ---");
        
        animalExistente.setIdAnimal(leerTexto("id Animal: "));
        animalExistente.setIdCentro(leerTexto("id Centro: "));
        animalExistente.setNombreAnim(leerTexto("Nuevo Nombre: "));
        animalExistente.setEdadMeses(leerNum("Nueva Edad: "));
        animalExistente.setCaracteristicas(leerTexto("Nueva Caracteristica: "));
        animalExistente.setNecesidadesEspeciales(leerTexto("Nuevas necesidades especiales: "));
        
       if(animalExistente instanceof Perro perro) {
    	   System.out.println("-- Datos especificos de Perro --");
    	   perro.setTamano(leerTexto("Nuevo tamaño (centimetros): "));
    	   perro.setEntrenado(leerBoolean("Entrenado (si/no): "));
    	   perro.setRaza(leerTexto("Nueva raza: "));
    	   
       }else if(animalExistente instanceof Pez pez) {
    	   System.out.println("-- Datos especificos de Pez --");
    	   pez.setAguaDulce(leerBoolean("Agua dulce (si/no): "));
    	   pez.setCompatibleComunidad(leerBoolean("Es compatible (si/no): "));
    	   pez.setEspeciePez(leerTexto("Especie: "));
       }else if(animalExistente instanceof Gato gato) {
    	   System.out.println("-- Datos especificos de Gato --");
    	   gato.setSociabilidad(leerNum("Nueva Sociabilidad: "));
    	   gato.setPelaje(leerTexto("Nuevo pelaje: "));
    	   gato.setRaza(leerTexto("Nueva raza: "));
       }

        
        try {
            Animal modificado = gestionAni.modAnimal(animalExistente);
            if (modificado != null) {
                System.out.println("Animal modificado correctamente.");
                System.out.println(modificado);
            } else {
                System.out.println("Error: No se encontró el animal.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
        
	}
	
	public static void buscarAnimal() throws SQLException {
		if(gestionAni.totAnimales() == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }
        
        String id = leerTexto("\n Introduce el ID del animal a buscar: ");
        Animal animalEncontrado = gestionAni.buscarAnimalId(id);

        if (animalEncontrado != null) {
            System.out.println("ANIMAL ENCONTRADO");
            System.out.println(animalEncontrado);
        } else {
            System.out.println("No se ha encontrado ningún animal con el ID " + id);
        }
        Logger.registrar("Modificar", "Animal", "se ha modificado un animal");
    }
	
	public static void crearCentro() throws SQLException {
		System.out.println("\n--- Nuevo Centro ---");
		
    	String idCen = leerTexto("ID centro: ");
		String nombre = leerTexto("Nombre: ");
		String localidad = leerTexto("Localidad: ");
		int capaMax = leerNum("Capacidad MAxima: ");

		try {
			Centro c = new Centro(idCen, nombre, localidad, capaMax);
			gestionCen.anadirCentro(c);
			System.out.println("Centro creado correctamente.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void mostrarCentro() throws SQLException {
		if (gestionCen.listarCentros() == null) {
			System.out.println("No hay centros registrados.");
			return;
		}
		System.out.println("\n--- LISTA DE CENTROS ---");
		for (Centro cen : gestionCen.listarCentros()) {
			System.out.println(cen);
		}
		Logger.registrar("Crear", "Centro", "Se ha creado un centro");
	}
    
	public static void eliminarCentro() throws SQLException {
		mostrarCentro();
		
		if (gestionCen.listarCentros() == null) return;

		String id = leerTexto("\n Introduce el ID del centro a eliminar: ");
		
		Centro eliminado = gestionCen.eliminarCentro(id);
		
		if (eliminado != null) {
			System.out.println("Centro eliminado: " + eliminado.getNombre());
		} else {
			System.out.println("Error: No existe ese ID.");
		}
		Logger.registrar("Elimina", "Centro", "Se ha eliminado un centro");
	}
	
	public static void modificarCentro() throws SQLException {
		mostrarCentro();
		if (gestionCen.listarCentros() == null) return;

		String id = leerTexto("\n Introduce el ID del centro a modificar: ");
		
		Centro resultado = gestionCen.buscarCentroID(id);
		
		if (gestionCen.buscarCentroID(id) == null) {
			System.out.println("Error: No existe ese ID.");
			return;
		}

		System.out.println("--- Introduce los nuevos datos ---");
		resultado.setIdCentro(id);
		resultado.setNombre(leerTexto("Nueva direccion: "));
		resultado.setCapaMax(leerNum("Nueva capacidad: "));

		try {
			Centro modificado = gestionCen.modCentro(resultado);
			
			if (modificado != null) {
				System.out.println("Centro modificado correctamente.");
				System.out.println(modificado);
			} else {
				System.out.println("Error: No existe ese ID.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error de validación: " + e.getMessage());
		}
		Logger.registrar("Modificar", "Centro", "Se ha modificado un centro");
	}
	
	public static void buscarCentro() throws SQLException {
		if (gestionCen.listarCentros() == null) {
			System.out.println("No hay centros.");
			return;
		}
		String id = leerTexto("Introduce el ID del centro: ");
		Centro cen = gestionCen.buscarCentroID(id);
		
		if (cen != null) {
			System.out.println("--- CENTRO ENCONTRADO ---");
			System.out.println(cen);
		} else {
			System.out.println("Error: No existe ese ID.");
		}
		Logger.registrar("Buscar", "Centro", "Se ha Buscado un centro");
	}
	
	public static void añadirAdop() throws SQLException {
		System.out.println("\n--- Nueva Adopción ---");
	    
	    String iDsolicitud = leerTexto("ID solicitud: ");
	    String idAnimal = leerTexto("ID de animal adoptado: "); 
	    // Comprobamos si el animal existe antes de seguir
	    if (gestionAni.buscarAnimalId(idAnimal) == null) {
	        System.out.println("Error: El animal con ID " + idAnimal + " no existe.");
	        return;
	    }
	    
	    String DNI = leerTexto("DNI del adoptante: ");
	    LocalDate fechaAdop = LocalDate.now(); // Asignamos la fecha actual
	    String estadoStr = leerTexto("Estado adopcion (SOLICITADA/APROBADA/FINALIZADA): ").toUpperCase();
	    
	    try {
	        // Convertimos el String a Enum (suponiendo que usas el Enum EstadoAdopcion)
	        Adopcion.EstadoAdopcion estado = Adopcion.EstadoAdopcion.valueOf(estadoStr);
	        Adopcion ad = new Adopcion(iDsolicitud, idAnimal, DNI, fechaAdop, estado);
	        
	        if (gestionAdop.añadirAdop(ad)) {
	            System.out.println("Adopción registrada correctamente.");
	            Logger.registrar("INSERT", "ADOPCION", "ID: " + iDsolicitud + " para Animal: " + idAnimal);
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: Estado no válido o datos incorrectos.");
	    }
	    Logger.registrar("Añadir", "Adopción", "Se ha creado una adopción");
	}
	
	public static void mostrarAdop() throws SQLException {
		if (gestionAdop.getListaAdopciones().isEmpty()) {
			System.out.println("No hay adopciones registradas.");
			return;
		}
		
		System.out.println("\n--- LISTA DE ADOPCIONES ---");
		for (Adopcion a : gestionAdop.getListaAdopciones()) {
			System.out.println(a);
		}
		Logger.registrar("Mostrar", "Adopción", "Se ha mostrado la lista de adopciones");
	}
    
	public static void borrarAdop() throws SQLException {
		
		mostrarAdop();
        if (gestionAdop.getListaAdopciones().isEmpty()) return;

        String id = leerTexto("\n Introduce el ID de la adopción a borrar: ");

        Adopcion eliminada = gestionAdop.elimAdop(id);

        if (eliminada != null) {
            System.out.println("Se ha eliminado la adopción solicitada por: " + eliminada.getDniAdoptante());
        } else {
            System.out.println("Error: No existe ese ID.");
        }
        Logger.registrar("Eliminar", "Adopción", "Se ha eliminado una adopción");
	}
	
	public static void modificarAdop() throws SQLException{
		mostrarAdop();
	    if (gestionAdop.getListaAdopciones().isEmpty()) return;

	    String id = leerTexto("\nIntroduce el ID de la adopción a modificar: ");
	    Adopcion adop = gestionAdop.buscarAdopcionId(id);

	    if (adop == null) {
	        System.out.println("Error: No existe esa adopción.");
	        return;
	    }

	    System.out.println("Modificando adopción " + id + " (Dejar actual si no se desea cambiar)");
	    adop.setDniAdoptante(leerTexto("Nuevo DNI: "));
	    String estadoStr = leerTexto("Nuevo Estado (SOLICITADA/APROBADA/FINALIZADA): ").toUpperCase();
	    
	    try {
	        adop.setEstado(Adopcion.EstadoAdopcion.valueOf(estadoStr));
	        if (gestionAdop.modAdop(adop)) {
	            System.out.println("Adopción modificada con éxito.");
	            Logger.registrar("UPDATE", "ADOPCION", "Modificado ID: " + id);
	        }
	    } catch (Exception e) {
	        System.out.println("Error al modificar: " + e.getMessage());
	    }
	    Logger.registrar("Modificar", "Adopción", "Se ha modificado una adopción");
	}
	
	public static void buscarAdop() throws SQLException {
		if (gestionAdop.getListaAdopciones().isEmpty()) {
			System.out.println("No hay adopciones registradas.");
			return;
		}
		
		String id = leerTexto("Introduce el ID de la adopción a buscar: ");
		
		Adopcion encontrado = gestionAdop.buscarAdopcionId(id);
		
		if (encontrado != null) {
			System.out.println("--- ADOPCIÓN ENCONTRADA ---");
			System.out.println(encontrado);
		} else {
			System.out.println("Error: No existe ese ID.");
		}
		Logger.registrar("Buscar", "Adopción", "Se ha buscado una adopción");
	}
	
	public static void mostrarOpcionAnim() {
  	  System.out.println("\n--- Que animal se añadira? ---");
        System.out.println("1. Crear perro");
        System.out.println("2. Crear pez");
        System.out.println("3. Crear gato");
        System.out.println("4. Salir");
  }
	
	public static Perro crearPerro() {
        System.out.println("---- Creación de Perro ----");
       
        String idAnim = leerTexto("id Animal: ");
        String idCen = leerTexto("id Centro: ");
        String nomAnim = leerTexto("Nombre: ");
        int edad = leerNum("Edad (meses): ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        String raza = leerTexto("Raza: ");
        String tamano = leerTexto("Tamaño: ");
        boolean entrenado = leerBoolean("¿Está entrenado? (si/no): ");

        return new Perro(idAnim, idCen, nomAnim, edad, carac, necEsp, raza, tamano, entrenado);
    }
	
	public static Gato crearGato() {
        System.out.println("---- Creación de Perro ----");
       
        String idAnim = leerTexto("id Animal: ");
        String idCen = leerTexto("id Centro: ");
        String nomAnim = leerTexto("Nombre: ");
        int edad = leerNum("Edad: ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        String raza = leerTexto("Raza: ");
        int soc = leerNum("Sociabilidad: ");
        String pela = leerTexto("Pelaje: ");

        return new Gato(idAnim, idCen, nomAnim, edad, carac, necEsp, raza, soc, pela);
    }
	
	public static Pez crearPez() {
        System.out.println("---- Creación de Pezz ----");
       
        String idAnim = leerTexto("id Animal: ");
        String idCen = leerTexto("id Centro: ");
        String nomAnim = leerTexto("Nombre: ");
        int edad = leerNum("Edad: ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        String especie = leerTexto("Especie: ");
        boolean compa = leerBoolean("Es compatible con otros peces (si/no): ");
        boolean agua = leerBoolean("Agua Dulce (si/no):");

        return new Pez(idAnim, idCen, nomAnim, edad, carac, necEsp, especie, compa, agua);
    }
	
    static boolean leerBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String conversion = sc.nextLine().trim().toLowerCase();

            if (conversion.equals("si") || conversion.equals("sí")) return true;
            if (conversion.equals("no")) return false;

            System.out.println("Respuesta inválida. Escribe si o no.");
        }
    }
    
    public static String leerTexto(String mensaje) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: No puedes dejar este campo vacío.");
            }
        }
        return texto;
    }

    public static int leerNum(String mensaje) {
        int num = 0;
        boolean valido = false;
        
        while (!valido) {
            try {
                System.out.print(mensaje);
                String input = sc.nextLine(); 
                num = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            }
        }
        return num;
    }
}

package app;

import java.util.Scanner;

import util.GestionAnimal;
import util.GestionCentro;
import util.GestionAdopcion;
import model.Animal;
import model.Adopcion;
import model.Centro;
import model.Perro;
import model.Pez;
import model.Gato;

public class MenuApp {
    
    static Scanner sc = new Scanner(System.in);
    static GestionAnimal gestionAni = new GestionAnimal();
    static GestionCentro gestionCen = new GestionCentro();
    static GestionAdopcion gestionAdop = new GestionAdopcion();

    public static void main (String[] args) {
        
        int opcion;
        
        cargarDatosDePrueba();
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
        		
        			
        } while (opcion!=3);
        
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

    public static void añadirAnimal() {
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
    }
     
    public static void mostrarAnimales() {
         if(gestionAni.totAnimales() == 0) {
             System.out.println("No hay animales registrados.");
             return;
         }
         System.out.println("\n--- LISTA DE ANIMALES ---");
         
         for(Animal a : gestionAni.getListaAnimales()) {
             System.out.println(a.toString());
         }
    }
    
    public static void eliminarAnimal() {
    	mostrarAnimales();
        if (gestionAni.totAnimales() == 0) return;

        int id = leerNum("\nIntroduce el ID del animal que quieres eliminar: ");

        Animal eliminado = gestionAni.eliminarAnimal(id);

        if (eliminado != null) {
            System.out.println("Se ha eliminado correctamente a: " + eliminado.getNombre());
        } else {
            System.out.println("Error: No se ha encontrado ningún animal con el ID " + id);
        }
    }
     
    public static void modificarAnimal() {
    	mostrarAnimales();
        if (gestionAni.totAnimales() == 0) return;

        int id = leerNum("\n Introduce el ID del animal que quieres modificar: ");
        
        Animal animalExistente = gestionAni.buscarAnimalId(id);

        if (gestionAni.buscarAnimalId(id) == null) {
            System.out.println("Error: No existe ese ID.");
            return;
        }

        System.out.println("--- Introduce los nuevos datos ---");
        String nuevoNombre = leerTexto("Nuevo Nombre: ");
        String nuevaRaza = leerTexto("Nueva Raza: ");
        int nuevaEdad = leerNum("Nueva Edad: ");
        boolean nuevaDisp = leerBoolean("¿Disponible? (si/no): ");
        String nuevoCentro = leerTexto("Nuevo Centro: ");
        boolean nuevoSano = leerBoolean("¿Sano? (si/no): ");   
        
        String nuevoTamano = null;
        boolean nuevoEntrenado = false;
        String nuevoColor = null;
        boolean nuevaAguaDulce = false;
        String nuevoPelaje = null;
        int nuevaSoci = 0;
        
       if(animalExistente instanceof Perro) {
    	   System.out.println("-- Datos especificos de Perro --");
    	   nuevoTamano = leerTexto("Nuevo tamaño (centimetros): ");
    	   nuevoEntrenado = leerBoolean("¿Entrenado? (si/no): ");
       }else if(animalExistente instanceof Pez) {
    	   System.out.println("-- Datos especificos de Pez --");
    	   nuevoColor = leerTexto("Nuevo color: ");
    	   nuevaAguaDulce = leerBoolean("¿Es de agua dulze? (si/no): ");
       }else if(animalExistente instanceof Gato) {
    	   nuevoPelaje = leerTexto("Pelaje: ");
    	   nuevaSoci = leerNum("Nuevo nivel de sociabilidad: ");
       }

        
        try {
            Animal modificado = gestionAni.modAnimal(id, nuevoNombre, nuevaRaza, nuevaEdad, nuevaDisp, nuevoCentro, nuevoSano, 
            		nuevoTamano, nuevoEntrenado,
            		nuevoColor, nuevaAguaDulce,
            		nuevoPelaje, nuevaSoci);

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
     
    public static void buscarAnimal() {
        if(gestionAni.totAnimales() == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }
        
        int id = leerNum("\n Introduce el ID del animal a buscar: ");
        Animal animalEncontrado = gestionAni.buscarAnimalId(id);

        if (animalEncontrado != null) {
            System.out.println("ANIMAL ENCONTRADO");
            System.out.println(animalEncontrado);
        } else {
            System.out.println("No se ha encontrado ningún animal con el ID " + id);
        }
    }

  
    
    public static void crearCentro() {
    	System.out.println("\n--- Nuevo Centro ---");
		
		String direccion = leerTexto("Dirección: ");
		String provincia = leerTexto("Provincia: ");
		String ciudad = leerTexto("Ciudad: ");

		try {
			Centro c = new Centro(direccion, provincia, ciudad);
			gestionCen.anadirCentro(c);
			System.out.println("Centro creado correctamente.");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
    
    public static void mostrarCentro() {
    	if (gestionCen.listarCentros() == null) {
			System.out.println("No hay centros registrados.");
			return;
		}
		System.out.println("\n--- LISTA DE CENTROS ---");
		for (Centro cen : gestionCen.listarCentros()) {
			System.out.println(cen);
		}
    }
    public static void eliminarCentro() {
    	mostrarCentro();
		
		if (gestionCen.listarCentros() == null) return;

		int id = leerNum("\n Introduce el ID del centro a eliminar: ");
		
		Centro eliminado = gestionCen.eliminarCentro(id);
		
		if (eliminado != null) {
			System.out.println("Centro eliminado: " + eliminado.getCiudad());
		} else {
			System.out.println("Error: No existe ese ID.");
		}
    }
    public static void modificarCentro() {
    	mostrarCentro();
		if (gestionCen.listarCentros() == null) return;

		int id = leerNum("\n Introduce el ID del centro a modificar: ");
		
		if (gestionCen.buscarCentroID(id) == null) {
			System.out.println("Error: No existe ese ID.");
			return;
		}

		System.out.println("--- Introduce los nuevos datos ---");
		String nuevaDir = leerTexto("Nueva Dirección: ");
		String nuevaProv = leerTexto("Nueva Provincia: ");
		String nuevaCiud = leerTexto("Nueva Ciudad: ");

		try {
			Centro resultado = gestionCen.modCentro(id, nuevaDir, nuevaProv, nuevaCiud);
			
			if (resultado != null) {
				System.out.println("Centro modificado correctamente.");
				System.out.println(resultado);
			} else {
				System.out.println("Error: No existe ese ID.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error de validación: " + e.getMessage());
		}
    }
    
    public static void buscarCentro() {
    	if (gestionCen.listarCentros() == null) {
			System.out.println("No hay centros.");
			return;
		}
		int id = leerNum("Introduce el ID del centro: ");
		Centro cen = gestionCen.buscarCentroID(id);
		
		if (cen != null) {
			System.out.println("--- CENTRO ENCONTRADO ---");
			System.out.println(cen);
		} else {
			System.out.println("Error: No existe ese ID.");
		}
    }

    public static void añadirAdop() {
    	System.out.println("\n--- Nueva Adopción ---");
		
		String solicitante = leerTexto("Nombre del Solicitante: ");
		String animal = leerTexto("Nombre del Animal: ");
		String raza = leerTexto("Raza del Animal: ");
		
		try {
			Adopcion ad = new Adopcion(solicitante, animal, raza);
			gestionAdop.añadirAdop(ad);
			System.out.println("Adopción registrada correctamente.");
			
		} catch (IllegalArgumentException e) {
			System.out.println("Error de validación: " + e.getMessage());
		}
    }
    public static void mostrarAdop() {
    	if (gestionAdop.getListaAdopciones().isEmpty()) {
			System.out.println("No hay adopciones registradas.");
			return;
		}
		
		System.out.println("\n--- LISTA DE ADOPCIONES ---");
		for (Adopcion a : gestionAdop.getListaAdopciones()) {
			System.out.println(a);
		}
    }
    public static void borrarAdop() {
    	mostrarAdop();
        if (gestionAdop.getListaAdopciones().isEmpty()) return;

        int id = leerNum("\n Introduce el ID de la adopción a borrar: ");

        Adopcion eliminada = gestionAdop.elimAdop(id);

        if (eliminada != null) {
            System.out.println("Se ha eliminado la adopción solicitada por: " + eliminada.getSolicitante());
        } else {
            System.out.println("Error: No existe ese ID.");
        }
    }
    public static void modificarAdop() {
    	mostrarAdop();
        if (gestionAdop.getListaAdopciones().isEmpty()) return;

        int id = leerNum("\n Introduce el ID de la adopción a modificar: ");

        if (gestionAdop.buscarAdopcionId(id) == null) {
            System.out.println("Error: No existe ese ID.");
            return;
        }

        System.out.println("--- Nuevos Datos ---");
        String newSol = leerTexto("Nuevo Solicitante: ");
        String newAni = leerTexto("Nuevo Animal: ");
        String newRaza = leerTexto("Nueva Raza: ");

        try {
            Adopcion modAdop = gestionAdop.modAdop(id, newSol, newAni, newRaza);

            if (modAdop != null) {
                System.out.println("Adopción modificada correctamente.");
                System.out.println(modAdop);
            } else {
                System.out.println("Error interno: No se pudo modificar.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
    public static void buscarAdop() {
    	if (gestionAdop.getListaAdopciones().isEmpty()) {
			System.out.println("No hay adopciones registradas.");
			return;
		}
		
		int id = leerNum("Introduce el ID de la adopción a buscar: ");
		
		Adopcion encontrado = gestionAdop.buscarAdopcionId(id);
		
		if (encontrado != null) {
			System.out.println("--- ADOPCIÓN ENCONTRADA ---");
			System.out.println(encontrado);
		} else {
			System.out.println("Error: No existe ese ID.");
		}
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
    
    private static void eleccionDeGestion(int opcion) {
        
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
        
    public static void cargarDatosDePrueba() {
        System.out.println("--- Cargando datos de prueba... ---");

        // 1. ANIMALES
        gestionAni.añadirAnimal(new Perro ("Toby", "Pastor Aleman", 5, true, "Centro Norte", true, "Grande", true));
        gestionAni.añadirAnimal(new Gato("Luna", "Persa", 2, true, "Centro Sur", true, 8, "suave"));
        gestionAni.añadirAnimal(new Pez("Rocky", "Pez payo", 4, false, "Centro Norte", false, "Naranja y blanco", false));

        // 2. CENTROS
        try {
            gestionCen.anadirCentro(new Centro("Calle Mayor 10", "Madrid", "Madrid"));
            gestionCen.anadirCentro(new Centro("Av. Diagonal 200", "Barcelona", "Barcelona"));
            gestionCen.anadirCentro(new Centro("Plaza España 5", "Sevilla", "Sevilla"));
        } catch (Exception e) {
            System.out.println("Error centros: " + e.getMessage());
        }

        // 3. ADOPCIONES
        gestionAdop.añadirAdop(new Adopcion("Juan Perez", "Toby", "Pastor Aleman"));
        gestionAdop.añadirAdop(new Adopcion("Maria Lopez", "Luna", "Persa"));

        System.out.println("--> Datos cargados correctamente.\n");
    }
    
    public static Perro crearPerro() {
        System.out.println("---- Creación de Perro ----");
       
        String nombre = leerTexto("Nombre: ");
        String raza = leerTexto("Raza: ");
        int edad = leerNum("Edad: ");
        boolean disp = leerBoolean("¿Disponible? (si/no): ");
        String centro = leerTexto("Centro: ");
        boolean sano = leerBoolean("¿Sano? (si/no): ");
        String tam = leerTexto("Tamaño (centimetros): ");
        boolean entrenado = leerBoolean("¿Está entrenado? (si/no): ");

        return new Perro(nombre, raza, edad, disp, centro, sano, tam, entrenado);
    }
    
    public static Pez crearPez() {
        
        System.out.println("----Creación de Pez----");
        
        // Atributos del padre Animales
        String nombre = leerTexto("Nombre:");
        
        String raza = leerTexto("Raza:");
        
        int edad = leerNum("Edad");
    
        boolean disponibilidad = leerBoolean("Disponibilidad (si/no):");
        
        String centro = leerTexto("Centro:");
        
        boolean sano = leerBoolean("Sano (si/no):");
        
        // Atributos de la clase hija Pez
        String color = leerTexto("Color:");
        
        boolean aguaDulce = leerBoolean("Agua Dulce (si/no):");
        // retorna el objeto pez
        return new Pez(nombre, raza, edad, disponibilidad, centro, sano, color, aguaDulce);
}
    
	public static Gato crearGato() {
	        
	        System.out.println("----Creación de gato----");
	        
	        String nombre = leerTexto("nombre: ");
	        String raza = leerTexto("Raza:");
	        int edad = leerNum("Edad:");
	        boolean disponibilidad = leerBoolean("Disponibilidad (si/no):");
	        String centro = leerTexto("Centro:");
	        boolean sano = leerBoolean("Sano (si/no):");
	        int sociabilidad = leerNum("Sociabilidad (1-10): ");
	        String pelaje = leerTexto("Pelaje:");
	        return new Gato (nombre, raza, edad, disponibilidad, centro, sano, sociabilidad, pelaje);
	}
    
    public static void mostrarOpcionAnim() {
    	  System.out.println("\n--- Que animal se añadira? ---");
          System.out.println("1. Crear perro");
          System.out.println("2. Crear pez");
          System.out.println("3. Crear gato");
          System.out.println("4. Salir");
    }
}
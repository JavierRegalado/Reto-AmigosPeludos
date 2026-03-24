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
	}
	
	public static void modificarAnimal() {
		
	}
	
	public static void buscarAnimal() {
		
	}
	
	public static void crearCentro() {
		
	}
	
	public static void mostrarCentro() {
		
	}
    
	public static void eliminarCentro() {
		
	}
	
	public static void modificarCentro() {
		
	}
	
	public static void buscarCentro() {
		
	}
	
	public static void añadirAdop() {
		
	}
	
	public static void mostrarAdop() {
		
	}
    
	public static void borrarAdop() {
		
	}
	
	public static void modificarAdop() {
		
	}
	
	public static void buscarAdop() {
		
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
        int edad = leerNum("Edad: ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        String tamano = leerTexto("Tamaño: ");
        boolean entrenado = leerBoolean("¿Está entrenado? (si/no): ");

        return new Perro(idAnim, idCen, nomAnim, edad, carac, necEsp, tamano, entrenado);
    }
	
	public static Gato crearGato() {
        System.out.println("---- Creación de Perro ----");
       
        String idAnim = leerTexto("id Animal: ");
        String idCen = leerTexto("id Centro: ");
        String nomAnim = leerTexto("Nombre: ");
        int edad = leerNum("Edad: ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        int soc = leerNum("Sociabilidad: ");
        String pela = leerTexto("Pelaje: ");

        return new Gato(idAnim, idCen, nomAnim, edad, carac, necEsp, soc, pela);
    }
	
	public static Pez crearPez() {
        System.out.println("---- Creación de Perro ----");
       
        String idAnim = leerTexto("id Animal: ");
        String idCen = leerTexto("id Centro: ");
        String nomAnim = leerTexto("Nombre: ");
        int edad = leerNum("Edad: ");
        String carac = leerTexto("Caracteristicas: ");
        String necEsp = leerTexto("Necesidades especiales: ");
        String color = leerTexto("Color: ");
        boolean agua = leerBoolean("Agua Dulce (si/no):");

        return new Pez(idAnim, idCen, nomAnim, edad, carac, necEsp, color, agua);
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

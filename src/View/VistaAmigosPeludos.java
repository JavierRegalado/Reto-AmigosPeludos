package View;

public class VistaAmigosPeludos {
	
    public static void mostrarMenuGestion() {
        System.out.println("\n--- GESTIÓN DEL ADMINISTRADOR ---");
        System.out.println("1. Gestionar animales");
        System.out.println("2. Gestionar centros");
        System.out.println("3. Gestionar adopciones");
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
}

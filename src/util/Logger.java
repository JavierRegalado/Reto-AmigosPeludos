package util;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    // Nombre del archivo log (se crea en la carpeta raíz del proyecto)
    private static final String ruta = "../log.txt";
    
    // Formato de fecha y hora para cada registro
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Se llama una vez al inicio del programa para crear el archivo limpio
    public static void inicializar() {
        
        //al ser true no borra el credo anteriormente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            
            bw.write("Inicio: " + LocalDateTime.now().format(FORMATO));
            bw.newLine();
            bw.write(" Registro de operaciones ");
            bw.newLine();
            bw.newLine();
            
        } catch (IOException e) {
            System.out.println("Error: No se pudo crear el log.txt");
        }
    }

    // Se llama cada vez que ocurre una operación para añadir una línea al log
    public static void registrar(String operacion, String entidad, String detalle) {
        
        // true = modo append, añade al final sin borrar lo anterior
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            
            String fechaHora = LocalDateTime.now().format(FORMATO);
            bw.write("[" + fechaHora + "] [" + operacion + "] [" + entidad + "] " + detalle);
            bw.newLine();
            
        } catch (IOException e) {
            System.out.println("Error: No se pudo escribir en log.txt");
        }
    }

    // Lee el archivo log.txt línea a línea y lo muestra por pantalla
    public static void leerLog() {
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            
            System.out.println("\n=== CONTENIDO DEL LOG ===");
            
            String linea = br.readLine(); 
            
            while (linea != null) {     
                System.out.println(linea);
                linea = br.readLine(); 
            }
            
            System.out.println("=========================\n");
            
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el log.txt");
        }
    }
}
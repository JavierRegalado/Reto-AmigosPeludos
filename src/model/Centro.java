package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Centro {
    
    //CONSTANTES (PATRONES)
    //Definimos los patrones una sola vez como 'static final' para eficiencia.
    
    //1. Patrón solo letras (Español + Espacios) -> Para Ciudad y Provincia
    private static final Pattern PATRON_LETRAS = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ ]+$");
    
    //2. Patrón Dirección (Letras + Números + Símbolos comunes de calle) -> Para DirCen
    private static final Pattern PATRON_DIRECCION = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ0-9,ºª\\. ]+");


    //ATRIBUTOS
    private int id; // El ID único de ESTE centro
    private String DirCen;
    private String Provincia;
    private String Ciudad;
    
    //Contador global estático (compartido por todos)
    public static int IDCentro = 0; 

    
    //CONSTRUCTORES
    
    public Centro(String dirCen, String provincia, String ciudad) {
        super();
        //Primero asignamos el ID
        IDCentro++;
        this.id = IDCentro;
        
        //Usamos los setters para validar. Si algo está mal, lanzará excepción aquí.
        this.setDirCen(dirCen);
        this.setProvincia(provincia);
        this.setCiudad(ciudad);
    }
    
    public Centro() {
        //Constructor vacío: Solo incrementa ID
        IDCentro++;
        this.id = IDCentro;
    }
    
    
    //GETTERS
    
    public int getId() {
        return id;
    }
    public static int getIDCentro() {
        return IDCentro;
    }
    public String getDirCen() {
        return DirCen;
    }
    public String getProvincia() {
        return Provincia;
    }
    public String getCiudad() {
        return Ciudad;
    }
    
    
    //SETTERS CON PATTERN Y MATCHER
    
    public void setDirCen(String dirCen) {
        // 1. Creamos el Matcher usando el Patrón definido arriba
        Matcher matcher = PATRON_DIRECCION.matcher(dirCen);
        
        // 2. Comprobamos si coincide
        if (matcher.matches()) {
            this.DirCen = dirCen;
        } else {
            throw new IllegalArgumentException("La Dirección contiene caracteres no válidos (se permiten letras, números, comas y puntos).");
        }
    }

    public void setProvincia(String provincia) {
        Matcher matcher = PATRON_LETRAS.matcher(provincia);
        
        if (matcher.matches()) {
            this.Provincia = provincia;
        } else {
            throw new IllegalArgumentException("La Provincia '" + provincia + "' no es válida. Solo letras del alfabeto español.");
        }
    }

    public void setCiudad(String ciudad) {
        Matcher matcher = PATRON_LETRAS.matcher(ciudad);
        
        if (matcher.matches()) {
            this.Ciudad = ciudad;
        } else {
            throw new IllegalArgumentException("La Ciudad '" + ciudad + "' no es válida. Solo letras del alfabeto español.");
        }
    }

    
    //TO STRING
    @Override
    public String toString() {
        return "[ID= " + id + ", DirCen= " + DirCen + ", Provincia= " + Provincia + ", Ciudad= " + Ciudad + "]";
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Centro other = (Centro) obj;
        return this.id == other.id;
    }
}
package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBD {
	
    // Atributo de clase. estatico
	private static Connection conexion;
   
    // Metodo statico para realizar la conexión
    public static void conectar(){

        try{
            //Cargamos el driver, el driver es la libreria que nos permite conectarnos a la BD
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado");        
            try{
                //Establecemos la conexion con la BD            
                //La BD se encuentra en el localhost(en mi ordenador)
                //La conexion se hace a traves del puerto 3306
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","1DAW3_BBDD"); // Añadir nombre de la bb, usuario y contraseña
                System.out.println("Conexion establecida");
          
             }catch(Exception e){
                System.out.println("Error en la conexion");
        }
        }catch(Exception e){
            System.out.println("Error en el driver");
        }
    }
    // Metoso statico para cerrar la conexión
    public static void cerrarConexion() throws SQLException {
	conexion.close();
}
    public static Connection getConexion() {
        return conexion;
    }
}
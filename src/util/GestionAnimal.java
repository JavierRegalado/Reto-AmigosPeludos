package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import BD.Conector;
import model.Animal;
import model.Animal.Especie;
import model.Gato;
import model.Perro;
import model.Pez;

public class GestionAnimal {

    // 1. LEER TODOS LOS ANIMALES
    public ArrayList<Animal> getListaAnimales() throws SQLException {
        ArrayList<Animal> listaAnimales = new ArrayList<>();
        String query = "SELECT * FROM animal";

        Connection con = Conector.getConexion();
        PreparedStatement myStmt = con.prepareStatement(query);
        ResultSet myRs = myStmt.executeQuery();

        while (myRs.next()) {
            Animal ani = instanciarAnimalDesdeResultSet(myRs);
            listaAnimales.add(ani);
        }

        myRs.close();
        myStmt.close();
        con.close();

        return listaAnimales;
    }

    // 2. BUSCAR UN ANIMAL POR ID
    public Animal buscarAnimalId(String idBusqueda) throws SQLException {
        Animal ani = null;
        String query = "SELECT * FROM animal WHERE id_animal = ?";

        Connection con = Conector.getConexion();
        PreparedStatement myStmt = con.prepareStatement(query);
        myStmt.setString(1, idBusqueda);
        
        ResultSet myRs = myStmt.executeQuery();

        if (myRs.next()) {
            ani = instanciarAnimalDesdeResultSet(myRs);
        }

        myRs.close();
        myStmt.close();
        con.close();

        return ani;
    }

    // 3. AÑADIR (INSERTAR) UN ANIMAL
    public void añadirAnimal(Animal ani) throws SQLException {
        String insert = "INSERT INTO animal (id_animal, id_centro, nombre, edad_meses, especie, caracteristicas, necesidades, tamano, entrenado, sociabilidad, pelaje, color, agua_dulce) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = Conector.getConexion();
        PreparedStatement myStmt = con.prepareStatement(insert);

        // Campos comunes
        myStmt.setString(1, ani.getIdAnimal());
        myStmt.setString(2, ani.getIdCentro());
        myStmt.setString(3, ani.getNombreAnim());
        myStmt.setInt(4, ani.getEdadMeses());
        myStmt.setString(5, ani.getEspecie().name());
        myStmt.setString(6, ani.getCaracteristicas());
        myStmt.setString(7, ani.getNecesidadesEspeciales());

        // Campos específicos (usamos instanceof como hacías en tu código original)
        if (ani instanceof Perro p) {
            myStmt.setString(8, p.getTamano());
            myStmt.setBoolean(9, p.isEntrenado());
            // Anulamos los campos de gato y pez
            myStmt.setNull(10, Types.INTEGER);
            myStmt.setNull(11, Types.VARCHAR);
            myStmt.setNull(12, Types.VARCHAR);
            myStmt.setNull(13, Types.BOOLEAN);
            
        } else if (ani instanceof Gato g) {
            myStmt.setNull(8, Types.VARCHAR);
            myStmt.setNull(9, Types.BOOLEAN);
            myStmt.setInt(10, g.getSociabilidad());
            myStmt.setString(11, g.getPelaje());
            myStmt.setNull(12, Types.VARCHAR);
            myStmt.setNull(13, Types.BOOLEAN);
            
        } else if (ani instanceof Pez pz) {
            myStmt.setNull(8, Types.VARCHAR);
            myStmt.setNull(9, Types.BOOLEAN);
            myStmt.setNull(10, Types.INTEGER);
            myStmt.setNull(11, Types.VARCHAR);
            myStmt.setString(12, pz.getColor());
            myStmt.setBoolean(13, pz.isAguaDulce());
        }

        myStmt.executeUpdate();

        myStmt.close();
        con.close();
    }

    // 4. MODIFICAR (ACTUALIZAR) UN ANIMAL
    // Se pasa el objeto Animal completo con los datos ya cambiados
    public Animal modAnimal(Animal ani) throws SQLException {
        String update = "UPDATE animal SET id_centro = ?, nombre = ?, edad_meses = ?, caracteristicas = ?, necesidades = ?, tamano = ?, entrenado = ?, sociabilidad = ?, pelaje = ?, color = ?, agua_dulce = ? WHERE id_animal = ?";

        Connection con = Conector.getConexion();
        PreparedStatement myStmt = con.prepareStatement(update);

        myStmt.setString(1, ani.getIdCentro());
        myStmt.setString(2, ani.getNombreAnim());
        myStmt.setInt(3, ani.getEdadMeses());
        myStmt.setString(4, ani.getCaracteristicas());
        myStmt.setString(5, ani.getNecesidadesEspeciales());

        if (ani instanceof Perro p) {
            myStmt.setString(6, p.getTamano());
            myStmt.setBoolean(7, p.isEntrenado());
            myStmt.setNull(8, Types.INTEGER);
            myStmt.setNull(9, Types.VARCHAR);
            myStmt.setNull(10, Types.VARCHAR);
            myStmt.setNull(11, Types.BOOLEAN);
        } else if (ani instanceof Gato g) {
            myStmt.setNull(6, Types.VARCHAR);
            myStmt.setNull(7, Types.BOOLEAN);
            myStmt.setInt(8, g.getSociabilidad());
            myStmt.setString(9, g.getPelaje());
            myStmt.setNull(10, Types.VARCHAR);
            myStmt.setNull(11, Types.BOOLEAN);
        } else if (ani instanceof Pez pz) {
            myStmt.setNull(6, Types.VARCHAR);
            myStmt.setNull(7, Types.BOOLEAN);
            myStmt.setNull(8, Types.INTEGER);
            myStmt.setNull(9, Types.VARCHAR);
            myStmt.setString(10, pz.getColor());
            myStmt.setBoolean(11, pz.isAguaDulce());
        }

        // El ID va al final para la cláusula WHERE
        myStmt.setString(12, ani.getIdAnimal());

        myStmt.executeUpdate();

        myStmt.close();
        con.close();
        
        return ani;
    }

    // 5. ELIMINAR UN ANIMAL
    public Animal eliminarAnimal(String idABuscar) throws SQLException {
        // Primero lo buscamos para poder devolverlo, como hacía tu método original
        Animal aniEliminado = buscarAnimalId(idABuscar);
        
        if (aniEliminado != null) {
            String delete = "DELETE FROM animal WHERE id_animal = ?";
            
            Connection con = Conector.getConexion();
            PreparedStatement myStmt = con.prepareStatement(delete);
            myStmt.setString(1, idABuscar);
            
            myStmt.executeUpdate();
            
            myStmt.close();
            con.close();
        }
        
        return aniEliminado;
    }

    // 6. TOTAL DE ANIMALES (Usamos COUNT en SQL en lugar de .size())
    public int totAnimales() throws SQLException {
        int total = 0;
        String query = "SELECT COUNT(*) FROM animal";
        
        Connection con = Conector.getConexion();
        PreparedStatement myStmt = con.prepareStatement(query);
        ResultSet myRs = myStmt.executeQuery();
        
        if (myRs.next()) {
            total = myRs.getInt(1); // El resultado del COUNT
        }
        
        myRs.close();
        myStmt.close();
        con.close();
        
        return total;
    }

    // --- MÉTODO AUXILIAR PRIVADO ---
    // Lo creamos para no repetir el código de sacar datos del ResultSet en Buscar y en LeerTodos
    private Animal instanciarAnimalDesdeResultSet(ResultSet myRs) throws SQLException {
        String idAnimal = myRs.getString("id_animal");
        String idCentro = myRs.getString("id_centro");
        String nombre = myRs.getString("nombre");
        int edad = myRs.getInt("edad_meses");
        Especie especie = Especie.valueOf(myRs.getString("especie"));
        String caracteristicas = myRs.getString("caracteristicas");
        String necesidades = myRs.getString("necesidades");

        switch (especie) {
            case Perro:
                String tamano = myRs.getString("tamano");
                boolean entrenado = myRs.getBoolean("entrenado");
                return new Perro(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, tamano, entrenado);
                
            case Gato:
                int sociabilidad = myRs.getInt("sociabilidad");
                String pelaje = myRs.getString("pelaje");
                return new Gato(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, sociabilidad, pelaje);
                
            case Pez:
                String color = myRs.getString("color");
                boolean aguaDulce = myRs.getBoolean("agua_dulce");
                return new Pez(idAnimal, idCentro, nombre, edad, caracteristicas, necesidades, color, aguaDulce);
                
            default:
                return null;
        }
    }
}
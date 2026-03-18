package util;

import java.util.ArrayList;
import model.Animal;
import model.Perro;
import model.Gato;
import model.Pez;

public class GestionAnimal {

    private ArrayList<Animal> listaAnimales;
    
    public GestionAnimal() {
        this.listaAnimales = new ArrayList<>();
    }
    
    //metodo para añadir in animal al array
    public void añadirAnimal(Animal animal) {
        listaAnimales.add(animal);
    }
    
    //metodo de modificacion
    public Animal modAnimal(int id, String nuevoNombre, String nuevaRaza, int nuevaEdad, boolean nuevaDisp, 
    		String nuevoCentro, boolean nuevoSano, String nuevoTamano, boolean nuevoEntrenado, String nuevoColor, 
    		boolean nuevaAguaDulze, String nuevoPelaje, int nuevaSocil ) {
        
        Animal ani = buscarAnimalId(id);
        
        if (ani != null) {
            ani.setNombre(nuevoNombre);
            ani.setRaza(nuevaRaza);
            ani.setEdad(nuevaEdad);
            ani.setDisponibilidad(nuevaDisp);
            ani.setCentro(nuevoCentro);
            ani.setSano(nuevoSano);
            
            if(ani instanceof Perro p) {
            	
            	((Perro) ani).setEntrenado(nuevoEntrenado);
            	((Perro) ani).setTamano(nuevoTamano);
            }
            else if(ani instanceof Pez pz) {
            	
            	((Pez) ani).setColor(nuevoColor);
            	((Pez) ani).setAguaDulce(nuevaAguaDulze);
            	
            }else if(ani instanceof Gato g) {
            	
            	((Gato) ani).setPelaje(nuevoPelaje);
            	((Gato) ani).setSociabilidad(nuevaSocil);
            }
        }
        
        return ani; 
    }
    
    //metodo para eliminar del array
    public Animal eliminarAnimal(int id) {
        Animal ani = buscarAnimalId(id);
        
        if (ani != null) {
            listaAnimales.remove(ani);
        }
        return ani;
    }
    
    //metodo para buscar por id
    public Animal buscarAnimalId(int id) {
        for (Animal ani : listaAnimales) {
            if (ani.getId() == id) {
                return ani;
            }
        }
        return null;
    }
    
    public ArrayList<Animal> getListaAnimales(){
        return listaAnimales;
    }
    
    //metodo que muestra total de animales 
    public int totAnimales() {
        return listaAnimales.size();
    }
}
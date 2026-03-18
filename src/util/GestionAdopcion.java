package util;

import java.util.ArrayList;
import model.Adopcion;

public class GestionAdopcion {
    
    private ArrayList<Adopcion> listaAdopcion;
    
    public GestionAdopcion() {
        this.listaAdopcion = new ArrayList<>();
    }
    
    public void añadirAdop (Adopcion adop) {
        listaAdopcion.add(adop);
    }


    public Adopcion modAdop (int idABuscar, String nuevoSol, String nuevoAnim, String nuevaRaza) {
        Adopcion adop = buscarAdopcionId(idABuscar);
        
        if (adop != null) {
            adop.setSolicitante(nuevoSol);
            adop.setAnimalSolicitado(nuevoAnim);
            adop.setRazaAnimal(nuevaRaza);
        }
        return adop;
    }

    public Adopcion elimAdop(int idABuscar) {
        Adopcion adop = buscarAdopcionId(idABuscar);
        
        if (adop != null) {
            listaAdopcion.remove(adop);
        }
        return adop;
    }
    
    public Adopcion buscarAdopcionId (int idBusqueda) {
        for (Adopcion adop : listaAdopcion) {
            if (adop.getId() == idBusqueda) {
                return adop;
            }
        }
        return null;
    }
    
    public ArrayList<Adopcion> getListaAdopciones() {
        return listaAdopcion;
    }    
}
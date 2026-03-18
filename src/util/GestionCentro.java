package util;

import java.util.ArrayList;
import model.Centro;

public class GestionCentro {

	 private ArrayList <Centro> listaCentros;
	    
	    public GestionCentro() {
	        this.listaCentros = new ArrayList<>();
	    }
	    
	    public void anadirCentro(Centro cen) {
	        listaCentros.add(cen);
	    }
	    public Centro modCentro(int id, String newDirCen, String newProvincia, String newCiudad) {

	        for (Centro cen : listaCentros) {
	            if (cen.getId() == id) {
	                cen.setDirCen(newDirCen);
	                cen.setProvincia(newProvincia);
	                cen.setCiudad(newCiudad);
	                return cen;
	            }
	        }
	        return null;
	    }
	    public ArrayList<Centro> listarCentros(){
	        if (listaCentros.isEmpty()) {
	            return null;
	        }
	        return listaCentros;
	    }
	    public Centro eliminarCentro(int id) {
	        for (int i = 0; i < listaCentros.size(); i++) {
	            Centro cen = listaCentros.get(i);
	            if (cen.getId() == id) {
	                return listaCentros.remove(i);
	            }
	        }
	        return null;
	    }
	    public Centro buscarCentroID (int idBusqueda) {
	        for (Centro cen : listaCentros) {
	            if(cen.getId()==idBusqueda) {
	                return cen;
	                
	            }
	        }
	        return null;
	    }
}

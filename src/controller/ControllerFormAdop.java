package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
 
import View.FormularioAdop;
import View.ListaAnimales;
import View.VistaMenuUsu;
import model.Adopcion;
import dao.GestionAdopcion;
import dao.Logger;

public class ControllerFormAdop {
	
	private FormularioAdop vista;
	
	public ControllerFormAdop(FormularioAdop vista, String idAnimal) {
		this.vista = vista;
	    this.vista.getTextAnimal().setText(idAnimal);
	    
	    try {

	        GestionAdopcion gestion = new GestionAdopcion();
	        

	        int siguienteNumero = gestion.contarAdopciones() + 1;
	        
	   
	        String idGenerado = String.format("SOL%03d", siguienteNumero);
	        
	        this.vista.getTextSolicitud().setText(idGenerado);
	        this.vista.getTextSolicitud().setEditable(false);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        this.vista.getTextSolicitud().setText("ERROR");
	    }
	    
	    this.vista.getBtnAceptar().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                guardarAdop();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
	    });
	    
	    this.vista.getBtnCancelar().addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            cancelar();
	        }
	    });
	}
	
	private void guardarAdop() throws SQLException {
		String idSolicitud = vista.getTextSolicitud().getText().trim();
		String idAnimal = vista.getTextAnimal().getText().trim();
		String dni = vista.getTextDNI().getText().trim();
 
			Adopcion adopcion = new Adopcion();
			adopcion.setIdSolicitud(idSolicitud);
			adopcion.setIdAnimal(idAnimal);
			adopcion.setDniAdoptante(dni);
 
			GestionAdopcion gestion = new GestionAdopcion();
			gestion.añadirAdop(adopcion);
			
			Logger.registrar("Añadir", "Solicitud Adopcion", "Se ha creado una adopción");
	}
	
	private void cancelar() {
		ListaAnimales listaAni = new ListaAnimales();
		ControllerListaAnimales controlador = new ControllerListaAnimales(listaAni);
		controlador.iniciarListaAnimales();
		vista.setVisible(false);
	}
	
	public void iniciarAdop() {
		this.vista.setVisible(true);
	}
}

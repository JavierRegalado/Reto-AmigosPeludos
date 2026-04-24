package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
 
import View.FormularioAdop;
import View.ListaAnimales;
import View.VistaMenuUsu;
import model.Adopcion;
import dao.GestionAdopcion;

public class ControllerFormAdop {
	
	private FormularioAdop vista;
	
	public ControllerFormAdop(FormularioAdop vista,String idAnimal) {
		this.vista = vista;
		
		this.vista.getTextAnimal().setText(idAnimal);
		
		this.vista.getBtnAceptar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarAdop();
			}
		});
		
		this.vista.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
	}
	
	private void guardarAdop() {
		String idSolicitud = vista.getTextSolicitud().getText().trim();
		String idAnimal = vista.getTextAnimal().getText().trim();
		String dni = vista.getTextDNI().getText().trim();
 
			Adopcion adopcion = new Adopcion();
			adopcion.setIdSolicitud(idSolicitud);
			adopcion.setIdAnimal(idAnimal);
			adopcion.setDniAdoptante(dni);
 
			GestionAdopcion gestion = new GestionAdopcion();
			
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

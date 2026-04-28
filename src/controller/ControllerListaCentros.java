package controller;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import View.ListaCentros;
import View.VistaMenuUsu;
import dao.GestionCentro;
import model.Centro;
import dao.Logger;
 
public class ControllerListaCentros {
 
	private ListaCentros vista;
	private ArrayList<Centro> listaCentros;

 
	public ControllerListaCentros(ListaCentros vista) {
		this.vista = vista;
		
		this.vista.getListCentros().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					mostrarDatosCentro();
				}
			}
		});
		this.vista.getBtnSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		
		cargarListaCentros();
	}
	
	private void cargarListaCentros() {
		try {
			GestionCentro gestion = new GestionCentro();
			listaCentros = gestion.listarCentros();
			
			DefaultListModel<String> modelo = new DefaultListModel<>();
			for(Centro c : listaCentros) {
				String fila = c.getNombre()+" - "+c.getLocalidad();
				modelo.addElement(fila);
			}
			
			vista.getListCentros().setModel(modelo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void mostrarDatosCentro() {
		int indice = vista.getListCentros().getSelectedIndex();
		
		Centro c = listaCentros.get(indice);
		vista.getTextCentro().setText(c.getIdCentro());
		vista.getTextNombre().setText(c.getNombre());
		vista.getTextLocalidad().setText(c.getLocalidad());
		vista.getTextCapacidad().setText(String.valueOf(c.getCapMax()));
	}
 
	private void volver() {
		VistaMenuUsu menuUsu = new VistaMenuUsu();
		ControllerMenuUsu controlador = new ControllerMenuUsu(menuUsu);
		controlador.iniciar();
		vista.setVisible(false);
	}
 
	public void iniciarListaCentros() {
		this.vista.setVisible(true);
	}
 
}
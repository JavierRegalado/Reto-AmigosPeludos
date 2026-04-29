package controller;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
 
import View.ListaAnimales;
import View.VistaMenuUsu;
import model.Animal;
import dao.GestionAnimal;
import View.FormularioAdop;
import controller.ControllerFormAdop;
import dao.Logger;
 
import javax.swing.DefaultListModel;
 
public class ControllerListaAnimales {
 
	private ListaAnimales vista;
	private ArrayList<Animal> listaAnimales;
 
	public ControllerListaAnimales(ListaAnimales vista) {
		this.vista = vista;
 
		this.vista.getBtnVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
 
		this.vista.getBtnAdoptar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarAdopcion();
			}
		});
 
		cargarAnimales();
	}
 
	private void cargarAnimales() {
		try {
			GestionAnimal gestion = new GestionAnimal();
			listaAnimales = gestion.getListaAnimales();
 
			DefaultListModel<String> modelo = new DefaultListModel<>();
			for (Animal a : listaAnimales) {
				String fila = a.getNombreAnim() + " - " + a.getEspecie() + " - " + a.getEdadMeses() + " meses";
				modelo.addElement(fila);
			}
 
			vista.getListAnimales().setModel(modelo);
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
 
	private void volver() {
		VistaMenuUsu menuUsu = new VistaMenuUsu();
		ControllerMenuUsu controlador = new ControllerMenuUsu(menuUsu);
		controlador.iniciar();
		vista.setVisible(false);
	}
 
	private void iniciarAdopcion() {
	    // 1. Obtenemos el índice seleccionado
	    int indice = vista.getListAnimales().getSelectedIndex();
	    
	    // 2. Comprobamos que REALMENTE se ha seleccionado algo (índice distinto de -1)
	    if (indice != -1) {
	        Animal animalSelec = listaAnimales.get(indice);
	        String idAnimal = animalSelec.getIdAnimal();
	        
	        FormularioAdop formAdop = new FormularioAdop();
	        ControllerFormAdop controlador = new ControllerFormAdop(formAdop, idAnimal);
	        controlador.iniciarAdop();
	        
	        vista.setVisible(false);
	    } 
	}
 
	public void iniciarListaAnimales() {
		this.vista.setVisible(true);
	}
 
}
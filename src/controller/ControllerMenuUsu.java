package controller;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import View.ListaAnimales;
import View.ListaCentros;
import View.VistaMenuUsu;
import dao.Logger;
 
public class ControllerMenuUsu {
 
	private VistaMenuUsu vista;
 
	ListaAnimales viewAnimales = new ListaAnimales();
	ListaCentros viewCentros = new ListaCentros();

	ControllerListaAnimales controladorAnimales = new ControllerListaAnimales(viewAnimales);
	ControllerListaCentros controladorCentros = new ControllerListaCentros(viewCentros);
 
	public ControllerMenuUsu(VistaMenuUsu vista) {
		this.vista = vista;
 
		
 
		this.vista.getAccesoAnimalesBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarVistaAnimales();
				Logger.registrar("Mostrar", "Animal", "se ha mostrado la lista de animales");
			}
		});
 
		this.vista.getAccesoCentrosBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarListaCentros();
				
				Logger.registrar("Mostrar", "Centros", "se ha mostrado la lista de centros");
			}
		});
 
	}
 
	public void iniciar() {
		this.vista.setVisible(true);
	}
 
	private void iniciarVistaAnimales() {
		controladorAnimales.iniciarListaAnimales();
		vista.setVisible(false);
	}
 
	private void iniciarListaCentros() {
		controladorCentros.iniciarListaCentros();
		vista.setVisible(false);
	}
 
}
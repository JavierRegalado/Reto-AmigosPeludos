package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.VistaMenuUsu;

public class ControllerMenuUsu {

	private VistaMenuUsu vista;
	
	public ControllerMenuUsu(VistaMenuUsu vista) {
		this.vista = vista;
		
		this.vista.getAccesoAnimalesBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				iniciarListaAnimales();
			}
		});
		
		this.vista.getAccesoCentrosBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				iniciarListaCentros();
			}
		});
		
	}
	
}

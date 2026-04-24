package controller;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import View.ListaCentros;
import View.VistaMenuUsu;
 
public class ControllerListaCentros {
 
	private ListaCentros vista;

 
	public ControllerListaCentros(ListaCentros vista) {
		this.vista = vista;

 
		this.vista.getBtnSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
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
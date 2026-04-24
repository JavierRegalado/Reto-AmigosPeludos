package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class FormularioAdop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSolicitud;
	private JTextField textAnimal;
	private JTextField textDNI;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAdop frame = new FormularioAdop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAdop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblSolicitud = new JLabel("ID Solicitud: ");
		lblSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolicitud.setBounds(86, 25, 115, 30);
		panel_1.add(lblSolicitud);
		
		JLabel lblAnimal = new JLabel("ID Animal:");
		lblAnimal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnimal.setBounds(86, 106, 95, 25);
		panel_1.add(lblAnimal);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDNI.setBounds(86, 175, 46, 18);
		panel_1.add(lblDNI);
		
		textSolicitud = new JTextField();
		textSolicitud.setBounds(231, 29, 115, 30);
		panel_1.add(textSolicitud);
		textSolicitud.setColumns(10);
		
		textAnimal = new JTextField();
		textAnimal.setColumns(10);
		textAnimal.setBounds(231, 101, 115, 30);
		//se pone esto en false porque se rellena automaticamente
		textAnimal.setEditable(false);
		panel_1.add(textAnimal);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(231, 163, 115, 30);
		panel_1.add(textDNI);

	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JTextField getTextSolicitud() {
		return textSolicitud;
	}
 
	public JTextField getTextAnimal() {
		return textAnimal;
	}
 
	public JTextField getTextDNI() {
		return textDNI;
	}
}

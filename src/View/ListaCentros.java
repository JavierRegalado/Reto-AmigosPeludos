package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;

public class ListaCentros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIDcentro;
	private JTextField textFieldNombre;
	private JTextField textFieldLocalidad;
	private JTextField textFieldCapacidad;
	private JButton btnSalir;
	private JList<String> listCentros;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCentros frame = new ListaCentros();
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
	public ListaCentros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneCentros = new JScrollPane();
		contentPane.add(scrollPaneCentros, BorderLayout.WEST);
		
		listCentros = new JList<String>();
		listCentros.setModel(new AbstractListModel() {
			String[] values = new String[] {"Refugio esperanza", "Huellas Felices", "Santuario Sur"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneCentros.setViewportView(listCentros);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblCentro = new JLabel("ID Centro");
		lblCentro.setBounds(54, 11, 86, 14);
		panel_1.add(lblCentro);
		
		textFieldIDcentro = new JTextField();
		textFieldIDcentro.setBounds(54, 28, 86, 20);
		panel_1.add(textFieldIDcentro);
		textFieldIDcentro.setEditable(false);
		textFieldIDcentro.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 57, 46, 14);
		panel_1.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(54, 71, 150, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(54, 102, 46, 14);
		panel_1.add(lblLocalidad);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setBounds(54, 116, 86, 20);
		panel_1.add(textFieldLocalidad);
		textFieldLocalidad.setEditable(false);
		textFieldLocalidad.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(54, 147, 86, 14);
		panel_1.add(lblCapacidad);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setBounds(54, 164, 86, 20);
		panel_1.add(textFieldCapacidad);
		textFieldCapacidad.setEditable(false);
		textFieldCapacidad.setColumns(10);

	}
	
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JList<String> getListCentros() {
		return listCentros;
	}

	public JTextField getTextCentro() {
		return textFieldIDcentro;
	}
	public JTextField getTextNombre() {
		return textFieldNombre;
	}
	public JTextField getTextLocalidad() {
		return textFieldLocalidad;
	}
	public JTextField getTextCapacidad() {
		return textFieldCapacidad;
	}
}

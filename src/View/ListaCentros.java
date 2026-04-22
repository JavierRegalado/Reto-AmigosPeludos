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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JList listaCentros = new JList();
		listaCentros.setModel(new AbstractListModel() {
			String[] values = new String[] {"Refugio esperanza", "Huellas Felices", "Santuario Sur"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneCentros.setViewportView(listaCentros);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblCentro = new JLabel("ID Centro");
		lblCentro.setBounds(10, 11, 86, 14);
		panel_1.add(lblCentro);
		
		textFieldIDcentro = new JTextField();
		textFieldIDcentro.setBounds(10, 28, 86, 20);
		panel_1.add(textFieldIDcentro);
		textFieldIDcentro.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 59, 46, 14);
		panel_1.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 71, 86, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 102, 46, 14);
		panel_1.add(lblLocalidad);
		
		textFieldLocalidad = new JTextField();
		textFieldLocalidad.setBounds(10, 116, 86, 20);
		panel_1.add(textFieldLocalidad);
		textFieldLocalidad.setColumns(10);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setBounds(10, 147, 86, 14);
		panel_1.add(lblCapacidad);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setBounds(10, 164, 86, 20);
		panel_1.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);

	}

}

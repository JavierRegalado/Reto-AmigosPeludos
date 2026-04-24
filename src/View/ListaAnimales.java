package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ListaAnimales extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolver;
	private JButton btnAdoptar;
	private JList<String> listAnimales;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaAnimales frame = new ListaAnimales();
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
	public ListaAnimales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnVolver = new JButton("Volver");
		panel.add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		listAnimales = new JList();
		listAnimales.setModel(new AbstractListModel() {
			String[] values = new String[] {"Luna, 60, Perro", "Max, 24, Gato", "Rocky, 96, Perro", "Nemo, 6, Pez", "Simba, 84, Gato", "Burbuja, 12, Pez", "Toby, 120, Perro", "Mia, 3, Gato", "Thor, 48, Perro", "Dory, 12, Pez", "Coco, 36, Perro", "Kira, 18, Gato", "Zeus, 72, Perro", "Lola, 5, Perro", "Felix, 60, Gato", "Goldie, 24, Pez", "Milo, 14, Perro", "Cleo, 40, Gato"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPane.setViewportView(listAnimales);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		btnAdoptar = new JButton("Adoptar");
		btnAdoptar.setBounds(81, 74, 147, 68);
		panel_1.add(btnAdoptar);

	}
	
	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public JButton getBtnAdoptar() {
		return btnAdoptar;
	}
	
	public JList<String> getListAnimales() {
		return listAnimales;
	}

}

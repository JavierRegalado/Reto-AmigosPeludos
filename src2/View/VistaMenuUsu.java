package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaMenuUsu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JButton salirMenuUsu;
    private JButton accesoAnimalesBtn;
    private JButton accesoCentrosBtn;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenuUsu frame = new VistaMenuUsu();
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
	public VistaMenuUsu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		salirMenuUsu = new JButton("Salir");
		panel.add(salirMenuUsu);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		accesoAnimalesBtn = new JButton("Animales");
		accesoAnimalesBtn.setBounds(160, 31, 103, 39);
		panel_1.add(accesoAnimalesBtn);
		
		accesoCentrosBtn = new JButton("Centros");
		accesoCentrosBtn.setBounds(160, 108, 103, 39);
		panel_1.add(accesoCentrosBtn);
		
		JLabel tituloPestaña = new JLabel("Menu de Usuario");
		tituloPestaña.setFont(new Font("Tahoma", Font.PLAIN, 35));
		tituloPestaña.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloPestaña, BorderLayout.NORTH);

	}
	
	public JButton getSalirMenuUsu() {
		return salirMenuUsu;
	}
	
	public JButton getAccesoAnimalesBtn() {
		return accesoAnimalesBtn;
	}
	
	public JButton getAccesoCentrosBtn() {
		return accesoCentrosBtn;
	}

}

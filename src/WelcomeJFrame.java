import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeJFrame frame = new WelcomeJFrame();
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
	public WelcomeJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Cita\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WindowNuevaCita test = new WindowNuevaCita();
				test.setVisible(true);
			}
		});
		btnNewButton.setBounds(110, 35, 200, 70);
		contentPane.add(btnNewButton);
		
		JButton btnBorrarCita = new JButton("Buscar/Cancelar Cita");
		btnBorrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WindowBorrarCita test = new WindowBorrarCita();
				test.setVisible(true);
			}
		});
		btnBorrarCita.setBounds(110, 135, 200, 70);
		contentPane.add(btnBorrarCita);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnNewButton_1.setBounds(323, 215, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}

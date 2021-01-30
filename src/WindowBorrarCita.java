import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WindowBorrarCita extends JFrame {

	private JPanel contentPane;
	private JTextField txtTelefono;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBorrarCita frame = new WindowBorrarCita();
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
	public WindowBorrarCita() {
		setTitle("Borrar Cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setBounds(12, 54, 81, 16);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(71, 51, 150, 22);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnBuscarCita = new JButton("Buscar Cita");
		btnBuscarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				boolean found = BDCitas.IDSLista.containsKey(txtTelefono.getText());
				
				if(found) {
					String res = String.valueOf(BDCitas.IDSLista.get(txtTelefono.getText()));
					txtDatos.setText(res);
				}else{
					JOptionPane.showMessageDialog(null, "¡Cita no encontrada!" );
				}
				
				
			}
		});
		btnBuscarCita.setBounds(28, 117, 162, 60);
		panel.add(btnBuscarCita);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnExit.setBounds(297, 199, 97, 25);
		panel.add(btnExit);
		
		JLabel lblNombre = new JLabel("Datos:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(12, 25, 56, 16);
		panel.add(lblNombre);
		
		txtDatos = new JTextField();
		txtDatos.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDatos.setForeground(Color.BLACK);
		txtDatos.setEditable(false);
		txtDatos.setBounds(60, 22, 333, 22);
		panel.add(txtDatos);
		txtDatos.setColumns(10);
		
		JButton btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String telefono = txtTelefono.getText();
				boolean found = BDCitas.IDSLista.containsKey(telefono);

				if(found) {
					BDCitas.IDSLista.delete(telefono);
					JOptionPane.showMessageDialog(null, "¡La cita se ha eliminado exitosamente!");
					txtDatos.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "¡Cita no encontrada!" );
				}
			}
		});
		btnCancelarCita.setBounds(232, 117, 162, 60);
		panel.add(btnCancelarCita);
		
		
	}

}

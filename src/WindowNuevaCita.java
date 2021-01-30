import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class WindowNuevaCita extends JFrame implements PropertyChangeListener{

	private JPanel contentPane;
	
	public static AgendarCita agendar;
	private static final long serialVersionUID = 1L;
	
	JFormattedTextField txtFecha_de_reservacion = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	private JTextField txtTelefono;
	private JTextField txtNombres;
	public int i=0;
	

	public JFormattedTextField getTxtFecha() {
		return txtFecha_de_reservacion;
	}

	public void setTxtFecha(JFormattedTextField txtFecha) {
		this.txtFecha_de_reservacion = txtFecha;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowNuevaCita frame = new WindowNuevaCita();
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
	public WindowNuevaCita() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		this.setTitle("Agendar nueva cita");
		Container cp = getContentPane();
		cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setLayout(null);
		txtFecha_de_reservacion.setEditable(false);
		txtFecha_de_reservacion.setBounds(80, 13, 130, 30);
		
		txtFecha_de_reservacion.setValue(new Date()); //Fecha actual
		
		txtFecha_de_reservacion.setPreferredSize(new Dimension(130,30));
		
		cp.add(txtFecha_de_reservacion);
		JButton calButton = new JButton("Escoge una fecha");
		calButton.setBounds(215, 13, 207, 28);
		cp.add(calButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 63, 410, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(5, 70, 60, 16);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setDocument(new JTextFieldLimit(10));
		txtTelefono.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE))) {
		        getToolkit().beep();
		        e.consume();
		      }
		    }
		  });
		txtTelefono.setBounds(70, 67, 116, 22);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombres.setBounds(5, 40, 80, 16);
		panel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(70, 37, 150, 22);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent evt) {

	         if(!(Character.isLetter(evt.getKeyChar()) || Character.isSpace(evt.getKeyChar()))){
	                evt.consume();
	            }
	        }
	    });
		
		
		JLabel lblHora = new JLabel("Hora:\r\n");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(15, 99, 60, 16);
		panel.add(lblHora);
		
		JComboBox cBHora = new JComboBox();
		cBHora.setModel(new DefaultComboBoxModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"}));
		cBHora.setBounds(70, 96, 68, 22);
		panel.add(cBHora);
		
		JButton btnAgendarCita = new JButton("Agendar Cita");
		btnAgendarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombres = txtNombres.getText();
				String telefono = txtTelefono.getText();
				String fecha = String.valueOf(txtFecha_de_reservacion.getText());
				String hora = String.valueOf(cBHora.getItemAt(cBHora.getSelectedIndex()));
				
				boolean valida = BDCitas.IDSLista.containsKey(telefono);
				
				
				
				
				if(!valida) {
					for (int i = 0; i < agendar.lista.size(); i++) {
						if(agendar.lista.get(i).getFecha().equals(fecha) && agendar.lista.get(i).getHora().equals(hora) ) {
							JOptionPane.showMessageDialog(null, "¡Fecha y hora no disponible!" +"\n" + " Fecha: " + fecha + " "+ hora);
						}	
					}
					agendar.crearCita(telefono, fecha, nombres, hora);
					JOptionPane.showMessageDialog(null, "¡Cita Agendada Exitosamente!" );
				}else {
					JOptionPane.showMessageDialog(null, "¡Número ya está en uso!" + "\n" + "Telefono: "+ telefono);
				}
			
				
				
				
				
				
				/*System.out.println("Usuario " + i + ":");
				System.out.print(agendar.lista.get(i).getNombres());
				System.out.println();
				System.out.print(agendar.lista.get(i).getTelefono());
				System.out.println();
				System.out.print(agendar.lista.get(i).getFecha());
				System.out.println();
				System.out.print(agendar.lista.get(i).getHora());
				System.out.println();*/
				//System.out.println(agendar.lista.get(1).getNombres());
				
			
				
					
						
			
		
			
				
			}
		});
		btnAgendarCita.setBounds(12, 262, 153, 50);
		contentPane.add(btnAgendarCita);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnExit.setBounds(365, 287, 97, 25);
		contentPane.add(btnExit);
		
		JButton btnIrAMenu = new JButton("Ir al men\u00FA");
		btnIrAMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeJFrame test = new WelcomeJFrame();
				test.setVisible(true);
			}
		});
		btnIrAMenu.setBounds(365, 224, 97, 50);
		contentPane.add(btnIrAMenu);
		
		CalendarWindow calendarWindow = new CalendarWindow();
		calendarWindow.setUndecorated(true);
		
		calendarWindow.addPropertyChangeListener(this);
		
		calButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// render the calendar window below the text field
				calendarWindow.setLocation(txtFecha_de_reservacion.getLocationOnScreen().x,
						(txtFecha_de_reservacion.getLocationOnScreen().y + txtFecha_de_reservacion.getHeight()));
				
				Date selectedDate = (Date) txtFecha_de_reservacion.getValue();
				calendarWindow.resetSelection(selectedDate);
				
				
				calendarWindow.setVisible(true);
			}
		});
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		if(event.getPropertyName().equals("selectedDate")) {
			
			java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
			Date selDate = cal.getTime();
			
			txtFecha_de_reservacion.setValue(selDate);
			
		}
		
	}
}

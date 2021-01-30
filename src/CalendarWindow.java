import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.CalendarView;
import com.mindfusion.scheduling.ControlAppearance;
import com.mindfusion.scheduling.Cursor;

public class CalendarWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private static final long serialVersionUID = 1L;
	
	Calendar calendar = new Calendar();
	java.util.Calendar selectedDate = java.util.Calendar.getInstance();
	
	protected PropertyChangeSupport changeSupport;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarWindow frame = new CalendarWindow();
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
	public CalendarWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 235, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		calendar.setCalendarCursor(Cursor.No);
		calendar.setCurrentView(CalendarView.List);
		calendar.setControlAppearance(ControlAppearance.Custom);
		calendar.setTheme(ThemeType.Lila);
		
		cp.add(calendar, BorderLayout.CENTER);
		
		changeSupport = new PropertyChangeSupport(this);
		
	
		calendar.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2) {
					calendar.getSelection().reset();
					
					DateTime pointedDate = calendar.getDateAt(e.getX(), e.getY());
					
					java.util.Calendar cal = java.util.Calendar.getInstance();
					
					cal.set(pointedDate.getYear(), pointedDate.getMonth() -1, pointedDate.getDay());
					
					setSelectedDate(cal);
					
					//calendar.setDate(arg0);;
					 
					
					//System.out.println(calendar.getDate().);
					dispose();
					
					
					
				}
				
			}
			
		});
		
	}
	
	public void resetSelection(Date date) {
	//	calendar.getSelection().reset();
		//calendar.getSelection().set(new DateTime(date));
		//calendar.setDate(new DateTime(date));
	}
	
	
	public void setSelectedDate (java.util.Calendar newDate) {
		java.util.Calendar oldDate = (java.util.Calendar) selectedDate.clone();
		
		selectedDate = newDate;
		changeSupport.firePropertyChange("selectedDate", oldDate, selectedDate);
	}
	
	
	//getter of the selectedDate property
	public java.util.Calendar getSelectedDate(){
		return selectedDate;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

}

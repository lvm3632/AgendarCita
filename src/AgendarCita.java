import java.util.ArrayList;

public class AgendarCita {

	private static String telefono;
	private   String fecha;
	private   String nombres;
	private   String hora;

	public static ArrayList<AgendarCita> lista = new ArrayList<AgendarCita>();
	public AgendarCita(){super();}
	
	public AgendarCita(String telefono, String fecha, String nombres, String hora) {
		this.telefono=telefono;
		this.fecha=fecha;
		this.nombres=nombres;
		this.hora=hora;
	}
	
	public static void  crearCita(String telefono, String fecha, String nombres, String hora) {
		BDCitas bd = new BDCitas();
		AgendarCita persona = new AgendarCita(telefono,fecha,nombres, hora);
		lista.add(persona);
		
		//if(validar(telefono)) {
			bd.guardarCita(telefono, fecha, hora, nombres);
			//return true;
		//}
		
		//return false;
	
	}
	
	
	/*public static boolean validar(String telefono) {
		BDCitas bd = new BDCitas();
		bd.getCita(telefono);
		
		if(bd.getTelefono().equals(null)) 
			return true;
		
		return false;
	}*/
	
	
	
	
	
	
	
	

	public static String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setHora() {
		this.hora=hora;
	}
	
	public String getHora() {
		return hora;
	}


	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
	
	
	
	
	

}

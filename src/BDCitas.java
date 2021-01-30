import java.util.Hashtable;

public class BDCitas {
	
	
	protected static HashTable IDSLista = new HashTable();
	private String fecha,
				   hora,
				   nombres,
				   telefono;
	
	public static void guardarCita(String telefono, String fecha, String hora, String nombres) {
		IDSLista.put(telefono, fecha + " " + hora + " " + nombres);
	}
	
	
	
	public void getCita(String telefono) {
		
		 String datos = (String) IDSLista.get(telefono);
		 
		 System.out.println(datos + " datos");
		 
		 String[] arr = datos.split(" ");
		 
		 System.out.println();
		 
		 this.setFecha(arr[0]);
		 this.setHora(arr[1]);
		
		 String res="";
		 int i=2;
		 
		 while(i<arr.length) {
			 
			 res+=arr[i]+" ";
			 i++;
			 
		 }
		
		 this.setNombres(res);
		 
	}
	
	
	
	
	public static void main(String[] args) {
		
		//BDCitas bd = new BDCitas();
		
		
		/*bd.guardarCita("1333111333", "20/20/20", "08:00", "Aldo Pedro");
		
			bd.getCita("1333111333");
			
			System.out.println(bd.getNombres());*/
		
		//System.out.println(bd.IDSLista.get("1333111333"));
	
	}


	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String  getTelefono() {
		return this.telefono;
	}

	public String getNombres() {
		return nombres;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	
	
	

}

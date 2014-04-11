package innova4b.ejemploCoches;

public class Empleado {
	
	private int id;
	private String nombre;
	private String Apellido;
	private int cocheId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public int getCocheId() {
		return cocheId;
	}
	public void setCocheId(int cocheId) {
		this.cocheId = cocheId;
	}
}

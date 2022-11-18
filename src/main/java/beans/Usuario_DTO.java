package beans;

public class Usuario_DTO {
	private int id, idTipo;
	private String email, clave, dni, nombre, apellidos;
	
	
	public Usuario_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario_DTO(int id, int idTipo, String email, String clave, String dni, String nombre, String apellidos) {
		super();
		this.id = id;
		this.idTipo = idTipo;
		this.email = email;
		this.clave = clave;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getIdTipo() {
		return idTipo;
	}
	public final void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getClave() {
		return clave;
	}
	public final void setClave(String clave) {
		this.clave = clave;
	}
	public final String getDni() {
		return dni;
	}
	public final void setDni(String dni) {
		this.dni = dni;
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public final String getApellidos() {
		return apellidos;
	}
	public final void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
}

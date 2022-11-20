package beans;

public class Usuario_DTO {

	// Variables
	private int id, idTipo;
	private String tipo, email, clave, dni, nombre, apellidos;
	
	// Constructor
	public Usuario_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_DTO(int id, int idTipo, String tipo, String email, String clave, String dni, String nombre, String apellidos) {
		super();
		this.id = id;
		this.idTipo = idTipo;
		this.tipo = tipo;
		this.email = email;
		this.clave = clave;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}

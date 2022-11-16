package beans;

public class Categoria_Tipo_DTO {
	// Variables
	private int id;
	private String nombre;
	
	// Constructors
	public Categoria_Tipo_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria_Tipo_DTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// Getters and Setters
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
}

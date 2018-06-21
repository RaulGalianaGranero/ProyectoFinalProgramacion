package modelo;

public class CocheDTO {

	private String matricula;
	private String modelo;
	private String marca;
	private String direccion_empresa;
	private String annio_modelo;
	
//CONSTRUCTOR
	
	public CocheDTO(String matricula, String modelo, String marca, String direccion_empresa, String annio_modelo) {
		
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.direccion_empresa = direccion_empresa;
		this.annio_modelo = annio_modelo;
	}
	
//METODO TO STRING
	
	
	


//HASCODE Y EQUALS
	
	
// GETTERS Y SETTERS

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDireccion_empresa() {
		return direccion_empresa;
	}

	public void setDireccion_empresa(String direccion_empresa) {
		this.direccion_empresa = direccion_empresa;
	}

	public String getAnnio_modelo() {
		return annio_modelo;
	}

	public void setAnnio_modelo(String anio_modelo) {
		this.annio_modelo = anio_modelo;
	}

	
	
	
}

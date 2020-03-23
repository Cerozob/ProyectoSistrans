package uniandes.isis2304.parranderos.negocio;

import java.util.LinkedList;
import java.util.List;

public class Cliente implements VOCliente{
	
	private Long identificacion;
	
	private String Nombre;
	
	private String Apellido;
	
	private TIPO_VINCULO vinculo; 
	
	private Long numero_Pago;
	
	private List<Object[]> contratos; 
	
	public Cliente()
	{
		identificacion = 0L;
		
		Nombre = "";
		
		Apellido = "";
		
		vinculo = null; 
		
		numero_Pago = 0L;
		
		contratos = new LinkedList<Object []>(); 
	}

	public Cliente(Long identificacion, String nombre, String apellido, TIPO_VINCULO vinculo, Long numero_Pago) {
		super();
		this.identificacion = identificacion;
		Nombre = nombre;
		Apellido = apellido;
		this.vinculo = vinculo;
		this.numero_Pago = numero_Pago;
		contratos = new LinkedList<Object []>(); 
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public TIPO_VINCULO getVinculo() {
		return vinculo;
	}

	public void setVinculo(TIPO_VINCULO vinculo) {
		this.vinculo = vinculo;
	}

	public Long getNumero_Pago() {
		return numero_Pago;
	}

	public void setNumero_Pago(Long numero_Pago) {
		this.numero_Pago = numero_Pago;
	}

	public List<Object[]> getContratos() {
		return contratos;
	}

	public void setContratos(List<Object[]> contratos) {
		this.contratos = contratos;
	}
	
	
	
	
}

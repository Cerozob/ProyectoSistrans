package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class Hospedaje implements VOHospedaje
{
	
	private long id; 

	private String nombre;
	
	private String direccion;
	
	private double valorTotal;
	
	private List<Object []> contratos;
	
	public Hospedaje() {
		super();
		this.id = 0;
		this.nombre = "";
		this.direccion = "";
		this.valorTotal = 0;
		contratos = new LinkedList<Object []> ();
	}
	

	public Hospedaje(long id, String nombre, String direccion, double valorTotal, List<Object[]> contratos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.valorTotal = valorTotal;
		contratos = new LinkedList<Object []> ();
	}

	public List<Object[]> getContratos() {
		return contratos;
	}

	public void setContratos(List<Object[]> contratos) {
		this.contratos = contratos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	
	
	
	
}

package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class Empresa implements VOEmpresa{
	
	private Long nIT;
	
	private Boolean registradoCamaraDeComercio;
	
	private Boolean registradoSuperintendenciaTurismo;
	
	private String nombre;

	private String web;

	private Long numeroPago;

	private List<Object[]> contratos;

	private List<Object[]> hoteles;

	private List<Object[]> hostales;

	private List<Object[]> viviendasUniversitarias;

	public Empresa()
	{
		nIT = 0L;
		
		registradoCamaraDeComercio = false;
		
		registradoSuperintendenciaTurismo = false;
		
		nombre = "";

		web = "";

		numeroPago = 0L;

		contratos = new LinkedList<Object[]>();;

		hoteles = new LinkedList<Object[]>();;

		hostales = new LinkedList<Object[]>();;

		viviendasUniversitarias = new LinkedList<Object[]>();
	}

	public Empresa(Long nIT, Boolean registradoCamaraDeComercio, Boolean registradoSuperintendenciaTurismo,
			String nombre, String web, Long numeroPago) {
		super();
		this.nIT = nIT;
		this.registradoCamaraDeComercio = registradoCamaraDeComercio;
		this.registradoSuperintendenciaTurismo = registradoSuperintendenciaTurismo;
		this.nombre = nombre;
		this.web = web;
		this.numeroPago = numeroPago;
		contratos = new LinkedList<Object[]>();;
		hoteles = new LinkedList<Object[]>();;
		hostales = new LinkedList<Object[]>();;
		viviendasUniversitarias = new LinkedList<Object[]>();
	}

	public Long getnIT() {
		return nIT;
	}

	public void setnIT(Long nIT) {
		this.nIT = nIT;
	}

	public Boolean getRegistradoCamaraDeComercio() {
		return registradoCamaraDeComercio;
	}

	public void setRegistradoCamaraDeComercio(Boolean registradoCamaraDeComercio) {
		this.registradoCamaraDeComercio = registradoCamaraDeComercio;
	}

	public Boolean getRegistradoSuperintendenciaTurismo() {
		return registradoSuperintendenciaTurismo;
	}

	public void setRegistradoSuperintendenciaTurismo(Boolean registradoSuperintendenciaTurismo) {
		this.registradoSuperintendenciaTurismo = registradoSuperintendenciaTurismo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Long getNumeroPago() {
		return numeroPago;
	}

	public void setNumeroPago(Long numeroPago) {
		this.numeroPago = numeroPago;
	}

	public List<Object[]> getContratos() {
		return contratos;
	}

	public void setContratos(List<Object[]> contratos) {
		this.contratos = contratos;
	}

	public List<Object[]> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Object[]> hoteles) {
		this.hoteles = hoteles;
	}

	public List<Object[]> getHostales() {
		return hostales;
	}

	public void setHostales(List<Object[]> hostales) {
		this.hostales = hostales;
	}

	public List<Object[]> getViviendasUniversitarias() {
		return viviendasUniversitarias;
	}

	public void setViviendasUniversitarias(List<Object[]> viviendasUniversitarias) {
		this.viviendasUniversitarias = viviendasUniversitarias;
	}
}

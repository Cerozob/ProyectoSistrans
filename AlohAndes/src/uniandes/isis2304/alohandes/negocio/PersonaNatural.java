package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class PersonaNatural implements VOPersonaNatural{

	private Long identificacion;
	
	private String nombre;

	private String apellido;

	private Long numeroPago;

	private List<Object[]> contratos;

	private List<Object[]> viviendas;

	private List<Object[]> apartamentos;

	private List<Object[]> habitaciones;
	
	public PersonaNatural()
	{
		identificacion = 0L;

		nombre = "";

		apellido = "";

		numeroPago = 0L;

		contratos = new LinkedList<Object[]>();
		
		viviendas = new LinkedList<Object[]>();

		apartamentos = new LinkedList<Object[]>();

		habitaciones = new LinkedList<Object[]>();
	}

	public PersonaNatural(Long identificacion, String nombre, String apellido, Long numeroPago) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroPago = numeroPago;
		contratos = new LinkedList<Object[]>();
		
		viviendas = new LinkedList<Object[]>();

		apartamentos = new LinkedList<Object[]>();

		habitaciones = new LinkedList<Object[]>();
	
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public List<Object[]> getViviendas() {
		return viviendas;
	}

	public void setViviendas(List<Object[]> viviendas) {
		this.viviendas = viviendas;
	}

	public List<Object[]> getApartamentos() {
		return apartamentos;
	}

	public void setApartamentos(List<Object[]> apartamentos) {
		this.apartamentos = apartamentos;
	}

	public List<Object[]> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Object[]> habitaciones) {
		this.habitaciones = habitaciones;
	}
}

package uniandes.isis2304.parranderos.negocio;

import java.util.LinkedList;
import java.util.List;

public class Hotel extends Hospedaje implements VOHotel
{
	private long id;
	
	private int cantidadHabitaciones;
	
	private int estrellas;
	
	private long idHospedaje;
	
	private List<Object []> servicios;
	
	private List<Object []> Habitaciones;
	
	private long idEmpresa;
	
	
	public Hotel()
	{
		this.id = 0;
		this.cantidadHabitaciones = 0;
		this.estrellas = 0;
		this.idHospedaje = 0;
		this.idEmpresa = 0;
		this.servicios = new LinkedList<Object []> ();
		this.Habitaciones = new LinkedList<Object []> ();
	}
	
	public Hotel(long id, int cantidadHabitaciones, int estrellas, long idHospedaje, 
			long idEmpresa) 
	{
		super();
		this.id = id;
		this.cantidadHabitaciones = cantidadHabitaciones;
		this.estrellas = estrellas;
		this.idHospedaje = idHospedaje;
		this.idEmpresa = idEmpresa;
		this.servicios = new LinkedList<Object []> ();
		this.Habitaciones = new LinkedList<Object []> ();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public long getIdHospedaje() {
		return idHospedaje;
	}
	
	

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setIdHospedaje(long idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public List<Object[]> getServicios() {
		return servicios;
	}

	public void setServicios(List<Object[]> servicios) {
		this.servicios = servicios;
	}

	public List<Object[]> getHabitaciones() {
		return Habitaciones;
	}

	public void setHabitaciones(List<Object[]> habitaciones) {
		Habitaciones = habitaciones;
	}


	public int getEstrellas() {
		return estrellas;
	}

	@Override
	public long getIdEmpresa() {
		return idEmpresa;
	}

	
}

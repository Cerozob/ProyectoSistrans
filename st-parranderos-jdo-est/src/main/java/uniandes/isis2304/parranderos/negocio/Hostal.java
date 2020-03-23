package uniandes.isis2304.parranderos.negocio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Hostal extends Hospedaje implements VOHostal 
{
	private long id;
	
	private Date apertura;
	
	private Date cierre;
	
	private List<Object []> servicios;
	
	private List<Object []> Habitaciones;
	
	private long idHospedaje;
	
	
	public Hostal() {
		super();
		this.id = 0;
		Date fecha = new Date();
		this.apertura = fecha;
		this.cierre = fecha;
		this.idHospedaje = idHospedaje;
		this.servicios = new LinkedList<Object []> ();
		this.Habitaciones = new LinkedList<Object []> ();
	}
	
	public Hostal(long id, Date apertura, Date cierre, 
			long idHospedaje) {
		super();
		this.id = id;
		this.apertura = apertura;
		this.cierre = cierre;
		this.idHospedaje = idHospedaje;
		this.servicios = new LinkedList<Object []> ();
		this.Habitaciones = new LinkedList<Object []> ();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getApertura() {
		return apertura;
	}

	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}

	public Date getCierre() {
		return cierre;
	}

	public void setCierre(Date cierre) {
		this.cierre = cierre;
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

	public long getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(long idHospedaje) {
		this.idHospedaje = idHospedaje;
	}
	
	
	
}

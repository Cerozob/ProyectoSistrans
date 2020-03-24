package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class ViviendaUniversitaria extends Hospedaje implements VOViviendaUniversitaria
{
	private long id;
	
	private String telefono;
	
	private int cantidadHabitaciones;
	
	private long idEmpresa;
	
	private long idHospedaje;
	
	private List<Object []> Habitaciones;

	public ViviendaUniversitaria() {
		super();
		this.id = 0;
		this.telefono = "";
		this.cantidadHabitaciones = 0;
		this.idEmpresa = 0;
		this.idHospedaje = 0;
		this.Habitaciones = new LinkedList<Object []> ();
	}
	
	
	public ViviendaUniversitaria(long id, String telefono, int cantidadHabitaciones, long idEmpresa, long idHospedaje
			) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.cantidadHabitaciones = cantidadHabitaciones;
		this.idEmpresa = idEmpresa;
		this.idHospedaje = idHospedaje;
		this.Habitaciones = new LinkedList<Object []> ();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCantidadHabitaciones() {
		return cantidadHabitaciones;
	}

	public void setCantidadHabitaciones(int cantidadHabitaciones) {
		this.cantidadHabitaciones = cantidadHabitaciones;
	}

	public long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public long getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(long idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public List<Object[]> getHabitaciones() {
		return Habitaciones;
	}

	public void setHabitaciones(List<Object[]> habitaciones) {
		Habitaciones = habitaciones;
	}
	
	
	
	
}

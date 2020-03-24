package uniandes.isis2304.alohandes.negocio;

import java.util.LinkedList;
import java.util.List;

public class Habitacion extends Hospedaje implements VOHabitacion
{
	public enum  TipoHabitacion
	{
		SUITE,
		SEMISUITE,
		ESTANDAR,
		COMPARTIDA
	}
	private long id;
	
	

	private TipoHabitacion tipoHabitacion;
	
	private int capacidad;
	
	private int numero;
	
	private long idVivienda;
	
	private long idHotel;
	
	private long idHospedaje;
	
	private long idHostal;
	
	private long idPersonaNatural;
	
	private List<Object []> servicios;
	
	public Habitacion() {
		super();
		this.id = 0;
		this.tipoHabitacion = null;
		this.capacidad = 0;
		this.numero = 0;
		this.idVivienda = 0;
		this.idHotel = 0;
		this.idHospedaje = 0;
		this.idHostal = 0;
		this.idPersonaNatural = 0;
		this.servicios = new LinkedList<Object []> ();
	}
	
	
	public Habitacion(long id, TipoHabitacion tipoHabitacion, int capacidad, int numero, long idVivienda, long idHotel,
			long idHospedaje, long idHostal, long idPersonaNatural) {
		super();
		this.id = id;
		this.tipoHabitacion = tipoHabitacion;
		this.capacidad = capacidad;
		this.numero = numero;
		this.idVivienda = idVivienda;
		this.idHotel = idHotel;
		this.idHospedaje = idHospedaje;
		this.idHostal = idHostal;
		this.idPersonaNatural = idPersonaNatural;
		this.servicios = new LinkedList<Object []> ();
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(long idVivienda) {
		this.idVivienda = idVivienda;
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}

	public long getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(long idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public long getIdHostal() {
		return idHostal;
	}

	public void setIdHostal(long idHostal) {
		this.idHostal = idHostal;
	}

	public long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	public List<Object[]> getServicios() {
		return servicios;
	}

	public void setServicios(List<Object[]> servicios) {
		this.servicios = servicios;
	}
	
	
	
}

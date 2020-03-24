package uniandes.isis2304.alohandes.negocio;

public class Apartamento extends Hospedaje implements VOApartamento
{
	private long id;
	
	private boolean amoblado;
	
	private int capacidad;
	
	private long idHospedaje;
	
	private long idPersonaNatural;
	
	
	public Apartamento() 
	{
		
		this.id = 0;
		this.amoblado = false;
		this.capacidad = capacidad;
		this.idHospedaje = 0;
		this.idPersonaNatural = 0;
	}
	
	public Apartamento(long id, boolean amoblado, int capacidad, long idHostal, long idPersonaNatural) {
		super();
		this.id = id;
		this.amoblado = amoblado;
		this.capacidad = capacidad;
		this.idHospedaje = idHospedaje;
		this.idPersonaNatural = idPersonaNatural;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAmoblado() {
		return amoblado;
	}

	public void setAmoblado(boolean amoblado) {
		this.amoblado = amoblado;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public long getIdHospedaje() {
		return idHospedaje;
	}

	public void setIdHospedaje(long idHospedaje) {
		this.idHospedaje = idHospedaje;
	}

	public long getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(long idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
	}

	



	
}

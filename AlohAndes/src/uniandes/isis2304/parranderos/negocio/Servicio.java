package uniandes.isis2304.parranderos.negocio;

public class Servicio implements VOServicio{
	
	private Long iDServicio;
	
	private String nombreServicio;

	private Double valor;

	private Long iDHabitacion;

	private Long iDHotel;

	private Long iDHostal;

	public Servicio()
	{
		iDServicio = 0L;
		
		nombreServicio = "";

		valor = 0.0;

		iDHabitacion = 0L;

		iDHotel = 0L;

		iDHostal = 0L;
	}

	public Servicio(Long iDServicio, String nombreServicio, Double valor, Long iDHabitacion, Long iDHotel,
			Long iDHostal) {
		
		this.iDServicio = iDServicio;
		this.nombreServicio = nombreServicio;
		this.valor = valor;
		this.iDHabitacion = iDHabitacion;
		this.iDHotel = iDHotel;
		this.iDHostal = iDHostal;
	}

	public Long getiDServicio() {
		return iDServicio;
	}

	public void setiDServicio(Long iDServicio) {
		this.iDServicio = iDServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getiDHabitacion() {
		return iDHabitacion;
	}

	public void setiDHabitacion(Long iDHabitacion) {
		this.iDHabitacion = iDHabitacion;
	}

	public Long getiDHotel() {
		return iDHotel;
	}

	public void setiDHotel(Long iDHotel) {
		this.iDHotel = iDHotel;
	}

	public Long getiDHostal() {
		return iDHostal;
	}

	public void setiDHostal(Long iDHostal) {
		this.iDHostal = iDHostal;
	}
	
	
	
}

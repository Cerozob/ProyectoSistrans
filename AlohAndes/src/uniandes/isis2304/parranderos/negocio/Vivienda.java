package uniandes.isis2304.parranderos.negocio;

public class Vivienda {

	private Long iDVivienda;
	
	private Integer numeroHabitaciones;
	
	private String Menaje;
	
	private Integer dias_Usada;
	
	private Double costo_Inmueble;
	
	private Double costoContenido;
	
	private Long iD_PersonaNatural;
	
	private Long iD_Hospedaje;
	
	private String nombre;
	
	private String direccion;
	
	private Double valorTotal;
	
	public Vivienda()
	{
		iDVivienda = 0L;
		
		numeroHabitaciones = 0;
		
		Menaje = "";
		
		dias_Usada = 0;
		
		costo_Inmueble = 0.0;
		
		costoContenido= 0.0;
		
		iD_PersonaNatural= 0L;
		
		iD_Hospedaje = 0L;
		
		nombre = "";
		
		direccion = "";
		
		valorTotal = 0.0;
	}

	public Vivienda(Long iDVivienda, Integer numeroHabitaciones, String menaje, Integer dias_Usada,
			Double costo_Inmueble, Double costoContenido, Long iD_PersonaNatural, Long iD_Hospedaje, String nombre,
			String direccion, Double valorTotal) {
		super();
		this.iDVivienda = iDVivienda;
		this.numeroHabitaciones = numeroHabitaciones;
		Menaje = menaje;
		this.dias_Usada = dias_Usada;
		this.costo_Inmueble = costo_Inmueble;
		this.costoContenido = costoContenido;
		this.iD_PersonaNatural = iD_PersonaNatural;
		this.iD_Hospedaje = iD_Hospedaje;
		this.nombre = nombre;
		this.direccion = direccion;
		this.valorTotal = valorTotal;
	}

	public Long getiDVivienda() {
		return iDVivienda;
	}

	public Integer getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public String getMenaje() {
		return Menaje;
	}

	public Integer getDias_Usada() {
		return dias_Usada;
	}

	public Double getCosto_Inmueble() {
		return costo_Inmueble;
	}

	public Double getCostoContenido() {
		return costoContenido;
	}

	public Long getiD_PersonaNatural() {
		return iD_PersonaNatural;
	}

	public Long getiD_Hospedaje() {
		return iD_Hospedaje;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setiDVivienda(Long iDVivienda) {
		this.iDVivienda = iDVivienda;
	}

	public void setNumeroHabitaciones(Integer numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public void setMenaje(String menaje) {
		Menaje = menaje;
	}

	public void setDias_Usada(Integer dias_Usada) {
		this.dias_Usada = dias_Usada;
	}

	public void setCosto_Inmueble(Double costo_Inmueble) {
		this.costo_Inmueble = costo_Inmueble;
	}

	public void setCostoContenido(Double costoContenido) {
		this.costoContenido = costoContenido;
	}

	public void setiD_PersonaNatural(Long iD_PersonaNatural) {
		this.iD_PersonaNatural = iD_PersonaNatural;
	}

	public void setiD_Hospedaje(Long iD_Hospedaje) {
		this.iD_Hospedaje = iD_Hospedaje;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}

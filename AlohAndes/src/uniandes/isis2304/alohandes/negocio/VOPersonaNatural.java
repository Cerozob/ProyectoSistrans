package uniandes.isis2304.alohandes.negocio;

import java.util.List;

public interface VOPersonaNatural {

	public Long getIdentificacion();

	public String getNombre() ;

	public String getApellido();

	public Long getNumeroPago() ;

	public List<Object[]> getContratos() ;

	public List<Object[]> getApartamentos() ;

	public List<Object[]> getViviendas() ;

	public List<Object[]> getHabitaciones();
}

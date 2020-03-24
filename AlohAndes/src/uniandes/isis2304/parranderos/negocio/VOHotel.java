package uniandes.isis2304.parranderos.negocio;

import java.util.List;

public interface VOHotel
{
	public long getId();
	
	public int getCantidadHabitaciones();
	
	public int getEstrellas();
	
	public long getIdEmpresa();
	
	public List<Object []> getServicios();
	
	public List<Object []> getHabitaciones();
	
	public long getIdHospedaje();

}

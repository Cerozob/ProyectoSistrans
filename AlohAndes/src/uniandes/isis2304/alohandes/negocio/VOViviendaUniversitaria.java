package uniandes.isis2304.alohandes.negocio;

import java.util.List;

public interface VOViviendaUniversitaria 
{
	public long getId();
	
	public String getTelefono();
	
	public int getCantidadHabitaciones();
	
	public long getIdEmpresa();
	
	public long getIdHospedaje();
	
	public List<Object[]> getHabitaciones();
}

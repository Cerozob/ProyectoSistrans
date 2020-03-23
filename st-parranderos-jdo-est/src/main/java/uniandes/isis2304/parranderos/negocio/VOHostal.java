package uniandes.isis2304.parranderos.negocio;

import java.util.Date;
import java.util.List;

public interface VOHostal {
	
	public long getId();
	
	public Date getCierre();
	
	public Date getApertura();
	
	public List<Object []> getServicios();
	
	public List<Object []> getHabitaciones();
	
	public long getIdHospedaje();
}

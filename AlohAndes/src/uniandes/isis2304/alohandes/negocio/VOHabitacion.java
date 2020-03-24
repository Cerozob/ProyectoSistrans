package uniandes.isis2304.alohandes.negocio;

import java.util.List;

import uniandes.isis2304.alohandes.negocio.Habitacion.TipoHabitacion;

public interface VOHabitacion 
{
	public TipoHabitacion getTipoHabitacion();
	
	public int getCapacidad();
	
	public int getNumero();
	
	public long getIdVivienda();
	
	public long getIdHotel();
	
	public long getIdHospedaje();
	
	public long getIdHostal();
	
	public long getIdPersonaNatural();
	
	public List<Object[]> getServicios() ;
}

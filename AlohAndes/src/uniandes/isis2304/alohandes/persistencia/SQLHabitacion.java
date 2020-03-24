package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.alohandes.negocio.Habitacion;
import uniandes.isis2304.alohandes.negocio.Habitacion.TipoHabitacion;

public class SQLHabitacion
{
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLHabitacion (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarHabitacion (PersistenceManager pm, long id, TipoHabitacion tipoHabitacion, int capacidad, int numero, long idVivienda, long idHotel,
			long idHospedaje, long idHostal, long idPersonaNatural) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHabitacion() + "(idHabitacion, tipoHabitacion, numero, capacidad , id_personaNatural, id_vivienda_universitaria , id_hospedaje ,id_Hostal, idHotel ) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, tipoHabitacion, numero, capacidad, idPersonaNatural, idVivienda, idHospedaje, idHostal, idHotel);
        return (long) q.executeUnique();
	}
	
	public long eliminarHabitacionPorId(PersistenceManager pm, long idHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion () + " WHERE idHabitacion = ?");
        q.setParameters(idHabitacion);
        return (long) q.executeUnique();
	}
	

	public Habitacion darHabitacionPorId (PersistenceManager pm, long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion () + " WHERE idHabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}
	
	
	
	public List<Habitacion> darHabitacion (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion ());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}
	
}

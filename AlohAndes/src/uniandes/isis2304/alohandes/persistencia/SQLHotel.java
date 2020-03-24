package uniandes.isis2304.alohandes.persistencia;

import java.util.Date;
import java.util.List;

import uniandes.isis2304.alohandes.negocio.Hostal;
import uniandes.isis2304.alohandes.negocio.Hotel;

public class SQLHotel 
{
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLHotel (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarHotel (PersistenceManager pm,long id, int cantidadHabitaciones, int estrellas, long idHospedaje, 
			long idEmpresa) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHotel() + "((IdHotel  , cantidadHabitaciones , estrellas , idHospedaje, NIT_EMPRESA ) values (?, ?, ?, ?, ?)");
        q.setParameters(id, cantidadHabitaciones, estrellas, idHospedaje,  idEmpresa);
        return (long) q.executeUnique();
	}
	
	public long eliminarHotelPorId(PersistenceManager pm, long IdHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel () + " WHERE IdHotel   = ?");
        q.setParameters(IdHotel);
        return (long) q.executeUnique();
	}
	
	
	
	public Hotel darHotelPorId (PersistenceManager pm, long IdHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel () + " WHERE IdHotel  = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(IdHotel);
		return (Hotel) q.executeUnique();
	}
	
	public List<Hotel> darHotel (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHotel ());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
}

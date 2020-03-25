package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Servicio;

public class SQLServicio {
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLServicio (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicio (PersistenceManager pm,Long iDServicio, String nombreServicio, Double valor, Long iDHabitacion, Long iDHotel,
			Long iDHostal) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(idservicio, nombreservicio, valor, idhabitacion, idhotel, idhostal) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(iDServicio, nombreServicio, valor, iDHabitacion,iDHotel,iDHostal);
        return (long) q.executeUnique();
	}
	
	public long eliminarServiciosPorId(PersistenceManager pm, long idservicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio () + " WHERE idservicio = ?");
        q.setParameters(idservicio);
        return (long) q.executeUnique();
	}
	
	
	public Servicio darServicioPorId (PersistenceManager pm, long idservicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio () + " WHERE idservicio = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idservicio);
		return (Servicio) q.executeUnique();
	}
	
	
	
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
}


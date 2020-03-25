package uniandes.isis2304.alohandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.PersonaNatural;

public class SQLPersonaNatural {
	
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLPersonaNatural (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarPersonaNatural (PersistenceManager pm,Long identificacion, String nombre, String apellido, Long numeroPago) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPersonaNatural() + "(identificacion, nombre, apellido,numeropago) values (?, ?, ?, ?)");
        q.setParameters( identificacion,  nombre,  apellido,  numeroPago);
        return (long) q.executeUnique();
	}
	
	public long eliminarPersonaNaturalsPorId(PersistenceManager pm, long identificacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPersonaNatural () + " WHERE identificacion = ?");
        q.setParameters(identificacion);
        return (long) q.executeUnique();
	}
	
	
	public PersonaNatural darPersonaNaturalPorId (PersistenceManager pm, long identificacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPersonaNatural () + " WHERE identificacion = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(identificacion);
		return (PersonaNatural) q.executeUnique();
	}
	
	
	
	public List<PersonaNatural> darPersonaNaturals (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPersonaNatural ());
		q.setResultClass(PersonaNatural.class);
		return (List<PersonaNatural>) q.executeList();
	}
}

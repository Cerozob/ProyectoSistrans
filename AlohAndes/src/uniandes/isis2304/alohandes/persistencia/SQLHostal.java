package uniandes.isis2304.alohandes.persistencia;

import java.util.Date;
import java.util.List;


import uniandes.isis2304.alohandes.negocio.Hostal;

public class SQLHostal 
{
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLHostal (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarHostal (PersistenceManager pm, long idHostal, Date apertura, Date cierre, 
			long idHospedaje, long NIT_EMPRESA) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHostal() + "((IdHostal  , apertura, cierre, idHospedaje, NIT_EMPRESA ) values (?, ?, ?, ?, ?)");
        q.setParameters(idHostal, apertura, cierre, idHospedaje,  NIT_EMPRESA);
        return (long) q.executeUnique();
	}
	
	public long eliminarHostalPorId(PersistenceManager pm, long idHostal)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHostal () + " WHERE IdHostal   = ?");
        q.setParameters(idHostal);
        return (long) q.executeUnique();
	}
	
	
	
	public Hostal darHostaljePorId (PersistenceManager pm, long idHostal) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHostal () + " WHERE IdHostal  = ?");
		q.setResultClass(Hostal.class);
		q.setParameters(idHostal);
		return (Hostal) q.executeUnique();
	}
	
	public List<Hostal> darHostal (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHostal ());
		q.setResultClass(Hostal.class);
		return (List<Hostal>) q.executeList();
	}
}

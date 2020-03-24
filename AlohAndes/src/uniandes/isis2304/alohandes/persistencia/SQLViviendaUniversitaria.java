package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import uniandes.isis2304.alohandes.negocio.Hotel;
import uniandes.isis2304.alohandes.negocio.ViviendaUniversitaria;

public class SQLViviendaUniversitaria
{
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLViviendaUniversitaria (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarViviendaUniversitaria (PersistenceManager pm,long id, String direccion, int telefono, long idHospedaje, 
			long idEmpresa) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaViviendaUniversitaria() + "((idViviendaU   , direccion  , telefono  , NIT_EMPRESA , idHospedaje  ) values (?, ?, ?, ?, ?)");
        q.setParameters(id, direccion, telefono, idEmpresa,  idHospedaje);
        return (long) q.executeUnique();
	}
	
	public long eliminarViviendaUniversitariaPorId(PersistenceManager pm, long IdViviendaUniversitaria )
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaViviendaUniversitaria () + " WHERE idViviendaU   = ?");
        q.setParameters(IdViviendaUniversitaria);
        return (long) q.executeUnique();
	}
	
	
	
	public ViviendaUniversitaria darViviendaUniversitariaPorId (PersistenceManager pm, long IdViviendaUniversitaria) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaViviendaUniversitaria () + " WHERE idViviendaU  = ?");
		q.setResultClass(ViviendaUniversitaria.class);
		q.setParameters(IdViviendaUniversitaria);
		return (ViviendaUniversitaria) q.executeUnique();
	}
	
	public List<ViviendaUniversitaria> darViviendaUniversitaria (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaViviendaUniversitaria ());
		q.setResultClass(ViviendaUniversitaria.class);
		return (List<ViviendaUniversitaria>) q.executeList();
	}
}

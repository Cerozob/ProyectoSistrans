package uniandes.isis2304.alohandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.alohandes.negocio.Hospedaje;
import uniandes.isis2304.alohandes.negocio.Hospedaje.TipoHospedaje;

public class SQLHospedaje
{
	private final static String SQL = PersistenciaAlohandes.SQL;

	private PersistenciaAlohandes pp;

	public SQLHospedaje (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}

	public long adicionarHospedaje (PersistenceManager pm, long id, String nombre, String direccion,TipoHospedaje tipo, double valorTotal) 
	{
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHospedaje() + "((idHospedaje , nombre, direccion,tipohospedaje, valorTotal ) values (?, ?, ?,?, ?)");
		q.setParameters(id, nombre, direccion,tipo, valorTotal);
		return (long) q.executeUnique();
	}


	public long eliminarHospedajePorId (PersistenceManager pm, long idHospedaje)
	{
		SQLContrato c = new SQLContrato(pp);
		if(c.darContratosPorIdHospedaje(pm, idHospedaje).isEmpty())
		{
			Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospedaje () + " WHERE idHospedaje = ?");
			q.setParameters(idHospedaje);
			return (long) q.executeUnique();
		}
		return -1;
	}

	public Hospedaje darHospedajePorId (PersistenceManager pm, long idHospedaje) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospedaje () + " WHERE idHospedaje = ?");
		q.setResultClass(Hospedaje.class);
		q.setParameters(idHospedaje);
		return (Hospedaje) q.executeUnique();
	}

	public List<Hospedaje> darHospedaje (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospedaje ());
		q.setResultClass(Hospedaje.class);
		return (List<Hospedaje>) q.executeList();
	}
}

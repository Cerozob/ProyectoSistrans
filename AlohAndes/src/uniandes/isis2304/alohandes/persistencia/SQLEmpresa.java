package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Empresa;

public class SQLEmpresa {

	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLEmpresa (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarEmpresa (PersistenceManager pm,Long nit,Boolean registradocamaracomercio,Boolean registradoSuperintendenciaTurismo,String nombre, String web, Long numeropago) 
	{	
		int camaracom = -1;
		int turismo = -1;
		if(registradocamaracomercio)
		{
			camaracom=1;
		}
		else
		{
			camaracom = 0;
		}
		if(registradoSuperintendenciaTurismo)
		{
			turismo = 1;
		}
		else
		{
			turismo = 0;
		}
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEmpresa() + "(nit, registradocamaracomercio,  registradoindependenciaTurismo,  nombre,web,numeropago) values (?, ?, ?, ?,?,?)");
        q.setParameters( nit,  camaracom,  turismo,  nombre,web,numeropago);
        return (long) q.executeUnique();
	}
	
	public long eliminarEmpresasPorId(PersistenceManager pm, long nit)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresa () + " WHERE nit = ?");
        q.setParameters(nit);
        return (long) q.executeUnique();
	}
	
	
	public Empresa darEmpresaPorId (PersistenceManager pm, long nit) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresa () + " WHERE nit = ?");
		q.setResultClass(Empresa.class);
		q.setParameters(nit);
		return (Empresa) q.executeUnique();
	}
	
	
	
	public List<Empresa> darEmpresas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresa ());
		q.setResultClass(Empresa.class);
		return (List<Empresa>) q.executeList();
	}
}

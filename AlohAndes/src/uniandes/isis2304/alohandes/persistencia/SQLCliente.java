package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Cliente;
import uniandes.isis2304.alohandes.negocio.VOCliente.TIPO_VINCULO;

public class SQLCliente {
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLCliente (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCliente (PersistenceManager pm,Long identificacion, String nombre, String apellido, TIPO_VINCULO vinculo, Long numero_pago) 
	{
		String tipoVinculo = vinculo.toString(); 
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCliente() + "(identificacion, nombre, apellido, vinculo, numero_pago) values (?, ?, ?, ?, ?)");
        q.setParameters(identificacion, nombre, apellido, tipoVinculo, numero_pago);
        return (long) q.executeUnique();
	}
	
	public long eliminarClientesPorId(PersistenceManager pm, long identificacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente () + " WHERE identificacion = ?");
        q.setParameters(identificacion);
        return (long) q.executeUnique();
	}
	
	
	public Cliente darClientePorId (PersistenceManager pm, long identificacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente () + " WHERE identificacion = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(identificacion);
		return (Cliente) q.executeUnique();
	}
	
	
	
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}
}

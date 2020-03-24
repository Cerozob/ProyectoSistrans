package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Apartamento;


public class SQLApartamento {
	
	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLApartamento (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarApartamento (PersistenceManager pm, long id, boolean amoblado, int capacidad, long idHospedaje, long idPersonaNatural) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaApartamento() + "(id_Apartamento, amoblado, capacidad, id_hospedaje , id_personaNatural ) values (?, ?, ?, ?, ?)");
        q.setParameters(id, amoblado, capacidad, idHospedaje, idPersonaNatural);
        return (long) q.executeUnique();
	}
	
	public long eliminarApartamentosPorId(PersistenceManager pm, long idApartamento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaApartamento () + " WHERE id_Apartamento = ?");
        q.setParameters(idApartamento);
        return (long) q.executeUnique();
	}
	
	
	public Apartamento darApartamentoPorId (PersistenceManager pm, long idApartamento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaApartamento () + " WHERE id_Apartamento = ?");
		q.setResultClass(Apartamento.class);
		q.setParameters(idApartamento);
		return (Apartamento) q.executeUnique();
	}
	
	
	
	public List<Apartamento> darApartamentos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaApartamento ());
		q.setResultClass(Apartamento.class);
		return (List<Apartamento>) q.executeList();
	}
	
	

}

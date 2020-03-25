package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Vivienda;

public class SQLVivienda {

	private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLVivienda (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarVivienda (PersistenceManager pm,Long iDVivienda, Integer numeroHabitaciones, String menaje, Integer dias_Usada,
			Double costo_Inmueble, Double costoContenido, Long iD_PersonaNatural, Long iD_Hospedaje, String nombre,
			String direccion, Double valorTotal)
	{	
		//sin nit de la empresa
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaVivienda() + "(id_vivienda, numero_habitaciones, menaje,  dias_usada,costocontenido,costo_inmueble,id_personanatural,id_hospedaje) values (?, ?, ?, ?,?,?,?,?)");
        q.setParameters( iDVivienda, numeroHabitaciones, menaje, dias_Usada,
    			costo_Inmueble, costoContenido, iD_PersonaNatural,iD_Hospedaje);
        return (long) q.executeUnique();
	}
	
	public long eliminarViviendasPorId(PersistenceManager pm, long id_vivienda)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVivienda () + " WHERE id_vivienda = ?");
        q.setParameters(id_vivienda);
        return (long) q.executeUnique();
	}
	
	
	public Vivienda darViviendaPorId (PersistenceManager pm, long id_vivienda) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVivienda () + " WHERE id_vivienda = ?");
		q.setResultClass(Vivienda.class);
		q.setParameters(id_vivienda);
		return (Vivienda) q.executeUnique();
	}
	
	
	
	public List<Vivienda> darViviendas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVivienda ());
		q.setResultClass(Vivienda.class);
		return (List<Vivienda>) q.executeList();
	}
}

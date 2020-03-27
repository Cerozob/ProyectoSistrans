package uniandes.isis2304.alohandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class SQLUtil {
	private final static String SQL = PersistenciaAlohandes.SQL;
	private PersistenciaAlohandes pp;
	
	public SQLUtil (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp.darSeqAlohandes() + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public long [] limpiarParranderos (PersistenceManager pm)
	{
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente());          
        Query qContrato = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaContrato ());
        Query qEmpresa = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresa());
        Query qPersonaNatural = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPersonaNatural());
        Query qServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qApartamento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaApartamento());
        Query qVivienda = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVivienda());
        Query qViviendaUniversitaria = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaViviendaUniversitaria());
        Query qHotel = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHotel());
        Query qHostal = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHostal());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion());
        Query qHospedaje = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospedaje());

        
        long clienteEliminados = (long) qCliente.executeUnique ();
        long contratoEliminados = (long) qContrato.executeUnique ();
        long empresaEliminadas = (long) qEmpresa.executeUnique ();
        long personaNaturalEliminadas = (long) qPersonaNatural.executeUnique ();
        long servicioEliminados = (long) qServicio.executeUnique ();
        long apartamentoEliminados = (long) qApartamento.executeUnique ();
        long viviendaEliminados = (long) qVivienda.executeUnique ();
        long viviendaUniversitariaEliminados = (long) qViviendaUniversitaria.executeUnique ();
        long hotelEliminados = (long) qHotel.executeUnique ();
        long hostalEliminados = (long) qHostal.executeUnique ();
        long habitacionEliminados = (long) qHabitacion.executeUnique ();
        long hospedajeEliminados = (long) qHospedaje.executeUnique ();
        
        
        return new long[] {clienteEliminados, 
        		contratoEliminados,
        		empresaEliminadas,
        		personaNaturalEliminadas,
        		servicioEliminados,
        		apartamentoEliminados,
        		viviendaEliminados,
        		viviendaUniversitariaEliminados,
        		hotelEliminados,
        		hostalEliminados,
        		habitacionEliminados,
        		hospedajeEliminados};
	}
	
}

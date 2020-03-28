package uniandes.isis2304.alohandes.persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Apartamento;
import uniandes.isis2304.alohandes.negocio.Habitacion;
import uniandes.isis2304.alohandes.negocio.Hospedaje;
import uniandes.isis2304.alohandes.negocio.Hotel;
import uniandes.isis2304.alohandes.negocio.Vivienda;
import uniandes.isis2304.alohandes.negocio.Hospedaje.TipoHospedaje;
import uniandes.isis2304.alohandes.negocio.Hostal;
import uniandes.isis2304.alohandes.negocio.ViviendaUniversitaria;

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

	public Object darAlojamientoPorId(PersistenceManager pm,long idhospedaje)
	{
		Hospedaje h = darHospedajePorId(pm, idhospedaje);

		switch (h.getTipo()) 
		{
		case  APARTAMENTO:
			SQLApartamento sqla= new SQLApartamento(pp);
			return sqla.darApartamentoPorId(pm, idhospedaje);
		case  VIVIENDA:
			SQLVivienda sqlv= new SQLVivienda(pp);
			return sqlv.darViviendaPorId(pm, idhospedaje);
		case  VIVIENDA_UNIVERSITARIA:
			SQLViviendaUniversitaria sqlvu = new SQLViviendaUniversitaria(pp);
			return sqlvu.darViviendaUniversitariaPorId(pm, idhospedaje);
		case  HOTEL:
			SQLHotel sqlh = new SQLHotel(pp);
			return sqlh.darHotelPorId(pm, idhospedaje);
		case  HOSTAL:
			SQLHostal sqlho= new SQLHostal(pp);
			return sqlho.darHostaljePorId(pm, idhospedaje);
		case  HABITACION:
			SQLHabitacion sqlha = new SQLHabitacion(pp);
			return sqlha.darHabitacionPorId(pm, idhospedaje);
		default:
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospedaje () + " WHERE idHospedaje = ?");
			q.setResultClass(Hospedaje.class);
			q.setParameters(idhospedaje);
			return q.executeUnique();
		}

	}

	public Long darIdDuenio(PersistenceManager pm,Long idhospedaje)
	{
		Hospedaje h = darHospedajePorId(pm, idhospedaje);

		switch (h.getTipo()) 
		{
		case  APARTAMENTO:
			Apartamento a = (Apartamento) darAlojamientoPorId(pm, idhospedaje);
			return a.getIdPersonaNatural();
		case  VIVIENDA:
			Vivienda v = (Vivienda) darAlojamientoPorId(pm, idhospedaje);
			return v.getiD_PersonaNatural();

		case  VIVIENDA_UNIVERSITARIA:
			ViviendaUniversitaria vu =(ViviendaUniversitaria) darAlojamientoPorId(pm, idhospedaje);
			return vu.getIdEmpresa();

		case  HOTEL:
			Hotel hot =(Hotel) darAlojamientoPorId(pm, idhospedaje);
			return hot.getIdEmpresa();

		case  HOSTAL:
			Hostal hos =(Hostal) darAlojamientoPorId(pm, idhospedaje);
			return hos.getNIT_EMPRESA();

		case  HABITACION:
			Habitacion hab = (Habitacion) darAlojamientoPorId(pm, idhospedaje);
			switch (hab.getTipoHabitacion()) {
			case CASA:
				return hab.getIdPersonaNatural();

			case COMPARTIDA:
				return hab.getIdHostal();

			case ESTANDAR:
				if(hab.getIdHostal() == 0)
				{
					return hab.getIdHotel();
				}
				else
				{
					return hab.getIdHostal();
				}

			case SEMISUITE:
				return hab.getIdHotel();

			case SUITE:
				return hab.getIdHotel();

			default:
				break;
			}
		default:
			return -1L;
		}
	}

	public List<Hospedaje> darHospedaje (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospedaje ());
		q.setResultClass(Hospedaje.class);
		return (List<Hospedaje>) q.executeList();
	}
}

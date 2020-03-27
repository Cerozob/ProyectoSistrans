package uniandes.isis2304.alohandes.persistencia;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import uniandes.isis2304.alohandes.negocio.Hospedaje;
import uniandes.isis2304.alohandes.negocio.Cliente;
import uniandes.isis2304.alohandes.negocio.Contrato;

public class SQLContrato {
private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLContrato (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarContrato (PersistenceManager pm,Long iDContrato, Double valor,Date fecha_Reserva, Date fecha_Inicio,  Date fecha_Final,Long iDHospedaje,
			Long iDCedulaCliente, Long nit_Empresa, Long cedulaPersonaNatural) 
	{
		SQLHospedaje sqlHospe = new SQLHospedaje(pp);
		SQLCliente sqlCliente = new SQLCliente(pp);
		
		Cliente cliente = sqlCliente.darClientePorId(pm, iDCedulaCliente);
		Hospedaje h = sqlHospe.darHospedajePorId(pm, iDHospedaje);
		
		boolean b = darNumeroDeVeceClientePorFecha(pm, iDCedulaCliente, fecha_Reserva);
		if(b == false)
		{
			if(h.getTipo().equals("APARTAMENTO")||h.getTipo().equals("VIVIENDA")||h.getTipo().equals("HABITACION"))
			{
				Long dif = Math.abs(fecha_Final.getTime()-fecha_Inicio.getTime());
				int dias =(int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
				if(dias >30)
				{
					Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaContrato() + "(idContrato, valor,fecha_reserva, fecha_inicio,fecha_final, idhospedaje, idcedulacliente,nit_empresa,cedulapersonanatural) values (?, ?, ?, ?, ?, ?, ?, ?,?)");
					q.setParameters(iDContrato, valor, fecha_Reserva,fecha_Inicio,fecha_Final,  iDHospedaje,
						iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
					return (long) q.executeUnique();
				}	
			}
				
			else if( h.getTipo().equals("VIVIENDA_UNIVERSITARIA"))
			{
				boolean esVinculoCorrecto = clienteEstudianteProfesorEmpleadoVisi(pm, iDCedulaCliente);
				if(esVinculoCorrecto == true)
				{
					Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaContrato() + "(idContrato, valor,fecha_reserva, fecha_inicio,fecha_final, idhospedaje, idcedulacliente,nit_empresa,cedulapersonanatural) values (?, ?, ?, ?, ?, ?, ?, ?,?)");
					q.setParameters(iDContrato, valor, fecha_Reserva,fecha_Inicio,fecha_Final,  iDHospedaje,
						iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
					return (long) q.executeUnique();
				}
			}
		else
			{
				Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaContrato() + "(idContrato, valor,fecha_reserva, fecha_inicio,fecha_final, idhospedaje, idcedulacliente,nit_empresa,cedulapersonanatural) values (?, ?, ?, ?, ?, ?, ?, ?,?)");
				q.setParameters(iDContrato, valor, fecha_Reserva,fecha_Inicio,fecha_Final,  iDHospedaje,
					iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
				return (long) q.executeUnique();
			}
		}
		return -1;
		
       
	}
	
	public boolean darNumeroDeVeceClientePorFecha(PersistenceManager pm, long idCedula,Date fechaReserva )
	{
		Query q = pm.newQuery(SQL, "SELECT count(*) FROM "+ pp.darTablaContrato() + "  WHERE idCedulaCliente = "+ idCedula);
		boolean b= false;
		q.setResultClass(Contrato.class);
		List<Contrato> lista =(List<Contrato>) q.executeList();
		for (int i = 0; i < lista.size(); i++) 
		{
			Contrato actual = lista.get(i);
			if(actual.getFecha_realizada() == fechaReserva)
			{
				b = true;
			}
		
		}
		return b;
	
	
	}
	
	
	public long eliminarContratosPorId(PersistenceManager pm, long idContrato)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaContrato () + " WHERE idContrato = ?");
        q.setParameters(idContrato);
        return (long) q.executeUnique();
	}
	
	public boolean clienteEstudianteProfesorEmpleadoVisi(PersistenceManager pm, long idCliente)
	{
		SQLCliente sqlCliente = new SQLCliente(pp);
		boolean b= false;
		Cliente cliente = sqlCliente.darClientePorId(pm, idCliente);
		if(cliente.getVinculo().equals("EMPLEADO") ||cliente.getVinculo().equals("PROFESOR") ||cliente.getVinculo().equals("PROFESOR_VISITANTE") ||cliente.getVinculo().equals("ESTUDIANTE") )
		{
			b = true;
		}
		return b;
	
	}
	
	
	public Contrato darContratoPorId (PersistenceManager pm, long idContrato) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaContrato () + " WHERE idContrato = ?");
		q.setResultClass(Contrato.class);
		q.setParameters(idContrato);
		return (Contrato) q.executeUnique();
	}
	
	
	
	public List<Contrato> darContratos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaContrato ());
		q.setResultClass(Contrato.class);
		return (List<Contrato>) q.executeList();
	}
	
	public List<Contrato> darContratosPorIdHospedaje (PersistenceManager pm, long idHospedaje) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaContrato () + " WHERE idhospedaje = ?");
		q.setResultClass(Contrato.class);
		q.setParameters(idHospedaje);
		return (List<Contrato>) q.executeList();
	}
}

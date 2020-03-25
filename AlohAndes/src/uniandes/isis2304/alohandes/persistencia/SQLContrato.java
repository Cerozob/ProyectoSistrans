package uniandes.isis2304.alohandes.persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Contrato;

public class SQLContrato {
private final static String SQL = PersistenciaAlohandes.SQL;
	
	private PersistenciaAlohandes pp;
	
	public SQLContrato (PersistenciaAlohandes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarContrato (PersistenceManager pm,Long iDContrato, Double valor, Date fecha_Final, Date fecha_Inicio, Long iDHospedaje,
			Long iDCedulaCliente, Long nit_Empresa, Long cedulaPersonaNatural) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaContrato() + "(idContrato, valor, fecha_final,fecha_inicio, idhospedaje, idcedulacliente,nit_empresa,cedulapersonanatural) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(iDContrato, valor, fecha_Final, fecha_Inicio, iDHospedaje,
    			 iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
        return (long) q.executeUnique();
	}
	
	public long eliminarContratosPorId(PersistenceManager pm, long idContrato)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaContrato () + " WHERE idContrato = ?");
        q.setParameters(idContrato);
        return (long) q.executeUnique();
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
}

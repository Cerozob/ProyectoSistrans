package uniandes.isis2304.alohandes.persistencia;

import java.util.logging.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.alohandes.negocio.Cliente;
import uniandes.isis2304.alohandes.negocio.Contrato;
import uniandes.isis2304.alohandes.negocio.Empresa;
import uniandes.isis2304.alohandes.negocio.Hospedaje;
import uniandes.isis2304.alohandes.negocio.PersonaNatural;
import uniandes.isis2304.alohandes.negocio.VOCliente.TIPO_VINCULO;

public class PersistenciaAlohandes {

	private static Logger log = Logger.getLogger(PersistenciaAlohandes.class.getName());

	public final static String SQL = "javax.jdo.query.SQL";

	private static PersistenciaAlohandes instance;

	private PersistenceManagerFactory pmf;

	private List <String> tablas;

	private SQLUtil sqlUtil;

	private SQLApartamento sqlApartamento ;
	private SQLCliente sqlCliente;
	private SQLContrato sqlContrato;
	private SQLEmpresa sqlEmpresa;
	private SQLHabitacion sqlHabitacion;
	private SQLHospedaje sqlHospedaje;
	private SQLHotel sqlHotel;
	private SQLHostal sqlHostal;
	private SQLPersonaNatural sqlPersonaNatural;
	private SQLServicio sqlServicio;
	private SQLVivienda sqlVivienda;
	private SQLViviendaUniversitaria sqlViviendaUniversitaria; 

	private PersistenciaAlohandes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Alohandes");		
		crearClasesSQL();

		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("Alohandes_sequence");
		tablas.add ("APARTAMENTO");
		tablas.add ("CLIENTE");
		tablas.add ("CONTRATO");
		tablas.add ("EMPRESA");
		tablas.add ("HABITACION");
		tablas.add ("HOSPEDAJE");
		tablas.add ("HOTEL");
		tablas.add ("HOSTAL");
		tablas.add ("PERSONA_NATURAL");
		tablas.add ("SERVICIO");
		tablas.add ("VIVIENDA_UNIVERSITARIA");
	}


	private PersistenciaAlohandes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);

		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();

		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	public static PersistenciaAlohandes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohandes();
		}
		return instance;
	}

	public static PersistenciaAlohandes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaAlohandes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}

	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}

		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlApartamento = new SQLApartamento(this);
		sqlCliente = new SQLCliente(this);
		sqlContrato = new SQLContrato(this);
		sqlEmpresa = new SQLEmpresa(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlHospedaje = new SQLHospedaje (this);
		sqlHotel = new SQLHotel(this);	
		sqlHostal = new SQLHostal(this);	
		sqlPersonaNatural = new SQLPersonaNatural(this);	
		sqlServicio = new SQLServicio(this);	
		sqlVivienda = new SQLVivienda(this);	
		sqlViviendaUniversitaria = new SQLViviendaUniversitaria(this);	

		sqlUtil = new SQLUtil(this);
	}

	public String darSeqAlohandes ()
	{
		return tablas.get (0);
	}

	public String darTablaApartamento ()
	{
		return tablas.get (1);
	}

	public String darTablaCliente ()
	{
		return tablas.get (2);
	}

	public String darTablaContrato ()
	{
		return tablas.get (3);
	}

	public String darTablaEmpresa ()
	{
		return tablas.get (4);
	}

	public String darTablaHabitacion()
	{
		return tablas.get (5);
	}
	public String darTablaHospedaje ()
	{
		return tablas.get (6);
	}
	public String darTablaHotel ()
	{
		return tablas.get (7);
	}
	public String darTablaHostal()
	{
		return tablas.get (8);
	}

	public String darTablaPersonaNatural ()
	{
		return tablas.get (9);
	}
	public String darTablaServicio ()
	{
		return tablas.get (10);
	}
	public String darTablaVivienda()
	{
		return tablas.get (11);
	}
	public String darTablaViviendaUniversitaria()
	{
		return tablas.get (12);
	}

	private long nextval ()
	{
		long resp = sqlUtil.nextval (pmf.getPersistenceManager());
		return resp;
	}

	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}


	public long [] limpiarAlohandes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			long [] resp = sqlUtil.limpiarParranderos (pm);
			tx.commit ();
			log.info ("Borrada la base de datos");
			return resp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return new long[] {-1, -1, -1, -1, -1, -1, -1};
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}

	//Requerimientos Funcionales

	//RF1 Parte 1 de 2
	public synchronized Empresa registrarEmpresaOperadorAlojamiento(Long nit,Boolean registradocamaracomercio,Boolean registradoSuperintendenciaTurismo,String nombre, String web, Long numeropago)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlEmpresa.adicionarEmpresa(pm, nit, registradocamaracomercio, registradoSuperintendenciaTurismo, nombre, web, numeropago);
			tx.commit();
			return new Empresa(nit, registradocamaracomercio, registradoSuperintendenciaTurismo, nombre, web, numeropago);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//RF1 Parte 2
	public synchronized PersonaNatural registrarPersonaNaturalOperadorAlojamiento(Long identificacion, String nombre, String apellido, Long numeroPago)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlPersonaNatural.adicionarPersonaNatural(pm, identificacion, nombre, apellido, numeroPago);
			tx.commit();
			return new PersonaNatural(identificacion, nombre, apellido, numeroPago);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	public synchronized Hospedaje registrarPropuestaAlojamiento()
	{

	}

	//RF3
	public synchronized Cliente registrarCliente(Long identificacion, String nombre, String apellido, TIPO_VINCULO vinculo, Long numero_pago)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlCliente.adicionarCliente(pm, identificacion, nombre, apellido, vinculo, numero_pago);
			tx.commit();
			return new Cliente(identificacion, nombre, apellido, vinculo, numero_pago);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//RF4
	public synchronized Contrato registrarReserva(Long iDContrato, Double valor, Date fecha_Inicio,Date fecha_Final,  Long iDHospedaje,
			Long iDCedulaCliente, Long nit_Empresa, Long cedulaPersonaNatural)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlContrato.adicionarContrato(pm, iDContrato, valor,fecha_Inicio, fecha_Final,  iDHospedaje, iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
			tx.commit();
			return new Contrato(iDContrato, valor,  fecha_Inicio,fecha_Final, iDHospedaje, iDCedulaCliente, nit_Empresa, cedulaPersonaNatural);
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	//RF5
	private synchronized void cancelarContrato(Long iDContrato)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlContrato.eliminarContratosPorId(pm, iDContrato);
			tx.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//RF6
	private synchronized void cancelarHospedaje(Long idHospedaje)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			sqlHospedaje.eliminarHospedajePorId(pm, idHospedaje);
			tx.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace(); 	
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//RF3 Privacidad
	public synchronized void cancelarReserva(Long cedula, Long iDContrato)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Contrato c = sqlContrato.darContratoPorId(pm, iDContrato);
		if (c.getiDCedulaCliente().equals(cedula))
		{
			cancelarContrato(iDContrato);
		}
	}
	
	//RF6 Privacidad
	public synchronized void cancelarAlojamiento(Long cedula, Long iDHospedaje)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Hospedaje h = sqlHospedaje.darHospedajePorId(pm, iDHospedaje);
	}
}

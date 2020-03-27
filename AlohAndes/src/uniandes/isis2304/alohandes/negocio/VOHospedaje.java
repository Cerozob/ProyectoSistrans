package uniandes.isis2304.alohandes.negocio;

import java.util.List;

import uniandes.isis2304.alohandes.negocio.Hospedaje.TipoHospedaje;

public interface  VOHospedaje 
{
	public long getId();
	
	public String getNombre();
	
	public String getDireccion();
	
	public double getValorTotal();
	
	public List<Object []>  getContratos();
	
	public TipoHospedaje getTipo();
}

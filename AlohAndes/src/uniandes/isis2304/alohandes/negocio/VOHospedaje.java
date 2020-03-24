package uniandes.isis2304.alohandes.negocio;

import java.util.ArrayList;
import java.util.List;

public interface  VOHospedaje 
{
	public long getId();
	
	public String getNombre();
	
	public String getDireccion();
	
	public double getValorTotal();
	
	public List<Object []>  getContratos();
	
	
}

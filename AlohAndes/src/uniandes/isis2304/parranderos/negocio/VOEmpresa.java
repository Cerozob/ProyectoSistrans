package uniandes.isis2304.parranderos.negocio;

import java.util.List;

public interface VOEmpresa {

	public Long getnIT();

	public Boolean getRegistradoCamaraDeComercio() ;

	public Boolean getRegistradoSuperintendenciaTurismo() ;

	public String getNombre() ;

	public String getWeb();

	public Long getNumeroPago() ;

	public List<Object[]> getContratos() ;

	public List<Object[]> getHoteles() ;

	public List<Object[]> getHostales() ;

	public List<Object[]> getViviendasUniversitarias();
	
}

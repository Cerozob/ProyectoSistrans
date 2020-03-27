package uniandes.isis2304.alohandes.negocio;

import java.util.Date;

public interface VOContrato {

	public Long getiDContrato();
	
	public Double getValor();

	public Date getFecha_Inicio();

	public Date getFecha_Final();

	public Long getiDHospedaje();
	
	public Long getiDCedulaCliente();

	public Long getNit_Empresa();
	
	public Long getCedulaPersonaNatural();
	
	public Date getFecha_realizada();
}

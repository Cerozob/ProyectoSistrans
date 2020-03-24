package uniandes.isis2304.alohandes.negocio;

import java.util.List;

public interface VOCliente {
	public enum TIPO_VINCULO {
		ESTUDIANTE,
		PROFESOR,
		EGRESADO,
		EMPLEADO,
		PADRE_ESTUDIANTE,
		PROFESOR_INVITADO,
		REGISTRADA_EVENTO
	}

	public Long getIdentificacion();
	
	public String getNombre();
	
	public String getApellido();
	
	public TIPO_VINCULO getVinculo();

	public Long getNumero_Pago();
	
	public List<Object []> getContratos();
}

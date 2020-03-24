package uniandes.isis2304.alohandes.negocio;

import java.util.Date;

public class Contrato implements VOContrato{
	private Long iDContrato;
	
	private Double valor;

	private Date fecha_Final;

	private Date fecha_Inicio;

	private Long iDHospedaje;

	private Long iDCedulaCliente;

	private Long nit_Empresa;

	private Long cedulaPersonaNatural;

	public Contrato()
	{
		Date d = new Date();
		
		iDContrato = 0L;
		
		valor = 0.0;

		fecha_Final = d;

		fecha_Inicio = d;

		iDHospedaje = 0L;

		iDCedulaCliente = 0L;

		nit_Empresa = 0L;

		cedulaPersonaNatural = 0L;
	}

	public Contrato(Long iDContrato, Double valor, Date fecha_Final, Date fecha_Inicio, Long iDHospedaje,
			Long iDCedulaCliente, Long nit_Empresa, Long cedulaPersonaNatural) {
		super();
		this.iDContrato = iDContrato;
		this.valor = valor;
		this.fecha_Final = fecha_Final;
		this.fecha_Inicio = fecha_Inicio;
		this.iDHospedaje = iDHospedaje;
		this.iDCedulaCliente = iDCedulaCliente;
		this.nit_Empresa = nit_Empresa;
		this.cedulaPersonaNatural = cedulaPersonaNatural;
	}

	public Long getiDContrato() {
		return iDContrato;
	}

	public void setiDContrato(Long iDContrato) {
		this.iDContrato = iDContrato;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha_Final() {
		return fecha_Final;
	}

	public void setFecha_Final(Date fecha_Final) {
		this.fecha_Final = fecha_Final;
	}

	public Date getFecha_Inicio() {
		return fecha_Inicio;
	}

	public void setFecha_Inicio(Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}

	public Long getiDHospedaje() {
		return iDHospedaje;
	}

	public void setiDHospedaje(Long iDHospedaje) {
		this.iDHospedaje = iDHospedaje;
	}

	public Long getiDCedulaCliente() {
		return iDCedulaCliente;
	}

	public void setiDCedulaCliente(Long iDCedulaCliente) {
		this.iDCedulaCliente = iDCedulaCliente;
	}

	public Long getNit_Empresa() {
		return nit_Empresa;
	}

	public void setNit_Empresa(Long nit_Empresa) {
		this.nit_Empresa = nit_Empresa;
	}

	public Long getCedulaPersonaNatural() {
		return cedulaPersonaNatural;
	}

	public void setCedulaPersonaNatural(Long cedulaPersonaNatural) {
		this.cedulaPersonaNatural = cedulaPersonaNatural;
	}
}

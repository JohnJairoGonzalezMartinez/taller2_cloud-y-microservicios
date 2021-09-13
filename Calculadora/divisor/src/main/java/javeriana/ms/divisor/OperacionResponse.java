package javeriana.ms.divisor;

import java.time.LocalDateTime;

public class OperacionResponse {

	private String resultado;
	private String solicitante;
	private String operador;
	private LocalDateTime momento;
	private String servidor;
	
	public OperacionResponse() {}
	
	public OperacionResponse(String resultado, String solicitante, String operador, LocalDateTime momento,
			String servidor) {
		super();
		this.resultado = resultado;
		this.solicitante = solicitante;
		this.operador = operador;
		this.momento = momento;
		this.servidor = servidor;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	
	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	@Override
	public String toString() {
		return "Operacion [" + operador + "] hecha por [" + solicitante + "] en [" + momento + "] con resultado: " + resultado + "\t atendido"
				+ " por [" + servidor + "]";  
	}
	
}

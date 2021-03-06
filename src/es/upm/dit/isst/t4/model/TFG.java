package es.upm.dit.isst.t4.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TFG implements Serializable {
	
	private static final long serialVersionUID=01L;
	
	@Id
	private String autor;
	private String titulo;
	private String resumen;
	private String tutor;
	private String secretario;
	private String fichero;
	private int estado;
	private String memoria;
	
	public TFG(String autor, String titulo, String resumen, String tutor,
			String secretario, String fichero, int estado) {
		this.autor = autor;
		this.titulo = titulo;
		this.resumen = resumen;
		this.tutor = tutor;
		this.secretario = secretario;
		this.fichero = fichero;
		this.estado = estado;
		this.memoria = null;
	}
}

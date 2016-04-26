package es.upm.dit.isst.t4.dao;

import java.util.List;

import es.upm.dit.isst.t4.model.TFG;

public interface TFGDAO {
	
	public TFG create(String autor, String titulo, String resumen, String tutor,
			String secretario, String fichero, int estado);
	public TFG read_alumno (String autor);
	public List<TFG> read_all();
	public List<TFG> read_tutor(String tutor);
	public List<TFG> read_secretario(String secretario);
	public List<TFG> read_estado(int estado);
    public TFG update(TFG tfg);
    public void delete(String id);

}

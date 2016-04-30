package es.upm.dit.isst.t4.dao;

import java.util.List;

import es.upm.dit.isst.t4.model.TFG;

public interface TFGDAO {
	
	public TFG create (String autor, String titulo, String resumen, String tutor, String secretario, String fichero, int estado);
	public List<TFG> readAlumno (String autor);
	public List<TFG> read ();
	public List<TFG> readTutor (String tutor);
	public List<TFG> readSecretario (String secretario);
	public List<TFG> readEstado (int estado);
	public void update (TFG TFG);
	public void delete (TFG TFG); 
}

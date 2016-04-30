package es.upm.dit.isst.t4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.t4.model.TFG;

public class TFGDAOImpl implements TFGDAO {

	private static TFGDAOImpl instance;
	
	private TFGDAOImpl() {
	}
	
	public static TFGDAOImpl getInstance() {
		if (instance == null)
			instance = new TFGDAOImpl();
		return instance;
	}
	
	@Override
	public TFG create(String autor, String titulo, String resumen,
			String tutor, String secretario, String fichero, int estado) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		TFG TFG = new TFG(autor, titulo, resumen, tutor, secretario, fichero, estado);
		em.persist(TFG);
		em.close();
		return TFG;
	}

	@Override
	public List<TFG> readAlumno(String autor) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from TFG t where t.autor = :autor");
	    q.setParameter("autor", autor);

		List<TFG> TFGs = q.getResultList();
		em.close();
		return TFGs;
	}

	@Override
	public List<TFG> read() {
		
		EntityManager em = EMFService.get().createEntityManager();
		String consulta = "select t from TFG t";
		
		Query q = em.createQuery(consulta);
		List<TFG> TFGs = q.getResultList();
		
		em.close();
		return TFGs;
	}

	@Override
	public List<TFG> readTutor(String tutor) {
		
		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from TFG t where t.tutor = :tutor");
	    q.setParameter("tutor", tutor);
		List<TFG> TFGs = q.getResultList();
		em.close();
		return TFGs;
	}
	
	@Override
	public List<TFG> readSecretario(String secretario) {

		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from TFG t where t.secretario = :secretario");
	    q.setParameter("secretario", secretario);
		List<TFG> TFGs = q.getResultList();
		em.close();
		return TFGs;
	}

	@Override
	public List<TFG> readEstado(int estado) {

		EntityManager em = EMFService.get().createEntityManager();
		
		Query q = em.createQuery("select t from TFG t where t.estado = :estado");
	    q.setParameter("estado", estado);
		List<TFG> TFGs = q.getResultList();
		em.close();
		return TFGs;
	}

	@Override
	public void update(TFG TFG) {

		EntityManager em = EMFService.get().createEntityManager();
		em.merge(TFG);
		em.close();
	}

	@Override
	public void delete(TFG TFG) {

		EntityManager em = EMFService.get().createEntityManager();
		em.remove(TFG);
		em.close();
	}

}

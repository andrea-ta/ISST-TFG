package es.upm.dit.isst.t4.dao;

import java.util.List;

import javax.persistence.*;

import es.upm.dit.isst.t4.model.TFG;

public class TFGDAOImpl implements TFGDAO {

	private static TFGDAOImpl instance; 
	private TFGDAOImpl () {
	}
	public static TFGDAOImpl getInstance() {
	if (instance == null) 
	instance  = new  TFGDAOImpl( ) ;
	return instance;  }

	@Override
	public TFG create(String autor, String titulo, String resumen,
			String tutor, String secretario, String fichero, int estado) {
		TFG tfg = null;
		EntityManager em = EMFService.get().createEntityManager();
		tfg = new TFG(autor, titulo,resumen,tutor,secretario,fichero,estado);
		em.persist(tfg);
		em.close();
		return tfg;
	}

	@Override
	public TFG read_alumno(String autor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select t from TFG t where t.autor = :autor");
		q.setParameter("autor",autor);
		TFG res = null;
		List<TFG> tfgs = q.getResultList();
		if(tfgs.size()>0)
			res = (TFG) (q.getResultList().get(0));
			em.close();
			return res;				
	}

	@Override
	public List<TFG> read_all() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q =  em.createQuery("select t from TFG t");
		List<TFG> res = q.getResultList();
		em.close();
		return res;
		
	}

	@Override
	public List<TFG> read_tutor(String tutor) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q =  em.createQuery("select t from TFG t where t.tutor = :tutor");
		q.setParameter("tutor",tutor);
		List<TFG> res = q.getResultList();
		em.close();
		return res;
	}

	@Override
	public List<TFG> read_secretario(String secretario) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q =  em.createQuery("select t from TFG t where  t.secretario = :secretario");
		q.setParameter("secretario",secretario);
		List<TFG> res = q.getResultList();
		em.close();
		return res;
	}

	@Override
	public List<TFG> read_estado(int estado) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q =  em.createQuery("select t from TFG t where t.estado = :estado");
		q.setParameter("estado",estado);
		List<TFG> res = q.getResultList();
		em.close();
		return res;
	}

	@Override
	public TFG update(TFG tfg) {
		EntityManager em = EMFService.get().createEntityManager();
			TFG actualiza = em.merge(tfg);
			em.close();
			return actualiza;

	}

	@Override
	public void delete(String id) {
		EntityManager em = EMFService.get().createEntityManager();
		try{
			TFG borra = em.find(TFG.class, id);
					em.remove(borra);
		} finally {
			em.close();
		}

	}

}

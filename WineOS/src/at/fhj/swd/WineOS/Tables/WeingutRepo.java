package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class WeingutRepo {

	private EntityManager em;

	/*
	 * Constructor
	 */
	public WeingutRepo(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * CRUD methods
	 */
	public Weingut insert(Weingut entity) {
		em.persist(entity);
		return entity;
	}

	public Weingut update(Weingut entity) {
		return em.merge(entity);
	}

	public void delete(Weingut entity) {
		em.remove(entity);
	}

	public Weingut findById(int id) {
		return em.find(Weingut.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Weingut> findAll() {
		final String hql = "SELECT u FROM " + Weingut.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Weingut createWeingut(int id, String adresse, String ort, int plz) {
		Weingut wg = new Weingut(id, adresse, ort, plz);
		insert(wg);
		return wg;
	}
}

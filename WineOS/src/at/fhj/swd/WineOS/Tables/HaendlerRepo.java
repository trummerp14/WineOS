package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class HaendlerRepo {

	private EntityManager em;

	/*
	 * Constructor
	 */
	public HaendlerRepo(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * CRUD methods
	 */
	public Haendler insert(Haendler entity) {
		em.persist(entity);
		return entity;
	}

	public Haendler update(Haendler entity) {
		return em.merge(entity);
	}

	public void delete(Haendler entity) {
		em.remove(entity);
	}

	public Haendler findById(int id) {
		return em.find(Haendler.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Haendler> findAll() {
		final String hql = "SELECT u FROM " + Haendler.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Haendler createHaendler(int id, String name, String adresse, String ort, int plz) {
		Haendler h = new Haendler(id, name, adresse, ort, plz);
		insert(h);
		return h;
	}
}

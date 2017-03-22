package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class HaendlerRepo {

	private EntityManagerSingelton em;

	/*
	 * Constructor
	 */
	public HaendlerRepo() {
		em = new EntityManagerSingelton();
	}

	public EntityManager getEntityManager() {
		return em.getInstance();
	}

	/*
	 * CRUD methods
	 */
	public Haendler insert(Haendler entity) {
		em.getInstance().persist(entity);
		return entity;
	}

	public Haendler update(Haendler entity) {
		return em.getInstance().merge(entity);
	}

	public void delete(Haendler entity) {
		em.getInstance().remove(entity);
	}

	public Haendler findById(int id) {
		return em.getInstance().find(Haendler.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Haendler> findAll() {
		final String hql = "SELECT u FROM " + Haendler.class.getName() + " AS u";
		return em.getInstance().createQuery(hql).getResultList();
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

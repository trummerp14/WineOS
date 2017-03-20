package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class ChargeRepo {

	private EntityManager em;

	/*
	 * Constructor
	 */
	public ChargeRepo(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * CRUD methods
	 */
	public Charge insert(Charge entity) {
		em.persist(entity);
		return entity;
	}

	public Charge update(Charge entity) {
		return em.merge(entity);
	}

	public void delete(Charge entity) {
		em.remove(entity);
	}

	public Charge findById(int id) {
		return em.find(Charge.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Charge> findAll() {
		final String hql = "SELECT u FROM " + Charge.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Charge createCharge(int id, String bezeichnung, Weingut weingut) {
		Charge c = new Charge(id, bezeichnung, weingut);
		insert(c);
		return c;
	}
}

package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class ChargeRepo {

	private EntityManagerSingelton em;

	/*
	 * Constructor
	 */
	public ChargeRepo() {
		em = new EntityManagerSingelton();
	}

	public EntityManager getEntityManager() {
		return em.getInstance();
	}

	/*
	 * CRUD methods
	 */
	public Charge insert(Charge entity) {
		em.getInstance().persist(entity);
		return entity;
	}

	public Charge update(Charge entity) {
		return em.getInstance().merge(entity);
	}

	public void delete(Charge entity) {
		em.getInstance().remove(entity);
	}

	public Charge findById(int id) {
		return em.getInstance().find(Charge.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Charge> findAll() {
		final String hql = "SELECT u FROM " + Charge.class.getName() + " AS u";
		return em.getInstance().createQuery(hql).getResultList();
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

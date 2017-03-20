package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class FlascheRepo {

	private EntityManager em;

	/*
	 * Constructor
	 */
	public FlascheRepo(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * CRUD methods
	 */
	public Flasche insert(Flasche entity) {
		em.persist(entity);
		return entity;
	}

	public Flasche update(Flasche entity) {
		return em.merge(entity);
	}

	public void delete(Flasche entity) {
		em.remove(entity);
	}

	public Flasche findById(int id) {
		return em.find(Flasche.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Flasche> findAll() {
		final String hql = "SELECT u FROM " + Flasche.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Flasche createFlasche(int Id, String Bezeichnung, double Fuellmenge, String Auspraegung, int Stueck, Charge charge) {
		Flasche f = new Flasche(Id, Bezeichnung, Fuellmenge, Auspraegung, Stueck, charge);
		insert(f);
		return f;
	}
}

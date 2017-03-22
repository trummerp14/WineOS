package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class FlascheRepo {

	private EntityManagerSingelton em;

	/*
	 * Constructor
	 */
	public FlascheRepo() {
		em = new EntityManagerSingelton();
	}

	public EntityManager getEntityManager() {
		return em.getInstance();
	}

	/*
	 * CRUD methods
	 */
	public Flasche insert(Flasche entity) {
		em.getInstance().persist(entity);
		return entity;
	}

	public Flasche update(Flasche entity) {
		return em.getInstance().merge(entity);
	}

	public void delete(Flasche entity) {
		em.getInstance().remove(entity);
	}

	public Flasche findById(int id) {
		return em.getInstance().find(Flasche.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Flasche> findAll() {
		final String hql = "SELECT u FROM " + Flasche.class.getName() + " AS u";
		return em.getInstance().createQuery(hql).getResultList();
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

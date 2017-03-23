package at.fhj.swd.WineOS.Tables;

import java.util.List;
import javax.persistence.EntityManager;

public class WeingutRepo {

	private EntityManagerSingelton em;
	
	/*
	 * Constructor
	 */
	public WeingutRepo() {
		em = new EntityManagerSingelton();
	}

	public EntityManager getEntityManager() {
		return em.getInstance();
	}

	/*
	 * CRUD methods
	 */
	public Weingut insert(Weingut entity) {
		em.getInstance().persist(entity);
		return entity;
	}

	public Weingut update(Weingut entity) {
		return em.getInstance().merge(entity);
	}

	public void delete(Weingut entity) {
		em.getInstance().remove(entity);
	}

	public Weingut findById(int id) {
		return em.getInstance().find(Weingut.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Weingut> findAll() {
		final String hql = "SELECT u FROM " + Weingut.class.getName() + " AS u";
		return em.getInstance().createQuery(hql).getResultList();
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
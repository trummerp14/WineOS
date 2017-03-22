package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class FertigungsanlageRepo {

	private EntityManagerSingelton em;
	
	/*
	 * Constructor
	 */
	public FertigungsanlageRepo() {
		em = new EntityManagerSingelton();
	}

	public EntityManager getEntityManager() {
		return em.getInstance();
	}

	/*
	 * CRUD methods
	 */
	public Fertigungsanlage insert(Fertigungsanlage entity) {
		em.getInstance().persist(entity);
		return entity;
	}

	public Fertigungsanlage update(Fertigungsanlage entity) {
		return em.getInstance().merge(entity);
	}

	public void delete(Fertigungsanlage entity) {
		em.getInstance().remove(entity);
	}

	public Charge findById(int id) {
		return em.getInstance().find(Charge.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Fertigungsanlage> findAll() {
		final String hql = "SELECT u FROM " + Fertigungsanlage.class.getName() + " AS u";
		return em.getInstance().createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Fertigungsanlage createFertigungsanlage(int id, String bezeichnung, int volumen, Weingut weingut) {
		Fertigungsanlage f = new Fertigungsanlage(id, bezeichnung, volumen, weingut);
		insert(f);
		return f;
	}
}

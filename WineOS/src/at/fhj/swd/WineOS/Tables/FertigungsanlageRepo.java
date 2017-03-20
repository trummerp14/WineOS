package at.fhj.swd.WineOS.Tables;

import java.util.List;

import javax.persistence.EntityManager;

public class FertigungsanlageRepo {

	private EntityManager em;

	/*
	 * Constructor
	 */
	public FertigungsanlageRepo(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}

	/*
	 * CRUD methods
	 */
	public Fertigungsanlage insert(Fertigungsanlage entity) {
		em.persist(entity);
		return entity;
	}

	public Fertigungsanlage update(Fertigungsanlage entity) {
		return em.merge(entity);
	}

	public void delete(Fertigungsanlage entity) {
		em.remove(entity);
	}

	public Charge findById(int id) {
		return em.find(Charge.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Fertigungsanlage> findAll() {
		final String hql = "SELECT u FROM " + Fertigungsanlage.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	/*
	 * Factory methods
	 */
	public Fertigungsanlage createFertigungsanlage(int id, String bezeichnung, int volumen) {
		Fertigungsanlage f = new Fertigungsanlage(id, bezeichnung, volumen);
		insert(f);
		return f;
	}
}

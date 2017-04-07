package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
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
	
	public List<Weingut> findWithAdresse(String adresse) {
	    return em.getInstance().createQuery(
	        "SELECT w FROM Weingut w WHERE w.adresse LIKE :wAdresse", Weingut.class)
	        .setParameter("wAdresse", adresse)
	        .getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	public List findChargeFlaschen() {
	    return em.getInstance().createNamedQuery("ChargeFlaschen")
	        .getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Charge> findCharge(String bez) {
	    return em.getInstance().createNamedQuery("findCharge")
	    		.setParameter("wBez", bez)
	    		.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Haendler> findHaendlerFromWeingut(int weingut){
		List<Haendler> list =  em.getInstance().createNamedQuery("findHaendler").setParameter("id", weingut).getResultList();
		List<Haendler> res = new ArrayList<Haendler>();
		for(Haendler h : list){
			if(!res.contains(h)){
				res.add(h);
			}
		}
		return res;
	}
}

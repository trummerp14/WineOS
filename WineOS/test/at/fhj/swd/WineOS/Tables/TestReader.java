package at.fhj.swd.WineOS.Tables;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestReader {

	static final String persistenceUnitName = "WINE_OS";
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction tx;
	
	static Weingut w;
	
	public static void open(String user, String password) {
		Map<String, String> props = new HashMap<String, String>();
		props.put("javax.persistence.jdbc.user", user);
		props.put("javax.persistence.jdbc.password", password);
		emf = Persistence.createEntityManagerFactory(persistenceUnitName, props);
		em = emf.createEntityManager();
	}
	
	@Test(expected = RollbackException.class)
	public void testInsert(){
		open("reader", "reader");
		tx = em.getTransaction();
		tx.begin();
		w = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
		Assert.assertNotNull(w);
		em.persist(w);
		tx.commit();
	}
	
	@Test
	public void testSelect(){
		//setup
		open("chofer", "wineos");
		tx = em.getTransaction();
		tx.begin();
		w = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
		Assert.assertNotNull(w);
		em.persist(w);
		tx.commit();
		
		//exercise
		open("reader", "reader");
		tx = em.getTransaction();
		tx.begin();
		Weingut w = em.find(Weingut.class, 1);
		Assert.assertNotNull(w);
		tx.commit();
	}
	
	@Test(expected = RollbackException.class)
	public void testUpdate(){
		//setup
		testInsert();
		
		open("reader", "reader");
		tx = em.getTransaction();
		tx.begin();
		Weingut verify = em.find(Weingut.class, 1);
		Assert.assertNotNull(verify);
		verify.setAdresse("changed");
		em.merge(verify);
		tx.commit();
	}
	
	@Test(expected = RollbackException.class)
	public void testDelete(){
		//setup
		testInsert();
		
		open("reader", "reader");
		tx = em.getTransaction();
		tx.begin();
		Weingut verify = em.find(Weingut.class, 1);
		Assert.assertNotNull(verify);
		em.remove(verify);
		tx.commit();
	}
	
	@After
	public void teardown(){
		open("chofer", "wineos");
		tx = em.getTransaction();
		tx.begin();
		Weingut w = em.find(Weingut.class, 1);
		if(w != null)
			em.remove(w);
		tx.commit();
	}
}

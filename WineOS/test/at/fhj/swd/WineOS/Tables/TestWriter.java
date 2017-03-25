package at.fhj.swd.WineOS.Tables;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TestWriter {

	static final String persistenceUnitName = "WINE_OS";
	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction tx;
	
	static Weingut w;
	
	public static EntityManager open(String user, String password) {
		Map<String, String> props = new HashMap<String, String>();
		props.put("javax.persistence.jdbc.user", user);
		props.put("javax.persistence.jdbc.password", password);
		emf = Persistence.createEntityManagerFactory(persistenceUnitName, props);
		em = emf.createEntityManager();
		return em;
	}
	
	@Before
	public void setup(){
		EntityManager em = open("writer", "writer");
		tx = em.getTransaction();
		w = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
	}
	
	@Test
	public void testWriter(){
		tx.begin();
		em.persist(w);
		tx.commit();
		
		tx.begin();
		Weingut verify = em.find(Weingut.class, 1);
		tx.commit();
		
		tx.begin();
		verify.setOrt("blablabla");
		em.merge(verify);
		tx.commit();
	}
	
	
	@After
	public void teardown(){
		tx.begin();
		Weingut w = em.find(Weingut.class, 1);
		Assert.assertNotNull(w);
		em.remove(w);
		tx.commit();
	}

}

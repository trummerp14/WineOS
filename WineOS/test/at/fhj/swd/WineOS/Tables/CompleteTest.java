package at.fhj.swd.WineOS.Tables;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompleteTest {

	Weingut weingut;
	Charge charge;
	Flasche flasche;
	Haendler h‰ndler;
	
	static final String persistenceUnitName = "WineOS";
	static EntityManagerFactory factory;
	static EntityManager manager;
	static EntityTransaction transaction;
	
	@Before
	public void setup(){
		weingut = new Weingut(1, "Teststraﬂe", "Testdorf", 5654);
		charge = new Charge(1, "Charge1", weingut);
		flasche = new Flasche(1,"Burgunder", 0.75, "Kork", 5, charge);
		h‰ndler = new Haendler(1, "Bundesstraﬂe 17", "Hofer KG", "Lorenzen", 6584);
		h‰ndler.addFlaschen(flasche);
		 
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		assertNotNull (factory);
		manager = factory.createEntityManager();
		assertNotNull (manager);
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(weingut);
		manager.persist(h‰ndler);
		manager.persist(charge);
		manager.persist(flasche);
		transaction.commit();
		manager.clear();
	}
	
	@Test
	public void testPersist(){
		Assert.assertEquals(weingut.getAdresse(), manager.find(Weingut.class, 1).getAdresse());
		Assert.assertEquals(charge, manager.find(Charge.class, 1));
		Assert.assertEquals(flasche, manager.find(Flasche.class, 1));
		Assert.assertEquals(h‰ndler, manager.find(Haendler.class, 1));
	}
	
	@After
	public void teardown(){
		transaction = manager.getTransaction();
		transaction.begin();
		manager.createNativeQuery("DELETE FROM dbo.Weingut Where id = " + weingut.getId()).executeUpdate();
		manager.createNativeQuery("DELETE FROM dbo.Haendler_Flaschen Where  FK_Flasche = 1").executeUpdate();
		manager.createNativeQuery("DELETE FROM dbo.Haendler Where id = " + h‰ndler.getID()).executeUpdate();
		manager.createNativeQuery("DELETE FROM dbo.Flasche_Haendler Where Flasche_ID = 1").executeUpdate();
		manager.createNativeQuery("DELETE FROM dbo.Flasche Where id = " + flasche.getID()).executeUpdate();
		manager.createNativeQuery("DELETE FROM dbo.charge Where id = " + charge.getId()).executeUpdate();
		transaction.commit();
		manager.close();
	}
	
}

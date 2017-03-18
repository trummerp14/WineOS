package at.fhj.swd.WineOS.Tables;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class AbstractTest {

	static final String persistenceUnitName = "WINE_OS";
	static EntityManagerFactory factory;
	static EntityManager manager;
	static EntityTransaction transaction;
	
	Weingut weingut;
	Charge charge;
	Flasche flasche;
	Haendler händler;
	
	@BeforeClass public static void setup() 
	 {
		 factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		 assertNotNull (factory);
		 manager = factory.createEntityManager();
		 assertNotNull (manager);
		 transaction = manager.getTransaction();
		 transaction.begin();
	 }
	 
	 @AfterClass public static void teardown() 
	 {
		 transaction.rollback();
		 if (manager == null) return;
		 manager.close();
		 factory.close();
	 }
	
}

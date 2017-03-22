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

	static Weingut weingut;
	static Charge charge;
	static Flasche flasche;
	static Haendler h‰ndler;
	static Fertigungsanlage anlage;

	@BeforeClass
	public static void setup() {
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		assertNotNull(factory);
		manager = factory.createEntityManager();
		assertNotNull(manager);
		transaction = manager.getTransaction();
		
	}

	@AfterClass
	public static void teardown() {
		if (manager == null) return;
		manager.close();
		factory.close();
	}
	
	public static void createWeingut() {
		weingut = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
	}

	public static void createHaendler() {
		h‰ndler = new Haendler(1, "Super AG", "Testroad1", "teststadt", 5642);
	}

	public static void createFlasche() {
		flasche = new Flasche(1, "Veltliner", 0.75, "kork", charge);
	}

	public static void createCharge() {
		charge = new Charge(1, "Charge1", weingut);
	}

	public static void createAnlage() {
		anlage = new Fertigungsanlage(1, "Anlage1", 2500, weingut);
	}
}

package Tests;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Tables.Charge;

	//@org.junit.FixMethodOrder( org.junit.runners.MethodSorters.NAME_ASCENDING)
public class Test_Charge 
{
	 static EntityManagerFactory factory;
	 static EntityManager manager;
	 static EntityTransaction transaction;
	 static final String persistenceUnitName = "WineOS";
	 static final int id = 158;
	 static final String Bezeichnung = "Charge_1";
	 static final String Bezeichnung_update = "Charge_1_update";
	 
	 
	 @BeforeClass public static void setup() 
	 {
		 factory = Persistence.createEntityManagerFactory( persistenceUnitName );
		 assertNotNull (factory);
		 manager = factory.createEntityManager();
		 assertNotNull (manager);
		 transaction = manager.getTransaction();
	 }
	 
	 @AfterClass public static void teardown() 
	 {
		 if (manager == null) return;
		 manager.close();
		 factory.close();
	 }
	 
	 @Test public void create () 
	 {
		 transaction.begin ();
		 Charge Charge_1 = new Charge (id, Bezeichnung);
		 assertNotNull (Charge_1);
		 manager.persist (Charge_1);
		 transaction.commit();
	 }
	 
	 @Test public void modify () 
	 {
		 Charge Charge_1 = manager.find (Charge.class, id);
		 assertNotNull (Charge_1);
		 transaction.begin ();
		 Charge_1.setBezeichnung("Charge_1_update");
		 transaction.commit();
		 teardown ();
		 setup ();
		 Charge_1 = manager.find (Charge.class, id);
		 assertEquals (Bezeichnung_update, Charge_1.getBezeichnung());
	 }
	 
	 @Test public void remove () 
	 {
		 Charge Charge_1 = manager.find (Charge.class, id);
		 assertNotNull (Charge_1);
		 transaction.begin ();
		 manager.remove ( Charge_1 );
		 transaction.commit();
		 Charge_1 = manager.find(Charge.class, id);
		 assertNull (Charge_1);
	 }
}

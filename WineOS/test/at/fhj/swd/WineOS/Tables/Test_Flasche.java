package at.fhj.swd.WineOS.Tables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Flasche 
{
	static EntityManagerFactory factory;
	 static EntityManager manager;
	 static EntityTransaction transaction;
	 static final String persistenceUnitName = "WineOS";
	 static final int id = 11;
	 static final String Bezeichnung = "Flasche_1";
	 static final String Bezeichnung_update = "Flasche1_Update";
	 static final double Fuellmenge = 0.75;
	 static final String Auspraegung = "normal";
	 static final int FK_Charge = 1;
	 static final int Stueck = 2;
	 
	 
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
		 Flasche Flasche_1 = new Flasche (id, Bezeichnung, Fuellmenge, Auspraegung, FK_Charge, 3, null);
		 assertNotNull (Flasche_1);
		 manager.persist (Flasche_1);
		 transaction.commit();
	 }
	 
	 @Test public void modify () 
	 {
		 Flasche Flasche_1 = manager.find (Flasche.class, id);
		 assertNotNull (Flasche_1);
		 transaction.begin ();
		 Flasche_1.setBezeichnung("Flasche_1_update");
		 transaction.commit();
		 teardown ();
		 setup ();
		 Flasche_1 = manager.find (Flasche.class, id);
		 assertEquals (Bezeichnung_update, Flasche_1.getBezeichnung());
	 }
	 
	 @Test public void remove () 
	 {
		 Flasche Flasche_1 = manager.find (Flasche.class, id);
		 assertNotNull (Flasche_1);
		 transaction.begin ();
		 manager.remove ( Flasche_1 );
		 transaction.commit();
		 Flasche_1 = manager.find(Flasche.class, id);
		 assertNull (Flasche_1);
	 }
}

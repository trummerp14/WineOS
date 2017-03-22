package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestHaendler extends AbstractTest {

	@Test
	public void create() {
		transaction.begin();
		createHaendler();
		Assert.assertNotNull(h�ndler);
		manager.persist(h�ndler);
		transaction.commit();
	}
	
	@Test
	public void modify() {
		Haendler h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(h�ndler1);
		transaction.begin();
		h�ndler1.setAdresse("Road 66");
		transaction.commit();
		
		teardown();
		setup();
		
		h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertEquals("Road 66", h�ndler1.getAdresse());
		Assert.assertTrue(h�ndler.equals(h�ndler1));
	}
	
	@Test
	public void remove(){
		Haendler h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(h�ndler1);
		transaction.begin();
		manager.remove(h�ndler1);
		transaction.commit();
		
		h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNull(h�ndler1);
	}
	
	@Test
	public void testGetters(){
		createHaendler();
		createWeingut();
		createCharge();
		createFlasche();
		h�ndler.addFlasche(flasche);
		
		//h�ndler = new Haendler(1, "Super AG", "Testroad1", "teststadt", 5642);
		Assert.assertEquals(1, h�ndler.getId());
		Assert.assertEquals("Super AG", h�ndler.getName());
		Assert.assertEquals("Testroad1", h�ndler.getAdresse());
		Assert.assertEquals("teststadt", h�ndler.getOrt());
		Assert.assertEquals(5642, h�ndler.getPlz());
		
		ArrayList<Flasche> flaschen = (ArrayList<Flasche>)h�ndler.getFlaschen();
		Assert.assertTrue(flasche.equals(flaschen.get(0)));
	}
}

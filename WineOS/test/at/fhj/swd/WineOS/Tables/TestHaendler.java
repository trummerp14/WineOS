package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestHaendler extends AbstractTest {

	@Test
	public void create() {
		transaction.begin();
		createHaendler();
		Assert.assertNotNull(händler);
		manager.persist(händler);
		transaction.commit();
	}
	
	@Test
	public void modify() {
		Haendler händler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(händler1);
		transaction.begin();
		händler1.setAdresse("Road 66");
		transaction.commit();
		
		teardown();
		setup();
		
		händler1 = manager.find(Haendler.class, 1);
		Assert.assertEquals("Road 66", händler1.getAdresse());
		Assert.assertTrue(händler.equals(händler1));
	}
	
	@Test
	public void remove(){
		Haendler händler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(händler1);
		transaction.begin();
		manager.remove(händler1);
		transaction.commit();
		
		händler1 = manager.find(Haendler.class, 1);
		Assert.assertNull(händler1);
	}
	
	@Test
	public void testGetters(){
		createHaendler();
		createWeingut();
		createCharge();
		createFlasche();
		händler.addFlasche(flasche);
		
		//händler = new Haendler(1, "Super AG", "Testroad1", "teststadt", 5642);
		Assert.assertEquals(1, händler.getId());
		Assert.assertEquals("Super AG", händler.getName());
		Assert.assertEquals("Testroad1", händler.getAdresse());
		Assert.assertEquals("teststadt", händler.getOrt());
		Assert.assertEquals(5642, händler.getPlz());
		
		ArrayList<Flasche> flaschen = (ArrayList<Flasche>)händler.getFlaschen();
		Assert.assertTrue(flasche.equals(flaschen.get(0)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void customAssert1(){
		new Haendler(0, "Test", "test", "test", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert2(){
		new Haendler(1, " ", "test", "test", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert3(){
		new Haendler(1, null, "test", "test", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert4(){
		new Haendler(1, "Test", " ", "test", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert5(){
		new Haendler(1, "Test", null, "test", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert6(){
		new Haendler(1, "Test", "Test", " ", 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert7(){
		new Haendler(1, "Test", "Test", null, 6500);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert8(){
		new Haendler(1, "Test", "Test", "Test", 999);
	}
}

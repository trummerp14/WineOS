package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestFlasche extends AbstractTest {

	@Test
	public void create() {
		transaction.begin();
		createWeingut();
		Assert.assertNotNull(weingut);
		manager.persist(weingut);
		createCharge();
		Assert.assertNotNull(charge);
		manager.persist(charge);
		createFlasche();
		Assert.assertNotNull(flasche);
		manager.persist(flasche);
		transaction.commit();
	}

	@Test
	public void modify() {
		Flasche flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNotNull(flasche1);
		transaction.begin();
		flasche1.setBezeichnung("Weiﬂburgunder");
		transaction.commit();

		teardown();
		setup();

		flasche1 = manager.find(Flasche.class, 1);
		Assert.assertEquals("Weiﬂburgunder", flasche1.getBezeichnung());
		Assert.assertTrue(charge.equals(flasche1.getCharge()));
		Assert.assertTrue(weingut.equals(flasche1.getCharge().getWeingut()));
	}

	@Test
	public void remove() {
		Weingut weingut1 = manager.find(Weingut.class, 1);
		Charge charge1 = manager.find(Charge.class, 1);
		Flasche flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNotNull(flasche1);
		transaction.begin();
		manager.remove(weingut1);
		manager.remove(charge1);
		manager.remove(flasche1);
		transaction.commit();

		flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNull(flasche1);
	}
	
	
	@Test
	public void testGetters(){
		createWeingut();
		createCharge();
		createFlasche();
		createHaendler();
		h‰ndler.addFlasche(flasche);
		
		//	flasche = new Flasche(1, "Veltliner", 0.75, "kork", charge);
		
		Assert.assertEquals(1, flasche.getId());
		Assert.assertEquals("Veltliner", flasche.getBezeichnung());
		Assert.assertEquals(0.75, flasche.getFuellmenge(), 0.001);
		Assert.assertEquals("kork", flasche.getAuspraegung());
		Assert.assertTrue(charge.equals(flasche.getCharge()));
		Assert.assertTrue(h‰ndler.equals(((ArrayList<Haendler>)flasche.getHaendler()).get(0)));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void customAssert1(){
		new Flasche(0, "Test", 0.75, 1, "Kork", new Charge());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void customAssert2(){
		new Flasche(1, "", 0.75, 1, "Kork", new Charge());
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert3(){
		new Flasche(1, null, 0.75, 1, "Kork", new Charge());
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert4(){
		new Flasche(1, "Test", 0, 1, "Kork", new Charge());
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert5(){
		new Flasche(1, "Test", 0.75, 1, " ", new Charge());
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert6(){
		new Flasche(1, "Test", 0.75, 1, null, new Charge());
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert7(){
		new Flasche(1, "Test", 0.75, 1, "Kork", null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void customAssert8(){
		Flasche f = new Flasche(1, "Test", 0.75, 1, "Kork", new Charge());
		f.addHaendler(null);
	}
	@Test
	public void customAssert9(){
		Flasche f1 = new Flasche(1, "Test", 0.75, 1, "Kork", new Charge());
		Flasche f2 = new Flasche(1, "hallo", 1,  1, "Kronkorken", new Charge());
		Assert.assertTrue(f1.equals(f2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

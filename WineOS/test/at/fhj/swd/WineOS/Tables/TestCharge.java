package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestCharge extends AbstractTest {

	/*
	 * new Charge(1, "Charge1", weingut); new Weingut(1, "Teststra�e 1",
	 * "Testdorf", 8600);
	 * 
	 */

	@Test
	public void create() {
		transaction.begin();
		createWeingut();
		manager.persist(weingut);
		createCharge();
		Assert.assertNotNull(charge);
		manager.persist(charge);
		transaction.commit();
	}

	@Test
	public void modify() {
		Charge charge1 = manager.find(Charge.class, 1);
		Assert.assertNotNull(charge1);
		transaction.begin();
		charge1.setBezeichnung("Charge of good wine");
		transaction.commit();

		teardown();
		setup();

		charge1 = manager.find(Charge.class, 1);
		Assert.assertEquals("Charge of good wine", charge1.getBezeichnung());
		Assert.assertTrue(weingut.equals(charge1.getWeingut()));
	}

	@Test
	public void remove() {
		Weingut weingut1 = manager.find(Weingut.class, 1);
		Charge charge1 = manager.find(Charge.class, 1);
		Assert.assertNotNull(charge1);
		transaction.begin();
		manager.remove(weingut1);
		manager.remove(charge1);
		transaction.commit();

		charge1 = manager.find(Charge.class, 1);
		Assert.assertNull(charge1);
	}

	@Test
	public void testGetters() {
		createWeingut();
		Charge charge1 = new Charge(2017099, "Wei�burgunder", weingut);
		Assert.assertEquals(2017099, charge1.getId());
		Assert.assertEquals("Wei�burgunder", charge1.getBezeichnung());
		Assert.assertEquals(weingut.getAdresse(), charge1.getWeingut().getAdresse());
		
		charge1.addFlasche(new Flasche(2, "Wei�burgunder", 0.75, "Kork", 1, new Charge()));
		Assert.assertEquals(2, (charge1.getFlaschen().get(0).getId()));
	}

	@Test
	public void customAssert1() {
		createWeingut();
		try {
			new Charge(0, "Wei�burgunder", weingut);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void customAssert2() {
		createWeingut();
		try {
			new Charge(1, null, weingut);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void customAssert3() {
		createWeingut();
		try {
			new Charge(1, "Wei�burgunder", null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void customAssert4() {
		createWeingut();
		Charge charge1 = new Charge(1, "Wei�burgunder", weingut);
		try {
			charge1.addFlasche(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}

}

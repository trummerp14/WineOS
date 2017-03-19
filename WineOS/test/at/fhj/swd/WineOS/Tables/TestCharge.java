package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestCharge extends AbstractTest {

	/*
	 * new Charge(1, "Charge1", weingut);
	 * new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
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
	}
	
	@Test
	public void remove(){
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
}

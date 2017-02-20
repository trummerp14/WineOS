package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCharge extends AbstractTest {

	@Before
	public void before(){
		createWeingut();
	}
	
	@Test
	public void testConstructor(){
		createCharge();
	}
	
	@Test
	public void testId(){
		createCharge();
		Assert.assertEquals(1, charge.getId());
		Assert.assertEquals("Charge1", charge.getBezeichnung());
		weingut.setCharge(charge);
		Assert.assertEquals(weingut, charge.getWeingut());
	}
	
	@Test 
	public void create () {
		createCharge();
		 Assert.assertNotNull (charge);
		 manager.persist (charge);
	 }
	
	private void createWeingut() {
		weingut = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
		manager.persist(weingut);
	}
	
	private void createCharge(){
		charge = new Charge(1, "Charge1", weingut);
	}
}

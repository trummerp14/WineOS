package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestWeingut extends AbstractTest{

	@Test
	public void testConstructor(){
		createWeingut();
	}
	
	@Test
	public void testId(){
		createWeingut();
		Assert.assertEquals(1, weingut.getId());
		Assert.assertEquals("Teststraﬂe 1", weingut.getAdresse());
		Assert.assertEquals("Testdorf", weingut.getOrt());
		Assert.assertEquals(8600, weingut.getPlz());
	}
	
	@Test 
	public void create () {
		createWeingut();
		Assert.assertNotNull (weingut);
		manager.persist (weingut);
	}
	 

	private void createWeingut() {
		weingut = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
		charge = new Charge(1, "Charge1", weingut);
		manager.persist(charge);
		weingut.addCharge(charge);
	}
	 
}

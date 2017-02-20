package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestFlasche extends AbstractTest {

	@Test
	public void testConstructor(){
		createCharge();
		createFlasche();
	}

	public void testFlasche(){
		createCharge();
		createFlasche();
		Assert.assertEquals("Veltliner", flasche.getBezeichnung());
		Assert.assertEquals(1, flasche.getID());
		Assert.assertEquals(charge, flasche.getCharge());
		Assert.assertEquals(h‰ndler, flasche.getHaendler());
	}
	
	public void create(){
		createCharge();
		createFlasche();
		Assert.assertNotNull (flasche);
		manager.persist(flasche);
	}
	
	private void createFlasche() {
		flasche = new Flasche(1,"Veltliner", 0.75, "kork", 1, charge);
	}
	
	private void createWeingut(){
		weingut = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
	}
	
	private void createCharge() {
		createWeingut();
		charge = new Charge(1, "Charge1", weingut);
		manager.persist(charge);
	}
	
}

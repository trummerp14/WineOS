package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;


public class TestHaendler extends AbstractTest{

	@Test
	public void testConstructor(){
		createHaendler();
	}
	
	@Test
	public void testH‰ndler(){
		createHaendler();
		createFlasche();
		h‰ndler.addFlaschen(flasche);
		Assert.assertEquals(1, h‰ndler.getID());
		Assert.assertEquals("Super AG", h‰ndler.getName());
		Assert.assertEquals("Testroad1", h‰ndler.getAdresse());
		Assert.assertEquals("teststadt", h‰ndler.getOrt());
		Assert.assertEquals(5642, h‰ndler.getPlz());
		Assert.assertEquals(1,h‰ndler.getFlaschen().size());
		Assert.assertTrue(h‰ndler.getFlaschen().contains(flasche));
	}

	@Test
	public void create(){
		createHaendler();
		createFlasche();
		Assert.assertNotNull (h‰ndler);
		manager.persist(h‰ndler);
	}
	
	private void createHaendler() {
		h‰ndler = new Haendler(1,"Super AG", "Testroad1", "teststadt", 5642);
	}

	private void createFlasche() {
		weingut = new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);
		manager.persist(weingut);
		charge = new Charge(1, "Charge1", weingut);
		manager.persist(charge);
		flasche = new Flasche(1,"Veltliner", 0.75, "kork", 1, charge);
		manager.persist(flasche);
	}
}

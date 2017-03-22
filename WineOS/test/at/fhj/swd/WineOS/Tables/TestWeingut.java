package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestWeingut extends AbstractTest {

	@Test
	public void testConstructor() {
		createWeingut();
		Assert.assertEquals(1, weingut.getId());
		Assert.assertEquals("Teststraﬂe 1", weingut.getAdresse());
		Assert.assertEquals("Testdorf", weingut.getOrt());
		Assert.assertEquals(8600, weingut.getPlz());
	}

	@Test
	public void create() {
		transaction.begin();
		createWeingut();
		Assert.assertNotNull(weingut);
		manager.persist(weingut);
		transaction.commit();
	}
	
	@Test
	public void modify() {
		Weingut weingut1 = manager.find(Weingut.class, 1);
		Assert.assertNotNull(weingut1);
		transaction.begin();
		weingut1.setAdresse("Road to Hell");
		transaction.commit();
		
		teardown();
		setup();
		
		weingut1 = manager.find(Weingut.class, 1);
		Assert.assertEquals("Road to Hell", weingut1.getAdresse());
		Assert.assertTrue(weingut.equals(weingut1));
	}
	
	@Test
	public void remove(){
		Weingut weingut = manager.find(Weingut.class, 1);
		Assert.assertNotNull(weingut);
		transaction.begin();
		manager.remove(weingut);
		transaction.commit();
		
		weingut = manager.find(Weingut.class, 1);
		Assert.assertNull(weingut);
	}
	
}

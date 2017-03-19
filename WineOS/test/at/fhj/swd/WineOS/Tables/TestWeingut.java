package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestWeingut extends AbstractTest {

	@Test
	public void testConstructor() {
		createWeingut();
	}

	@Test
	public void testId() {
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
		Weingut weingut = manager.find(Weingut.class, 1);
		Assert.assertNotNull(weingut);
		transaction.begin();
		weingut.setAdresse("Road to Hell");
		createAnlage();
		manager.persist(anlage);
		weingut.setAnlage(anlage);
		transaction.commit();
		
		teardown();
		setup();
		
		weingut = manager.find(Weingut.class, 1);
		Assert.assertEquals("Road to Hell", weingut.getAdresse());
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

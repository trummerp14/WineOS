package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestHaendler extends AbstractTest {

	@Test
	public void testConstructor() {
		createHaendler();
	}

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
}

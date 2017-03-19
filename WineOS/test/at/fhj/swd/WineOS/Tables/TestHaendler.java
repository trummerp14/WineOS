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
		Assert.assertNotNull(h�ndler);
		manager.persist(h�ndler);
		transaction.commit();
	}
	
	@Test
	public void modify() {
		Haendler h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(h�ndler1);
		transaction.begin();
		h�ndler1.setAdresse("Road 66");
		transaction.commit();
		
		teardown();
		setup();
		
		h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertEquals("Road 66", h�ndler1.getAdresse());
	}
	
	@Test
	public void remove(){
		Haendler h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNotNull(h�ndler1);
		transaction.begin();
		manager.remove(h�ndler1);
		transaction.commit();
		
		h�ndler1 = manager.find(Haendler.class, 1);
		Assert.assertNull(h�ndler1);
	}
}

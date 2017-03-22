package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestFertigungsanlage extends AbstractTest {

	@Test
	public void testGetters() {
		createAnlage();
		Assert.assertEquals(1, anlage.getId());
		Assert.assertEquals("Anlage1", anlage.getBezeichnung());
		Assert.assertEquals(2500, anlage.getVolume());
	}

	@Test
	public void testSetBestandteile() {
		anlage.addBestandteile("Presse XY2300");
		anlage.addBestandteile("Maische-Tank 1000L");
		anlage.addBestandteile("Abseianlage 2530Z");

		Assert.assertEquals(3, anlage.getBestandteile().size());
	}

	@Test
	public void create() {
		transaction.begin();
		createAnlage();
		Assert.assertNotNull(anlage);
		manager.persist(anlage);
		transaction.commit();
	}

	@Test
	public void modify() {
		Fertigungsanlage anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertNotNull(anlage1);
		transaction.begin();
		anlage1.addBestandteile("Abseianlage 2530Z");
		anlage1.addBestandteile("Presse XY2300");
		anlage1.addBestandteile("Maische-Tank 1000L");
		createWeingut();
		manager.persist(weingut);
		anlage1.setWeingut(weingut);
		transaction.commit();

		teardown();
		setup();

		anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertEquals("Abseianlage 2530Z", anlage1.getBestandteile().get(1));
	}

	@Test
	public void remove() {
		Fertigungsanlage anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertNotNull(anlage1);
		transaction.begin();
		manager.remove(anlage1);
		transaction.commit();

		anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertNull(anlage1);
	}
	
	@Test
	public void customAssert1() {
		try {
			new Fertigungsanlage(-1, "Gesamtanlage", 1000);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void customAssert2() {
		try {
			new Fertigungsanlage(2, null, 1000);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void customAssert3() {
		try {
			new Fertigungsanlage(2, "Gesamtanlage", 0);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void customAssert4() {
		Fertigungsanlage anlage = new Fertigungsanlage(2, "Gesamtanlage", 2500);
		try {
			anlage.addBestandteile(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void customAssert5() {
		Fertigungsanlage anlage = new Fertigungsanlage(2, "Gesamtanlage", 2500);
		try {
			anlage.setWeingut(null);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e instanceof IllegalArgumentException);
		}
	}
}

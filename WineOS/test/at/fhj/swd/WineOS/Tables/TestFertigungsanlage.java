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
		createWeingut();
		Assert.assertNotNull(weingut);
		manager.persist(weingut);
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
		transaction.commit();

		teardown();
		setup();

		anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertEquals("Abseianlage 2530Z", anlage1.getBestandteile().get(0));
	}

	@Test
	public void remove() {
		Fertigungsanlage anlage1 = manager.find(Fertigungsanlage.class, 1);
		Weingut weingut = manager.find(Weingut.class, 1);
		Assert.assertNotNull(anlage1);
		Assert.assertNotNull(weingut);
		transaction.begin();
		manager.remove(weingut);
		manager.remove(anlage1);
		transaction.commit();

		anlage1 = manager.find(Fertigungsanlage.class, 1);
		Assert.assertNull(anlage1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert1() {
		new Fertigungsanlage(-1, "Gesamtanlage", 1000, new Weingut());
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert2() {
		new Fertigungsanlage(2, null, 1000, new Weingut());
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert3() {
		new Fertigungsanlage(2, "Gesamtanlage", 0, new Weingut());
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert4() {
		new Fertigungsanlage(2, "Gesamtanlage", 0, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert5() {
		Fertigungsanlage anlage = new Fertigungsanlage(2, "Gesamtanlage", 2500, new Weingut());
		anlage.addBestandteile(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert6() {
		Fertigungsanlage anlage = new Fertigungsanlage(2, "Gesamtanlage", 2500, new Weingut());
		anlage.setWeingut(null);
	}
	@Test
	public void customAssert7() {
		Fertigungsanlage anlage1 = new Fertigungsanlage(2, "Gesamtanlage", 2500, new Weingut());
		Fertigungsanlage anlage2 = new Fertigungsanlage(2, "Anlage", 780, new Weingut());
		Assert.assertTrue(anlage1.equals(anlage2));
	}
}

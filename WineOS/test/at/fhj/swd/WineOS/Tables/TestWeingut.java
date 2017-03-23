package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

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
	public void remove() {
		Weingut weingut = manager.find(Weingut.class, 1);
		Assert.assertNotNull(weingut);
		transaction.begin();
		manager.remove(weingut);
		transaction.commit();

		weingut = manager.find(Weingut.class, 1);
		Assert.assertNull(weingut);
	}

	@Test
	public void testGetters() {
		createWeingut();
		createAnlage();
		createCharge();

		List<Charge> expectedChargen = new ArrayList<Charge>();

		Charge charge2 = new Charge(2, "lalala", weingut);
		Charge charge3 = new Charge(3, "tatata", weingut);
		expectedChargen.add(charge);
		expectedChargen.add(charge2);
		expectedChargen.add(charge3);
		weingut.addCharge(charge2);
		weingut.addCharge(charge3);

		// new Weingut(1, "Teststraﬂe 1", "Testdorf", 8600);

		Assert.assertEquals(1, weingut.getId());
		Assert.assertEquals("Teststraﬂe 1", weingut.getAdresse());
		Assert.assertEquals("Testdorf", weingut.getOrt());
		Assert.assertEquals(8600, weingut.getPlz());
		Assert.assertTrue(weingut.equals(anlage.getWeingut()));
		Assert.assertTrue(weingut.equals(charge.getWeingut()));

		List<Charge> chargen = (ArrayList<Charge>) weingut.getChargen();
		for (int i = 0; i < expectedChargen.size(); i++) {
			Assert.assertTrue(chargen.get(i).equals(expectedChargen.get(i)));
		}

		Charge actualCharge = weingut.getCharge(2);
		Assert.assertTrue(actualCharge.equals(charge3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert1() {
		new Weingut(0, "Teststraﬂe", "testort", 5000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert2() {
		new Weingut(4, null, "testort", 5000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert3() {
		new Weingut(4, " ", "testort", 5000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert4() {
		new Weingut(4, "Teststraﬂe", " ", 5000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert5() {
		new Weingut(4, "Teststraﬂe", null, 5000);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert6() {
		new Weingut(4, "Teststraﬂe", "Testort", 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert7() {
		Weingut w = new Weingut(4, "Teststraﬂe", "Testort", 5006);
		w.addCharge(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void customAssert8() {
		Weingut w = new Weingut(4, "Teststraﬂe", "Testort", 5006);
		w.setAnlage(null);
	}
}

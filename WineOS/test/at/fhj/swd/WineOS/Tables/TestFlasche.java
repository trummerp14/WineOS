package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Test;

public class TestFlasche extends AbstractTest {

	@Test
	public void create() {
		transaction.begin();
		createWeingut();
		Assert.assertNotNull(weingut);
		manager.persist(weingut);
		createCharge();
		Assert.assertNotNull(charge);
		manager.persist(charge);
		createFlasche();
		Assert.assertNotNull(flasche);
		manager.persist(flasche);
		transaction.commit();
	}

	@Test
	public void modify() {
		Flasche flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNotNull(flasche1);
		transaction.begin();
		flasche1.setBezeichnung("Weiﬂburgunder");
		;
		transaction.commit();

		teardown();
		setup();

		flasche1 = manager.find(Flasche.class, 1);
		Assert.assertEquals("Weiﬂburgunder", flasche1.getBezeichnung());
	}

	@Test
	public void remove() {
		Weingut weingut1 = manager.find(Weingut.class, 1);
		Charge charge1 = manager.find(Charge.class, 1);
		Flasche flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNotNull(flasche1);
		transaction.begin();
		manager.remove(weingut1);
		manager.remove(charge1);
		manager.remove(flasche1);
		transaction.commit();

		flasche1 = manager.find(Flasche.class, 1);
		Assert.assertNull(flasche1);
	}
}

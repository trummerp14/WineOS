package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRepos {

	static EntityTransaction tx;
	
	static WeingutRepo wrepo = new WeingutRepo();
	static private ArrayList<Weingut> wlist = new ArrayList<Weingut>(); 
	static HaendlerRepo hrepo = new HaendlerRepo();
	static private ArrayList<Haendler> hlist = new ArrayList<Haendler>();
	static FlascheRepo flrepo = new FlascheRepo();
	static private ArrayList<Flasche> fllist = new ArrayList<Flasche>();
	static ChargeRepo crepo = new ChargeRepo();
	static private ArrayList<Charge> clist = new ArrayList<Charge>();
	static FertigungsanlageRepo frepo = new FertigungsanlageRepo();
	static private ArrayList<Fertigungsanlage> flist = new ArrayList<Fertigungsanlage>();
	
		
	@BeforeClass
	public static void setup() {
		tx = wrepo.getEntityManager().getTransaction();
		createData();
	}
	

	@Test
	public void verifyWeingut(){
		tx.begin();
		//verify findById
		Weingut wg  = wrepo.findById(2);
		Assert.assertNotNull(wg);
		Assert.assertEquals(2, wg.getId());
		Assert.assertEquals("Road to hell", wg.getAdresse());
		
		// verify modify
		Weingut wg2 = wrepo.findById(3);
		Assert.assertNotNull(wg2);
		wg2.setAdresse("Trumpparade");
		wrepo.update(wg2);
		tx.commit();
		
		tx.begin();
		Weingut newWg = wrepo.findById(3);
		Assert.assertNotNull(newWg);
		Assert.assertEquals("Trumpparade", newWg.getAdresse());
		Assert.assertEquals("Trumptower", newWg.getOrt());
		tx.commit();
		
		//verify findAll
		tx.begin();
		List<Weingut> wglist = wrepo.findAll();
		Assert.assertEquals(3, wglist.size());
		for (int i = 0; i < wlist.size(); i++){
			Assert.assertTrue(wglist.get(i).equals(wlist.get(i)));
		}
		tx.commit();
	}
	
	@Test
	public void verifyHaendler(){
		tx.begin();
		//verify findById
		Haendler h = hrepo.findById(3);
		Assert.assertNotNull(h);
		Assert.assertEquals("Apu Nahasapeemapetilon", h.getName());
		Assert.assertEquals("Hauptstraße 15", h.getAdresse());
		
		//verify modify
		Haendler moe = hrepo.findById(2);
		Assert.assertNotNull(moe);
		moe.setPlz(5686);
		hrepo.update(moe);
		tx.commit();
		
		tx.begin();
		Haendler verifyMoe = hrepo.findById(2);
		Assert.assertNotNull(verifyMoe);
		Assert.assertEquals(5686, verifyMoe.getPlz());
		
		//verify findAll
		List<Haendler> list = hrepo.findAll();
		Assert.assertEquals(3, list.size());
		for (int i = 0; i < hlist.size(); i++){
			Assert.assertTrue(list.get(i).equals(hlist.get(i)));
		}
		tx.commit();
	}
	
	@Test
	public void verifyCharge(){
		tx.begin();
		//verify findById
		Charge c = crepo.findById(3);
		Assert.assertNotNull(c);
		Assert.assertEquals("Blaufränkischer", c.getBezeichnung());
		Assert.assertTrue(c.getWeingut().equals(wlist.get(2)));
		Assert.assertTrue(c.getWeingut().getAnlage().equals(flist.get(2)));
		
		//verify modify
		Charge c2 = crepo.findById(2);
		Assert.assertNotNull(c2);
		c2.setBezeichnung("Cuve Blau");
		crepo.update(c2);
		tx.commit();
		
		tx.begin();
		Charge verifyC2 = crepo.findById(2);
		Assert.assertNotNull(verifyC2);
		Assert.assertEquals("Cuve Blau", verifyC2.getBezeichnung());
		
		//verify findAll
		List<Charge> list = crepo.findAll();
		Assert.assertEquals(3, list.size());
		for (int i = 0; i < clist.size(); i++){
			Assert.assertTrue(list.get(i).equals(clist.get(i)));
		}
		tx.commit();
	}
	
	@Test
	public void verifyFlasche(){
		tx.begin();
		//verify findById
		Flasche fl = flrepo.findById(1);
		Assert.assertNotNull(fl);
		Assert.assertEquals("Weißburgunder süd", fl.getBezeichnung());
		Assert.assertTrue(fl.getCharge().equals(clist.get(0)));
		Assert.assertTrue(fl.getCharge().getWeingut().equals(wlist.get(0)));
		
		//verify modify
		Flasche fl5 = flrepo.findById(5);
		Assert.assertNotNull(fl5);
		fl5.setBezeichnung("Cuve Blau");
		flrepo.update(fl5);
		tx.commit();
		
		tx.begin();
		Flasche verifyFl5 = flrepo.findById(5);
		Assert.assertNotNull(verifyFl5);
		Assert.assertEquals("Cuve Blau", verifyFl5.getBezeichnung());
		
		//verify findAll
		List<Flasche> list = flrepo.findAll();
		Assert.assertEquals(12, list.size());
		for (int i = 0; i < fllist.size(); i++){
			Assert.assertTrue(list.get(i).equals(fllist.get(i)));
		}
		tx.commit();
	}
	
	@Test
	public void verifyAnlage(){
		tx.begin();
		//verify findById
		Fertigungsanlage f = frepo.findById(1);
		Assert.assertNotNull(f);
		Assert.assertEquals(500, f.getVolume());
		Assert.assertTrue(f.getWeingut().equals(wlist.get(0)));
		
		//verify modify
		Fertigungsanlage anlage3 = frepo.findById(3);
		Assert.assertNotNull(anlage3);
		anlage3.addBestandteile("Presse 200XL");
		anlage3.addBestandteile("Maische Tank");
		anlage3.addBestandteile("Abfüllanlage");
		frepo.update(anlage3);
		tx.commit();
		
		tx.begin();
		Fertigungsanlage verify = frepo.findById(3);
		Assert.assertNotNull(verify);
		List<String> bestandteile = verify.getBestandteile();
		Assert.assertEquals("Presse 200XL", bestandteile.get(0));
		Assert.assertEquals("Maische Tank", bestandteile.get(1));
		Assert.assertEquals("Abfüllanlage", bestandteile.get(2));
		
		//verify findAll
		List<Fertigungsanlage> list = frepo.findAll();
		Assert.assertEquals(3, list.size());
		for (int i = 0; i < flist.size(); i++){
			Assert.assertTrue(list.get(i).equals(flist.get(i)));
		}
		tx.commit();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testQuerry(){
		
		List<Weingut> l = wrepo.findWithAdresse("Petzoldstraße");
		Assert.assertTrue(l.get(0) instanceof Weingut);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testNamedQuerry1(){
		List l = wrepo.findChargeFlaschen();
		System.out.println(l.toString());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testNamedQuerry2(){
		List l = wrepo.findWeingutHaendler("Weißburgunder");
		System.out.println(l.toString());
	}
	
	
	
	@AfterClass
	public static void teardown(){
		tx.begin();
		
		List<Flasche> flaschen = flrepo.findAll();
		for(Flasche f : flaschen){
			flrepo.delete(f);
		}
		
		List<Charge> chargen = crepo.findAll();
		for(Charge c : chargen){
			crepo.delete(c);
		}
		
		List<Fertigungsanlage> anlagen = frepo.findAll();
		for(Fertigungsanlage a : anlagen){
			frepo.delete(a);
		}
		
		List<Weingut> weingüter = wrepo.findAll();
		for(Weingut w : weingüter){
			wrepo.delete(w);
		}
		
		List<Haendler> händler = hrepo.findAll();
		for(Haendler h : händler){
			hrepo.delete(h);
		}
		
		tx.commit();
	}
	
	
	/*
	 * Helper
	 */
	
	private static void createData() {
		tx.begin();
		//Weingut
		wlist.add(wrepo.createWeingut(1, "Petzoldstraße", "Hirzberg", 8605));
		wlist.add(wrepo.createWeingut(2, "Road to hell", "hell", 6666));
		wlist.add(wrepo.createWeingut(3, "Trumpway", "Trumptower", 656547));
		//Händler
		hlist.add(hrepo.createHaendler(1, "Ned Flanders", "Kirche hinten links", "Springfild", 5686));
		hlist.add(hrepo.createHaendler(2, "Moe Szyslak", "Moe´s Tavern", "Springfild", 5687));
		hlist.add(hrepo.createHaendler(3, "Apu Nahasapeemapetilon", "Hauptstraße 15", "Springfild", 5686));
		//Charge
		clist.add(crepo.createCharge(1, "Weißburgunder", wlist.get(0)));
		clist.add(crepo.createCharge(2, "Riesling", wlist.get(1)));
		clist.add(crepo.createCharge(3, "Blaufränkischer", wlist.get(2)));
		//Flasche
		addFlaschen();
		//Fertigungsanlage
		flist.add(frepo.createFertigungsanlage(1, "Gesamtanlage", 500, wlist.get(0)));
		flist.add(frepo.createFertigungsanlage(2, "Gesamtanlage", 2500, wlist.get(1)));
		flist.add(frepo.createFertigungsanlage(3, "Gesamtanlage", 2500, wlist.get(2)));
		tx.commit();
	}

	private static void addFlaschen() {
		fllist.add(flrepo.createFlasche(1, "Weißburgunder süd", 0.75, 1, "Kronkorken", clist.get(0)));
		fllist.add(flrepo.createFlasche(2, "Weißbrugunder süd", 0.75, 1, "Kronkorken", clist.get(0)));
		fllist.add(flrepo.createFlasche(3, "Weißbrugunder süd", 0.75, 1, "Kronkorken", clist.get(0)));
		fllist.add(flrepo.createFlasche(4, "Weißbrugunder süd", 0.75, 1, "Kronkorken", clist.get(0)));
		fllist.add(flrepo.createFlasche(5, "Riesling südwest", 0.75, 1, "Korken", clist.get(1)));
		fllist.add(flrepo.createFlasche(6, "Riesling südwest", 0.75, 1, "Korken", clist.get(1)));
		fllist.add(flrepo.createFlasche(7, "Riesling südwest", 0.75, 1, "Korken", clist.get(1)));
		fllist.add(flrepo.createFlasche(8, "Riesling südwest", 0.75, 1, "Korken", clist.get(1)));
		fllist.add(flrepo.createFlasche(9, "Blaufränkischer", 0.75, 1, "Korken", clist.get(2)));
		fllist.add(flrepo.createFlasche(10, "Blaufränkischer", 0.75, 1, "Korken", clist.get(2)));
		fllist.add(flrepo.createFlasche(11, "Blaufränkischer", 0.75, 1, "Korken", clist.get(2)));
		fllist.add(flrepo.createFlasche(12, "Blaufränkischer", 0.75, 1, "Korken", clist.get(2)));
	}
}

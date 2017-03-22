package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRepos {

	static WeingutRepo wrepo = new WeingutRepo();
	static private ArrayList<Weingut> wlist = new ArrayList<Weingut>(); 
	static HaendlerRepo hrepo = new HaendlerRepo();
	static private ArrayList<Haendler> hlist = new ArrayList<Haendler>();
	static EntityTransaction tx;

	
	
	@BeforeClass
	public static void setup() {
		tx = wrepo.getEntityManager().getTransaction();
		createData();

	}
	
	private static void createData() {
		
		tx.begin();
		wlist.add(wrepo.createWeingut(1, "Petzoldstraße", "Hirzberg", 8605));
		wlist.add(wrepo.createWeingut(2, "Road to hell", "hell", 6666));
		wlist.add(wrepo.createWeingut(3, "Trumpway", "Trumptower", 656547));
		hlist.add(hrepo.createHaendler(1, "Ned Flanders", "Kirche hinten links", "Springfild", 5686));
		hlist.add(hrepo.createHaendler(2, "Moe Szyslak", "Moe´s Tavern", "Springfild", 5687));
		hlist.add(hrepo.createHaendler(3, "Apu Nahasapeemapetilon", "Hauptstraße 15", "Springfild", 5686));
		tx.commit();
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
	
	
	@AfterClass
	public static void teardown(){
		tx.begin();
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
	

}

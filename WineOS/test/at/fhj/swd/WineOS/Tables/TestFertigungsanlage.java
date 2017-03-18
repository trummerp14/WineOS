package at.fhj.swd.WineOS.Tables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestFertigungsanlage {

	Fertigungsanlage wb;
	
	@Before
	public void setup(){
		wb = new Fertigungsanlage(1, "Gesamtanlage");
	}
	
	
	@Test
	public void testConstructor(){
		new Fertigungsanlage(1, "Gesamtanlage");
	}
	
	@Test
	public void testGetters(){
		Assert.assertEquals(1, wb.getId());
		Assert.assertEquals("Gesamtanlage", wb.getBezeichnung());
	}
	
	@Test
	public void testSetBestandteile(){
		wb.addBestandteile("Presse XY2300");
		wb.addBestandteile("Maische-Tank 1000L");
		wb.addBestandteile("Abseianlage 2530Z");
		
		Assert.assertEquals(3, wb.getBestandteile().size());
	}
}

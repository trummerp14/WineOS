package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="dbo.Charge") public class Charge 
{
	public Charge(int ID, String Bezeichnung, List<Flasche> Flasche)
	{
		setID(ID);
		setBezeichnung(Bezeichnung);
		setFlaschen(Flasche);
		
	}
	public List<Flasche> getFlaschen() {
		return Flaschen;
	}
	public void setFlaschen(List<Flasche> flaschen) {
		Flaschen = flaschen;
	}
	protected Charge(){};
	
	@OneToMany(mappedBy="Charge")
	private List<Flasche>Flaschen = new ArrayList<Flasche>();
	
	@Id private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	
	private String Bezeichnung;
	public String getBezeichnung() {
		return Bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.Bezeichnung = bezeichnung; 
	}
	
	@Override
	public String toString() {
		return "Charge [ID=" + ID + ", Bezeichnung=" + Bezeichnung + "]";
	}
}

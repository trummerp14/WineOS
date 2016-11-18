package Persistance;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity public class Charge 
{
	public Charge(int ID, String Bezeichnung, Flasche flascheCharge)
	{
		setID(ID);
		setBezeichnung(Bezeichnung);
		setFlasche_charge(flascheCharge);
	}
	
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
	
	@OneToOne private Flasche flasche_charge;
	public void setFlasche_charge (Flasche flascheCharge) {
		 this.flasche_charge = flascheCharge;
		 }
		 public Flasche getParkingSpace() { 
			 return flasche_charge;
		 }
}

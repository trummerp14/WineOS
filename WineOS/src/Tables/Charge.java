package Tables;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class Charge 
{
	public Charge(int ID, String Bezeichnung, Flasche flascheCharge)
	{
		setID(ID);
		setBezeichnung(Bezeichnung);
		//setFlasche_charge(flascheCharge);
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
	
	@Override
	public String toString() {
		return "Charge [ID=" + ID + ", Bezeichnung=" + Bezeichnung + "]";
	}
}

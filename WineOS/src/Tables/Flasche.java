package Tables;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class Flasche {
	
	public Flasche(String Bezeichnung, double Füllmenge, int FK_Charge, int Stück, String Ausprägung, Charge Charge)
	{
		setBezeichnung(Bezeichnung);
		setFüllmenge(Füllmenge);
		setFK_Charge(FK_Charge);
		setStück(Stück);
		setAusprägung(Ausprägung);
		setCharge(Charge);
	}
	
	
	@ManyToOne private Charge Charge;
	public void setCharge(Charge charge)
	{
		this.Charge = charge;
	}
	public Charge getCharge()
	{
		return Charge;
	}

	@Id private int ID;
	public int getID() {
		return ID;
	}
	
	//By the SQLServer the ID should be auto incremented by the Server
	/*public void setID(int iD) {
		ID = iD;
	}*/
	
	private String Bezeichnung;
	public String getBezeichnung() {
		return Bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}
	
	private double Füllmenge;
	public double getFüllmenge() {
		return Füllmenge;
	}
	public void setFüllmenge(double füllmenge) {
		Füllmenge = füllmenge;
	}
	
	private int FK_Charge;
	public int getFK_Charge() {
		return FK_Charge;
	}
	public void setFK_Charge(int fK_Charge) {
		FK_Charge = fK_Charge;
	}
	
	private int Stück;
	public int getStück() {
		return Stück;
	}
	public void setStück(int stück) {
		Stück = stück;
	}
	
	private String Ausprägung;
	public String getAusprägung() {
		return Ausprägung;
	}
	public void setAusprägung(String ausprägung) {
		Ausprägung = ausprägung;
	}
	
	@Override
	public String toString() {
		return "Flasche [Charge=" + Charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", Füllmenge=" + Füllmenge
				+ ", FK_Charge=" + FK_Charge + ", Stück=" + Stück + ", Ausprägung=" + Ausprägung + "]";
	}
}

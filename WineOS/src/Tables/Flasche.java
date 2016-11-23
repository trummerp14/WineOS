package Tables;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class Flasche {
	
	public Flasche(String Bezeichnung, double Fuellmenge, int FK_Charge, int Stueck, String Auspraegung, Charge Charge)
	{
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setFK_Charge(FK_Charge);
		setStueck(Stueck);
		setAuspraegung(Auspraegung);
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
	
	private double Fuellmenge;
	public double getFuellmenge() {
		return Fuellmenge;
	}
	public void setFuellmenge(double fuellmenge) {
		Fuellmenge = fuellmenge;
	}
	
	private int FK_Charge;
	public int getFK_Charge() {
		return FK_Charge;
	}
	public void setFK_Charge(int fK_Charge) {
		FK_Charge = fK_Charge;
	}
	
	private int Stueck;
	public int getStueck() {
		return Stueck;
	}
	public void setStueck(int stueck) {
		Stueck = stueck;
	}
	
	private String Auspraegung;
	public String getAuspraegung() {
		return Auspraegung;
	}
	public void setAuspraegung(String auspraegung) {
		Auspraegung = auspraegung;
	}
	
	@Override
	public String toString() {
		return "Flasche [Charge=" + Charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", Fuellmenge=" + Fuellmenge
				+ ", FK_Charge=" + FK_Charge + ", Stueck=" + Stueck + ", Auspruegung=" + Auspraegung + "]";
	}
}

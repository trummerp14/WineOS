package at.fhj.swd.WineOS.Tables;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="dbo.Flasche") public class Flasche {
	
	public Flasche(int ID, String Bezeichnung, double Fuellmenge, String Auspraegung, int FK_Charge, int Stueck, Charge Charge)
	{
		setID(ID);
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setStueck(Stueck);
		setAuspraegung(Auspraegung);
		setFK_Charge(FK_Charge);
		setCharge(Charge);
	}
	
	protected Flasche(){};
	
	
	@ManyToOne @JoinColumn(name="FK_Charge")
	private Charge Charge;
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
	public void setID(int id)
	{
		this.ID = id;
	}
	
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
	
	private int FK_Charge;
	public int getKF_Charge() {
		return FK_Charge;
	}

	public void setFK_Charge(int kF_Charge) {
		FK_Charge = FK_Charge;
	}

	@Override
	public String toString() {
		return "Flasche [Charge=" + Charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", Fuellmenge=" + Fuellmenge
				 + ", Stueck=" + Stueck + ", Auspruegung=" + Auspraegung + "]";
	}
}

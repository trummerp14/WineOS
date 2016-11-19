package Tables;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity public class Flasche {
	
	public Flasche(String Bezeichnung, double F�llmenge, int FK_Charge, int St�ck, String Auspr�gung, Charge Charge)
	{
		setBezeichnung(Bezeichnung);
		setF�llmenge(F�llmenge);
		setFK_Charge(FK_Charge);
		setSt�ck(St�ck);
		setAuspr�gung(Auspr�gung);
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
	
	private double F�llmenge;
	public double getF�llmenge() {
		return F�llmenge;
	}
	public void setF�llmenge(double f�llmenge) {
		F�llmenge = f�llmenge;
	}
	
	private int FK_Charge;
	public int getFK_Charge() {
		return FK_Charge;
	}
	public void setFK_Charge(int fK_Charge) {
		FK_Charge = fK_Charge;
	}
	
	private int St�ck;
	public int getSt�ck() {
		return St�ck;
	}
	public void setSt�ck(int st�ck) {
		St�ck = st�ck;
	}
	
	private String Auspr�gung;
	public String getAuspr�gung() {
		return Auspr�gung;
	}
	public void setAuspr�gung(String auspr�gung) {
		Auspr�gung = auspr�gung;
	}
	
	@Override
	public String toString() {
		return "Flasche [Charge=" + Charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", F�llmenge=" + F�llmenge
				+ ", FK_Charge=" + FK_Charge + ", St�ck=" + St�ck + ", Auspr�gung=" + Auspr�gung + "]";
	}
}

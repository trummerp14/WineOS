package at.fhj.swd.WineOS.Tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "dbo.Weingut")
public class Weingut {

	@Id private int id;
	@OneToOne 
	@JoinColumn(name = "Charge_id") private Charge Charge;
	private String adresse;
	private String ort;
	private int plz;

	public Weingut(int id, String adresse, String ort, int plz) {
		setId(id);
		setAdresse(adresse);
		setOrt(ort);
		setPlz(plz);
	}
	
	public Weingut(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public void setCharge(Charge charge) {
		this.Charge = charge;
	}

	public Charge getCharge() {
		return Charge;
	}

}

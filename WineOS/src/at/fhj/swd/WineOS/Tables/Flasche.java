package at.fhj.swd.WineOS.Tables;

import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name = "dbo.Flasche")
public class Flasche {

	@Id private int ID;
	private String Bezeichnung;
	@ManyToOne 
	@JoinColumn (name = "FK_Charge") private Charge Charge;
	private String Auspraegung;
	private double Fuellmenge;
	@ManyToMany private Collection<Haendler> händler = new ArrayList<Haendler>();

	public Flasche(int ID, String Bezeichnung, double Fuellmenge, String Auspraegung, int Stueck, Charge Charge) {
		setID(ID);
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setStueck(Stueck);
		setAuspraegung(Auspraegung);
		setCharge(Charge);
	}
	
	public Flasche(){};

	public void setCharge(Charge charge) {
		this.Charge = charge;
		Charge.addFlasche(this);
	}

	public Charge getCharge() {
		return Charge;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		this.ID = id;
	}

	public String getBezeichnung() {
		return Bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}

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

	public String getAuspraegung() {
		return Auspraegung;
	}

	public void setAuspraegung(String auspraegung) {
		Auspraegung = auspraegung;
	}
	
	public Collection<Haendler> getHaendler() {
		return händler;
	}

	public void addHaendler(Haendler händler) {
		this.händler.add(händler);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flasche other = (Flasche) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flasche [Charge=" + Charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", Fuellmenge="
				+ Fuellmenge + ", Stueck=" + Stueck + ", Auspruegung=" + Auspraegung + "]";
	}
}

package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity(name = "dbo.Flasche")
public class Flasche {
	
	//primary Key
	@Id private int ID;
	
	// Beziehung zwischen Charge und Flaschen 1:n Source ist Charge
	@ManyToOne 
	@JoinColumn (name = "FK_Charge") private Charge charge;
	
	// Beziehung zwischen Händler und Flasche m:n Source ist Händler
	@ManyToMany (mappedBy = "flaschen") private Collection<Haendler> händler = new ArrayList<Haendler>();

	private String Bezeichnung;
	private String Auspraegung;
	private double Fuellmenge;
	
	public Flasche(int Id, String Bezeichnung, double Fuellmenge, String Auspraegung, int Stueck, Charge charge) {
		setId(Id);
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setStueck(Stueck);
		setAuspraegung(Auspraegung);
		setCharge(charge);
	}
	
	public Flasche(){};

	public void setCharge(Charge charge) {
		this.charge = charge;
		this.charge.addFlasche(this);
	}

	public Charge getCharge() {
		return charge;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
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

	void addHaendler(Haendler händler) {
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
		return "Flasche [Charge=" + charge + ", ID=" + ID + ", Bezeichnung=" + Bezeichnung + ", Fuellmenge="
				+ Fuellmenge + ", Stueck=" + Stueck + ", Auspruegung=" + Auspraegung + "]";
	}
}

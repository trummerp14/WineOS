package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity(name = "dbo.Flasche")
public class Flasche {

	// primary Key
	@Id
	private int Id;

	// Beziehung zwischen Charge und Flaschen 1:n Source ist Charge
	@ManyToOne
	@JoinColumn(name = "FK_Charge")
	private Charge charge;

	// Beziehung zwischen Händler und Flasche m:n Source ist Händler
	@ManyToMany(mappedBy = "flaschen")
	private Collection<Haendler> haendler = new ArrayList<Haendler>();

	private String Bezeichnung;
	private String Auspraegung;
	private double Fuellmenge;
	private int Stueck;

	public Flasche(int Id, String Bezeichnung, double Fuellmenge, String Auspraegung, Charge charge) {
		setId(Id);
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setAuspraegung(Auspraegung);
		setCharge(charge);
	}

	public Flasche() {
	};

	public void setCharge(Charge charge) {
		if (charge == null)
			throw new IllegalArgumentException();
		this.charge = charge;
		this.charge.addFlasche(this);
	}

	public Charge getCharge() {
		return charge;
	}

	public void setId(int id) {
		if (id <= 0)
			throw new IllegalArgumentException();
		this.Id = id;
	}

	public int getId() {
		return Id;
	}

	public void setBezeichnung(String bezeichnung) {
		if (bezeichnung == null)
			throw new IllegalArgumentException();
		this.Bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return Bezeichnung;
	}

	public void setFuellmenge(double fuellmenge) {
		Fuellmenge = fuellmenge;
	}

	public double getFuellmenge() {
		return Fuellmenge;
	}

	public void setAuspraegung(String auspraegung) {
		if (auspraegung == null)
			throw new IllegalArgumentException();
		Auspraegung = auspraegung;
	}

	public String getAuspraegung() {
		return Auspraegung;
	}

	void addHaendler(Haendler haendler) {
		if(haendler == null)
			throw new IllegalArgumentException();
		this.haendler.add(haendler);
	}

	public Collection<Haendler> getHaendler() {
		return haendler;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
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
		if (Id != other.Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flasche [Charge=" + charge + ", Id=" + Id + ", Bezeichnung=" + Bezeichnung + ", Fuellmenge="
				+ Fuellmenge + ", Stueck=" + Stueck + ", Auspruegung=" + Auspraegung + "]";
	}
}

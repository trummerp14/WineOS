package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity(name = "dbo.Flasche")
public class Flasche {

	// primary Key
	@Id
	private int id;

	// Beziehung zwischen Charge und Flaschen 1:n Source ist Charge
	@ManyToOne
	@JoinColumn(name = "FK_Charge")
	private Charge charge;

	// Beziehung zwischen Händler und Flasche m:n Source ist Händler
	@ManyToMany(mappedBy = "flaschen")
	private Collection<Haendler> haendler = new ArrayList<Haendler>();

	private String bezeichnung;
	private String auspraegung;
	private double fuellmenge;
	private int stueck;

	public Flasche(int Id, String Bezeichnung, double Fuellmenge,int stueck, String Auspraegung, Charge charge) {
		setId(Id);
		setBezeichnung(Bezeichnung);
		setFuellmenge(Fuellmenge);
		setAuspraegung(Auspraegung);
		setCharge(charge);
		setStueck(stueck);
	}

	public Flasche() {
	};

	public int getStueck() {
		return stueck;
	}

	public void setStueck(int stueck) {
		if(stueck < 0)
			throw new IllegalArgumentException();
		this.stueck = stueck;
	}

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
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setBezeichnung(String bezeichnung) {
		if (bezeichnung == null || bezeichnung.trim().length() == 0)
			throw new IllegalArgumentException();
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setFuellmenge(double fuellmenge) {
		if(fuellmenge <= 0)
			throw new IllegalArgumentException();
		this.fuellmenge = fuellmenge;
	}

	public double getFuellmenge() {
		return fuellmenge;
	}

	public void setAuspraegung(String auspraegung) {
		if (auspraegung == null || auspraegung.trim().length() == 0)
			throw new IllegalArgumentException();
		this.auspraegung = auspraegung;
	}

	public String getAuspraegung() {
		return auspraegung;
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flasche [Charge=" + charge + ", Id=" + id + ", Bezeichnung=" + bezeichnung + ", Fuellmenge="
				+ fuellmenge + ", Stueck=" + stueck + ", Auspruegung=" + auspraegung + "]";
	}
}

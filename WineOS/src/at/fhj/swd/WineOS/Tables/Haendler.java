package at.fhj.swd.WineOS.Tables;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name="dbo.Haendler")
public class Haendler 
{
	@Id private int ID;
	private String name;
	private String adresse;
	private String ort;
	private int plz;
	@ManyToMany 
	@JoinTable(name = "Haendler_Flaschen",
			joinColumns = @JoinColumn (name="FK_Haendler"), 
			inverseJoinColumns = @JoinColumn (name="FK_Flasche"))
			private Collection<Flasche> flaschen = new ArrayList<Flasche>();
	
	public Haendler(int id, String name, String adresse, String ort, int plz)
	{
		setID(id);
		setName(name);
		setAdresse(adresse);
		setOrt(ort);
		setPlz(plz);
	}
	
	public Haendler(){};

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Collection<Flasche> getFlaschen() {
		return flaschen;
	}

	public void addFlaschen(Flasche flasche) {
		this.flaschen.add(flasche);
		flasche.addHaendler(this);
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
		Haendler other = (Haendler) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	

}

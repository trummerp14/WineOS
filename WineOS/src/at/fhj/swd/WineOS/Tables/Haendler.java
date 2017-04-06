package at.fhj.swd.WineOS.Tables;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="dbo.Haendler")
public class Haendler 
{
	// Primary Key
	@Id private int id;

	//Beziehung zwischen Flasche und Händler m:n Händler ist Source
	@ManyToMany 
	@JoinTable(name = "Flasche_Haendler",
			joinColumns = @JoinColumn (name="FK_Haendler"), 
			inverseJoinColumns = @JoinColumn (name="FK_Flasche"))
			private Collection<Flasche> flaschen = new ArrayList<Flasche>();
	
	private String name;
	private String adresse;
	private String ort;
	private int plz;
	
	public Haendler(int id, String name, String adresse, String ort, int plz)
	{
		setId(id);
		setName(name);
		setAdresse(adresse);
		setOrt(ort);
		setPlz(plz);
	}
	
	public Haendler(){};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0)
			throw new IllegalArgumentException();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.trim().length() == 0)
			throw new IllegalArgumentException();
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		if(adresse == null || adresse.trim().length() == 0)
			throw new IllegalArgumentException();
		this.adresse = adresse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		if(ort == null || ort.trim().length() == 0)
			throw new IllegalArgumentException();
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		if(plz <= 999)
			throw new IllegalArgumentException();
		this.plz = plz;
	}

	public Collection<Flasche> getFlaschen() {
		return flaschen;
	}

	public void addFlasche(Flasche flasche) {
		this.flaschen.add(flasche);
		flasche.addHaendler(this);
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
		if (id != other.id)
			return false;
		return true;
	}	
}

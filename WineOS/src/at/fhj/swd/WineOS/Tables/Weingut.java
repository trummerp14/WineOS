package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "dbo.Weingut")

@NamedQueries({
	@NamedQuery(name="ChargeFlaschen",
				query = "SELECT c.bezeichnung, f.bezeichnung, f.auspraegung "+
						"FROM Charge c JOIN c.flaschen f "+
						"ORDER BY f.fuellmenge"),
	@NamedQuery(name="findCharge",
				query = "SELECT c " +
						"FROM Charge c JOIN c.flaschen f JOIN c.weingut w " +
						"WHERE c.bezeichnung = :wBez"),
	@NamedQuery(name="findHaendler",
				query = "SELECT h " +
						"FROM Haendler h JOIN h.flaschen f JOIN f.charge c JOIN c.weingut w " +
						"WHERE w.id = :id"),
})

public class Weingut {
	
	// primary key
	@Id private int id;
	
	// Beziehung zu Fertigungsanlage. 1:1 Source ist Weingut
	@OneToOne (mappedBy = "weingut") private Fertigungsanlage anlage;
	
	// Beziehung zu Charge 1:M Source is Weingut
	@OneToMany(mappedBy = "weingut") private Collection<Charge> chargen = new ArrayList<Charge>();
	
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
		if(id <= 0)
			throw new IllegalArgumentException();
		this.id = id;
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

	void addCharge(Charge charge) {
		if(charge == null)
			throw new IllegalArgumentException();
		chargen.add(charge);
	}
	
	public Collection<Charge> getChargen(){
		return chargen;
	}

	public Charge getCharge(int index) {
		List<Charge> list = null;
		if(chargen instanceof List)
			list = (List<Charge>) chargen;
		return list.get(index);
	}

	void setAnlage(Fertigungsanlage wb){
		if(wb == null)
			throw new IllegalArgumentException();
		this.anlage = wb;
	}
	
	public Fertigungsanlage getAnlage(){
		return anlage;
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
		Weingut other = (Weingut) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weingut [id=" + id + ", anlage=" + anlage + ", chargen=" + chargen + ", adresse=" + adresse + ", ort="
				+ ort + ", plz=" + plz + "]";
	}

	
	
	
	
}

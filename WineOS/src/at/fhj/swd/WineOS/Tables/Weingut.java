package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "dbo.Weingut")
public class Weingut {

	// primary key
	@Id private int id;
	
	// Beziehung zu Fertigungsanlage. 1:1 Source ist Weingut
	@OneToOne (mappedBy = "weingut") private Fertigungsanlage anlage;
	
	// Beziehugn zu Charge 1:M Source is Weingut
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

	public void addCharge(Charge charge) {
		if(charge == null)
			throw new IllegalArgumentException();
		chargen.add(charge);
		//charge.setWeingut(this);
	}
	
	public ArrayList<Charge> getChargen(){
		ArrayList<Charge> res;
		try {
			res = (ArrayList<Charge>) chargen;
		} catch (Exception e) {
			throw new ClassCastException();
		}
		return res;
	}

	public Charge getCharge(int index) {
		List<Charge> list = null;
		if(chargen instanceof List)
			list = (List<Charge>) chargen;
		return list.get(index);
	}

	public void setAnlage(Fertigungsanlage wb){
		if(wb == null)
			throw new IllegalArgumentException();
		this.anlage = wb;
		//wb.setWeingut(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((anlage == null) ? 0 : anlage.hashCode());
		result = prime * result + ((chargen == null) ? 0 : chargen.hashCode());
		result = prime * result + id;
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
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
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (anlage == null) {
			if (other.anlage != null)
				return false;
		} else if (!anlage.equals(other.anlage))
			return false;
		if (chargen == null) {
			if (other.chargen != null)
				return false;
		} else if (!chargen.equals(other.chargen))
			return false;
		if (id != other.id)
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		return true;
	}
	
	
	
}

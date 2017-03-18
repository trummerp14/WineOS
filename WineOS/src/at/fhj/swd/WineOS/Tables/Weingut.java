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
	@OneToOne(mappedBy = "weingut")private Fertigungsanlage anlage;
	
	// Beziehugn zu Charge 1:M Source is Weingut
	@OneToMany (mappedBy = "Weingut") private Collection<Charge> chargen = new ArrayList<Charge>();
	
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
	
	public Collection<Charge> getChargen(){
		return chargen;
	}

	public Charge getCharge(int index) {
		List<Charge> list = null;
		if(chargen instanceof List)
			list = (List<Charge>) chargen;
		return list.get(index);
	}

	public void setWeinbereitungsanlage(Fertigungsanlage wb){
		if(wb == null)
			throw new IllegalArgumentException();
		this.anlage = wb;
		wb.setWeingut(this);
	}
	
}

package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "dbo.Charge")
public class Charge {
	
	@Id
	private int id;
	@ManyToOne private Weingut weingut;
	@OneToMany (mappedBy = "Charge") private Collection<Flasche> flaschen = new ArrayList<Flasche>();
	private String bezeichnung;

	public Charge(int id, String bezeichnung, Weingut weingut) {
		setId(id);
		setBezeichnung(bezeichnung);
		setWeingut(weingut);
	}

	public Charge(){};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Weingut getWeingut() {
		return weingut;
	}

	public void setWeingut(Weingut weingut) {
		if(weingut == null)
			throw new IllegalArgumentException();
		
		this.weingut = weingut;
		weingut.addCharge(this);
	}

	public Collection<Flasche> getFlaschen() {
		return flaschen;
	}

	public void addFlasche(Flasche flasche) {
		flaschen.add(flasche);
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
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
		Charge other = (Charge) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

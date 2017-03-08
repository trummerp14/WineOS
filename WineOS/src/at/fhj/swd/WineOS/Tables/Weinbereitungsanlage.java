package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Weinbereitungsanlage {

	@Id private int id;
	private String bezeichnung;
	private List<String> bestandteile = new ArrayList<String>();
	@OneToOne 
	@JoinColumn(name = "Weingut_id") private Weingut weingut;
	
	public Weinbereitungsanlage(){}
	
	public Weinbereitungsanlage(int id, String bezeichnung) {
		setBezeichnung(bezeichnung);
		setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0)
			throw new IllegalArgumentException();
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		if(bezeichnung == null)
			throw new IllegalArgumentException();
		this.bezeichnung = bezeichnung;
	}

	public List<String> getBestandteile() {
		return bestandteile;
	}

	public void addBestandteile(String bestandteil) {
		if(bestandteil == null)
			throw new IllegalArgumentException();
		bestandteile.add(bestandteil);
	}

	public void setWeingut(Weingut wg){
		if(wg == null)
			throw new IllegalArgumentException();
		this.weingut = wg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestandteile == null) ? 0 : bestandteile.hashCode());
		result = prime * result + ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
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
		Weinbereitungsanlage other = (Weinbereitungsanlage) obj;
		if (bestandteile == null) {
			if (other.bestandteile != null)
				return false;
		} else if (!bestandteile.equals(other.bestandteile))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		return true;
	}
	
	
	
}

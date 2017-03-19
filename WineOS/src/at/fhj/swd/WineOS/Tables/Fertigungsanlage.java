package at.fhj.swd.WineOS.Tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "dbo.Fertigungsanlage")
public class Fertigungsanlage {

	//primary key
	@Id private int id;
	
	// Beziehung zu Weingut 1:1 Source ist Weingut
	@OneToOne private Weingut weingut;
	
	private String bezeichnung;
	private List<String> bestandteile = new ArrayList<String>();
	private int volumen;
	
	public Fertigungsanlage(){}
	
	public Fertigungsanlage(int id, String bezeichnung, int volumen) {
		setBezeichnung(bezeichnung);
		setId(id);
		setVolume(volumen);
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
		this.weingut.setAnlage(this);
	}
	
	public void setVolume(int i){
		if(i <= 0)
			throw new IllegalArgumentException();
		this.volumen = i;
	}
	
	public int getVolume(){
		return volumen;
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
		Fertigungsanlage other = (Fertigungsanlage) obj;
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

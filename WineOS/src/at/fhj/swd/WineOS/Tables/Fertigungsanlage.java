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
	@OneToOne @JoinColumn(name = "FK_Weingut") private Weingut weingut;
	
	private String bezeichnung;
	private List<String> bestandteile = new ArrayList<String>();
	private int volumen;
	
	public Fertigungsanlage(){}
	
	public Fertigungsanlage(int id, String bezeichnung, int volumen, Weingut wg) {
		setBezeichnung(bezeichnung);
		setId(id);
		setVolume(volumen);
		setWeingut(wg);
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
	
	public Object getWeingut() {
		return weingut;
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
		Fertigungsanlage other = (Fertigungsanlage) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	



	
	
	
}

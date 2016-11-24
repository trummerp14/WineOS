package at.fhj.swd.WineOS.Tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="dbo.Haendler") 
public class Weingut 
{
	public Weingut(int ID, Date Oeffnungszeit_Von, Date Oeffnugszeit_Bis, Boolean Verkostungsmoeglichkeit)
	{
		setID(ID);
		setOeffnungszeit_Von(Oeffnungszeit_Von);
		setOeffnungszeit_Bis(Oeffnugszeit_Bis);
		setVerkostungsmoeglichkeit(Verkostungsmoeglichkeit);
	}
	
	protected Weingut(){};
	
	@Id
	public int getID() {
		return ID;
	}

	private int ID;
	public void setID(int iD) {
		ID = iD;
	}
	
	private Date Oeffnungszeit_Von;
	public Date getOeffnungszeit_Von() {
		return Oeffnungszeit_Von;
	}

	public void setOeffnungszeit_Von(Date oeffnungszeit_Von) {
		Oeffnungszeit_Von = oeffnungszeit_Von;
	}

	private Date Oeffnungszeit_Bis;
	public Date getOeffnungszeit_Bis() {
		return Oeffnungszeit_Bis;
	}

	public void setOeffnungszeit_Bis(Date oeffnungszeit_Bis) {
		Oeffnungszeit_Bis = oeffnungszeit_Bis;
	}

	private Boolean Verkostungsmoeglichkeit;
	public Boolean getVerkostungsmoeglichkeit() {
		return Verkostungsmoeglichkeit;
	}

	public void setVerkostungsmoeglichkeit(Boolean verkostungsmoeglichkeit) {
		Verkostungsmoeglichkeit = verkostungsmoeglichkeit;
	} 
}

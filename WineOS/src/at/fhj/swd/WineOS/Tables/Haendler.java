package at.fhj.swd.WineOS.Tables;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;


@Entity(name="dbo.Haendler")
public class Haendler 
{
	
	public Haendler(Date Oeffnungszeit_Von, Date Oeffnungszeit_Bis)
	{
		setOeffnungszeit_Von(Oeffnungszeit_Von);
		setOeffnungszeit_Bis(Oeffnungszeit_Bis);
	}
	
	protected Haendler(){};
	
	@Id private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	private Date Oeffnungszeit_Von;
	public Date getOeffnungszeit_Von() {
		return Oeffnungszeit_Von;
	}
	public void setOeffnungszeit_Von(Date Oeffnungszeit_Von) {
		this.Oeffnungszeit_Von = Oeffnungszeit_Von;
	}
	
	private Date Oeffnungszeit_Bis;
	public Date getOeffnungszeit_Bis() {
		return Oeffnungszeit_Bis;
	}
	public void setOeffnungszeit_Bis(Date Oeffnungszeit_Bis) {
		this.Oeffnungszeit_Bis = Oeffnungszeit_Bis;
	}

	@Override
	public String toString() {
		return "Haendler [ID=" + ID + ", Oeffnungszeit_Von=" + Oeffnungszeit_Von + "]";
	}
}

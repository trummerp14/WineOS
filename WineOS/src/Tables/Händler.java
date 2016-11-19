package Tables;
import javax.persistence.Id;

import java.util.Date;

public class Händler {
	
	public Händler(Date Öffnungszeit_Von, Date Öffnungszeit_Bis)
	{
		setÖffnungszeit_Von(Öffnungszeit_Von);
		setÖffnungszeit_Bis(Öffnungszeit_Bis);
	}
	
	@Id private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	private Date Öffnungszeit_Von;
	public Date getÖffnungszeit_Von() {
		return Öffnungszeit_Von;
	}
	public void setÖffnungszeit_Von(Date öffnungszeit_Von) {
		Öffnungszeit_Von = öffnungszeit_Von;
	}
	
	private Date Öffnungszeit_Bis;
	public Date getÖffnungszeit_Bis() {
		return Öffnungszeit_Bis;
	}
	public void setÖffnungszeit_Bis(Date öffnungszeit_Bis) {
		Öffnungszeit_Bis = öffnungszeit_Bis;
	}

	@Override
	public String toString() {
		return "Händler [ID=" + ID + ", Öffnungszeit_Von=" + Öffnungszeit_Von + "]";
	}
}

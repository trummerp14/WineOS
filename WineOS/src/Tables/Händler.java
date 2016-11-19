package Tables;
import javax.persistence.Id;

import java.util.Date;

public class H�ndler {
	
	public H�ndler(Date �ffnungszeit_Von, Date �ffnungszeit_Bis)
	{
		set�ffnungszeit_Von(�ffnungszeit_Von);
		set�ffnungszeit_Bis(�ffnungszeit_Bis);
	}
	
	@Id private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	private Date �ffnungszeit_Von;
	public Date get�ffnungszeit_Von() {
		return �ffnungszeit_Von;
	}
	public void set�ffnungszeit_Von(Date �ffnungszeit_Von) {
		�ffnungszeit_Von = �ffnungszeit_Von;
	}
	
	private Date �ffnungszeit_Bis;
	public Date get�ffnungszeit_Bis() {
		return �ffnungszeit_Bis;
	}
	public void set�ffnungszeit_Bis(Date �ffnungszeit_Bis) {
		�ffnungszeit_Bis = �ffnungszeit_Bis;
	}

	@Override
	public String toString() {
		return "H�ndler [ID=" + ID + ", �ffnungszeit_Von=" + �ffnungszeit_Von + "]";
	}
}

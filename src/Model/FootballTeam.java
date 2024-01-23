package Model;

import java.io.Serializable;

public class FootballTeam implements Serializable {
	String idteam;
	String footballname;
	int quantity;
	int founding;
	String idiamge;
	public FootballTeam() {
		
	}
	public FootballTeam(String idteam, String footballname, int quantity, int founding, String idiamge) {
		this.idteam = idteam;
		this.footballname = footballname;
		this.quantity = quantity;
		this.founding = founding;
		this.idiamge = idiamge;
	}
	public String getIdteam() {
		return idteam;
	}
	public void setIdteam(String idteam) {
		this.idteam = idteam;
	}
	public String getFootballname() {
		return footballname;
	}
	public void setFootballname(String footballname) {
		this.footballname = footballname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFounding() {
		return founding;
	}
	public void setFounding(int founding) {
		this.founding = founding;
	}
	public String getIdiamge() {
		return idiamge;
	}
	public void setIdiamge(String idiamge) {
		this.idiamge = idiamge;
	}
	public String toString() {
		return "FootballTeam [idteam=" + idteam + ", footballname=" + footballname + ", quantity=" + quantity
				+ ", founding=" + founding + ", idiamge=" + idiamge + "]";
	}
	
}

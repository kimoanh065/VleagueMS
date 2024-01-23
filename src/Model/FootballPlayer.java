package Model;

import java.io.Serializable;

public class FootballPlayer implements Serializable {
	String id;
	String name;
	int age;
	String position;
	String IDFootballTeam;
	public FootballPlayer() {
		
	}
	public FootballPlayer(String id, String name, int age, String position, String iDFootballTeam) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.position = position;
		IDFootballTeam = iDFootballTeam;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getIDFootballTeam() {
		return IDFootballTeam;
	}
	public void setIDFootballTeam(String iDFootballTeam) {
		IDFootballTeam = iDFootballTeam;
	}
	public String toString() {
		return "FootballPlayer [id=" + id + ", name=" + name + ", age=" + age + ", position=" + position
				+ ", IDFootballTeam=" + IDFootballTeam + "]";
	}
	
	
	
}

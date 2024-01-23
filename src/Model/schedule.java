package Model;

import java.io.Serializable;

public class schedule implements Serializable {
	int idschedule;
	String date;
	String time;
	String footballteam1;
	String footballteam2;
	
	public schedule() {
		
	}

	public schedule(int idschedule, String date, String time, String footballteam1, String footballteam2) {
		
		this.idschedule = idschedule;
		this.date = date;
		this.time = time;
		this.footballteam1 = footballteam1;
		this.footballteam2 = footballteam2;
	}

	public int getIdschedule() {
		return idschedule;
	}

	public void setIdschedule(int idschedule) {
		this.idschedule = idschedule;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFootballteam1() {
		return footballteam1;
	}

	public void setFootballteam1(String footballteam1) {
		this.footballteam1 = footballteam1;
	}

	public String getFootballteam2() {
		return footballteam2;
	}

	public void setFootballteam2(String footballteam2) {
		this.footballteam2 = footballteam2;
	}

	public String toString() {
		return "schedule [idschedule=" + idschedule + ", date=" + date + ", time=" + time + ", footballteam1="
				+ footballteam1 + ", footballteam2=" + footballteam2 + "]";
	}
	
	
}

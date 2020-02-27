package com.miniclip.model;

import java.sql.Timestamp;

//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="RPS_GAMEDATA_JPA")
public class RpsData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="RpsSeqJpa")
	@SequenceGenerator(name="RpsSeqJpa",sequenceName="RPS_PK_JPA", allocationSize=1)
	@Column(name="SERIAL")
	private int serial;
	@Column(name="USER_CHOICE")
	private String userChoice;
	@Column(name="SYSTEM_CHOICE")
	private String systemChoice;
	@Column(name="TIME_STAMP")
	private Timestamp timeStamp;
	@Column(name="WINNER")
	private String winner;
	
	public RpsData(){
		
	}
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getUserChoice() {
		return userChoice;
	}
	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}
	public String getSystemChoice() {
		return systemChoice;
	}
	public void setSystemChoice(String systemChoice) {
		this.systemChoice = systemChoice;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}	
}

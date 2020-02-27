package com.miniclip.model;

import java.util.HashMap;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class RpsOption implements Serializable {
	
	private static final long serialVersionUID = 1L;
	RpsData rpsData;	
	
	@Inject
	private RpsService rpsService;
	
	private String[] options;
	private String userChoice;
	private HashMap<String, String>gameresult;

	
	public void setGameresult() {
		this.gameresult = RpsLogic.rpsLogic(this.getUserChoice());
	}

	public HashMap<String, String> getGameresult() {
		return gameresult;
	}

	public RpsOption() {
		super();	
		rpsData = new RpsData();
		options= new String[]{"ROCK","PAPER","SCISSORS"};
		this.setUserChoice("ROCK");//set for default option at view level
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getUserChoice() {
		return userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	public RpsData getRpsData() {
		return rpsData;
	}

	public void setRpsData() {
		System.out.println(this.getGameresult().get("systemChoice"));
		System.out.println(this.getGameresult().get("userChoice"));
		System.out.println(this.getGameresult().get("winner"));
		this.rpsData.setSystemChoice(this.getGameresult().get("systemChoice"));
		this.rpsData.setUserChoice(this.getGameresult().get("userChoice"));
		this.rpsData.setWinner(this.getGameresult().get("winner"));
		System.out.println("PrintingRpsData bean content.");
		System.out.println("syschoice:"+this.rpsData.getSystemChoice());
		System.out.println("userChoice"+this.rpsData.getUserChoice());
		System.out.println("winner"+this.rpsData.getWinner());
		
		this.rpsService.createRpsData(this.getRpsData());
		
	}

	public RpsService getRpsService() {
		return rpsService;
	}

	public void setRpsService(RpsService rpsService) {
		this.rpsService = rpsService;
	}
	public String showMessage() {
		return this.getGameresult().get("gameResultStatus");
	}
	
}

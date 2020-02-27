package com.miniclip.controller;


import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

import com.miniclip.model.RpsData;
import com.miniclip.model.RpsOption;
import java.io.Serializable;


@RequestScoped
@Named
public class GameChoiceProcessor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private RpsOption rpsOption;
	private RpsData rpsData;
	    
	
    
    public RpsData getRpsData() {
		return rpsData;
	}



	public void setRpsData(RpsData rpsData) {
		this.rpsData = rpsData;
	}



	public GameChoiceProcessor() {              
    }

	
	
	public String calculateGameResult(){
		rpsOption.setGameresult();
		rpsOption.setRpsData();
		this.setRpsData(rpsOption.getRpsData());
		//System.out.println(" "+rpsOption.getUserChoice());
		//System.out.println(rpsOption.showMessage());
		return "insertResult";
		

		
		
		
		//String userChoice = request.getParameter("radio"); //receiving user choice
		//HashMap<String,String> gameResult = new HashMap<String,String>();
		//gameResult = RpsLogic.rpsLogic(userChoice);	
		//rpsData = new RpsData();
		//rpsService= new RpsService();
		
		 	
		//here, data gets persisted,
		//create rps system model RPS,=> RPsDao interface for procedures =>oracleRPSDaoImpl for ops.insert query and read query only.
		//list of resultset received here
		//after that,connection closes,control moves to view, current result and resultset forwarded to view 
		//el used to show present state data and previous data result table 
		
				
		//String query = "INSERT INTO RPS_GAMEDATA(USER_CHOICE,SYSTEM_CHOICE,WINNER) VALUES"+"(?,?,?)";//have to fire insert query here
		//RPSDao rpsDao= new OracleRPSDaoImpl();
		//RpsData rpsData = new RpsData();
		/*rpsData.setUserChoice(gameResult.get("userChoice").toUpperCase());
		rpsData.setSystemChoice(gameResult.get("systemChoice").toUpperCase());
		rpsData.setWinner(gameResult.get("winner").toUpperCase());*/
		
	//	rpsData=rpsService.createRpsData(rpsData.getUserChoice(),rpsData.getSystemChoice(),rpsData.getWinner());
		
		//int result = rpsDao.insertRpsData(dbc.getConnection(), query, rpsData);
		//System.out.println(""+result+" Row inserted.");
		/*request.setAttribute("gameResultStatus", gameResult.get("gameResultStatus"));
		request.setAttribute("winner", gameResult.get("winner"));*/
	
		/*if(dbc.closeConnection(false)==true){
			System.out.println("Connection closed successfully.");
		}
		else{
			System.out.println("Error in closing connection.");
		}*/
		/*RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/GameResult.jsp");
		view.forward(request, response);*/
		
	}
}

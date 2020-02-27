package com.miniclip.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniclip.model.*;

/**
 * Servlet implementation class GameHistory
 */
@WebServlet("/gamedata.do")
public class GameHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RpsService rpsService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameHistory() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  rpsService = new RpsService();
		//  List<RpsData> rpsData = rpsService.readRpsData();
		  /*for(RpsData i : rpsData) {
			  System.out.println(" "+i.getSerial()+" "+i.getSystemChoice()+" "+i.getUserChoice()+" "+i.getWinner()+" "+i.getTimeStamp());
		  } */
		  //request.setAttribute("result", rpsData);
		  RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/RpsHistory.jsp");
		  view.forward(request, response);
	}

}











/*		/*DbConnectionParameter dcp = new OracleDbConnectionParameter();
		LoginInfo loginInfo = new LoginInfo();
		RequestDispatcher view = null;
		loginInfo.setUserName(getServletContext().getInitParameter("oradbUid"));
		loginInfo.setPassword(getServletContext().getInitParameter("oradbPasswd"));
		dcp.setLoginInfo(loginInfo);
		dcp.setHostName(getServletContext().getInitParameter("oradbHostName"));
		dcp.setDriverType(getServletContext().getInitParameter("oradbDriverType"));
		dcp.setSid(getServletContext().getInitParameter("oradbSid"));
		dcp.setPort(getServletContext().getInitParameter("oradbPortNumber"));
		dcp.setUrl(getServletContext().getInitParameter("oradbUrl"));
		DbConnection dbc = new OracleDbConnection();
		dbc.setDcp(dcp);
		dbc.setConnectionUrl();
		dbc.setConnection();
		//System.out.println(" "+dbc.getConnectionUrl());
		//check if connection created successfully
		if(dbc.getConnection()!=null){
			System.out.println("Connected To Db successfully.");
		}
		else{
			System.out.println("Connection Failed.");
		}
		//here, data gets persisted,
		//create rps system model RPS,=> RPsDao interface for procedures =>oracleRPSDaoImpl for ops.insert and read only.
		//list of resultset received here
		//after that,connection closes,control moves to view, current result and resultsetforwarded to view 
		//el used to show present state data and previous data result table 
		
		//a dummy read query to check db connection
		String query = "SELECT * FROM rps_gamedata ORDER BY serial";
		RPSDao rpsDao= new OracleRPSDaoImpl();
		List<RpsData> result = rpsDao.readRpsData(dbc.getConnection(), query);
		for(RpsData rpsData : result){
			System.out.println(""+rpsData.getSerial()+" "+rpsData.getUserChoice()+" "+rpsData.getSystemChoice()+" "+rpsData.getTimeStamp()+" "+rpsData.getWinner());
		}
		request.setAttribute("result", result);
		
		///closing connection
		
		if(dbc.closeConnection(false)==true){
			System.out.println("Connection closed successfully.");
		}
		else{
			System.out.println("Error in closing connection.");
		}*/
		//view=request.getRequestDispatcher("WEB-INF/view/RpsHistory.jsp");
		//view.forward(request, response);*/
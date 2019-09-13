package com.project.recipie.configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DBConnectionManager {

	private  static Connection connection;
	private static  DBConnectionManager manager;
	private static String derbyURL= "jdbc:derby:c:\\MyDB\\recipes;create=true;";
	final static Logger logger=Logger.getLogger(DBConnectionManager.class);
	 
	private  DBConnectionManager(String dbType) throws Exception
	{
		if(dbType.equalsIgnoreCase("derby"))
		{
			initDerbyConnection();
		}
		else
		{
			initDerbyConnection();
		}
	}
	public static DBConnectionManager getConnectionManager(String dbType)throws Exception
	{
		if(manager==null)
		{
			manager=new DBConnectionManager(dbType);
		}
		return manager;
	}
	
	private void initDerbyConnection()throws Exception
	{
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		connection=DriverManager.getConnection(derbyURL);
		  Statement stmt = connection.createStatement();
		try{
		  stmt.executeUpdate("Create table recipes (recipeId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), createdDate TIMESTAMP, isVeg char(10),numberOfPeople int ,ingredients LONG VARCHAR,instructions LONG VARCHAR,createdBy varchar(30),updatedBy varchar(30), updatedDate TIMESTAMP,recipeName varchar(30) ) ");
		}
		catch(Exception e)
		{
			//skip this exception if table is already present 
		}
//		    // query
//		    ResultSet rs = stmt.executeQuery("SELECT * FROM recipes");
//		    // print out query result
//		    while (rs.next()) { 
//		      System.out.printf("%d\t%s\n", rs.getInt("recipeId"), rs.getString("createdDate"));
//		    }
		}
		catch(ClassNotFoundException classExp)
		{
			logger.error("Error while getting DB connection "+classExp.getMessage());
			throw classExp;
		}
		catch(SQLException sqlExc )
		{
			logger.error("ERROR WHILE Getting DB COnnection "+sqlExc.getMessage());
			throw sqlExc;
		}
		
		  
	}
	public  Connection getConnection() 
	{
		return connection;
	}
	
	/*
	public static void main(String []args)throws Exception {
		DBConnectionManager manager=DBConnectionManager.getConnectionManager("derby");
	}*/
	
}

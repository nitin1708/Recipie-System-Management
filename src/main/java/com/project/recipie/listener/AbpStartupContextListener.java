package com.project.recipie.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.project.recipie.AssignmentProjectConstant;
import com.project.recipie.configurations.DBConnectionManager;
import com.project.recipie.derbyImpl.RecipesDAODerbyImpl;

public class AbpStartupContextListener implements ServletContextListener {

	final static Logger logger=Logger.getLogger(RecipesDAODerbyImpl.class);
	
	public void contextInitialized(ServletContextEvent sce) {
	
		try {
			logger.debug("Inside Servelet Context");
			DBConnectionManager.getConnectionManager(AssignmentProjectConstant.DBTYPE);
		} catch (Exception e) {
			logger.error("Error while creating DB "+e.getMessage());
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
	
		try {
			DBConnectionManager.getConnectionManager(AssignmentProjectConstant.DBTYPE).getConnection().close();
		} catch  (Exception e) {
			logger.error("Error while closing DB "+e.getMessage());
		}
		
	}

}

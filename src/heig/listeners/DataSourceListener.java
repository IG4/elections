package heig.listeners;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import heig.metier.Election;

public class DataSourceListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	    try {
	        Context initCtx = new InitialContext();
	        Context envCtx = (Context) initCtx.lookup("java:comp/env");
	        DataSource ds = (DataSource) envCtx.lookup("jdbc/election");
	        Election election = new Election(ds);
	        sce.getServletContext().setAttribute("election", election);
	      } catch (NamingException e) {
	        e.printStackTrace();
	      }
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}

}

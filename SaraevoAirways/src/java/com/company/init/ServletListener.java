package com.company.init;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ServletListener implements ServletContextListener {
    
    @SuppressWarnings("unused")
    private DataSource datasource;

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) { 
        InitialContext initContext;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            datasource = (DataSource) envContext.lookup("jdbc/airlinesdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}

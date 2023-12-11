package com.company.controller;

import com.company.dao.Dao;
import com.company.dao.impl.TicketDao;
import com.company.dao.impl.UserDao;
import com.company.service.UserService;
import com.company.service.impl.TicketServiceImpl;
import com.company.service.impl.UserServiceImpl;
import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import com.company.service.TicketService;

public abstract class InitServlet extends HttpServlet {
    private @Resource(name = "jdbc/airlinesdb")
    DataSource dataSource;
    protected Dao ticketDao, userDao;
    protected TicketService ticketService;
    protected UserService userService;

    @Override
    public void init() {
        ticketDao = new TicketDao(dataSource);
        ticketService = new TicketServiceImpl(ticketDao);
        
        userDao = new UserDao(dataSource);
        userService = new UserServiceImpl(userDao);
    }  
    
}

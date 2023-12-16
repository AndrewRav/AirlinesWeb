package com.company.controller.tickets;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.Ticket;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FlightNumberServlet", urlPatterns = {"/FlightNumberServlet"})
public class FlightNumberServlet extends InitServlet implements Jumpable {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightNumberString = request.getParameter("ticketByFlightNumber");
        int flightNumber = Integer.parseInt(flightNumberString);
        Set<Ticket> ticket = ticketService.getByFlightNumber(flightNumber);
        request.setAttribute("ticket", ticket);
        jump("/WEB-INF/jsp/readAllTickets.jsp", request, response);
    }
}

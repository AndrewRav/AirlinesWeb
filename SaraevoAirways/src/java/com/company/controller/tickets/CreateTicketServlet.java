package com.company.controller.tickets;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.Ticket;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateTicketServlet", urlPatterns = {"/CreateTicketServlet"})
public class CreateTicketServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/createTicket.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightNumberStr = request.getParameter("flightNumber");
        int flightNumber = Integer.parseInt(flightNumberStr);
        String seatStr = request.getParameter("seat");
        int seat = Integer.parseInt(seatStr);
        String departurePoint = request.getParameter("departurePoint");
        String destinationPoint = request.getParameter("destinationPoint");
        String departureTime = request.getParameter("departureTime");
        String arrivalTime = request.getParameter("arrivalTime");
        String airplaneType = request.getParameter("airplaneType");
        String ticketOwnerFirstName = request.getParameter("ticketOwnerFirstName");
        String ticketOwnerLastName = request.getParameter("ticketOwnerLastName");
        String ticketOwnerSurName = request.getParameter("ticketOwnerSurName");
        
        Ticket ticket = new Ticket();
        ticket.setFlightNumber(flightNumber);
        ticket.setSeat(seat);
        ticket.setDeparturePoint(departurePoint);
        ticket.setDestinationPoint(destinationPoint);
        ticket.setDepartureTime(departureTime);
        ticket.setArrivalTime(arrivalTime);
        ticket.setAirplaneType(airplaneType);
        ticket.setTicketOwnerFirstName(ticketOwnerFirstName);
        ticket.setTicketOwnerLastName(ticketOwnerLastName);
        ticket.setTicketOwnerSurName(ticketOwnerSurName);
        boolean success = ticketService.create(ticket);
        request.setAttribute("success", success);
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}

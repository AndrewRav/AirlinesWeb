package com.company.controller.tickets;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.Ticket;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateTicketServlet", urlPatterns = {"/UpdateTicketServlet"})
public class UpdateTicketServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Ticket ticket = ticketService.getById(id);
        request.setAttribute("ticket", ticket);
        jump("/WEB-INF/jsp/updateTicket.jsp", request, response);
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
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        boolean success = ticketService.update(id, flightNumber, seat, departurePoint, destinationPoint, departureTime, arrivalTime, airplaneType, ticketOwnerFirstName, ticketOwnerLastName, ticketOwnerSurName);
        request.setAttribute("success", success);
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}

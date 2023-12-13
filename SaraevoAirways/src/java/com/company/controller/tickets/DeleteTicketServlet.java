package com.company.controller.tickets;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteTicketServlet", urlPatterns = {"/DeleteTicketServlet"})
public class DeleteTicketServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ticketId = request.getParameter("id");
        int id = Integer.parseInt(ticketId);
        boolean success = ticketService.delete(id);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        jump("/WEB-INF/jsp/admin.jsp", request, response);
    }
}

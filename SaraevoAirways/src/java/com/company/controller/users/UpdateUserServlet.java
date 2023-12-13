package com.company.controller.users;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        User user = userService.getById(id);
        request.setAttribute("user", user);
        if (request.getSession().getAttribute("status").equals("user")) {
         jump("/WEB-INF/jsp/updatePersonalData.jsp", request, response);   
        } else {
         jump("/WEB-INF/jsp/updateUsersAdmin.jsp", request, response);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        String email = request.getParameter("email");
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        boolean success = userService.update(id, login, password, lastName, firstName, surName, email);
        // request.setAttribute("success", success ? "Данные обновлены" : "Данные не обновлены");
        // jump("/WEB-INF/jsp/result.jsp", request, response);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        doGet(request, response);
    }
}

package com.company.controller.users;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateUserServlet", urlPatterns = {"/CreateUserServlet"})
public class CreateUserServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/createUser.jsp", request, response);
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

        User user = new User();
    	user.setLogin(login);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setSurName(surName);
        user.setEmail(email);
        boolean success = userService.create(user);
        request.setAttribute("success", success);
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}

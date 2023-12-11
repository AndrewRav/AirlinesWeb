package com.company.controller;

import com.company.model.User;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User loginUser = userService.login(login, password);
        session.setAttribute("deleteStatus", "asd");
        
        if (loginUser != null) {
            session.setAttribute("firstName", loginUser.getFirstName());
            session.setAttribute("surName", loginUser.getSurName());
            session.setAttribute("id", loginUser.getId());
        } else {
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}

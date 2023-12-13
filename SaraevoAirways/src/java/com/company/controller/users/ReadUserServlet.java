package com.company.controller.users;

import com.company.controller.InitServlet;
import com.company.controller.Jumpable;
import com.company.model.User;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadUserServlet", urlPatterns = {"/ReadUserServlet"})
public class ReadUserServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<User> user = userService.read();
        request.setAttribute("user", user);
        jump("/WEB-INF/jsp/readAllUsers.jsp", request, response);
    }
}

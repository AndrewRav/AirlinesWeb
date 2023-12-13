package com.company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TransitionPageServlet", urlPatterns = {"/BackServlet"})
public class BackServlet extends HttpServlet implements Jumpable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/main.jsp", request, response);
    }
}

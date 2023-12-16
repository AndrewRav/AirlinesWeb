package com.company.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionTimeOutListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        int timeout = 100;
        session.setMaxInactiveInterval(timeout);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}

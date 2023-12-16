<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/mainStyle.css"%></style>
            <title><fmt:message key="title.mainPage"/></title>
    </head>
    <body>
        <div class="welcome-message">
            <fmt:message key="welcomeMessage"/>, <%= session.getAttribute("firstName")%> <%= session.getAttribute("surName")%>
        </div>
        <form action="CreateTicketServlet" method="get" class="form_2">
            <input class="button" type="submit" value='<fmt:message key="button.createTicket"/>'/>
        </form>
        <form action="ReadTicketServlet" method="get" class="form_2">
            <input class="button" type="submit" value='<fmt:message key="button.showTickets"/>'/>
        </form>
        <form action="CreateUserServlet" method="get" class="form_2">
            <input class="button" type="submit" value='<fmt:message key="button.createUser"/>'/>
        </form>
        <form action="ReadUserServlet" method="get" class="form_2">
            <input class="button" type="submit" value='<fmt:message key="button.showAllUsers"/>'/>
        </form>
        <form action="FlightNumberServlet" method="get" class="form_4">
            <label><fmt:message key="label.enterFlightNumber"/>: </label>
            <input type="number" id="ticketByFlightNumber" name="ticketByFlightNumber" placeholder='<fmt:message key="placeholder.enterFlightNumber"/>' required/><br/>
            <input class="button" type="submit" value='<fmt:message key="button.showTicketsByFlightNumber"/>'/>
        </form>
        <form action="TicketOwnerLastNameServlet" method="get" class="form_4">
            <label><fmt:message key="label.enterLastName"/>: </label>
            <input type="text" id="ticketByLastName" name="ticketByLastName" placeholder='<fmt:message key="placeholder.enterLastName"/>' required/><br/>
            <input class="button" type="submit" value='<fmt:message key="button.showTicketsByLastName"/>'/>
        </form>
        <form action="index.html" class="form_7">
            <input type="hidden" name="logout" value="true"/>
            <input class="leave" type="submit" value='<fmt:message key="button.logout"/>'/>
        </form>
    </body>
     </fmt:bundle>
</html>
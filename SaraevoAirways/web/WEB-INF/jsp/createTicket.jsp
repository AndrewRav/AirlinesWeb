<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/createStyle.css"%></style>
            <title><fmt:message key="title.createTicket"/></title>
        </head>
        <body>
            <form action="BackServlet" method="post">
                <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
            </form>
            <form action="CreateTicketServlet" method="post">
                <label for="flightNumber"><fmt:message key="label.flightNumber"/></label>
                <input type="number" id="flightNumber" name="flightNumber" required>
                <label for="seat"><fmt:message key="label.seat"/></label>
                <input type="number" id="seat" name="seat" required>
                <label for="departurePoint"><fmt:message key="label.departurePoint"/></label>
                <input type="text" id="departurePoint" name="departurePoint" required>
                <label for="destinationPoint"><fmt:message key="label.destinationPoint"/></label>
                <input type="text" id="destinationPoint" name="destinationPoint" required>
                <label for="departureTime"><fmt:message key="label.departureTime"/></label>
                <input type="datetime-local" id="departureTime" name="departureTime" required>
                <label for="arrivalTime"><fmt:message key="label.arrivalTime"/></label>
                <input type="datetime-local" id="arrivalTime" name="arrivalTime" required>
                <label for="airplaneType"><fmt:message key="label.airplaneType"/></label>
                <input type="text" id="airplaneType" name="airplaneType" required>
                <label for="ticketOwnerFirstName"><fmt:message key="label.ticketOwnerFirstName"/></label>
                <input type="text" id="ticketOwnerFirstName" name="ticketOwnerFirstName" required>
                <label for="ticketOwnerLastName"><fmt:message key="label.ticketOwnerLastName"/></label>
                <input type="text" id="ticketOwnerLastName" name="ticketOwnerLastName" required>
                <label for="ticketOwnerSurName"><fmt:message key="label.ticketOwnerSurName"/></label>
                <input type="text" id="ticketOwnerSurName" name="ticketOwnerSurName" required>
                <input type="submit" class="send" value='<fmt:message key="button.send"/>'>
            </form>
        </body>
    </fmt:bundle>
</html>